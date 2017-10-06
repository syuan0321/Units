package com.syuan0321.unitseed.HttpClient.Socket.TCP;
/**
 * TCP Sending Data
 * *********
 * A:Create Socket, when this step succeed which means connection is built
 * B:Get output stream, and write data
 * C:Release connection source
 *
 * If connection error
 * java.net.ConnectException: Connection refused: connect
 */

import java.io.OutputStream;
import java.net.Socket;

public class SocketExample {
	public static int PORT_NUM = 10087;
	public static String IP = "127.0.0.1";

	public static void main(String[] args) {
		// Socket(InetAddress address, int port) && Socket(String host, int
		// port)
		try (Socket s = new Socket(IP, PORT_NUM)) { // Socket s = new
													// Socket(InetAddress.getByName(IP),
													// PORT_NUM);

			// public OutputStream getOutputStream()
			OutputStream os = s.getOutputStream();
			os.write("hello,tcp,here is Derek".getBytes());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
