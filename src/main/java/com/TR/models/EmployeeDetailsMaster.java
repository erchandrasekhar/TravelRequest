package com.TR.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="employee_details_master" , schema="alpo_tr")
@SequenceGenerator(name="emp_details_master_id_seq" , sequenceName="alpo_tr.emp_details_master_id_seq" , initialValue=0 , allocationSize=1)
public class EmployeeDetailsMaster  implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
     @GeneratedValue(generator="emp_details_master_id_seq", strategy = GenerationType.SEQUENCE)
     @Column(name="num_emp_detail_id")
     private long numEmpDetailIdPk;
	 
	 @Column(name="num_employee_id")
     private int numEmployeeId;
	 
	 @Column(name="txt_employee_user_id", length=75)
	 private String txtEmployeeUserId;
	 
	 @Column(name="txt_employee_name")
     private String txtEmployeeName;
	 
	 @Column(name="txt_gender", length=1)
     private String txtGender;
	 
	 @Column(name="txt_marital_status")
     private String txtMaritalStatus;

     
     @Column(name="emp_active_flag", length=1)
     private String empActiveFlag;
     
     @Column(name="txt_employee_designation")
     private String txtEmpLoyeeDesignation;
     
     @Column(name="txt_approver_user_id", length=75)
     private String txtApproverUserId;

   

	@Column(name="text_employee_type")
     private String txtemptype;
	
	@Column(name="emp_email_id")
    private String empEmailId;
	
	
	@Column(name="emp_mobile_number")
    private String empMobileNumber;

	public long getNumEmpDetailId() {
		return numEmpDetailIdPk;
	}

	public void setNumEmpDetailIdPk(long numEmpDetailIdPk) {
		this.numEmpDetailIdPk = numEmpDetailIdPk;
	}
	
	public int getNumEmployeeId() {
		return numEmployeeId;
	}

	public void setNumEmployeeId(int numEmployeeId) {
		this.numEmployeeId = numEmployeeId;
	}
	
	public String getTxtEmployeeUserId() {
		return txtEmployeeUserId;
	}

	public void setTxtEmployeeUserId(String txtEmployeeUserId) {
		this.txtEmployeeUserId = txtEmployeeUserId;
	}

	public String getTxtEmployeeName() {
		return txtEmployeeName;
	}

	public void setTxtEmployeeName(String txtEmployeeName) {
		this.txtEmployeeName = txtEmployeeName;
	}

	public String getTxtGender() {
		return txtGender;
	}

	public void setTxtGender(String txtGender) {
		this.txtGender = txtGender;
	}
	
	public String getTxtMaritalStatus() {
		return txtMaritalStatus;
	}

	public void setTxtMaritalStatus(String txtMaritalStatus) {
		this.txtMaritalStatus = txtMaritalStatus;
	}

	public String getBoolActiveFlag() {
		return empActiveFlag;
	}

	public void setEmpActiveFlag(String empActiveFlag) {
		this.empActiveFlag = empActiveFlag;
	}

	public String getTxtEmpLoyeeDesignation() {
		return txtEmpLoyeeDesignation;
	}

	public void setTxtEmpLoyeeDesignation(String txtEmpLoyeeDesignation) {
		this.txtEmpLoyeeDesignation = txtEmpLoyeeDesignation;
	}

	public String getTxtApproverUserId() {
		return txtApproverUserId;
	}

	public void setTxtApproverUserId(String txtApproverUserId) {
		this.txtApproverUserId = txtApproverUserId;
	}
	
	public String getTxtemptype() {
			return txtemptype;
	}

	public void setTxtemptype(String txtemptype) {
			this.txtemptype = txtemptype;
	}

	public String getEmpEmailId() {
		return empEmailId;
	}

	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	public String getEmpMobileNumber() {
		return empMobileNumber;
	}

	public void setEmpMobileNumber(String empMobileNumber) {
		this.empMobileNumber = empMobileNumber;
	}

	public long getNumEmpDetailIdPk() {
		return numEmpDetailIdPk;
	}

	public String getEmpActiveFlag() {
		return empActiveFlag;
	}

	@Override
	public String toString() {
		return "EmployeeDetailsMaster [numEmpDetailIdPk=" + numEmpDetailIdPk + ", numEmployeeId=" + numEmployeeId
				+ ", txtEmployeeUserId=" + txtEmployeeUserId + ", txtEmployeeName=" + txtEmployeeName + ", txtGender="
				+ txtGender + ", txtMaritalStatus=" + txtMaritalStatus + ", empActiveFlag=" + empActiveFlag
				+ ", txtEmpLoyeeDesignation=" + txtEmpLoyeeDesignation + ", txtApproverUserId=" + txtApproverUserId
				+ ", txtemptype=" + txtemptype + ", empEmailId=" + empEmailId + ", empMobileNumber=" + empMobileNumber
				+ "]";
	}

	
	
}