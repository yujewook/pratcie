package com.pratice.dto;

import java.util.Arrays;

public class MemerInfoDto {

	private String id;
    private String pwd;
    private String name;
    private String email;
    private int rowCnt;
	private String birth;
	private String[] sns;
    private String reg_date;

    
    
	public int getRowCnt() {
		return rowCnt;
	}

	public void setRowCnt(int rowCnt) {
		this.rowCnt = rowCnt;
	}

    
    public MemerInfoDto() {
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
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth2) {
		this.birth = birth2;
	}
	
    public String[] getSns() {
		return sns;
	}

	public void setSns(String[] snsArray) {
		this.sns = snsArray;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getReg_date() {
		return reg_date;
	}
	
}
