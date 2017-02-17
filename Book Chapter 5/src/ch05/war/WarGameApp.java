package ch05.war;
//---------------------------------------------------------------------
// WarGameApp.java         by Dale/Joyce/Weems                Chapter 5
//
// Interacts with the user through the console.
//
// Simulates a number of instances of the card game War and reports 
// the average number of battles required to complete a game.
// 
// Input consists of the number of games to simulate and the maximum
// number of battles allowed for a game before it is discontinued.
//
// Output consists of statistics on the number of discontinued games,
// the number of completed games, and the average number of battles
// in the completed games.
//----------------------------------------------------------------------

import java.util.Scanner;

public class WarGameApp 
{
  public static void main(String[] args)
  {
    Scanner conIn = new Scanner(System.in);

    WarGame game;

    int numGames;         // number of games to simulate
    int maxNumBattles;    // maximum number of battles allowed for a game
    
    int numDiscont = 0;   // number of dicontinued games
    int numCompleted = 0; // number of completed games
    
    int totBattles = 0;   // total number of battles so far in completed games

    System.out.println("How many games should be simulated? ");
    numGames = conIn.nextInt();
    
    System.out.println("What is the maximum number of battles per game? ");
    maxNumBattles = conIn.nextInt();
    
    game = new WarGame(maxNumBattles);

    for (int i = 0; i < numGames; i++)
    {
      if (game.play())
      {
        numCompleted = numCompleted + 1;
        totBattles = totBattles + game.getNumBattles();
      }
      else
        numDiscont = numDiscont + 1;
    }
    
    // Output results.
    System.out.println("Number of Games Simulated:    "+ numGames);
    System.out.println("Number of Discontinued Games: "+ numDiscont);
    System.out.println("Number of Completed Games:    "+ numCompleted);
    System.out.println();
    
    if (numCompleted > 0)
    {
      System.out.println("In the completed games");
      System.out.println("  Total Number of Battles "+ totBattles);
      System.out.println("  Average Number of Battles "+ totBattles/numCompleted);
    }
    
    System.out.println("\nProgram completed.");
  }
}