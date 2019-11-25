//
// YodafyServidorIterativo
// 
//

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress; 
import java.net.UnknownHostException;

public class YodafyClienteUDP {

    public static void main(String[] args) {
		
	byte []buferEnvio;
	byte []buferRecepcion=new byte[256];
	int bytesLeidos=0;
		
	// Nombre del host donde se ejecuta el servidor:
	String host="localhost";
	// Puerto en el que espera el servidor:
	int port=8989;
	InetAddress direccion;
	DatagramPacket paquete;	
	DatagramSocket socket;

	try {
	    socket = new DatagramSocket();

	    direccion = InetAddress.getByName(host);
       
	    //para enviar paquete
	    buferEnvio="Al monte del volcan debes ir sin demora".getBytes();
	    paquete = new DatagramPacket(buferEnvio, buferEnvio.length,
					 direccion, port);
	    socket.send(paquete); 
		
	    //recibimos mensaje yodificado
	    paquete = new DatagramPacket(buferRecepcion, buferRecepcion.length);
	    socket.receive(paquete);
	    buferRecepcion = paquete.getData();
	    bytesLeidos = paquete.getLength(); 
	    //paquete.getAddress();
	    
	    //paquete.getport();

	    // MOstremos la cadena de caracteres recibidos:
	    System.out.println("Recibido: ");
	    System.out.println(new String(buferRecepcion, 0,buferRecepcion.length));  
	    /**
	    for(int i=0;i<buferRecepcion.length;i++){
		System.out.print((char)buferRecepcion[i]);
	    }
	    */		
	    socket.close(); // cerramos la conexión

	// Excepciones:
	} catch (UnknownHostException e) {
	    System.err.println("Error: Nombre de host no encontrado.");
	} catch (IOException e) {
	    System.err.println("Error de entrada/salida al abrir el socket.");
	}
    }
}
