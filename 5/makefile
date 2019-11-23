MemClient.class: MemClient.java
	javac MemClient.java
MemServidor.class: MemServidor.java MemProcessor.java
	javac MemServidor.java

cliente: MemClient.class
	java MemClient

servidor: MemServidor.class
	java MemServidor

clear:
	rm *~ *.class
