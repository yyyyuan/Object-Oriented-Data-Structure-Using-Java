//----------------------------------------------------------------------
// BalancedApp.java         by Dale/Joyce/Weems                Chapter 3
//
// Checks for balanced grouping symbols.
// Input consists of a sequence of expressions, one per line.
// Special symbol types are (), [], and {}.
//----------------------------------------------------------------------

import java.util.Scanner;

public class BalancedApp 
{
  public static void main(String[] args)
  {
    Scanner conIn = new Scanner(System.in);

    // Instantiate new Balanced class with grouping symbols.
    Balanced bal = new Balanced("([{", ")]}");
    
    int result;                  // 0 = balanced, 1 = unbalanced,
                                 // 2 = premature end

    String expression = null;    // expression to be evaluated
    String more = null;          // used to stop or continue processing

    do
    {
      // Get next expression to be processed.
      System.out.println("Enter an expression to be evaluated: ");
      expression = conIn.nextLine();
      
      // Obtain and output result of balanced testing.
      result = bal.test(expression);
      if (result == 1)
        System.out.println("Unbalanced symbols ");
      else
      if (result == 2)
        System.out.println("Premature end of expression");
      else
        System.out.println("The symbols are balanced.");

      // Determine if there is another expression to process.
      System.out.println();
      System.out.print("Evaluate another expression? (Y=Yes): ");
      more = conIn.nextLine();
      System.out.println();
    }
    while (more.equalsIgnoreCase("y"));
  }
}