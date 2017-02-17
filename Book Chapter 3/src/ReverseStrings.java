//----------------------------------------------------------------------
// ReverseStrings.java         by Dale/Joyce/Weems                Chapter 3
//
// Sample use of stack. Outputs strings in reverse order of entry.
//----------------------------------------------------------------------

import ch03.stacks.*;
import java.util.Scanner;

public class ReverseStrings 
{
  public static void main(String[] args)
  {
    Scanner conIn = new Scanner(System.in);

    BoundedStackInterface<String> stack;
    stack = new ArrayStack<String>(3);
    
    String line;
    
    for (int i = 1; i <= 3; i++)
    {
      System.out.print("Enter a line of text > ");
      line = conIn.nextLine();
      stack.push(line);
    }
    	 
    System.out.println("\nReverse is:\n");
    while (!stack.isEmpty())
    {
      line = stack.top();
      stack.pop();
      System.out.println(line);
    }
  }
}