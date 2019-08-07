package com.TR.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.TR.models.ProjectStatusMaster;

public interface ProjectStatusMasterRepository extends CrudRepository<ProjectStatusMaster, Integer>
{
  public List<ProjectStatusMaster> findByUserId(String numUserId);
}
