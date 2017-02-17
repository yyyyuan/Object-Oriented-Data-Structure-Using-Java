package ch05.concurrency;
import ch05.threads.*;

public class Demo01
{
  public static void main(String[] args)
  {
    Counter myCounter = new Counter();
    myCounter.increment();
    myCounter.increment();
    myCounter.increment();
    System.out.println(myCounter);
  }
}