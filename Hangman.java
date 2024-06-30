
import java.util.Scanner;

class Hangman
{
    //track current guess, maxGuesses, word..
    private String word;
    private String currentGuess;
    private int maxGuesses;
    
    //constructor --> word and max attempts
    public Hangman(String word, int maxAttempts){
        this.word = word;
        this.maxGuesses = maxAttempts;
        this.currentGuess = "_".repeat(word.length()); //___ as long as the word
    }
    
    public void play(){
        char arrayOfCharacters[] = word.toCharArray(); //creates array of characters
        int guessesLeft = maxGuesses; //decrement after each guess
        
        Scanner character = new Scanner(System.in);

        while(guessesLeft<=maxGuesses){ //max guess = whatever user puts in
            System.out.println("Current guess: " + currentGuess + "  Guesses left : " + guessesLeft);
            System.out.println("Enter a character: ");
            String userInput = character.next(); //keep going til guessLeft = 0
            
            char userChar = userInput.charAt(0); //get 1st character //ignores all other things user puts in
            
            boolean correctGuess = false;
            for (int i=0;i<arrayOfCharacters.length;i++){ //iterate through each char and check it 
                if (userChar == arrayOfCharacters[i]){
                    correctGuess = true; //if userChar enetered == char in array, set as true
                    StringBuilder builder = new StringBuilder(currentGuess);
                    builder.setCharAt(i, userChar); //replace with correct letter
                    currentGuess = builder.toString(); //updates
                    
                }
            }
            if (correctGuess) { //print statements for correct and incorrect guessses
                System.out.println("Correct Guess!");
                guessesLeft--; //each time one less guess regardless of 
                if (currentGuess.equals(word)) {
                    System.out.println("You guessed the word: " + word);
                    break; //end game if the word is full
                }
            } else {
                System.out.println("Incorrect Guess!");
                guessesLeft--;
            }

            if (guessesLeft == 0) {
                System.out.println("No guesses left :'(((.. The word was: " + word);
                break; // ends if guesses maxed out
            }
        }
        
        character.close(); //close scanner
    }
}
