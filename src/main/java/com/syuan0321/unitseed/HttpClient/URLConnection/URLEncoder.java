/***
 * URLEncoding BaseEncoding
 * 
 * http using MIME protocol which is not reliable on ASCII (7bit encoding 0~127 which 128~255 is not visible)[Test tranforming not Stream transforming]
 * ASCII caused char lost error on specifical chars like 10,13
 * 
 * 
 */
package com.syuan0321.unitseed.HttpClient.URLConnection;

import java.net.URLDecoder;

public class URLEncoder {
	public static void main(String[] args) {
		String url = "http://www.google.com?serarch=\"helloworld\"&key=value";//& ? 
		//URLEncoder encode
		String encode = java.net.URLEncoder.encode(url);
		System.out.println(encode);
		//URLDecoder decode
		String decode = URLDecoder.decode(encode);
		System.out.println(decode);
		String decode2 = URLDecoder.decode(url);
		System.out.println(decode2);
	}

}
