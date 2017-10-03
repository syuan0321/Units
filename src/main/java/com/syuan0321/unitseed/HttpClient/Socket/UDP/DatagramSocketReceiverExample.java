package com.syuan0321.unitseed.HttpClient.Socket.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramSocketReceiverExample {
	public static int PORT_NUM = 10086;	
	
	public static void main(String[] args) {
        // DatagramSocket(int port)
        try(DatagramSocket ds = new DatagramSocket(PORT_NUM)){
        	// DatagramPacket(byte[] buf, int length)
        	byte[] bys = new byte[1024];
        	int length = bys.length;
        	DatagramPacket dp = new DatagramPacket(bys, length);
        	
        	// public void receive(DatagramPacket p)
        	ds.receive(dp); // Blocking
        	
        	// public InetAddress getAddress()
        	InetAddress address = dp.getAddress();
        	String ip = address.getHostAddress();
        	// public byte[] getData():
        	// public int getLength():
        	byte[] bys2 = dp.getData();
        	int len = dp.getLength();
        	String s = new String(bys2, 0, len);
        	System.out.println(ip + "Receiving:" + s);
        }catch (Exception e) {
        	e.printStackTrace();
		}	

    }
}
