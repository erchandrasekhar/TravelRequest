package com.TR.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TR.models.TravelRequest;

@Repository
public interface TravelRequestrepository extends CrudRepository<TravelRequest, Integer>
{
	@Query(value = "SELECT * FROM alpo_tr.travel_request where num_applied_by_emp_id=?1", nativeQuery = true)
	public List<TravelRequest> getTravelRequestListByApplicant(int applicant_empid);

}
