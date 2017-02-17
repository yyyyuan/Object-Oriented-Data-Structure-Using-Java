package ch05.palindromes;
//---------------------------------------------------------------------
// Palindrome.java           by Dale/Joyce/Weems              Chapter 5
//
// Provides a method to test whether a string is a palindrome. 
// Non letters are skipped.
//---------------------------------------------------------------------

import ch03.stacks.*;
import ch05.queues.*;

public class Palindrome 
{
  public static boolean test(String candidate)
  // Returns true if candidate is a palindrome, false otherwise.
  {
    char ch;                   // current candidate character being processed
    int length;                // length of candidate string
    int numLetters;            // number of letter characters in candidate string
    int charCount;             // number of characters checked so far

    char fromStack;            // current character popped from stack
    char fromQueue;            // current character dequeued from queue
    boolean stillPalindrome;   // true as long as the string might still be a palindrome

    BoundedStackInterface<Character> stack;   // holds non blank string characters
    BoundedQueueInterface<Character> queue;   // also holds non blank string characters

    // initialize variables and structures
    length = candidate.length();
    stack = new ArrayStack<Character>(length);
    queue = new ArrayBndQueue<Character>(length);
    numLetters = 0;

    // obtain and handle characters
    for (int i = 0; i < length; i++)
    {
      ch = candidate.charAt(i);
      if (Character.isLetter(ch))
      {
        numLetters++;
        ch = Character.toLowerCase(ch);
        stack.push(ch);
        queue.enqueue(ch);
      }
    }
    
    // determine if palindrome
    stillPalindrome = true;
    charCount = 0;
    while (stillPalindrome && (charCount < numLetters))
    {
      fromStack = stack.top();
      stack.pop();
      fromQueue = queue.dequeue();
      if (fromStack != fromQueue)
        stillPalindrome = false;
      charCount++;
    }
    
    // return result
    return stillPalindrome;
  }
}