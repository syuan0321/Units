package com.syuan0321.unitseed.LifecycleEvent;

public class LifecycleException extends Exception{
	private String exceptionMessage;
	
	public LifecycleException(String reason) {
		super(reason);
		this.exceptionMessage = reason;
	}
	
	public LifecycleException(String reason, Throwable t) {
		super(reason);
		this.exceptionMessage = reason;
	}
	
	public String getReason() {
		return exceptionMessage;
	}
}
