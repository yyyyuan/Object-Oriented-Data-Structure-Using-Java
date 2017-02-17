package ch04;

//----------------------------------------------------------------------
// Grid.java              by Dale/Joyce/Weems                  Chapter 4
//
// Supports grid objects consisting of blob and non-blob characters.
// Allows the number of blobs it contains to be counted.
//----------------------------------------------------------------------

import java.util.Random;

public class Grid
{
  protected int rows;         // number of grid rows
  protected int cols;         // number of grid columns
    
  protected boolean [][] grid;     // the grid containing blobs
  boolean [][] visited;            // used by blobCount

  public Grid(int rows, int cols, int percentage)
  // Preconditions: rows and cols > 0
  //                0 <= percentage <= 100
  //
  // Instantiates a grid of size rows by cols, where locations are set to 
  // indicate blob characters based on the percentage probability.
  {
    this.rows = rows;
    this.cols = cols;
    grid = new boolean [rows][cols];

    // to generate random numbers
    int randInt;
    Random rand = new Random();

    for (int i = 0; i < rows; i++)
      for (int j = 0; j < cols; j++)
      {
        randInt = rand.nextInt(100);  // random number 0 .. 99
        if (randInt < percentage)
          grid[i][j] = true;
        else
          grid[i][j] = false;
      }
  }

  public String toString()
  {
    String gridString = "";
    for (int i = 0; i < rows; i++)
    {
      for (int j = 0; j < cols; j++)
      {
        if (grid[i][j])
          gridString = gridString + "X";
        else
          gridString = gridString + "-";
       }
      gridString = gridString + "\n";   // end of row
    }  
    return gridString;
  }

  public int blobCount()
  // returns the number of blobs in this grid
  {
    int count = 0;
    visited = new boolean [rows][cols];  // true if location visited
    
    // initialize visited
    for (int i = 0; i < rows; i++)
      for (int j = 0; j < cols; j++)
        visited[i][j] = false;
      
    // count blobs
    for (int i = 0; i < rows; i++)
      for (int j = 0; j < cols; j++)
        if (grid[i][j] && !visited[i][j])
        {
          count++;
          markBlob(i, j); 
        }
       
  return count;
  }
  
  private void markBlob(int row, int col)
  // Mark position row, col as having been visited.
  // Check and if appropriate mark locations above, below, left,
  // and right of that position.
  {
    visited[row][col] = true;
   
    // check above
    if ((row - 1) >= 0)           // if its on the grid
      if (grid[row - 1][col])       // and has a blob character
        if (!visited[row - 1][col])   // and has not been visited
          markBlob(row - 1, col);       // then mark it
    
    // check below
    if ((row + 1) < rows)        // if its on the grid
      if (grid[row + 1][col])       // and has a blob character
        if (!visited[row + 1][col])   // and has not been visited
          markBlob(row + 1, col);       // then mark it
    
    // check left
    if ((col - 1) >= 0)           // if its on the grid
      if (grid[row][col - 1])       // and has a blob character
        if (!visited[row][col - 1])   // and has not been visited
          markBlob(row, col - 1);       // then mark it
    
    // check right
    if ((col + 1) < cols)        // if its on the grid
      if (grid[row][col + 1])       // and has a blob character
        if (!visited[row][col + 1])   // and has not been visited
          markBlob(row, col + 1);       // then mark it
  }
}
  
 