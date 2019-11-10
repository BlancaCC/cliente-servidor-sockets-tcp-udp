- qué es Tor
- funcionamiento / n
- historia
- infraestructura
- funcionamiento 
- debilidades
- guía de cómo utilizarlo
- cómo influye en al sociedad


# Seminario Tor  

## Preliminares  

### Web superficial  

-Porción de www que es pública y encontrable por los motorés de búsqueda de las páginas web.  Páginas web que se enlazan a otras páginas web 
 
Las arañas de los buscadores van recorriendo las páginas web, almacenando información que contienen y buscando enlaces a otros sitios web para seguir actualizando sus bases de datos. 
Se conoce como Internet superficial a la porción de Internet que es indexada por las arañas de los motores de búsqueda. 

### Deep wed o red produnda  (90%)

Contenido interner no indexado por motores de búsqueda convecionales (Google, yahoo, bing) 

Origen: 
- Servidores anteriores no son capaces de encontrar o indexar gran parte de la información existente en Internet o páginas privadas. 

- Paper científicos, archivo privado google drive


### Dark web   (0.1% de la deep web)
- Subconjunto de la deep web que se oculta inrencionadamente 
- direcciones ip enmascaradas
- contenido que se encuetra en una darknet (web solo accesibles con porgramas específicos) 



## Qué es la red Tor   
Tor es la sigla de The Onion Router (en español: El Rúter Cebolla). Es un proyecto cuyo objetivo princiThe Onion Router pal es el desarrollo de una red de comunicaciones distribuida de baja latencia y superpuesta sobre internet, en la que el encaminamiento de los mensajes intercambiados entre los usuarios no revela su identidad, es decir, su dirección IP (anonimato a nivel de red) y que, además, mantiene la integridad y el secreto de la información que viaja por ella. 

Construye sobre software libre específico. Uso de encaminamiento de cebolla. 

### Enrutamiento   
- Mover paquetes de una red a otra  
Encaminamiento o enrutamiento es la función de nuscar paquetes en las posibles topología sde red "¿cuál es la mejor ruta?", "ruta de red"


#### Proxy   

Servidor o red informática que hace de intermiddario 
Ofrece; anonimato, contros de acceso, registro del tráfico, caché web

### Red de mezcla


Protocolo enrutamiento comunicacioens difíciles de rastreas usan cadenas de sercidores proxy (múltiples emisores -> reordenamos -> devuelven orden aleatoro) 

- Cifrado con criptografía asimétrica (muñeca rusa o cebolla)  
- Cada proxy descifra el mensaje cifrado de su propia capa para saber a dónde enviar el siguiente. 

Aquí la clave de cifrado, la existencia de un sercidor proxy con imposibilidad de rastreo. 




### Encaminamiento de cebolla
- Aplicando ideas de las redes de mezclado a los sistemas de encaminamiento. 

#### implemetación  
 Chaum de esconder la relación entre el origen y el destino de una información encapsulando los mensajes en capas de criptografía de clave pública. 
 
 
 un modo de encaminamiento, lo que hacemos es transmitir mensajes con distintas capas de cifrado (por ese ligero parecido resultante y coincidente con ése interior enrollado del bulbo con un diagrama de la explicación de su viaje, a éstas redes se les conoce como 'de cebolla') sobre un camino compuesto por nodos de mezclado (mixes) convertidos ahora en routers (router de cebolla) donde cada router del camino lo que hace es descifrar ('pela' una capa de la cebolla), transmitir y reordenar los mensajes antes de transmitir al siguiente router. 
 
Ideas esenciales:

