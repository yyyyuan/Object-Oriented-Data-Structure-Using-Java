package ch06.storing;

//---------------------------------------------------------------------
// SerSongsApp.java         by Dale/Joyce/Weems               Chapter 6
//
// Allows user to manage a song list.
// Uses the file songs.dat to store and retrieve song list info.
//----------------------------------------------------------------------

import java.util.*;      // Scanner
import java.io.*;        // streams
import ch06.serLists.*;  // SerSongList
import support.*;        // SerSong

public class SerSongsApp 
{
  public static void main(String[] args) 
  {
    Scanner conIn = new Scanner(System.in);
    final String FILENAME = "songs.dat";
    
    String name;          // song name
    String listName;      // name of the song list
    int minutes;          // song duration
    int seconds;          // song duration
    int number;           // song number
    
    SerSongList songs;    // list of songs
    SerSong song;         // a single song
    
    String skip;  // skip rest of input line after reading integer

    try
    {
      // Obtain song information from file and display it.
      ObjectInputStream in = new ObjectInputStream(new
                                           FileInputStream(FILENAME));
      songs = (SerSongList)in.readObject();
      System.out.println(songs);
    }
    catch (Exception e)
    {
      // Create a new song list.
      System.out.println("Because the " + FILENAME + " file does not exist or");
      System.out.println("can't be used, a new song list will be created.\n");
      System.out.print("Song list name: ");
      listName = conIn.nextLine();
      songs = new SerSongList(listName);
    }
    
    // Get song information from user.
    System.out.print("\nSong name (press Enter to end): ");
    name = conIn.nextLine();
    while (!name.equals(""))
    {
      System.out.print("Minutes: ");
      minutes = conIn.nextInt();
      skip = conIn.nextLine();
      System.out.print("Seconds: ");
      seconds = conIn.nextInt();
      skip = conIn.nextLine();
      
      song = new SerSong(name, minutes, seconds);
      
      System.out.print("Song number between 1 and " + (songs.getSize() + 1) + ": ");
      number = conIn.nextInt();
      skip = conIn.nextLine();
      songs.add(number, song);
      
      System.out.println();
      System.out.println(songs);
      System.out.println();
      
      System.out.print("Song name (press Enter to end): ");
      name = conIn.nextLine();
    }
    
    // Display results.
    System.out.println();
    System.out.println("This song list will be saved in " + FILENAME + ":\n");
    System.out.println(songs);
    System.out.println();
    
    // Save list.
    try
    {
      ObjectOutputStream out = new ObjectOutputStream(new
              FileOutputStream(FILENAME));
      out.writeObject(songs);
      out.close();
    }
    catch (Exception e)
    {
      System.out.println("Unable to save song information.");
    }
  }
}