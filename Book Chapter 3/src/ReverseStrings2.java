//----------------------------------------------------------------------
// ReverseStrings2.java         by Dale/Joyce/Weems                Chapter 3
//
// Sample use of the library Stack. 
// Outputs strings in reverse order of entry.
//----------------------------------------------------------------------

import java.util.Stack;
import java.util.Scanner;

public class ReverseStrings2 
{
  public static void main(String[] args)
  {
    Scanner conIn = new Scanner(System.in);

    Stack<String> stack = new Stack<String>();
    
    String line;
    
    for (int i = 1; i <= 3; i++)
    {
      System.out.print("Enter a line of text > ");
      line = conIn.nextLine();
      stack.push(line);
    }
    
    System.out.println("\nReverse is:\n");
    while (!stack.empty())
    {
      line = stack.peek();
      stack.pop();
      System.out.println(line);
    }
  }
}