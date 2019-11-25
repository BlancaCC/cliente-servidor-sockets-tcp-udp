//
// YodafyServidorIterativo
// (CC) jjramos, 2012
//
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress; 
import java.util.Random;


//
// Nota: si esta clase extendiera la clase Thread, y el procesamiento lo hiciera el método "run()",
// ¡Podríamos realizar un procesado concurrente! 
//
public class ProcesadorYodafy {
    // Referencia a un socket para enviar/recibir las peticiones/respuestas
    private DatagramSocket socket;
   
    // Para que la respuesta sea siempre diferente, usamos un generador de números aleatorios.
    private Random random;
	
    // Constructor que tiene como parámetro una referencia al socket abierto en por otra clase
    public ProcesadorYodafy(DatagramSocket socket) {
	this.socket=socket;
	random=new Random();
    }
	
	
    // Aquí es donde se realiza el procesamiento realmente:
    void procesa(){
		
	// Como máximo leeremos un bloque de 1024 bytes. Esto se puede modificar.
	byte [] datosRecibidos=new byte[1024];
	int bytesRecibidos=0;

	int port;
	InetAddress direccion;
	DatagramPacket paquete; 
		
	// Array de bytes para enviar la respuesta. Podemos reservar memoria cuando vayamos a enviarka:
	byte [] datosEnviar;
		

	try {

	    //recibir datos
	    paquete = new DatagramPacket(datosRecibidos, datosRecibidos.length);
	    socket.receive(paquete);
	    datosRecibidos = paquete.getData();
	    bytesRecibidos = paquete.getLength(); 
	    direccion = paquete.getAddress();
	    port = paquete.getPort();
	    // fin de recibir paquete 
       
	    // Yoda hace su magia:
	    // Creamos un String a partir de un array de bytes de tamaño "bytesRecibidos":
	    String peticion=new String(datosRecibidos,0,bytesRecibidos);
	    //System.out.println("El dato leído es " + peticion);
	    // Yoda reinterpreta el mensaje:
	    String respuesta=yodaDo(peticion);
	    // Convertimos el String de respuesta en una array de bytes:
	    //System.out.println("La respuesta que bamso a dar es " + respuesta);
	    datosEnviar=respuesta.getBytes();
			
	    // Enviamos la traducción de Yoda:
	    ////////////////////////////////////////////////////////
	    
	    paquete = new DatagramPacket(datosEnviar, datosEnviar.length,
					 direccion, port);
	    socket.send(paquete); 

	    socket.close(); 
	    ////////////////////////////////////////////////////////
			
			
			
	} catch (IOException e) {
	    System.err.println("Error al obtener los flujo de entrada/salida. en Procesador yodify");
	}

    }

    // Yoda interpreta una frase y la devuelve en su "dialecto":
    private String yodaDo(String peticion) {
	// Desordenamos las palabras:
	String[] s = peticion.split(" ");
	String resultado="";
		
	for(int i=0;i<s.length;i++){
	    int j=random.nextInt(s.length);
	    int k=random.nextInt(s.length);
	    String tmp=s[j];
			
	    s[j]=s[k];
	    s[k]=tmp;
	}
		
	resultado=s[0];
	for(int i=1;i<s.length;i++){
	    resultado+=" "+s[i];
	}
		
	return resultado;
    }
}
