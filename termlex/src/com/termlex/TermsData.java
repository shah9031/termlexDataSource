package com.termlex;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO class to store data
@Entity(name="termdata")
@Table
public class TermsData {
	@Id
	private int id;
	private String term;
	
	//Getters and Setter for above properties
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	
	@Override
	public String toString() {
		return term;
	}
	
	

}
