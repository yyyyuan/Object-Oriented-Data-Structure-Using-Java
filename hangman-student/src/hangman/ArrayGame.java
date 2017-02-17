package hangman;

/**
 * A class to play the hangman game.
 */
public class ArrayGame {

	public static void main(String[] args) {
          Words words = new Words("data/grade2-words.txt");
          String word = words.pick();
          GameIO gameIO = new ConsoleGameIO();
          GameModel model = new ArrayGameModel(word);
          GameController gameController = new GameController(gameIO, model);
          gameController.play();
	}

}
