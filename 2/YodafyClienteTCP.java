//
// YodafyServidorIterativo
// (CC) jjramos, 2012
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class YodafyClienteTCP {

    public static void main(String[] args) {
		
		
	// Nombre del host donde se ejecuta el servidor:
	String host="localhost";
	// Puerto en el que espera el servidor:
	int port=8989;
		
	// Socket para la conexión TCP
	Socket socketServicio=null;
		
	try {
	    // Creamos un socket que se conecte a "host" y "port":
	    //////////////////////////////////////////////////////

	    try {
		socketServicio = new Socket(host, port);
	    } catch( UnknownHostException  e){
		System.err.println("Error: equipo desconocido\n");
	    } catch (IOException e) {
		System.err.println( "Error: no se pudo establecer la conexion");
	    }
	    
	    //obtenemos flujo de lectura y de escritura para el socket
	    // y lo introudcimos en objetos de control de flujo
	    
	    PrintWriter outPrinter = new PrintWriter(socketServicio.getOutputStream(), true);
	    BufferedReader inReader = new BufferedReader(new InputStreamReader(socketServicio.getInputStream()));
			
	    // Si queremos enviar una cadena de caracteres por un OutputStream, hay que pasarla primero

	    String bufferEnvio = "Al monte del volcan debes ir sin demora";
	    // Enviamos el array por el outputStream;

	    outPrinter.println(bufferEnvio);
	    outPrinter.flush();

	
	    // Leemos la respuesta del servidor. 
	    String bufferRecepcion = inReader.readLine(); 

	  
	    // Mstremos el string recibido  recibidos:
	    System.out.println("Recibido: \n" + bufferRecepcion);

	
	    // Una vez terminado el servicio, cerramos el socket (automáticamente se cierran

	    outPrinter.close();
	    inReader.close();
	    socketServicio.close(); 	
	    //////////////////////////////////////////////////////
	    
	    // Excepciones:
	} catch (UnknownHostException e) {
	    System.err.println("Error: Nombre de host no encontrado.");
	} catch (IOException e) {
	    System.err.println("Error de entrada/salida al abrir el socket.");
	}
    }
}
