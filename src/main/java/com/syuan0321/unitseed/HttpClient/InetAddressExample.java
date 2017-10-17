package com.syuan0321.unitseed.HttpClient;

import java.net.InetAddress;
/**
 * 
 * only IP no port here
 * 
 * */
import java.net.InetSocketAddress;

public class InetAddressExample {
	
	public static void main(String[] args) {
		try {
			//InetAddress address = InetAddress.getByName("decisionlender.solutions");
			InetAddress address = InetAddress.getByName("google.com");
			
			System.out.println("Name: " + address.getHostName() + "  IP: " + address.getHostAddress());
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
