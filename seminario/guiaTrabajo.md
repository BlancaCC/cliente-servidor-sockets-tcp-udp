- qué es Tor
- funcionamiento / n
- historia
- infraestructura
- funcionamiento 
- debilidades
- guía de cómo utilizarlo
- cómo influye en al sociedad


# Seminario Tor  


## Qué es lo que busca tor

No se puedan rastrear paquetes para llegar hasta el usuario (su dirección ip)
, como efecto colateral es más difícil vigilar y censurar el contenido. 

### Porqué la red que utilizamos normalmente no funciona   
Protocolos de nivel superior y otras características: cookies, plugins java, flash, 
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
 
Ideas esenciales:  PROXY APLICACIÓN -> ONION PROXY ->(entry funnel) ONION ROUTER -> ... -> ONION RUTER (exit funnel) -> mensaje a destino 

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
Cambiar parcialment e la  PROXY APLICACIÓN -> ONION PROXY ->(entry funnel) ONION OROUTER -> ... -> ONION RUTER (exit funnel) -> mensaje a destino topología del circuito: Leakhy-pipe circuit topology:  permiten salida del circuiwall de red. SOCKS es una abreviación de "SOCKetS". to usando nodo intermedio: frustra ataques que se basen en atacar el último nodo. 





 
 



## Fuentes : 

https://es.wikipedia.org/wiki/Internet_profunda 
https://www.xataka.com/basics/que-dark-web-que-se-diferencia-deep-web-como-puedes-navegar-ella

https://es.wikipedia.org/wiki/Tor_(red_de_anonimato)
https://openwebinars.net/blog/que-es-el-routing/
https://es.wikipedia.org/wiki/Servidor_proxy
https://es.wikipedia.org/wiki/Red_de_mezcla
https://es.wikipedia.org/wiki/Encaminamiento_cebolla
