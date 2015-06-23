package com.example.root.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
 

public class SimpleTextServer {
 
	Sender sender = new Sender("AIzaXXXXXXXXXXXXXXXXXXXXXXXXX");
	Message message = new Message.Builder().build();
	Result result = sender.send(message,"device_token", 1);
	System.out.println(result.toString());
}
