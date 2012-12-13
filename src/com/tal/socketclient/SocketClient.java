package com.tal.socketclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketClient {
	private String hostname;
	private int port;

	//Sockets	
	private Socket socket = null;

	//In and out writers
	PrintWriter out;
	BufferedReader in;

	public SocketClient() throws IOException{
		this("localhost", 8080);
	}

	public SocketClient(String host, int port) throws IOException{
		this.hostname = host;
		this.port = port;

		//Create the socket
		try {
			socket = new Socket(hostname, port);
		} catch (IOException e) {
			System.err.println("Error creating socket: ");
			e.printStackTrace();
			throw(e);
		}
		startServer();
	}

	private void startServer() throws IOException{
		//create the in and out
		out = new PrintWriter(socket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		runServer();
	}

	private void runServer() throws IOException{
		String inputLine, outputLine;

		for(int i=0; i<10; i++) {
			outputLine = "GIMME DATA!";
			out.println(outputLine);
			
			if((inputLine = in.readLine()) != null) {
				System.out.println("Reply received from server" + socket.getInetAddress() +": " + inputLine);
			}
		}

		out.close();
		in.close();
		socket.close();
	}
}
