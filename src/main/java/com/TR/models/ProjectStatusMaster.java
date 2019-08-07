package com.TR.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProjectStatusMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int projectStatusIdPk;
	
	private String projectName;
	private String userId;
	private String userName;
	private String userDesignation;
	public int getProjectStatusIdPk() {
		return projectStatusIdPk;
	}
	public void setProjectStatusIdPk(int projectStatusIdPk) {
		this.projectStatusIdPk = projectStatusIdPk;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserDesignation() {
		return userDesignation;
	}
	public void setUserDesignation(String userDesignation) {
		this.userDesignation = userDesignation;
	}
	@Override
	public String toString() {
		return "ProjectStatusMaster [projectStatusIdPk=" + projectStatusIdPk + ", projectName=" + projectName
				+ ", userId=" + userId + ", userName=" + userName + ", userDesignation=" + userDesignation + "]";
	}
	

	
}
