all: Main.class Hangman.class

Main.class: Main.java
	javac Main.java

Hangman.class: Hangman.java
	javac Hangman.java

run: Main.class
	java Main fix
