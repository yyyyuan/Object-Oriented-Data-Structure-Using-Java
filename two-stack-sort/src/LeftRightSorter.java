import java.util.Stack;
import java.util.EmptyStackException;


public class LeftRightSorter {

  Stack<String> left   = new Stack<String>();
  Stack<String> right  = new Stack<String>();		
  public LeftRightSorter() {
	 left = new Stack<String>();
	 right = new Stack<String>();
  }
	
	
  //----------------------------------------
  public void shiftLeft() {
    // TODO(0)
    // move top element of right to the top of left
	  String top;

	  try {
		  top = right.pop();
		  left.addElement(top);
	} catch (Exception underflow) {
		// TODO: handle exception
		System.out.println("There is an underflow exception.");
	}
  }
	

  public void shiftRight() {
    // TODO(1)
    // move top element of left to top of right
	  String top;
	  
	  try {
		  top = left.pop();
		  right.push(top);	
	} catch (Exception underflow) {
		// TODO: handle exception
		System.out.println("There is an underflow exception.");
	}
	  
  }
	

  public void makeRoom(String w) {
    // TODO(2)
    // shift elements as needed until w can be legally pushed onto left
	  String topOfLeft = null;
	  String topOfRight = null;
	  
	  try {
			topOfLeft = left.peek();		
		} catch (EmptyStackException underflow) {
			// TODO: handle exception
			topOfLeft = w;
		}
		  try {
			  topOfRight = right.peek();
		} catch (EmptyStackException underflow1) {
			// TODO: handle exception
			topOfRight = w;
		}
	  
	  do {
				  if (w.compareTo(topOfLeft) < 0) {
					  if (!left.empty()) {
						  shiftRight();		  
					  }
				  }
				  else {
					  if (!right.empty()) {
						  shiftLeft();	  
					  }
				  }
				  
				  try {
						topOfLeft = left.peek();		
					} catch (EmptyStackException underflow) {
						// TODO: handle exception
						topOfLeft = w;
					}
					  try {
						  topOfRight = right.peek();
					} catch (EmptyStackException underflow1) {
						// TODO: handle exception
						topOfRight = w;
					}

	} while (w.compareTo(topOfLeft) < 0 || w.compareTo(topOfRight) > 0);
	  
	  right.push(w);
  }
	

  public void loadStacks( Stack<String> words) {
    // TODO(3)
    // move all the strings from the given stack 'words' into left and right, 
    // maintaining conditions 1-3 discussed in the handout
	  String word;
	  
	  while (!words.empty()) {
		  word = words.pop();
		  makeRoom(word);
	  }
  }

  public String wordAt(int n) {
    // TODO(4)
    // returns the nth string in alphabetical order among those stored
    // in the left and right stacks (assume zero-based indexing: the
    // 1st word has index n=0, etc)
	  int index = 0;
	  String result;
	  
	  if (n > left.size() + right.size() - 1) {
		  return "the index is too large";
	  }
	  else {
	  while (!left.empty()) {
		  shiftRight();
	  }
	  while (index != n) {
		  shiftLeft();
		  index++;
	  }
	  result = right.peek();
	  return result;
	  }
  }
  //----------------------------------------
	
	
  public void printStacks() {
    System.out.println("Left:");
    for (int i = left.size() - 1; i >= 0; i -= 1) 
      System.out.println("\t" + left.get(i));
    System.out.println("Right:");
    for (int i = right.size() - 1; i >= 0; i -= 1) 
      System.out.println("\t" + right.get(i));		
  }	
}
