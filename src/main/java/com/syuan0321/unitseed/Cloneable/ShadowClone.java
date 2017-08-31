package com.syuan0321.unitseed.Cloneable;

public class ShadowClone {
	static class Body implements Cloneable{  
	    public Head head;  
	    public Body() {}  
	    public Body(Head head) {this.head = head;}  
	  
	    @Override  
	    protected Object clone() throws CloneNotSupportedException {  
	        Body newBody =  (Body) super.clone();  
	        return newBody;  
	    }  
	      
	}  
	static class Head implements Cloneable{  
	      
	    public Head() {}  
	    @Override  
	    protected Object clone() throws CloneNotSupportedException {  
	        return super.clone();  
	    }  
	}   
	public static void main(String[] args) throws CloneNotSupportedException {  
	      
	    Body body = new Body(new Head());  
	      
	    Body body1 = (Body) body.clone();  
	      
	    System.out.println("body == body1 : " + (body == body1) );  
	      
	    System.out.println("body.head == body1.head : " +  (body.head == body1.head));  
	      
	      
	} 
}
