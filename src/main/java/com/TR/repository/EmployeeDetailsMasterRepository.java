package com.TR.repository;

import org.springframework.data.repository.CrudRepository;

import com.TR.models.EmployeeDetailsMaster;

public interface EmployeeDetailsMasterRepository extends CrudRepository<EmployeeDetailsMaster, Long>{

	public EmployeeDetailsMaster findByNumEmployeeId(int numEmployeeId);
	public EmployeeDetailsMaster findByTxtEmployeeUserId(String textEmployeeId);
}
