package ch04;

import java.io.*;

public class tryComb
{

private static int count;

private static int combinations(int group, int members)
// Pre:  group and members are positive
// Post: Return value = number of combinations of members size
//       that can be constructed from the total group size
{
  count++;
  if (members == 1)
    return group;             // Base case 1
  else if (members == group)
    return 1;                 // Base case 2
  else
    return (combinations(group - 1, members - 1) +
            combinations(group - 1, members));
}


  public static void main(String[] args) throws IOException 
  { 
    count = 0;
    System.out.println("comb(20,5) = " + combinations(20,5));
	 System.out.println("method entered " + count + "times");
	 count = 0;
    System.out.println("comb(4,3) = " + combinations(4,3));
	 System.out.println("method entered " + count + "times");
	 count = 0;
    System.out.println("comb(10,3) = " + combinations(10,3));
	 System.out.println("method entered " + count + "times");
  } 
}
