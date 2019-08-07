package com.TR.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.TR.models.LeaveFlowTableMaster;
@Repository
public interface LeaveFlowTableMasterRepository extends CrudRepository<LeaveFlowTableMaster, Integer>{
	
	@Query(value = "SELECT * FROM alpo_tr.leave_approval_flow_table_master where num_leave_applicant_empid=?1", nativeQuery = true)
    public LeaveFlowTableMaster getLeaveApplicantEmpId(int leaveApplicantEmpId);

	


}
