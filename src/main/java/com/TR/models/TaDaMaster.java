package com.TR.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TaDaMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tadaIdPk;
	
	private String userDesignation;
	private Double ta;
	private Double da;
	private Double accomodation;
	public int getTadaIdPk() {
		return tadaIdPk;
	}
	public void setTadaIdPk(int tadaIdPk) {
		this.tadaIdPk = tadaIdPk;
	}
	public String getUserDesignation() {
		return userDesignation;
	}
	public void setUserDesignation(String userDesignation) {
		this.userDesignation = userDesignation;
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
	

	
	
}
