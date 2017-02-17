package ch04;
//----------------------------------------------------------------------------
// UseStack3.java             by Dale/Joyce/Weems                    Chapter 4
//
// Driver for LinkedStack3
//----------------------------------------------------------------------------

public class UseStack3
{
  public static void main(String[] args)
  { 
    LinkedStack3<String> myStack3 = new LinkedStack3<String>();
    myStack3.push("first");
    myStack3.push("second");
    myStack3.push("third");
    myStack3.push("fourth");
    myStack3.printReversed();
  }
}