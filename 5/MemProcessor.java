/**
   @file MemProcessor 
   @brief Interact with client 
 */


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;


public class MemProcessor extends Thread {

    private Socket socket;      //referenced socket
    
    //communication streams 
    private InputStream input; 
    private OutputStream output;

    private PrintWriter outPrinter;
    private BufferedReader inReader; 
    


    //constructor
    public MemProcessor(Socket socket) {
	this.socket = socket; 
    }

    private void initStream() {
	try{
	outPrinter = new PrintWriter(socket.getOutputStream(), true);
	inReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}catch(IOException e) {
	    System.err.println("Error: can NOT stablish input/outpur streams in MEmProcessor"); 
	}
    }

    //paralell process
    public void run() {
	initStream();
	
	try {
	    
	    String  peticion = inReader.readLine();
	    System.out.println(petition); 
	    switch (peticion) {
	    default:

		outPrinter.print("ok register: ¿cómo se llama?");
		outPrinter.flush();
	
		name = inReader.readLine();		 
		System.out.print("ha accedido "+ ms);

		
		outPrinter.print("hi "+ms);
		outPrinter.flush();
	    }


	    
	    outPrinter.close();
	    inReader.close();
	} catch(IOException e) {
	    System.err.println("Stream object can't be used"); 
	}
    }

    
    
}
