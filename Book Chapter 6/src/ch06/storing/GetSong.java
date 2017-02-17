package ch06.storing;

import java.io.*;
import java.util.*;
import support.*;
 
public class GetSong
{
  public static void main(String[] args) throws IOException
  {
    String name;
    int duration;

    FileReader fin = new FileReader("song.txt");
    Scanner songIn = new Scanner(fin);

    name = songIn.nextLine();
    duration = songIn.nextInt();

    Song song2 = new Song(name, duration);

    System.out.println("The name of the song is " + song2.getName());
    System.out.println("The duration of the song is  " + song2.getDuration());
  }
}
