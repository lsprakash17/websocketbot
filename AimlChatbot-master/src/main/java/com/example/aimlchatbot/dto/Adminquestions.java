package com.example.aimlchatbot.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="adminquestions")
public class Adminquestions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="id")
	private int id;
	
	@Column(name = "addabout")
	private String addabout;
	 
	@Column(name="justification")
	private String justification;

	

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


	
	
	
	

}
