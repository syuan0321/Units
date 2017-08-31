package com.syuan0321.unitseed.Cloneable;

import java.io.Serializable;

public class CloneableC extends Object implements Cloneable,Serializable {
	private static final long serialVersionUID = 1L;
	
	private int x ;
	
	
	public CloneableC() {
		x = 3;
	}
	
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	public static void main(String[] args) {
		try {
			CloneableC c0 = new CloneableC();
			c0.x = 6;
			CloneableC c1 = new CloneableC();
			CloneableC c2 = (CloneableC) c0.clone();
			CloneableC c3 = c0;
			
			System.out.println(c0);
			System.out.println(c1);
			System.out.println(c2);
			System.out.println(c3);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
