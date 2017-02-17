package ch05.concurrency;
import ch05.threads.*;
import ch05.queues.*;

public class Demo06
{
  public static void main(String[] args) throws InterruptedException
  {
    int LIMIT = 100;
    SyncCounter  c = new SyncCounter();
    BoundedQueueInterface<Integer> q;
    q = new ArrayBndQueue<Integer>(LIMIT);
    
    for (int i = 1; i <= LIMIT; i++)
       q.enqueue(i);
      
    Runnable r1 = new Increase3(c, q);
    Runnable r2 = new Increase3(c, q);
    Thread   t1 = new Thread(r1);
    Thread   t2 = new Thread(r2);

    t1.start();  t2.start();
    t1.join();   t2.join();
    
    System.out.println("Count is:    " + c);
  }
}