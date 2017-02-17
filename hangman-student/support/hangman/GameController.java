package hangman;

/**
 * A class to play the hangman game.
 */
public class GameController {

  /** The game board state. */
  private GameModel model;
	
  /** The I/O class for the game to the user. */
  private GameIO gameIO;
	
  /**
   * Creates a new GameController object.
   */
  public GameController(GameIO gameIO, GameModel model) {
    this.gameIO = gameIO;
    this.model = model;
  }
	
  /**
   * Plays the hangman game.
   */
  public void play() {
    boolean endOfGame = false;
    char guess;
    gameIO.displayMessage(model.toString());		
    do {
      guess = gameIO.nextLetter();
      if (guess == 0) {
        endOfGame = true;
      }
			
      if (model.isPriorGuess(guess)) {
        gameIO.displayMessage("You guessed " + guess + " already!");				
        gameIO.displayMessage("guess: " + model);
      }
			
      if (!model.isPriorGuess(guess)) {
        boolean success = model.doMove(guess);
				
        if (!success) {
          gameIO.displayMessage("Bad guess!");
        } else {
          gameIO.displayMessage("Good guess!");
        }
      }
			
      gameIO.displayMessage("");
      gameIO.displayGallows(model.getState());
      gameIO.displayMessage(model.previousGuessString());
			
      if (model.inWinningState()) {
        gameIO.displayMessage("You won!");
        gameIO.displayMessage("The word was " + model.getWord() + "!");
        gameIO.displayMessage("Number of guesses: " + model.numberOfGuesses());
        endOfGame = true;
      } else if (model.inLosingState()) {
        gameIO.displayMessage("The word was " + model.getWord() + "!");
        gameIO.displayMessage("Number of guesses: " + model.numberOfGuesses());
        gameIO.displayMessage("You lose!");
        endOfGame = true;
      } else {
        gameIO.displayMessage("");
        gameIO.displayMessage(model.toString());
      }

    } while (!endOfGame);
  }
}
