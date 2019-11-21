all:
YodafyServidorIterativo.class: YodafyServidorIterativo.java ProcesadorYodafy.java
	javac YodafyServidorIterativo.java

YodafyClienteTCP.class: YodafyClienteTCP.java
	javac YodafyClienteTCP.java

servidor: YodafyServidorIterativo.class
	java YodafyServidorIterativo


cliente: YodafyClienteTCP.class
	java YodafyClienteTCP


clear:
	rm *~ *.class

