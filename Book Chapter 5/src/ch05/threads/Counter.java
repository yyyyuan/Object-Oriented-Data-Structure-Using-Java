//---------------------------------------------------------------------------
// Counter.java              by Dale/Joyce/Weems                    Chapter 5
//
// Tracks the current value of a counter.
//---------------------------------------------------------------------------

package ch05.threads;

public class Counter
{
  private int count;
  
  public Counter()
  {
     count = 0;
  }

  public void increment()
  {
    count++;
  }

  public String toString()
  {
    return "Count is:\t" + count ;
  }

}
