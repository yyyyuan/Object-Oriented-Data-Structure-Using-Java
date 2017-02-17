package ch04;

//import java.util.*;

public class Factorial2
{
  private static int factorial(int n)
  {
    int retValue = 1;   // return value
    while (n != 0)
    {
	   retValue = retValue * n;
		n = n - 1;
	 }
    return(retValue);
  }

  public static void main(String[] args) 
  { 
    System.out.println("\n9! is " + factorial(9));
  } 
}
