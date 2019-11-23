/**
   @file MemServidor 
   @brief Server: always waiting for a conexion 
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class MemServidor {

    public static void main(String[] args){
	
	int port = 7777;
	//open server socker in pasive mode 
	ServerSocket serverSocket = null;

	try {
	    serverSocket = new ServerSocket(port);
	} catch(IOException e){
	    System.err.println("Error: Port " + port + " can't be opened"); 
	}

	//It is always waiting for connections 
	Socket socketConnection = null;	
	while(true) {

	    // Accept new connection 
	    
	    try {
		socketConnection = serverSocket.accept(); 
	    } catch(IOException e){
		System.err.println("Error: New request can NOT be accepted"); 
	    }
	    
	    MemProcessor process = new MemProcessor(socketConnection,new Memories() );
	    process.start(); 

	    //process close socketConnection
	    
	} //while(true)

	
    }
    
}
