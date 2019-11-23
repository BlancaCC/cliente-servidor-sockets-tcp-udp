/**
   @file MemClient
   @brief Client of memories 
   @date November 2019
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner; 


public class MemClient {

    // connection variables 
    private static String host="localhost";
    private static int port=7777;
    private static Socket socket = null;

    private static PrintWriter outPrinter;
    private static BufferedReader inReader;

    //menus variables
    private static  boolean in = true;
    private static BufferedReader stdin; //standar in
    private static Scanner scan;

    private static void init() {

	stdin = new BufferedReader(new InputStreamReader(System.in));
	scan = new Scanner(System.in);
	
	try {

	
	    //stablis connection 
	    try {
		socket = new Socket(host, port);
	    } catch( UnknownHostException  e){
		System.err.println("Error: unkown host");
	    } catch (IOException e) {
		System.err.println( "Error: connection can NOT be stablished");
	    }

	    // write and read stream
	    outPrinter = new PrintWriter(socket.getOutputStream(), true);
	    inReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    
	} catch (UnknownHostException e) {
	    System.err.println("Error: host not found");
	} catch (IOException e) {
	    System.err.println("Error in read/write.");
	}
    }


    private static void close() {
	try{

	    stdin.close();
	    scan.close();

	    //connection close 
	    inReader.close();
	    outPrinter.close();
	    socket.close();
	} catch(IOException e){
	    System.err.println("Error in close"); 
	}
    }

    // ------ messages ----- 

    private static String ms0 = "--- Wellcome to short memories manager:--- \n"+
"What do you want to do? (Enter the number): \n" +
"1) login \n" +
"2) register\n" +
"3) exit... :(  \n" +
"Option: ";


    private static int menu0() {
	int ret; 

	do {
	
        System.out.print(ms0);

        // This method reads the number provided using keyboard
        ret = scan.nextInt();
	
	} while( ret>3 || ret<1 );
	
	return ret; 
    }

    private static void register() {
	boolean askName = true;
	String name;

	//register protocol
	try{
	    outPrinter.print("register");
	    outPrinter.flush(); 

	    System.out.print("ha recibido?:" + inReader.readLine() );
	    while(askName){
		System.out.println("User: ");
		name = stdin.readLine();
	    
		outPrinter.print(name);

		System.out.println("La respuesta del servidor es: ");
		String ms = inReader.readLine();
		System.out.println("ya se ha léído es " + ms);
		askName = false; 
	    }
	}catch(IOException e){
	    System.err.println("Error in stream"); 
	}
	
    }

    public static void main(String[] args) {


	//init connection 
	init(); 

	while (in){
	    switch( menu0()){
	    case 2: //register
		register(); 
		break; 
	    case 3:
	    default:
		in = false; 
	    }
	    
	}


	//close connection and input 
	close(); 

	  
    }
}
