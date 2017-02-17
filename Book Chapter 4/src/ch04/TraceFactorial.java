package ch04;

//import java.util.*;

public class TraceFactorial
{
  private static String indent = "";  // indentation for trace

  private static int factorial(int n)
  {
    int retValue;   // return value
    System.out.println(indent + "Enter factorial " + n);
    indent = indent + "  ";

    if (n == 0)
      retValue = 1;
    else
      retValue = (n * factorial (n - 1));
      
    indent = indent.substring(2);
    System.out.println(indent + "Return " + retValue);
    
    return(retValue);
  }

  public static void main(String[] args) 
  { 
    System.out.println("\n9! is " + factorial(9));
  } 
}
