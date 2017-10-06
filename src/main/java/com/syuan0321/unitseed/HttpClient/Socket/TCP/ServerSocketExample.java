package com.syuan0321.unitseed.HttpClient.Socket.TCP;

/**
 * TCP receive data:
 * **************
 * A:Create receiver 
 * B:Listen port and return a listened Socket obj
 * C:Get input stream
 * D:Release source
 */
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketExample {
	public static int PORT_NUM = 10087;

	public static void main(String[] args) {
		try (ServerSocket ss = new ServerSocket(PORT_NUM)) {
			Socket socket = ss.accept(); // listen the port

			InputStream is = socket.getInputStream();

			byte[] bys = new byte[1024];
			int len = is.read(bys); // Blocking style
			String str = new String(bys, 0, len);

			String ip = socket.getInetAddress().getHostAddress();

			System.out.println(ip + "---" + str);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
