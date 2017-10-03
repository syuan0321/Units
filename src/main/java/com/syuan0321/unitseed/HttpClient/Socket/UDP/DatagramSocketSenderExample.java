package com.syuan0321.unitseed.HttpClient.Socket.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramSocketSenderExample {
	public static int PORT_NUM = 10086;
	public static String IP = "127.0.0.1";
	
	
	
	public static void main(String[] args){
        // Create DatagramSocket()
		try (DatagramSocket ds =  new DatagramSocket() ){
			
			// Create and package sending data 
			byte[] bys = "hello,udp,here is Derek. ".getBytes();
			int length = bys.length;
			
			// IP
			InetAddress address = InetAddress.getByName(IP);
			// Port
			int port = PORT_NUM;
			// DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
			DatagramPacket dp = new DatagramPacket(bys, length, address, port);
			
			/******************************************************************/
			// Sending data...
			// public void send(DatagramPacket p)
			ds.send(dp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
}
