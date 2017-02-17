package ch08;

//----------------------------------------------------------------------------
// ITDBinarySearchTree.java         by Dale/Joyce/Weems               Chapter 8
//
// Interactive Test Driver for the BinarySearchTree class
//----------------------------------------------------------------------------

import java.util.*;
import ch08.trees.*;

public class ITDBinarySearchTree
{
  public static void main(String[] args) 
  {
    Scanner conIn = new Scanner(System.in);

    String skip;       // skip end of line after reading an integer
    boolean keepGoing; // flag for "choose operation" loop
    int operation;     // user's choice of operation
	 int order;         // user's choice of traversal order

    String testName;
    BinarySearchTree<String> tree = new BinarySearchTree<String>();

    String element;
	 String target;
	 int treeSize;      
	 
    // Handle test name  
    System.out.println("What is the name of this test?");
    testName = conIn.nextLine();
    System.out.println("\nThis is test " + testName + ".");

    // Handle test cases
    keepGoing = true;  
    while (keepGoing)
    {
      System.out.println("\nChoose an operation:");
      System.out.println("1: isEmpty");
      System.out.println("2: size");
      System.out.println("3: size2");
	   System.out.println("4: contains (string)");
      System.out.println("5: remove (string)");
      System.out.println("6: get (string)");
      System.out.println("7: add (string)");
      System.out.println("8: print (traversal order)");
      System.out.println("9: stop Testing \n");
		System.out.print("Enter choice: ");
      if (conIn.hasNextInt())
        operation = conIn.nextInt();
      else
      {
        System.out.println("Error: you must enter an integer.");
        System.out.println("Terminating test.");
        return;
      } 
      skip = conIn.nextLine();
		
		switch (operation)
      {
        case 1:  // isEmpty
        System.out.println("isEmpty returns " + tree.isEmpty());
        break;
        
        case 2:  // size
        System.out.println("size returns " + tree.size());
        break;
        
        case 3:  // size2
        System.out.println("size2 returns " + tree.size2());
        break;
        
        case 4:  // contains
        System.out.print("Enter string to search for: ");
        target = conIn.nextLine();
        System.out.println("contains(" + target + ") returns " + tree.contains(target));
        break;
        
        case 5:  // remove
        System.out.print("Enter string to remove: ");
        target = conIn.nextLine();
        System.out.println("remove(" + target + ") returns " + tree.remove(target));
        break;
            
        case 6:  // get
        System.out.print("Enter string to get: ");
        target = conIn.nextLine();
        System.out.println("get(" + target + ") returns " + tree.get(target));
        break;
  
        case 7:  // add
        System.out.print("Enter string to add: ");
        element = conIn.nextLine();
        tree.add(element);
		  break;
  
        case 8:  // print tree
        System.out.println("Choose a traversal order:");
        System.out.println("1: Preorder");
        System.out.println("2: Inorder");
        System.out.println("3: Postorder");
        if (conIn.hasNextInt())
           order = conIn.nextInt();
        else
        {
          System.out.println("Error: you must enter an integer.");
          System.out.println("Terminating test.");
          return;
        }
        skip = conIn.nextLine();

        switch (order)
        {
          case 1:
          treeSize = tree.reset(BinarySearchTree.PREORDER);
          System.out.println("The tree in Preorder is:");
          for (int count = 1; count <= treeSize; count++)
          {
            element = (String) tree.getNext(BinarySearchTree.PREORDER);
            System.out.println(element);
          }
          break;
          
          case 2:
          treeSize = tree.reset(BinarySearchTree.INORDER);
          System.out.println("The tree in Inorder is:");
          for (int count = 1; count <= treeSize; count++)
          {
            element = (String) tree.getNext(BinarySearchTree.INORDER);
            System.out.println(element);
          }
          break;

          case 3:
          treeSize = tree.reset(BinarySearchTree.POSTORDER);
          System.out.println("The tree in Postorder is:");
          for (int count = 1; count <= treeSize; count++)
          {
            element = (String) tree.getNext(BinarySearchTree.POSTORDER);
            System.out.println(element);
          }
          break;

          default:
          System.out.println("Error in order choice. Terminating test.");
          return;
        }
        break;
		  
        case 9:  // stop testing
        keepGoing = false;
        break;
        
        default:
        System.out.println("Error in operation choice. Terminating test.");
        return;
      }
    }
  System.out.println("End of Interactive Test Driver");
  }
}

