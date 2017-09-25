package com.syuan0321.unitseed.Cloneable;

import java.lang.Thread.State;
import java.util.HashSet;

public class DeepClone {
	static class Body implements Cloneable{  
	    public Head head;  
	    public Body() {}  
	    public Body(Head head) {this.head = head;}  
	    
	    public int state = 0;
	  
	    @Override  
	    protected Object clone() throws CloneNotSupportedException {  
	        Body newBody =  (Body) super.clone();  
	        newBody.head = (Head) head.clone();  
	        return newBody;  
	    }  
	      
	}  
	  
	static class Head implements Cloneable{  
	    public Head() {}  
	    public int substate = 0;
	    @Override  
	    protected Object clone() throws CloneNotSupportedException {  
	        return super.clone();  
	    }  
	}   
	  
	  
	public static void main(String[] args) throws CloneNotSupportedException {  
	      
	    Body body = new Body(new Head());  
	    Body body1 = (Body) body.clone();  
	    body.state = 1;
	    body.head.substate = 3;
	    
	    HashSet<String> hs = new HashSet<>();
	    for(String s : hs){
	    	
	    }
	    
	    System.out.println(body.state + "   " + body1.state);
	    System.out.println(body.head.substate + "   " + body1.head.substate);
	    
	    
	    
	    System.out.println("body == body1 : " + (body == body1) );  
	      
	    System.out.println("body.head == body1.head : " +  (body.head == body1.head));  
	      
	}  
}
