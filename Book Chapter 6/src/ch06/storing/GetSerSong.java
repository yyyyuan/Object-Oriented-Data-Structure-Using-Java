package ch06.storing;

import java.io.*;
import support.*;
 
public class GetSerSong
{
  public static void main(String[] args) throws IOException
  {
    SerSong song2;
    ObjectInputStream in = new ObjectInputStream(new 
               FileInputStream("song.dat"));
 
    try
    {
      song2 = (SerSong) in.readObject();
      System.out.println("The name of the song is " + song2.getName());
      System.out.println("The duration of the song is  " + song2.getDuration());
    }
    catch (Exception e)
    {
      System.out.println("Error in readObject: " + e);
      System.exit(1);
    }
  }
}
