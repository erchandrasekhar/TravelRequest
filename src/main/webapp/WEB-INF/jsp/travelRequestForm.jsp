<%@include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.TR.models.EmployeeDetailsMaster"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Raise Travel Request</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <!--datePikar datepikar  -->
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <%
EmployeeDetailsMaster loginUser = (EmployeeDetailsMaster) request.getSession()
		.getAttribute("loginUser");
%>


<style type="text/css"> 
  
  #applicanName,#email,#designation,#ta,#project,#location,#fromDate,#toDate,#da,#grandTotal,#remark,#accomodation{
  
  font-size: 12px;
  height: 25px;
  }
  
  .panel-info>.panel-heading {
    color: #dedada;
    background-color: #586eff;
    border-color: #bce8f1;
}
  
  </style>

</head>
<body>


<div class="container">
 <h3>Travel Request Form </h3>
  <div class="panel-group">
    
    <c:choose>
				<c:when test="${empty msg}">
				</c:when>
				<c:otherwise>
					<div class="alert alert-success" id="mess" name="mess"
						style="background-color: green; color: white;">
						<strong></strong>${msg}</div>
				</c:otherwise>
			</c:choose>
    
      <form action="addTravelRequest" method="post">
      <div class="panel panel-info">
      <div class="panel-heading">Traveller Details</div>
      <div class="panel-body">
      <div class="row">
    
    <div class="col-md-4">
    <div class="form-group">
    <label class="control-label" for="applicanName">Applicant Name&nbsp;<font size="3" color="red">*</font></label>
          <input type="text" name="applicanName" id="applicanName" value="<%=loginUser.getTxtEmployeeName() %>" class="form-control" placeholder="Enter Applicant Name" required="" readonly="">
         
          
  </div>
  </div>
    
    <div class="col-md-4">
    <div class="form-group">
    <label class="control-label" for="email">Email Id&nbsp;<font size="3" color="red">*</font></label>
          <input type="text" name="email" id="email" value="<%=loginUser.getEmpEmailId() %>" class="form-control" placeholder="Enter Email Id" required="" readonly="">
  </div>
  </div>
  
 
   <div class="col-md-4">
    <div class="form-group">
    <label class="control-label">Designation&nbsp;<font size="3" color="red">*</font></label>
          <input type="text" name="designation" id="designation" value="<%=loginUser.getTxtEmpLoyeeDesignation() %>" class="form-control" placeholder="Designation" required="" readonly="">
         
  </div>
  </div>
  
  </div></div>
    </div>
  
  
    <div class="panel panel-info">
      <div class="panel-heading">Basic Details</div>
      <div class="panel-body">
      
      <div class="row">
    
    <div class="col-md-8">
    <div class="form-group">
    <label class="control-label" for="travellingFor">Travelling For(Tour Programme)&nbsp;<font size="3" color="red">*</font></label>
         <!--  <input type="text" name="owner" id="owner" class="form-control" placeholder="Enter Travelling Reasion" required > -->
          <textarea rows="" cols="" name="travellingFor" id="travellingFor" class="form-control" style="resize: vertical;" maxlength="255" placeholder="Enter Travelling Reasion" required=""></textarea>
        
          
  </div>
  </div>

 <div class="col-md-4">
    <div class="form-group">
    <label class="control-label" for="projectIdPk">Project&nbsp;<font size="3" color="red">*</font></label>
         
        <select class="form-control" id="projectIdPk" name="projectIdPk" required>
        
        <option value="" >------------------Select Peoject-------------------</option>
        
             <c:forEach items="${listProjectStatusMaster }" var="pl">
             <option value="${pl.projectStatusIdPk}">${pl.projectName}</option>
             </c:forEach>
        </select>
       
  </div>
  </div>
   
  </div>
       <div class="row">
    
    <div class="col-md-4">
    <div class="form-group">
    <label class="control-label" for="fromDate">FomDate&nbsp;<font size="3" color="red">*</font></label>
          <input type="text" name="fromDate" id="fromDate" class="form-control " placeholder="DD-MM-YYYY" required="">
        
          
  </div>
  </div>
    
    <div class="col-md-4">
    <div class="form-group">
    <label class="control-label" for="toDate">ToDate&nbsp;<font size="3" color="red">*</font></label>
          <input type="text" name="toDate" id="toDate" onblur="grandTotalCalculation();" class="form-control " placeholder="DD-MM-YYYY" required="">
  </div>
  </div>
  
  
  
  <div class="col-md-4">
    <div class="form-group">
    <label class="control-label">Location&nbsp;<font size="3" color="red">*</font></label>
          <input type="text" name="location" id="location" class="form-control" placeholder="Location" required="">
  </div>
  </div>
  
  </div>
  
   <div class="row">
    
    <div class="col-md-4">
    <div class="form-group">
    <label class="control-label" for="owner">Traveling Expenses(TA)&nbsp;<font size="3" color="red">*</font></label>
          <input type="text" name="ta" id="ta" value="${tadaObject.ta }" class="form-control" placeholder="Enter From Date" required="" readonly="">
          <input type="text" name="tadaIdPk" id="tadaIdPk" value="${tadaObject.tadaIdPk}" class="form-control" placeholder="Enter ta" required="" readonly="">
          
  </div>
  </div>
    
    <div class="col-md-4">
    <div class="form-group">
    <label class="control-label" for="da">Daily Allowance(DA)&nbsp;<font size="3" color="red">*</font></label>
          <input type="text" name="da" id="da" value="${tadaObject.da}" class="form-control" placeholder="Enter da " required="" readonly="">
  </div>
  </div>
  
  <div class="col-md-4">
    <div class="form-group">
    <label class="control-label">Accommodation&nbsp;<font size="3" color="red">*</font></label>
          <input type="text" name="accomodation" id="accomodation" value="${tadaObject.accomodation}" class="form-control" placeholder="Accomodation" required="" readonly="">
  </div>
  </div>
 
  </div>
  
  <div class="row">
    
    <div class="col-md-4">
    <div class="form-group">
    <label class="control-label" for="GT">Grand Total&nbsp;<font size="3" color="red">*</font></label>
          <input type="text" name="grandTotal" id="grandTotal" value="" class="form-control" placeholder="Grand Total" required="" readonly="">
          
  </div>
  </div>
    
    <div class="col-md-8">
    <div class="form-group">
    <label class="control-label" for="remark">Remarks (if any):</label>
          <input type="text" name="remark" id="remark" class="form-control" placeholder="">
  </div>
  </div>
 </div>
 
 <br>
     <div class="row">
    
    <div class="col-md-4">
    
  </div>
    
    <div class="col-md-4">
         <div class="row" style="text-align: center;">
                  
        	    <button type="submit" class="btn btn-success" id="btnSave" style="border-radius:0px;">Save
        		<span class="fa fa-check-circle"></span>
        		</button>
        		<button type="reset" class="btn btn-danger" style="border-radius:0px;">Reset
        		<span class="fa fa-refresh"></span>
        		</button>
        
        
              </div>
  </div>

  <div class="col-md-4">
   
  </div>
 
  </div>
   </div>
    </div>
      </form>
    
  </div>
</div>
<br>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
  <script type="text/javascript">
  $( function() {
	    $( "#fromDate" ).datepicker({
	      changeMonth: true,
	      changeYear: true,
	      dateFormat: 'dd-mm-yy'
	    });
	    
	    $( "#toDate" ).datepicker({
	        changeMonth: true,
	        changeYear: true,
	        dateFormat: 'dd-mm-yy'
	        
	      });
	    
	  } );
  </script>
  
   <script type="text/javascript">
      
      function grandTotalCalculation(){
    	 
    	  var ta = document.getElementById("ta").value;
    	  var da = document.getElementById("da").value;
    	  var accomodation = document.getElementById("accomodation").value;
    	  var grandTotalValue = parseFloat(ta)+parseFloat(da)+ parseFloat(accomodation);
    	   
    	  document.getElementById("grandTotal").value=grandTotalValue.toFixed(2);
      }
  </script>
  <script> $( "#mess" ).fadeOut( 3000 );</script>
</body>
</html>
