package ch05.threads;

import ch05.queues.*;

public class Increase3 implements Runnable
{
   private SyncCounter c;
   private BoundedQueueInterface<Integer> q;
   
   public Increase3 (SyncCounter c, BoundedQueueInterface<Integer> q)
   {
      this.c = c;  this.q = q;
   }
   
   public void run()
   {
      int hold;
      while (!q.isEmpty())
      {
         hold = q.dequeue();
         for (int i = 1; i <= hold; i++)
            c.increment();
      }
   }
}