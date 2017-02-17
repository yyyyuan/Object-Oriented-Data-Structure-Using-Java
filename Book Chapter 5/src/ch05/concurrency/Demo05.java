package ch05.concurrency;
import ch05.threads.*;

public class Demo05
{
  public static void main(String[] args) throws InterruptedException
  {
    SyncCounter  sc = new SyncCounter();
    Runnable r1 = new Increase2(sc, 5000);
    Runnable r2 = new Increase2(sc, 5000);
    Thread   t1 = new Thread(r1);
    Thread   t2 = new Thread(r2);

    t1.start();  t2.start();
    t1.join();   t2.join();
    
    System.out.println("Count is:    " + sc);
  }
}