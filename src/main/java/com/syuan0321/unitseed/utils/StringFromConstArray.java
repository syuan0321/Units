package com.syuan0321.unitseed.utils;
/**************************************************************************
StringFromConstArray<br/>


***************************************************************************/

public class StringFromConstArray {
	//Must start with 0, because array 1st position indexed as 0
	public static final int	TYPE_A= 0;
	public static final int	TYPE_B= 1;
	public static final int	TYPE_C= 2;
	public static final int	TYPE_D= 3;
	public static final String[] TYPE_VALUES = {"A", "B", "C", "D"};	//Start with index 0
	
	private static String fromConstArray(String[] strings, Object index) {
		int i = 0;
		if (index instanceof Integer) {
			i = (Integer)index;
			if (i < 0 || i >= strings.length) {
				i = 0;
			}
		}
		return strings[i];
	}
	
	
	public static void main(String[] args) {
		for (int i = 0; i <= 3; i++) {
			String result = fromConstArray(StringFromConstArray.TYPE_VALUES, i);
			System.out.println(result);		
		}
		
	}
	
}
