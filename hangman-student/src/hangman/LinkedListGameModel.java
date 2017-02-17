package hangman;

import sun.awt.AWTAccessor.SystemColorAccessor;

public class LinkedListGameModel implements GameModel {
	
	/** The acceptable characters. */
    private static final String ALPHABET="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /** hung state */
    private int state;
    
    private LLCharacterNode previousGuess;
    
    private LLCharacterNode currentlyGuess;
    
    private LLCharacterNode guessWord;
    
    private LLCharacterNode copyOfCurrentlyGuess;
    
    private LLCharacterNode copyOfGuessWord;
    
    private LLCharacterNode index;
    
	private LLCharacterNode positionOfCurrent = null;
                
	private LLCharacterNode position = null;
	
    private String wordGuessed;

    /**
     * Creates a new LinkedListGameModel object.
     * 
     * guessWord the word to guess
     */
    public LinkedListGameModel(String guessWord) {
     // TODO (1)
 	state = STARTING_STATE;
 	wordGuessed = guessWord;
 	this.guessWord = add(guessWord, null);
 	this.copyOfGuessWord = add(guessWord, null);
 	char[] temp = new char[guessWord.length()];
 	for (int i = 0; i < temp.length; i++) {
		temp[i] = '_';
	}
 	String forCurrentlyGuess = new String(temp);
 	this.currentlyGuess = add(forCurrentlyGuess, null);
 	this.copyOfCurrentlyGuess = add(forCurrentlyGuess, null);
    }
    

	  public LLCharacterNode insert(char element, LLCharacterNode log)
	    {
	      LLCharacterNode newNode = new LLCharacterNode(element);
	      newNode.setLink(log);
	      log = newNode;
	      return log;
	    }
	  
	  public int size(LLCharacterNode log)
	  {
	    int count = 0;
	    LLCharacterNode node;
	    node = log;
	    while (node != null)
	    {
	      count++;
	      node = node.getLink();
	    }
	    return count;
	  }
	  
	  public boolean contains(char element, LLCharacterNode log)
	  {
	    LLCharacterNode node;
	    node = log;
	    while (node != null)
	    {
	      if (element == node.getInfo()) {
	    	  return true;  
	      }
	      else
	        node = node.getLink();
	    }
	   return false;
	  }
	  
	  public void replace(char element) {
		  LLCharacterNode node;
		  node = positionOfCurrent;
		  while (node != null) {
			  node.setInfo(element);
			  node = node.getLink();
		  }
	  }
	  
	  public LLCharacterNode position(char element) {
		  while (isCorrectGuess(element)) {
			  position = insert(element, position);
		  }
		  return position;
	  }
	  
	  public LLCharacterNode add(String input, LLCharacterNode receiver) {
		  char[] cache = input.toCharArray();
		  for (int i = 0; i < cache.length; i++) {
			  receiver = insert(cache[i], receiver);
		}
		  return receiver;
	  }
    
	@Override
	public boolean isPriorGuess(char guess) {
		// TODO Auto-generated method stub
		boolean result = contains(guess, previousGuess);
		if (result) {
			return true;
		}
		else return false;
	}

	@Override
	public int numberOfGuesses() {
		// TODO Auto-generated method stub
		int number = size(previousGuess);
		return number;
	}

	@Override
	public boolean isCorrectGuess(char guess) {
		// TODO Auto-generated method stub
		boolean result = contains(guess, guessWord);
		if (result) {
			return true;
		}
		else return false;
	}

	@Override
	public boolean doMove(char guess) {
		// TODO Auto-generated method stub
		if (isCorrectGuess(guess) && !isPriorGuess(guess)) {
			LLCharacterNode node;
			position = insert(guess, position);
			node = copyOfGuessWord;
			LLCharacterNode log = position;
			LLCharacterNode index = currentlyGuess;
			while (log != null) {
				while (node != null) {
					if (node.getInfo() == log.getInfo()) {
						index.setInfo(node.getInfo());
						node = node.getLink();
						index = index.getLink();
					}
					else {
						node = node.getLink();
						index = index.getLink();
					}
					
				}
				log = log.getLink();
			}
			
			if (!isPriorGuess(guess)) {
				previousGuess = insert(guess, previousGuess);
				}
			return true;
			}
		else {
			if (!isPriorGuess(guess)) {
				previousGuess = insert(guess, previousGuess);
				state++;
				}
			return false;
		}
	}

	@Override
	public boolean inWinningState() {
		// TODO Auto-generated method stub
		LLCharacterNode node;
		node = currentlyGuess;
		if (node == null) {
			return false;
		}
		else {
		while (node!= null) {
			if ('_' == node.getInfo()) {
				return false;
			}
			else
				node = node.getLink();
		}
		return true;
		}
	}

	@Override
	public boolean inLosingState() {
		// TODO Auto-generated method stub
		if (state == 10) {
    		return true;
    	}
    	else return false;
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return state;
	}

	@Override
	public String previousGuessString() {
		// TODO Auto-generated method stub
		int count = size(previousGuess)-1;
		String previousGuessString = "]";
		LLCharacterNode node = previousGuess;
		
		while (node != null) {
			previousGuessString = node.getInfo() + previousGuessString;
			if (count != 0) {
				previousGuessString = "," + " " + previousGuessString;
			}
			node = node.getLink();
			count--;
		}
		previousGuessString = "[" + previousGuessString;
        return previousGuessString;
	}
	
    public String toString() {
        // TODO (8)    	
    	int count = size(currentlyGuess)-1;
    	String board = "";
    	LLCharacterNode node = currentlyGuess;
    	
    	while (node != null) {
    		board = node.getInfo() + board;
    		if (count != 0) {
    			board = ' ' + board;
    		}
    		node = node.getLink();
    		count--;
    	}
    	return board;
    }

	@Override
	public String getWord() {
		// TODO Auto-generated method stub
		return wordGuessed;
	}

}
