public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		Hangman newGame = new Hangman("hangman", 7);
		newGame.play();
	}
}
