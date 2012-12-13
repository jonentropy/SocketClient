package com.tal.socketclient;

import java.io.IOException;

public class SocketClientMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Socket client starting main...");
		
		try {
			SocketClient s = new SocketClient("127.0.0.1", 8080);
		} catch (IOException e) {
			System.out.println("Couldn't create client.");
		}
	
	System.out.println("end");

	}

}
