package com.syuan0321.unitseed.Semaphore;

import javax.sql.DataSource;

public class ResourceExample {
	private DataSource da;
	private String name;

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
