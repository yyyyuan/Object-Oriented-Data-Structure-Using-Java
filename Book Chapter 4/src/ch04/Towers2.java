package ch04;

//----------------------------------------------------------------------
// Towers2.java         by Dale/Joyce/Weems                    Chapter 4
//
// Driver class for doTowers method that gets initial values and
// calls the method. Tracing statements removed.
//----------------------------------------------------------------------

import java.util.Scanner;

public class Towers2
{
  public static void main(String[] args)
  {
    Scanner conIn = new Scanner(System.in);

    // Number of rings on starting peg.
    int n;       
    System.out.print("Input the number of rings: ");
    if (conIn.hasNextInt())
      n = conIn.nextInt();
    else
    {
      System.out.println("Error: you must enter an integer.");
      System.out.println("Terminating program.");
      return;
    }
 
    System.out.println("Towers of Hanoi with " + n + " rings\n");
    doTowers(n, 1, 2, 3);
  }
 
  public static void doTowers(
         int n,              // Number of rings to move
         int startPeg,       // Peg containing rings to move
         int auxPeg,         // Peg holding rings temporarily
         int endPeg      )   // Peg receiving rings being moved
  {
    if (n > 0)
    {
      // Move n - 1 rings from starting peg to auxiliary peg
      doTowers(n - 1, startPeg, endPeg, auxPeg);

      // Move nth ring from starting peg to ending peg
      System.out.println("Move ring " + n + " from peg " + startPeg
              + " to peg " + endPeg);
 
      // Move n - 1 rings from auxiliary peg to ending peg
      doTowers(n - 1, auxPeg, startPeg, endPeg);
    }
  }
}
