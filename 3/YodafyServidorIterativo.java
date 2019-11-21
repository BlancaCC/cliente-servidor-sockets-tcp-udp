import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//
// YodafyServidorIterativo
// (CC) jjramos, 2012
//
public class YodafyServidorIterativo {

    public static void main(String[] args) {
	
	// Puerto de escucha
	int port=8989;

	       		
	// Abrimos el socket en modo pasivo, escuchando el en puerto indicado por "port"
	ServerSocket  socketServidor = null ;
	try {
	    socketServidor = new ServerSocket(port);
	} catch (IOException e){
	    System.err.println("Error no se pudo abrir el puerto "+port +"\n");
	}
				    
	do {

	    // Aceptamos una nueva conexión con accept()
	    Socket socketConexion = null;
	    try {
		socketConexion = socketServidor.accept();
	    }  catch (IOException e){
		System.err.println("Error: no se pudo aceptar la conexión solicitada");
	    }
						
	    // Creamos un objeto de la clase ProcesadorYodafy, pasándole como 
	    // argumento el nuevo socket, para que realice el procesamiento
	    // Este esquema permite que se puedan usar hebras más fácilmente.
	    //ProcesadorYodafy procesador=new ProcesadorYodafy(socketServidor);
	    ProcesadorYodafy procesador=new ProcesadorYodafy(socketConexion);
	    procesador.start();
		
				
	} while (true);
	
    }

    //socketServidor.close();		

}
