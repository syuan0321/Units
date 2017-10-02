/*ApplicationContext using Threadlocal
 * 
 * Threadlocal as a cached map to store runtime variable:
 * ApplicationContext.findContext().setA(a);
 * 	then:
 * ApplicationContext.findContext().getA();==. return cache Object A
 * 
 * 
 * 
 * 
 */
package com.syuan0321.unitseed.ThreadLocal;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.http.HTTPException;

public class ApplicationContext implements IApplicationContext{
	private static ThreadLocal<ApplicationContext> dl4LocalThread = new ThreadLocal<ApplicationContext>();
	HTTPException session = null;
	private boolean isThreadBound = false;
	
	private Map<String,Object> attributes = new HashMap<String,Object>();

	
	private ApplicationContext(){}
	
	
	public static synchronized ApplicationContext findContext() {
		if(dl4LocalThread.get() == null){
			ApplicationContext context = new ApplicationContext();
			context.setThreadLocal();
			return context;
		}else{
			return dl4LocalThread.get();
		}
	}
	
	private synchronized void setThreadLocal() {
		if(dl4LocalThread.get() == null){
			dl4LocalThread.set(this);
			isThreadBound = true;
		}
	}

    @Override
	public synchronized void unsetThreadLocal() {
		if(isThreadBound) {
			isThreadBound = false;
			dl4LocalThread.set(null);
		}
	}

    @Override
	public Map<String,Object> getAttributes() {
		return attributes;
	}
	
    @Override
	public Object getAttribute(String name) {
		return attributes.get(name);
	}
    
    
    public static void main(String[] args) {
		ApplicationContext context =  ApplicationContext.findContext();
		/**
		 * 
		 * ApplicationContext.findContext().getA();==. return cache Object A
		 * 
		 */
		
	}
    
}
