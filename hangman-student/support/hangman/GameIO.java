package hangman;

/**
 * An instance of GameIO is used to interact with the user of the hangman game.
 */
public interface GameIO {
  /**
   * Returns the next letter from the input. 
   */
  public char nextLetter();
	
  /**
   * Displays the String s to the user. 
   */
  public void displayMessage(String s);

  /**
   * Displays the current state of the gallows to the user.
   */
  public void displayGallows(int state);
}
