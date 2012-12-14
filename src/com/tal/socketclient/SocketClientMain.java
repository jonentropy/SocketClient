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


			for(int i=0; i<10; i++) {
				String outputLine = "GIMME DATA! :-)";		
				String inputLine = s.getData(outputLine);

				if(inputLine != null) {
					System.out.println("Reply received from server: " + inputLine);
				}
			}

		} catch (IOException e) {
			System.out.println("Couldn't create client.");
		}

		System.out.println("end");
	}
}
