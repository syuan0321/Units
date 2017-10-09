package com.syuan0321.unitseed.HttpClient.URLConnection;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class URLConnecionExample {
	static String str_url = "http://192.168.1.100:8080/myweb/1.html?name=lisi";
	public static void main(String[] args) {
        URL urlReceiver,urlSender;
        /**
         * Receiver
         * */
		try {
			//HTTP Receiver
			urlReceiver = new URL(str_url);
			//JAVA internal parsed object + socket 
			URLConnection connReceiver = urlReceiver.openConnection();
			System.out.println(connReceiver);
			//Get HTTP header
			String value = connReceiver.getHeaderField("Content-Type");
			System.out.println(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		/**
		 * Sender
		 * */
		try {
			//HTTP Sender
			urlSender = new URL(str_url);
			HttpURLConnection connSender = (HttpURLConnection)urlSender.openConnection();
			connSender.setRequestMethod("GET");
			
			connSender.setConnectTimeout(2000);
			connSender.setReadTimeout(5000);
			connSender.setDoInput(true);
			connSender.setUseCaches(false);
			
			int responseCode = connSender.getResponseCode();
			System.out.println("GET Response Code :: " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				BufferedReader in = new BufferedReader(new InputStreamReader(
						connSender.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				System.out.println(response.toString());
			} else {
				System.out.println("GET request not worked");
			}			
			

			// HttpsURLConnection SSL
			HttpsURLConnection.setDefaultSSLSocketFactory(new SSLSocketFactory() {
				@Override
				public Socket createSocket(InetAddress arg0, int arg1, InetAddress arg2, int arg3) throws IOException {
					return null;
				}
				
				@Override
				public Socket createSocket(String arg0, int arg1, InetAddress arg2, int arg3)
						throws IOException, UnknownHostException {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public Socket createSocket(InetAddress arg0, int arg1) throws IOException {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public Socket createSocket(String arg0, int arg1) throws IOException, UnknownHostException {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public String[] getSupportedCipherSuites() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public String[] getDefaultCipherSuites() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
					// TODO Auto-generated method stub
					return null;
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
    public static String getTextFromStream(InputStream is) {
        try {
            byte[] b = new byte[1024];
            int len;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while ((len = is.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            //From byteArray to read-able string
            String text = new String(bos.toByteArray());
            return text;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }	
	
	
}
