package ch07;

//---------------------------------------------------------------------
// LargeIntApp.java         by Dale/Joyce/Weems               Chapter 7
//
// Allows user to add or subtract large integers.
//----------------------------------------------------------------------

import java.util.Scanner;
import ch07.largeInts.LargeInt;

public class LargeIntApp 
{
  public static void main(String[] args)
  {
    Scanner conIn = new Scanner(System.in);

    LargeInt first;     
    LargeInt second;     

    String intString;
    String more = null;    // used to stop or continue processing

    do
    {
      // Get large integers.
      System.out.println("Enter the first large integer: ");
      intString = conIn.nextLine();
      first = new LargeInt(intString);
      
      System.out.println("Enter the second large integer: ");
      intString = conIn.nextLine();
      second = new LargeInt(intString);
      System.out.println();
      
      // Perform and report the addition and subtraction.
      System.out.print("First number:  ");
      System.out.println(first);
      System.out.print("Second number: ");
      System.out.println(second);
      System.out.print("Sum:           ");
      System.out.println(LargeInt.add(first,second));
      System.out.print("Difference:    ");
      System.out.println(LargeInt.subtract(first,second));
      
      // Determine if there is more to process.
      System.out.println();
      System.out.print("Process another pair of numbers? (Y=Yes): ");
      more = conIn.nextLine();
      System.out.println();

    }
    while (more.equalsIgnoreCase("y"));
  }
}