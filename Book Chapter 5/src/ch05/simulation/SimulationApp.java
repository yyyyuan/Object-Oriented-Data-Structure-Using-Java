package ch05.simulation;
//---------------------------------------------------------------------
// SimulationApp.java       by Dale/Joyce/Weems               Chapter 5
//
// Simulates customers waiting in queues. Customers always enter
// the shortest queue.
//
// Input consists of customer information:
//    Minimum and maximum customer inter-arrival time.
//    Minimum and maximum customer service time.
// Followed by a sequence of simulation instance information:
//    Number of queues and customers.
//
// Output includes, for each simulation instance:
//    The average waiting time for a customer.
//----------------------------------------------------------------------

import java.util.Scanner;

public class SimulationApp 
{
  public static void main(String[] args)
  {
    Scanner conIn = new Scanner(System.in);

    int minIAT;    // minimum inter-arrival time
    int maxIAT;    // maximum inter-arrival time
    int minST;     // minimum service time
    int maxST;     // maximum service time
    int numQueues; // number of queues
    int numCust;   // number of customers

    String skip;           // skip end of line after reading an integer
    String more = null;    // used to stop or continue processing

    // Get customer information
    System.out.print("Enter minimum inter-arrival time: ");
    minIAT = conIn.nextInt();
    System.out.print("Enter maximum inter-arrival time: ");
    maxIAT = conIn.nextInt();
    System.out.print("Enter minimum service time: ");
    minST = conIn.nextInt();
    System.out.print("Enter maximum service time: ");
    maxST = conIn.nextInt();      

    // create object to perform simulation
    Simulation sim = new Simulation(minIAT, maxIAT, minST, maxST);

    do
    {
      // Get next simulation instance to be processed.
      System.out.print("Enter number of queues: ");
      numQueues = conIn.nextInt();     
      System.out.print("Enter number of customers: ");
      numCust = conIn.nextInt();    
      skip = conIn.nextLine();   // skip end of line
      
      // run simulation and output average waiting time
      sim.simulate(numQueues, numCust);
      System.out.println("Average waiting time is " + sim.getAvgWaitTime());

      // Determine if there is another simulation instance to process
      System.out.println();
      System.out.print("Evaluate another simulation instance? (Y=Yes): ");
      more = conIn.nextLine();
      System.out.println();
    }
    while (more.equalsIgnoreCase("y"));

    System.out.println("Program completed.");
  }
}