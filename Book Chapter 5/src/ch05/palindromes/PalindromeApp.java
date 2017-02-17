package ch05.palindromes;
//---------------------------------------------------------------------
// PalindromeApp.java       by Dale/Joyce/Weems               Chapter 5
//
// Checks for strings that are palidromes.
// Input consists of a sequence of strings.
// Output consists of whether the input string is a palindrome.
//----------------------------------------------------------------------

import java.util.Scanner;

public class PalindromeApp 
{
  public static void main(String[] args)
  {
    Scanner conIn = new Scanner(System.in);

    String candidate = null;     // string to be evaluated
    String more = null;          // used to stop or continue processing

    do
    {
      // Get next candidate string to be processed.
      System.out.println("Enter a string to be evaluated: ");
      candidate = conIn.nextLine();
      
      // Obtain and output result of palindrome testing.
      if (Palindrome.test(candidate))
        System.out.println("is a palindrome.");
      else
        System.out.println("is NOT a palindrome.");

      // Determine whether there is another candidate string to process.
      System.out.println();
      System.out.print("Evaluate another string? (Y=Yes): ");
      more = conIn.nextLine();
      System.out.println();

    }
    while (more.equalsIgnoreCase("y"));
  }
}