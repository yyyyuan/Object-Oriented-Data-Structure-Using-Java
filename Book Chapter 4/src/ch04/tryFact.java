package ch04;

import java.io.*;

public class tryFact
{

	static int n = 5;
	static int result = 1;
	
private static int factorial()
{
  if (n == 0)
    return result;
  else
	result = n * result;
  	n--;
  	return factorial();
}

private static int factorial2(int n)
{
  int fact = 1;
  for (int count = 2; count <= n; count++)
  {
    fact = fact * count;
  }
  return fact;
}

  public static void main(String[] args) throws IOException 
  { 
    System.out.println("5! = " + factorial());
    System.out.println("5! = " + factorial2(5));
  } 
}
