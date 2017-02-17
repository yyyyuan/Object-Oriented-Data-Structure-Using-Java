package hangman;

public class LinkedListGame {
	
	public static void main(String[] args) {
        Words words = new Words("data/grade2-words.txt");
        String word = words.pick();
        GameIO gameIO = new ConsoleGameIO();
        GameModel model = new LinkedListGameModel(word);
        GameController gameController = new GameController(gameIO, model);
        gameController.play();
	}

}
