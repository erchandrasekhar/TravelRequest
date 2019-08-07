package com.TR.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="leave_approval_flow_table_master", schema="alpo_tr")
@SequenceGenerator(name = "leaveflow_sequence", sequenceName = "alpo_tr.leaveflow_seq", initialValue = 0, allocationSize = 1)
public class LeaveFlowTableMaster implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	 @GeneratedValue(strategy=GenerationType.SEQUENCE)
	 @Column(name="num_flow_id_pk") 
	 private int numFlowIdPK;
	
	@JoinColumn(name = "num_leave_applicant_empid", referencedColumnName = "num_employee_id")
    @ManyToOne(fetch = FetchType.EAGER)
	 //@Column(name="num_leave_applicant_empid")
	 private EmployeeDetailsMaster leaveApplicantEmpId;
	 
	@JoinColumn(name = "num_leave_first_approval_empid", referencedColumnName = "num_employee_id")
    @ManyToOne(fetch = FetchType.EAGER)
	// @Column(name="num_leave_first_approval_empid")
	 private EmployeeDetailsMaster leaveFirstApprovalEmpId;
	 
	@JoinColumn(name = "num_leave_second_approval_empid", referencedColumnName = "num_employee_id")
    @ManyToOne(fetch = FetchType.EAGER)
	 //@Column(name="num_leave_second_approval_empid")
	 private EmployeeDetailsMaster leaveSecondApprovalEmpId;
	 
	@JoinColumn(name = "num_leave_final_approval_empid", referencedColumnName = "num_employee_id")
    @ManyToOne(fetch = FetchType.EAGER)
	// @Column(name="num_leave_final_approval_empid")
	 private EmployeeDetailsMaster leaveFinalApprovalEmpId;


	public int getNumFlowIdPK() {
		return numFlowIdPK;
	}

	public void setNumFlowIdPK(int numFlowIdPK) {
		this.numFlowIdPK = numFlowIdPK;
	}

	public EmployeeDetailsMaster getLeaveApplicantEmpId() {
		return leaveApplicantEmpId;
	}

	public void setLeaveApplicantEmpId(EmployeeDetailsMaster leaveApplicantEmpId) {
		this.leaveApplicantEmpId = leaveApplicantEmpId;
	}

	public EmployeeDetailsMaster getLeaveFirstApprovalEmpId() {
		return leaveFirstApprovalEmpId;
	}

	public void setLeaveFirstApprovalEmpId(EmployeeDetailsMaster leaveFirstApprovalEmpId) {
		this.leaveFirstApprovalEmpId = leaveFirstApprovalEmpId;
	}

	public EmployeeDetailsMaster getLeaveSecondApprovalEmpId() {
		return leaveSecondApprovalEmpId;
	}

	public void setLeaveSecondApprovalEmpId(EmployeeDetailsMaster leaveSecondApprovalEmpId) {
		this.leaveSecondApprovalEmpId = leaveSecondApprovalEmpId;
	}

	public EmployeeDetailsMaster getLeaveFinalApprovalEmpId() {
		return leaveFinalApprovalEmpId;
	}

	public void setLeaveFinalApprovalEmpId(EmployeeDetailsMaster leaveFinalApprovalEmpId) {
		this.leaveFinalApprovalEmpId = leaveFinalApprovalEmpId;
	}

	@Override
	public String toString() {
		return "LeaveFlowTableMaster [numFlowIdPK=" + numFlowIdPK + ", leaveApplicantEmpId=" + leaveApplicantEmpId
				+ ", leaveFirstApprovalEmpId=" + leaveFirstApprovalEmpId + ", leaveSecondApprovalEmpId="
				+ leaveSecondApprovalEmpId + ", leaveFinalApprovalEmpId=" + leaveFinalApprovalEmpId + "]";
	}

	
	
	
}
