package com.TR.repository;

import org.springframework.data.repository.CrudRepository;

import com.TR.models.TaDaMaster;

public interface TaDaMasterRepository extends CrudRepository<TaDaMaster, Integer>{
	
	public TaDaMaster findByUserDesignation(String userDesignation);

}
