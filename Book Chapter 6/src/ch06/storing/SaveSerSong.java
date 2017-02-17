package ch06.storing;

import java.io.*;
import support.*;
 
public class SaveSerSong
{
  private static PrintWriter outFile;
 
  public static void main(String[] args) throws IOException
  {
    SerSong song1 = new SerSong("Penny Lane", 2, 57);

    ObjectOutputStream out = new ObjectOutputStream(new
                                FileOutputStream("song.dat"));
    out.writeObject(song1);
    out.close();
  }
}
