package hangman;

import sun.awt.AWTAccessor.SystemColorAccessor;

/**
* The Array implementation of the GameModel interface.
*/
public class ArrayGameModel implements GameModel {

    /** The acceptable characters. */
    private static final String ALPHABET="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /** hung state */
    private int state;
    
    private char[] previousGuess = new char[100];
    
    private char[] currentlyGuess;
    
    private char[] guessWord;
    
    private int index = 0;
    
    private int[] indexOfCorrect;
    
    private String wordGuessed;
   
    
    /**
        * Creates a new ArrayGameModel object.
        * 
        * guessWord the word to guess
        */
    public ArrayGameModel(String guessWord) {
        // TODO (1)
    	state = STARTING_STATE;
    	wordGuessed = guessWord;
    	this.guessWord = guessWord.toCharArray();
    	this.currentlyGuess = new char[guessWord.length()];
    	for (int i = 0; i < currentlyGuess.length; i++) {
			currentlyGuess[i] = '_';
		}
    	indexOfCorrect = new int[guessWord.length()+1];
    }

    public boolean isPriorGuess(char guess) {
        // TODO (2)
    	int ifPriorGuess = 0;
    	
    	for (int i = 0; i <= index; i++) {
			if (guess == previousGuess[i]) {
				ifPriorGuess++;
			}
		}
    	if (ifPriorGuess != 0) {
    		return true;
    	}
    	else return false;
    }

    public int numberOfGuesses() {
        // TODO (3)
        return index;
    }

    public boolean isCorrectGuess(char guess) {
        // TODO (4)
    	int numOfChange = 0;
    	
    	for (int i = 0; i < guessWord.length; i++) {
			if (guess == guessWord[i]) {
				numOfChange++;
			}
    	}
    	if (numOfChange != 0) {
       		return true;
    	}
    	else	
    		return false;
    }



    public boolean doMove(char guess) {
        // TODO (5)
    	if (isCorrectGuess(guess) && !isPriorGuess(guess)) {
        	for (int i = 0; i < guessWord.length; i++) {
    			if (guess == guessWord[i]) {
    				indexOfCorrect[i+1] = i+1;
    			}
        	}
    		for (int j = 1; j < indexOfCorrect.length; j++) {
				if (indexOfCorrect[j] != 0) {
					currentlyGuess[j-1] = guessWord[j-1];
				}
				
			if (!isPriorGuess(guess)) {
				previousGuess[index] = guess;
				index++;
				}
			}
    		return true;
    	}
    	else {
    		if (!isPriorGuess(guess)) {
				previousGuess[index] = guess;
				index++;
				state++;
				}
    		return false;
    	}
    }

    public boolean inWinningState() {
        // TODO (6)
    	int numOfNotGuessed = 0;
    	for (int i = 1; i < indexOfCorrect.length; i++) {
			if (indexOfCorrect[i] == 0) {
				numOfNotGuessed++;
			}
		}
    	if (numOfNotGuessed == 0) {
    		return true;
    	}
    	else return false;
    }

    public boolean inLosingState() {
        // TODO (7)
    	if (state == 10) {
    		return true;
    	}
    	else return false;
    }

    public String toString() {
        // TODO (8)    	
    	String board = "";
    	for (int i = 0; i < currentlyGuess.length; i++) {
			board = board + currentlyGuess[i];
			if (i != currentlyGuess.length-1) {
				board += ' ';
			}
		}
        return board;
    }

    public String previousGuessString() {
        // TODO (9)
    	String previousGuessString = "[";
    	for (int i = 0; i < index; i++) {
    		if (i != 0) {
				previousGuessString = previousGuessString + ',' + ' ';
			}
			previousGuessString = previousGuessString + previousGuess[i];
			
		}
    	previousGuessString += "]";
        return previousGuessString;
    }

    public int getState() {
        return state;
    }
    

    public String getWord() {
        // TODO (10)
        return wordGuessed;
    }
}
