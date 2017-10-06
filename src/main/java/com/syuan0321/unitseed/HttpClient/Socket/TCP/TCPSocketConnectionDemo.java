package com.syuan0321.unitseed.HttpClient.Socket.TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TCPSocketConnectionDemo {
	public static int PORT_NUM = 10087;
	public static String IP = "127.0.0.1";

	public static void main(String[] args) {
		try (Socket s = new Socket(IP, PORT_NUM)) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

			String line = null;
			while ((line = br.readLine()) != null) {
				if ("exit".equalsIgnoreCase(line)) {
					break;
				}
				bw.write(line);
				bw.newLine();
				bw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