- Emisor origen -> proxy aplicación : (homogenizaciín protocolo router) 
- proxy aplicación->[mensajes] -> onion proxy Nodo OP  (ruta destino estrucutra de datos al que enciar el siguiente nodo OPNIOS FORWARD : Cifra con su clave pública 
  Ejemplo pasará por <4,3,5> cifraría 
EPK_4(dirección3, EPK_3(dirección router 5, EPK_5( datos) )
(nodos forward por los que pasará)


- la estructura creada pasa del onion proxy al entry funnel el cual es un onio rute (Nodo OR)  -> Node OR

...

- último nodo OR : actua modo salida: exit funnel -> MENSAJE ORIGINAL QUE PRODUCCO EL proxy aplicación  -> envía información a la dirección destino especificada. 

**Respuesta del receptor**:
- Exit funnel: protocolo genérico, cifra clave privada envía al onion router
- onion router envía de vuelta por la estructura que ha pasado obteniendo  
ESK_4(ESK_3(ESK_4(datos_respuesta)))
- hasta que llega al onion proxy que descifra con claves públicas que escogió como camino origianal

## ¿dónde está la seguridad en este protocolo? 
- Con que uno de los nodo mantenga el anonimato el protocolo será seguro. 

## ¿dónde está la parte de mezcla?
- Retardo artificial para no identificar paquetes pro el tráfico de entrado a salida 
- Tráfico relleno 
- Tamaño fijo 
- Encaminamiento de ajo: 
  Paqutes que viajen agrupados, de tamaño fijo y con paquetes relleno 
  
## ¿ataque por reinyección? 
- Paquetes con un tiempo de validez  

## Publicación datos de concfiguraciń 

¿cada 
Tor servicio directorio: autoridades confiabkes que publican: routers activos, direcciones, clave públicas

## ¿Siempre se decide la misma ruta?  
Cambiar parcialment e la topología del circuito: Leakhy-pipe circuit topology:  permiten salida del circuito usando nodo intermedio: frustra ataques que se basen en atacar el último nodo. 





--- (mirar wikipedia)
    El emisor origen de la comunicación establece una conexión de inicialización con un proxy de aplicación (en inglés Application Proxy) que convierte los mensajes del protocolo específico de la aplicación a un formato genérico que pueda ser manejado por los routers.
    A continuación el proxy de aplicación envía los mensajes a un Onion Proxy (se le suele llamar nodo OP), el cual decide la ruta hacia el destino y construye la estructura de datos que se va a enviar al siguiente nodo y a la que se llama onion ('cebolla' en inglés) o onion forward ('cebolla hacia adelante', para indicar el sentido de la comunicación). La estructura de datos tiene una capa cifrada por cada router que vaya a formar parte del circuito.

    Si E P K ( ⟨ d a t o s ⟩ ) {\displaystyle E_{PK}({\rm {\langle datos\rangle )}}} {\displaystyle E_{PK}({\rm {\langle datos\rangle )}}} representa el cifrado usando la clave pública PK, D S K ( ⟨ d a t o s ⟩ ) {\displaystyle D_{SK}({\rm {\langle datos\rangle )}}} {\displaystyle D_{SK}({\rm {\langle datos\rangle )}}} representa el descifrado usando la clave privada y el onion proxy inicial decide que se va a usar la ruta <4,3,5> de routers, entonces el paquete que se envía al siguiente router puede ser representado por:

        E P K 4 ( direcciónderouter 3 , E P K 3 ( direcciónderouter 5 , E P K 5 ( ⟨ d a t o s ⟩ ) ) ) {\displaystyle E_{PK_{4}}({\mbox{direcciónderouter}}_{3},E_{PK_{3}}({\mbox{direcciónderouter}}_{5},E_{PK_{5}}({\rm {\langle datos\rangle )))}}} {\displaystyle E_{PK_{4}}({\mbox{direcciónderouter}}_{3},E_{PK_{3}}({\mbox{direcciónderouter}}_{5},E_{PK_{5}}({\rm {\langle datos\rangle )))}}}.

    La estructura de datos es enviada por el onion proxy a el entry funnel (punto de entrada al canal). El cual es un onion router (nodo OR) usado como punto de entrada a la red de encaminadores de la red cebolla. Este router descifra el paquete (pela su capa de la 'cebolla') y obtiene la dirección del siguiente nodo OR en el camino del mensaje.
    A continuación el entry funnel coge el resto del mensaje y lo manda al siguiente onion router.
    Así se continúa hasta llegar al onion router que actúa como nodo de salida al que llama exit funnel. Este nodo descifra y obtiene el mensaje que originalmente produjo el proxy de aplicación. Este mensaje se envía a la dirección destino especificada.
    Cuando el receptor envía una respuesta a un mensaje particular, el exit funnel lo convierte al protocolo genérico, lo cifra con su clave privada y lo envía de vuelta al onion router del que le vino el mensaje original.
    Cada onion router opera de forma similar cifrando la respuesta y lo envía de vuelta obteniendo una estructura de datos, a la que se llama reply onion o onion forward, que tiene la siguiente estructura:

        E S K 4 ( E S K 3 ( E S K 5 ( ⟨ d a t o s ⟩ ) ) ) {\displaystyle E_{SK_{4}}(E_{SK_{3}}(E_{SK_{5}}({\rm {\langle datos\rangle )))}}} {\displaystyle E_{SK_{4}}(E_{SK_{3}}(E_{SK_{5}}({\rm {\langle datos\rangle )))}}}

    El mensaje llega al onion proxy el cual descifra usando las claves públicas de los onion routers que escogió como camino del mensaje original.
---


Los datos es civada por un onion proxi al entry funnel un onion router  OR. 



 
 



## Fuentes : 

https://es.wikipedia.org/wiki/Internet_profunda 
https://www.xataka.com/basics/que-dark-web-que-se-diferencia-deep-web-como-puedes-navegar-ella

https://es.wikipedia.org/wiki/Tor_(red_de_anonimato)
https://openwebinars.net/blog/que-es-el-routing/
https://es.wikipedia.org/wiki/Servidor_proxy
https://es.wikipedia.org/wiki/Red_de_mezcla
https://es.wikipedia.org/wiki/Encaminamiento_cebolla
