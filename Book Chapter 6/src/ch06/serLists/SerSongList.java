//----------------------------------------------------------------------
// SerSongList.java         by Dale/Joyce/Weems                Chapter 6
//
// Supports a list of song objects having a name and a total duration.
// Allows application to view indexing as starting at 1.
// Implements Serializable.
//----------------------------------------------------------------------

package ch06.serLists;

import java.io.*;    // Serializable interface
import java.text.*;  // DecimalFormat
import support.*;    // SerSong

public class SerSongList implements Serializable
{
  protected String listName;       // name of song list
  protected int totDuration = 0;   // total duration of songs in seconds
  
  protected SArrayIndexedList songList; 
  
  DecimalFormat fmt = new DecimalFormat("00");  // to format seconds

  public SerSongList(String listName)
  {
    this.listName = listName;
    songList = new SArrayIndexedList(10);
  }

  public String getListName()
  {
    return listName;
  }
  
  public int getTotDuration()
  {
    return totDuration;
  }
  
  public int getSize()
  {
    return songList.size();
  }

  public void add(int number, SerSong song)
  // If number is a legal position, then adds song onto the 
  // indexed songList at position (number - 1). 
  // Otherwise, adds song at the end of the songList.
  {
    totDuration = totDuration + song.getDuration();
    if ((number <= 0) || (number > (songList.size() + 1)))
      songList.add(songList.size(), song);
    else
      songList.add(number - 1, song);
  }
  
  public String toString()
  {
    // Returns a nicely formatted string that represents this SerSongList.
    SerSong song;
    int duration;
    int numSongs = songList.size();

    String hold = listName + ":\n";
    for (int i = 0; i < numSongs; i++)
    {
      song = (SerSong)songList.get(i);
      duration = song.getDuration();
      hold = hold + (i + 1) + ": " + song.getName() + "  [" 
             + (duration / 60) + ":" + fmt.format(duration % 60) + "]\n";
    }
    hold = hold + "\n";
    hold = hold + "Total Time: " + (totDuration / 60) +" minutes, " 
                + fmt.format(totDuration % 60) + " seconds\n";
    return hold;
  }  
}
 