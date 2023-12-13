package com.example.aimlchatbot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userinformation")
public class Userinformation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="uname")
	private String uname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="Mobnum")
	private Long Mobnum;

	@Column(name="refid")
	private int refid;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobnum() {
		return Mobnum;
	}

	public void setMobnum(Long mobnum) {
		Mobnum = mobnum;
	}

	public int getRefid() {
		return refid;
	}

	public void setRefid(int refid) {
		this.refid = refid;
	}
	


}
