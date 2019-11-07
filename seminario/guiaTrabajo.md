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
- proxy aplicación -> opnion proxy NOdo OP  (ruta destino estrucutra de datos al que enciar el siguiente nodo OPNIOS FORWARD : Cifra con su clave pública 
  Ejemplo pasará por <4,3,5> cifraría 
EPK_4(dirección3, EPK_3(dirección router 5, EPK_5( datos) )


Los datos es civada por un onion proxi al entry funnel un onion router  OR. 



 
 



## Fuentes : 

https://es.wikipedia.org/wiki/Internet_profunda 
https://www.xataka.com/basics/que-dark-web-que-se-diferencia-deep-web-como-puedes-navegar-ella

https://es.wikipedia.org/wiki/Tor_(red_de_anonimato)
https://openwebinars.net/blog/que-es-el-routing/
https://es.wikipedia.org/wiki/Servidor_proxy
https://es.wikipedia.org/wiki/Red_de_mezcla
https://es.wikipedia.org/wiki/Encaminamiento_cebolla
