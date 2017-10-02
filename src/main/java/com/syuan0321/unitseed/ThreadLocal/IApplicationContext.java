package com.syuan0321.unitseed.ThreadLocal;

import java.util.Map;

public interface IApplicationContext {

	public void unsetThreadLocal() ;

	public Map<String,Object> getAttributes() ;
	
	public Object getAttribute(String name) ;
	
}
