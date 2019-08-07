package com.TR.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.TR.models.EmployeeDetailsMaster;
import com.TR.models.LeaveFlowTableMaster;
import com.TR.models.ProjectStatusMaster;
import com.TR.models.TaDaMaster;
import com.TR.models.TravelRequest;
import com.TR.repository.EmployeeDetailsMasterRepository;
import com.TR.repository.LeaveFlowTableMasterRepository;
import com.TR.repository.ProjectStatusMasterRepository;
import com.TR.repository.TaDaMasterRepository;
import com.TR.repository.TravelRequestrepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class TravelRequestController {

	@Autowired
	EmployeeDetailsMasterRepository employeeDetailsMasterRepository;
	@Autowired 
	ProjectStatusMasterRepository projectStatusMasterRepository;
	@Autowired
	TaDaMasterRepository taDaMasterRepository;
	@Autowired
	TravelRequestrepository travelRequestrepository;
	@Autowired
	LeaveFlowTableMasterRepository leaveFlowTableMasterRepository;
	
	@RequestMapping(value={"/","/login"},method=RequestMethod.GET)
	public ModelAndView loadLogin(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,ModelMap modelmap)
	{
		String textEmpUserId=request.getParameter("username");
		ModelAndView mv = new ModelAndView();
		
		if(textEmpUserId!="")
		{   
			
			System.out.println("userId:"+textEmpUserId);
			EmployeeDetailsMaster empObject=employeeDetailsMasterRepository.findByTxtEmployeeUserId(textEmpUserId);
			System.out.println(empObject);
			if(empObject!=null)
			{
				request.getSession().setAttribute("loginUser", empObject);
				modelmap.put("employeeName", empObject.getTxtEmployeeName());
				mv.setViewName("home");
			}
			
		}
		else{
			mv.setViewName("login");
			System.out.println("blank user details");
		}
		
		
		return mv;
	}
	
	@RequestMapping(value="/addTravelRequest",method=RequestMethod.GET)
	public ModelAndView loadTravelRequest(HttpServletRequest request,ModelMap modelmap)
	{   
		ModelAndView mv = new ModelAndView();
		/*getting session for login user*/
		EmployeeDetailsMaster loginUser = (EmployeeDetailsMaster) request.getSession().getAttribute("loginUser");
		/*getting project list of login user*/
		
		ArrayList<ProjectStatusMaster> listProjectStatusMaster =(ArrayList<ProjectStatusMaster>) projectStatusMasterRepository.findByUserId(loginUser.getTxtEmployeeUserId());
	  	modelmap.put("listProjectStatusMaster", listProjectStatusMaster);
	  	/*getting tada for  login user*/
	  	
	  	TaDaMaster tadaObject = taDaMasterRepository.findByUserDesignation(loginUser.getTxtEmpLoyeeDesignation());
	  	modelmap.put("tadaObject", tadaObject);
		mv.setViewName("travelRequestForm");
		return mv;
	}
	
	
	@RequestMapping(value="/addTravelRequest",method=RequestMethod.POST)
	public ModelAndView addTravelRequest(HttpServletRequest request,ModelMap modelmap)
	{   
		ModelAndView mv = new ModelAndView();
		TravelRequest travelRequest = new TravelRequest();
		/*getting session for login user*/
		EmployeeDetailsMaster loginUser = (EmployeeDetailsMaster) request.getSession().getAttribute("loginUser");
		int projectIdpk = Integer.parseInt(request.getParameter("projectIdPk"));
		int tadaIdPk = Integer.parseInt(request.getParameter("tadaIdPk"));
		
		Double ta = Double.parseDouble(request.getParameter("ta"));
		Double da = Double.parseDouble(request.getParameter("da"));
		Double accomodation = Double.parseDouble(request.getParameter("accomodation"));
		Double grandTotal = Double.parseDouble(request.getParameter("grandTotal"));
		String location = request.getParameter("location");
		String remark = request.getParameter("remark");
		String  fromDate = request.getParameter("fromDate");
		String  toDate = request.getParameter("fromDate");
		String tourProgram = request.getParameter("travellingFor");
		Date date1=null;
		Date date2=null;
		try 
		{
			 date1 =(Date) new SimpleDateFormat("dd-MM-yyyy").parse(fromDate);
			 date2=(Date)new SimpleDateFormat("dd-MM-yyyy").parse(toDate);
			 
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		
		
		
		ProjectStatusMaster psmObject = projectStatusMasterRepository.findOne(projectIdpk);
		TaDaMaster tadaObject = taDaMasterRepository.findOne(tadaIdPk);
		
		EmployeeDetailsMaster emp = employeeDetailsMasterRepository.findByNumEmployeeId(loginUser.getNumEmployeeId());
	    
		LeaveFlowTableMaster lfmObject = leaveFlowTableMasterRepository.getLeaveApplicantEmpId(emp.getNumEmployeeId());
        EmployeeDetailsMaster applicantObject = employeeDetailsMasterRepository.findByNumEmployeeId(loginUser.getNumEmployeeId());
		
             
		EmployeeDetailsMaster firstApprovalObject = employeeDetailsMasterRepository.findByNumEmployeeId((lfmObject.getLeaveFirstApprovalEmpId().getNumEmployeeId()));
		EmployeeDetailsMaster secondApprovalObject = employeeDetailsMasterRepository.findByNumEmployeeId((lfmObject.getLeaveSecondApprovalEmpId().getNumEmployeeId()));
		EmployeeDetailsMaster finalApprovalObject = employeeDetailsMasterRepository.findByNumEmployeeId((lfmObject.getLeaveFinalApprovalEmpId().getNumEmployeeId()));
		
		travelRequest.setTaDaMaster(tadaObject);
	  	travelRequest.setProjectstatusMaster(psmObject);
	  	travelRequest.setLeaveFlowTableMaster(lfmObject);
	  	travelRequest.setNumAppliedByEmpId(applicantObject);
	  	
	  	travelRequest.setFirstApproverId(firstApprovalObject);
	  	travelRequest.setSecondApproverId(secondApprovalObject);
	  	travelRequest.setFinalApproverId(finalApprovalObject);
	  	
	  	travelRequest.setTa(ta);
	  	travelRequest.setDa(da);
	  	travelRequest.setAccomodation(accomodation);
	  	travelRequest.setTourProgram(tourProgram);
	    travelRequest.setGrandTotal(grandTotal);
	  	travelRequest.setFromDate(date1);
	  	travelRequest.setFromDateAndTimeStemp(new Date());
	  	travelRequest.setToDate(date2);
	  	travelRequest.setToDateAndTimeStemp(new Date());
	  	travelRequest.setLocation(location);
	  	travelRequest.setRemark(remark);
	  	travelRequest.setYear(Calendar.getInstance().get(Calendar.YEAR));
	  	travelRequest.setAction("A");
	 	TravelRequest tr =travelRequestrepository.save(travelRequest);
	  	modelmap.put("msg", "You have successfully Apply Travel Request and Your Id is:"+tr.getTravelRequestIdPk());
		mv.setViewName("travelRequestForm");
		return mv;
	}
	
	@RequestMapping(value="/getAllTravelRequest",method=RequestMethod.GET)
	public ModelAndView getAllTravelRequest(HttpServletRequest request,ModelMap modelmap)
	{
		ModelAndView mv = new ModelAndView();
		ArrayList<TravelRequest> allTravelRequestList = (ArrayList<TravelRequest>) travelRequestrepository.findAll();
		modelmap.put("allTravelRequestList", allTravelRequestList);
		System.out.println("alllist::::::::::"+allTravelRequestList);
		mv.setViewName("travelRequestList");
		return mv;
	}
	
	@RequestMapping(value="/myTravelRequest",method=RequestMethod.GET)
	public ModelAndView myTravelRequest(HttpServletRequest request,ModelMap modelmap)
	{   EmployeeDetailsMaster loginUser = (EmployeeDetailsMaster) request.getSession().getAttribute("loginUser");
		ModelAndView mv = new ModelAndView();
		ArrayList<TravelRequest> myTravelRequestList = (ArrayList<TravelRequest>) travelRequestrepository.getTravelRequestListByApplicant(loginUser.getNumEmployeeId());
		System.out.println("list::::::::::"+myTravelRequestList);
		modelmap.put("myTravelRequestList", myTravelRequestList);
		mv.setViewName("myTravelRequest");
		return mv;
	}
}
