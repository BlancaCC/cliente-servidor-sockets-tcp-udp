import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress; 
//
// YodafyServidorIterativo
// (CC) jjramos, 2012
//
public class YodafyServidorIterativo {

    public static void main(String[] args) {
	
	// Puerto de escucha
	int port=8989;	       		
	// Abrimos el socket en modo pasivo, escuchando el en puerto indicado por "port"
	DatagramSocket  socketServidor = null ;
	do{
	    try {
		socketServidor = new DatagramSocket(port);
	    } catch (IOException e){
		System.err.println("Error no se pudo abrir el puerto "+port +"\n");
	    }			    
	
	    
	    ProcesadorYodafy procesador=new ProcesadorYodafy(socketServidor);
	    procesador.procesa();
	    	
				
	} while (true);
	// socket.close(); ya lo cerramos en el ProcesadorYodify
	
    }   
    
}
