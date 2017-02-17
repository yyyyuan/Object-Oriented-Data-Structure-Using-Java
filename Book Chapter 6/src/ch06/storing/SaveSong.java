package ch06.storing;

import java.io.*;
import support.*;
 
public class SaveSong
{
  private static PrintWriter outFile;
 
  public static void main(String[] args) throws IOException
  {
    Song song1 = new Song("Penny Lane", 2, 57);

    outFile = new PrintWriter(new FileWriter("song.txt"));
    outFile.println(song1.getName());
    outFile.println(song1.getDuration());
    outFile.close();
  }
}
