package com.TR.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="travel_request")
public class TravelRequest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int travelRequestIdPk;
	
	@Column(name="tour_program")
	private String tourProgram;
	
	@Column(name="fron_date")
	@Temporal(TemporalType.DATE)
	private Date fromDate;
	
	@Column(name="fron_date_timestemp")
	private Date fromDateAndTimeStemp;
	
	@Column(name="to_date")
	@Temporal(TemporalType.DATE)
	private Date toDate;
	
	@Column(name="to_date_timestemp")
	private Date toDateAndTimeStemp;
	
	@Column(name="year")
	private int year;
	
	@Column(name="remark")
	private String remark;
	
	@Column(name="location")
	private String location;
	
	@Column(name="ta")
	private Double ta;
	
	@Column(name="da")
	private Double da;
	
	@Column(name="accomodation")
	private Double accomodation;
	
	@Column(name="grand_total")
	private Double grandTotal;
	
	@Column(name="action")/*action A for apply and P for pending AP for approve*/
	private String action;

	@Column(name = "total_no_of_days")
	private Float numTotalNoOfDays;
    
	@Column(name = "no_of_working_days")
	private Float numNoOfWorkingDays;
	
	@JoinColumn(name = "num_applied_by_emp_id", referencedColumnName = "num_employee_id")
    @ManyToOne(fetch = FetchType.EAGER)
	private EmployeeDetailsMaster numAppliedByEmpId;
	
	@JoinColumn(name = "first_approver_id", referencedColumnName = "num_employee_id")
    @ManyToOne(fetch = FetchType.EAGER)
	private EmployeeDetailsMaster firstApproverId;
	
	@Column(name = "first_approver_timestamp")
	@Temporal(TemporalType.DATE)
	private Date firstApproverTimestamp;

	@Column(name = "first_approval_flag")
	private String firstApprovalFlag;
	
	
	@Column(name = "first_approver_reason")
	private String first_approver_reason;

	
	@JoinColumn(name = "second_approver_id", referencedColumnName = "num_employee_id")
    @ManyToOne(fetch = FetchType.EAGER)
	private EmployeeDetailsMaster secondApproverId;
	
	
	@Column(name = "second_approver_timestamp")
	@Temporal(TemporalType.DATE)
	private Date secondApproverTimestamp;

	@Column(name = "second_approval_flag")
	private String secondApprovalFlag;
	
	
	@Column(name = "second_approver_reason")
	private String second_approver_reason;


	@JoinColumn(name = "final_approver_id", referencedColumnName = "num_employee_id")
    @ManyToOne(fetch = FetchType.EAGER)
	private EmployeeDetailsMaster finalApproverId;
	
	@Column(name = "final_approver_timestamp")
	@Temporal(TemporalType.DATE)
	private Date finalApproverTimestamp;
	
	
	@Column(name = "final_approval_flag")
	private String finalApprovalFlag;
	
	
	@Column(name = "final_approver_reason")
	private String final_approver_reason;

	@JoinColumn(name="tadaIdFk")
	@OneToOne(fetch = FetchType.EAGER)
	private TaDaMaster taDaMaster;
	
	@JoinColumn(name="projectStatusMasterIdFk")
	@OneToOne(fetch = FetchType.EAGER)
	private ProjectStatusMaster projectstatusMaster;
	
	@JoinColumn(name = "leave_flow_id_Fk")
	@ManyToOne(fetch = FetchType.EAGER)
	private LeaveFlowTableMaster leaveFlowTableMaster;

	public int getTravelRequestIdPk() {
		return travelRequestIdPk;
	}

	public void setTravelRequestIdPk(int travelRequestIdPk) {
		this.travelRequestIdPk = travelRequestIdPk;
	}

	public String getTourProgram() {
		return tourProgram;
	}

	public void setTourProgram(String tourProgram) {
		this.tourProgram = tourProgram;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getFromDateAndTimeStemp() {
		return fromDateAndTimeStemp;
	}

	public void setFromDateAndTimeStemp(Date fromDateAndTimeStemp) {
		this.fromDateAndTimeStemp = fromDateAndTimeStemp;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Date getToDateAndTimeStemp() {
		return toDateAndTimeStemp;
	}

	public void setToDateAndTimeStemp(Date toDateAndTimeStemp) {
		this.toDateAndTimeStemp = toDateAndTimeStemp;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getTa() {
		return ta;
	}

	public void setTa(Double ta) {
		this.ta = ta;
	}

	public Double getDa() {
		return da;
	}

	public void setDa(Double da) {
		this.da = da;
	}

	public Double getAccomodation() {
		return accomodation;
	}

	public void setAccomodation(Double accomodation) {
		this.accomodation = accomodation;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Float getNumTotalNoOfDays() {
		return numTotalNoOfDays;
	}

	public void setNumTotalNoOfDays(Float numTotalNoOfDays) {
		this.numTotalNoOfDays = numTotalNoOfDays;
	}

	public Float getNumNoOfWorkingDays() {
		return numNoOfWorkingDays;
	}

	public void setNumNoOfWorkingDays(Float numNoOfWorkingDays) {
		this.numNoOfWorkingDays = numNoOfWorkingDays;
	}

	public EmployeeDetailsMaster getFirstApproverId() {
		return firstApproverId;
	}

	public void setFirstApproverId(EmployeeDetailsMaster firstApproverId) {
		this.firstApproverId = firstApproverId;
	}

	public Date getFirstApproverTimestamp() {
		return firstApproverTimestamp;
	}

	public void setFirstApproverTimestamp(Date firstApproverTimestamp) {
		this.firstApproverTimestamp = firstApproverTimestamp;
	}

	public String getFirstApprovalFlag() {
		return firstApprovalFlag;
	}

	public void setFirstApprovalFlag(String firstApprovalFlag) {
		this.firstApprovalFlag = firstApprovalFlag;
	}

	public String getFirst_approver_reason() {
		return first_approver_reason;
	}

	public void setFirst_approver_reason(String first_approver_reason) {
		this.first_approver_reason = first_approver_reason;
	}

	public EmployeeDetailsMaster getSecondApproverId() {
		return secondApproverId;
	}

	public void setSecondApproverId(EmployeeDetailsMaster secondApproverId) {
		this.secondApproverId = secondApproverId;
	}

	public Date getSecondApproverTimestamp() {
		return secondApproverTimestamp;
	}

	public void setSecondApproverTimestamp(Date secondApproverTimestamp) {
		this.secondApproverTimestamp = secondApproverTimestamp;
	}

	public String getSecondApprovalFlag() {
		return secondApprovalFlag;
	}

	public void setSecondApprovalFlag(String secondApprovalFlag) {
		this.secondApprovalFlag = secondApprovalFlag;
	}

	public String getSecond_approver_reason() {
		return second_approver_reason;
	}

	public void setSecond_approver_reason(String second_approver_reason) {
		this.second_approver_reason = second_approver_reason;
	}

	public EmployeeDetailsMaster getFinalApproverId() {
		return finalApproverId;
	}

	public void setFinalApproverId(EmployeeDetailsMaster finalApproverId) {
		this.finalApproverId = finalApproverId;
	}

	public Date getFinalApproverTimestamp() {
		return finalApproverTimestamp;
	}

	public void setFinalApproverTimestamp(Date finalApproverTimestamp) {
		this.finalApproverTimestamp = finalApproverTimestamp;
	}

	public String getFinalApprovalFlag() {
		return finalApprovalFlag;
	}

	public void setFinalApprovalFlag(String finalApprovalFlag) {
		this.finalApprovalFlag = finalApprovalFlag;
	}

	public String getFinal_approver_reason() {
		return final_approver_reason;
	}

	public void setFinal_approver_reason(String final_approver_reason) {
		this.final_approver_reason = final_approver_reason;
	}

	public TaDaMaster getTaDaMaster() {
		return taDaMaster;
	}

	public void setTaDaMaster(TaDaMaster taDaMaster) {
		this.taDaMaster = taDaMaster;
	}

	public ProjectStatusMaster getProjectstatusMaster() {
		return projectstatusMaster;
	}

	public void setProjectstatusMaster(ProjectStatusMaster projectstatusMaster) {
		this.projectstatusMaster = projectstatusMaster;
	}

	public LeaveFlowTableMaster getLeaveFlowTableMaster() {
		return leaveFlowTableMaster;
	}

	public void setLeaveFlowTableMaster(LeaveFlowTableMaster leaveFlowTableMaster) {
		this.leaveFlowTableMaster = leaveFlowTableMaster;
	}

	public EmployeeDetailsMaster getNumAppliedByEmpId() {
		return numAppliedByEmpId;
	}

	public void setNumAppliedByEmpId(EmployeeDetailsMaster numAppliedByEmpId) {
		this.numAppliedByEmpId = numAppliedByEmpId;
	}
	
	
	
	
	
}
