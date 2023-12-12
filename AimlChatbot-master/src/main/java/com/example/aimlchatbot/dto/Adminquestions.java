package com.example.aimlchatbot.dto;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adminquestions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	private String addabout;
	 
	private String justification;
	
	private Boolean Show;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddabout() {
		return addabout;
	}

	public void setAddabout(String addabout) {
		this.addabout = addabout;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public Boolean getShow() {
		return Show;
	}

	public void setShow(Boolean show) {
		Show = show;
	}

	public Adminquestions() {
		super();
	}

	public Adminquestions(String addabout, String justification, Boolean show) {
		super();
		this.addabout = addabout;
		this.justification = justification;
		Show = show;
	}
	
	
	
	

}
