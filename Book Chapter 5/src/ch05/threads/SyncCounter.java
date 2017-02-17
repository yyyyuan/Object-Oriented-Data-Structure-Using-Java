//---------------------------------------------------------------------------
// SyncCounter.java            by Dale/Joyce/Weems                  Chapter 5
//
// Tracks the current value of a counter.
// Provides synchronized access to the increment method.
//---------------------------------------------------------------------------

package ch05.threads;

public class SyncCounter
{
  private int count;
  
  public SyncCounter()
  {
     count = 0;
  }

  public synchronized void increment()
  {
    count++;
  }

  public String toString()
  {
    return "Count is:\t" + count;
  }
}
