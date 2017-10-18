package com.syuan0321.unitseed.Semaphore;

import javax.sql.DataSource;

public class ResourceExample {
	public static final int RDY_INI = 0;
	public static final int IN_USE = 1;

	private DataSource da;
	private String name;
	private int status;
	
	public ResourceExample(){
		status = 0;
	}
	
	public void reSet(){
		status = 0;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public DataSource getDa() {
		return da;
	}

	public void setDa(DataSource da) {
		this.da = da;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
