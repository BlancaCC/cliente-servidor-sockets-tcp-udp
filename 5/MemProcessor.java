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
    
    private Memories m;

    //constructor
    public MemProcessor(Socket socket, Memories m) {
	this.socket = socket;
	this.m = m; 
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
	Boolean in = true;

	try {
	    //
	    while(in){
		String  petition = inReader.readLine();
		System.out.println("Hemos recibido la petición " + petition);
	     
		switch (petition) {
		case "register":
		    Register();
		    break;
		case "login":
		    if(Login()){
			Write();
		    }
		    break;
		    
		case "exit":
		    in = false;
		break;
		default:
		    outPrinter.println("Petición no en protocolo");
		    outPrinter.flush();
		}
	    } //while 
	   
	    outPrinter.close();
	    inReader.close();
	} catch(IOException e) {
	    System.err.println("Stream object can't be used"); 
	}
    }


    private boolean Login(){
	boolean ret = false;
	try{
	    String name = inReader.readLine();
	    String password = inReader.readLine();
	
	     ret = m.correctPassword(name, password);
	
	    String answer = "NO";
	    if(ret)
		answer = "OK";

	    outPrinter.println(answer);
	    outPrinter.flush();

	} catch(IOException e) {
	    System.err.println("Stream object can't be used"); 
	}
	    
	return ret;

    }
    private  void Register() {

	try {
	    outPrinter.println("ok register; wait for you user");
	    outPrinter.flush();

	    //ask for a name until it doesn't exist
	    String name = inReader.readLine();
	    while( m.userExists(name)){
		outPrinter.println("no");
		outPrinter.flush();
		name = inReader.readLine();
	    }
	    outPrinter.println("OK");
	   
	    //ask for a password
	    String password = inReader.readLine();

	    //add user and password
	    m.addUser(name, password);
	    System.out.println("New user: "+ name +
			       " Password: " + password);

	} catch(IOException e) {
	    System.err.println("Stream object can't be used"); 
	}
    }

    private void Write(){
	try{
	    String ms =inReader.readLine();
	    m.addContent(ms);
	} catch(IOException e) {
	    System.err.println("Stream object can't be used"); 
	}

	
    }
    
}

