package hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * A ConsoleGameIO is used to interact with the user from a console. 
 */
public class ConsoleGameIO implements GameIO {
  // Constants
  private static final String[] states = {
    // State 0:
    "",

    // State 1:
    "|--------|\n",
		
    // State 2:
    "|        \n" +
    "|        \n" +
    "|        \n" +
    "|        \n" +
    "|        \n" +
    "|        \n" +
    "|--------|\n",
		
    // State 3:
    "-----    \n" +
    "|        \n" +
    "|        \n" +
    "|        \n" +
    "|        \n" +
    "|        \n" +
    "|        \n" +
    "|--------|\n",
		
    // State 4:
    "-----|   \n" +
    "|    |   \n" +
    "|        \n" +
    "|        \n" +
    "|        \n" +
    "|        \n" +
    "|        \n" +
    "|--------|\n",
		
    // State 5:
    "-----|   \n" +
    "|    |   \n" +
    "|    O   \n" +
    "|        \n" +
    "|        \n" +
    "|        \n" +
    "|        \n" +
    "|--------|\n",
		
    // State 6:
    "-----|   \n" +
    "|    |   \n" +
    "|    O   \n" +
    "|    |   \n" +
    "|    |   \n" +
    "|        \n" +
    "|        \n" +
    "|--------|\n",
		
    // State 7:
    "-----|   \n" +
    "|    |   \n" +
    "|    O   \n" +
    "|    |   \n" +
    "|    |   \n" +
    "|   /    \n" +
    "|        \n" +
    "|--------|\n",
		
    // State 8:
    "-----|   \n" +
    "|    |   \n" +
    "|    O   \n" +
    "|    |   \n" +
    "|    |   \n" +
    "|   / \\ \n" +
    "|        \n" +
    "|--------|\n",
		
    // State 9:
    "-----|   \n" +
    "|    |   \n" +
    "|    O   \n" +
    "|   /|   \n" +
    "|    |   \n" +
    "|   / \\ \n" +
    "|        \n" +
    "|--------|\n",
		
    // State 10:
    "-----|   \n" +
    "|    |   \n" +
    "|    O   \n" +
    "|   /|\\  \n" +
    "|    |   \n" +
    "|   / \\ \n" +
    "|        \n" +
    "|--------|\n",		
  };

  // Attributes
  private BufferedReader reader;
  private PrintWriter printer;

  /**
   * Creates a new ConsoleGameIO object.
   */
  public ConsoleGameIO(BufferedReader reader, PrintWriter printer) {
    this.reader = reader;
    this.printer = printer;
  }
  
  public ConsoleGameIO() {
    this(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out, true));
  }

  public char nextLetter() {
    try {
      printer.print("pick a letter: ");
      printer.flush();
      String response = reader.readLine();
      if (response != null) {
        char[] a = response.toCharArray();
        if (a.length > 0) {
          return a[0];
        } else {
          return 0;
        }
      } else {
        return 0;
      }
    } catch (IOException e) {
      return 0;
    }
  }
	
  public void displayMessage(String s) {
    printer.println(s);
  }

  /**
   * Displays the state of the gallows.
   */
  public void displayGallows(int state) {
    if (state < 0 || state >= states.length) {
      System.err.println("Logic error: the state is not within the appropriate bounds.");
      System.exit(1);
    }		
    printer.print(states[state]);
  }
	
}
