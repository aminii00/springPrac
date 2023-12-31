package com.spring.member.vo;

import java.util.Date;

public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joindate;
	
	public MemberVO() {
		
	}
	
	public MemberVO(String id, String pwd, String name, String eamil) {
		this.id = id;
		this.pwd =pwd;
		this.email = eamil;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	
}
