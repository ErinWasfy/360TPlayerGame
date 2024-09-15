package com.demo.msgtransport;

import com.demo.msgtransport.api.Client;
import com.demo.msgtransport.api.Server;

import java.net.ConnectException;

public class MsgtransportApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MsgtransportApplication.class, args);
		try {
			startClient();
		} catch (ConnectException e) {
			startServer();
		}
	}
	private static void startClient() throws ConnectException {
		print("Looking for a server");
		try {
			new Client();
		} catch (ConnectException e) {
			throw new ConnectException();
		}
	}

	/**
	 * Method to create a Server() instance.
	 *
	 */

	private static void startServer() {
		print("Server could not found");
		print("Initializing a Server");
		new Server();
	}

	/**
	 * Instead of writing System.out.println, this is a simplified solution It gets
	 * the value for the given key from the bundle.
	 *
	 * @param str
	 */
	private static void print(String str) {
		System.out.println(str);
	}

}
