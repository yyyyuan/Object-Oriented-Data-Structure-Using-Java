package ch05.war;
//---------------------------------------------------------------------
// WarGame.java             by Dale/Joyce/Weems               Chapter 5
//
// Models the card game War. 
// Tracks how many battles are played.
//---------------------------------------------------------------------

import ch05.queues.*;
import support.*;      // for RankCardDeck

public class WarGame 
{
  BoundedQueueInterface<Integer> player1;   // player 1's hand
  BoundedQueueInterface<Integer> player2;   // player 2's hand

  int maxNumBattles;            // maximum number of battles allowed before
                                // game is discontinued

  int numBattles = 0;           // number of battles played in current game

  RankCardDeck deck;            // deck of cards

  BoundedQueueInterface<Integer> prize;  // cards for current battle
    
  static final int numCards = 52;  // number of cards in a deck
  
  public WarGame(int maxNumBattles)
  {
    this.maxNumBattles = maxNumBattles;
    deck = new RankCardDeck();
  }
       
  public int getNumBattles()
  {
    return numBattles;
  }
    
  public boolean play()
  // Simulates one game. If number of battles played 
  // reaches maxNumBattles, the game is discontinued.
  // Returns true if game finishes normally; returns false
  // if game is discontinued.
  {
    // instantiate players' hands
    player1 = new ArrayBndQueue<Integer>(numCards);
    player2 = new ArrayBndQueue<Integer>(numCards);
    
    // instantiate prize pile
    prize = new ArrayBndQueue<Integer>(numCards);
    
    boolean gameOver = false;  // becomes true when the game is over
    boolean gameOK = true;     // becomes false if game is discontinued
    
    // deal original hands
    deck.shuffle();
    while (deck.hasMoreCards())
    {
      player1.enqueue(deck.nextCard());
      if (deck.hasMoreCards())
        player2.enqueue(deck.nextCard());
    }  
    
    // play game until somebody runs out of cards or
    // reach the maximum number of battles
    numBattles = 0;
    while (!gameOver)
    {
      try
      {
        numBattles = numBattles + 1;
        battle();
      }
      catch (QueueUnderflowException exceptionVar)
      {
        gameOver = true;
      }
      
      if (numBattles == maxNumBattles)
      {
        gameOver = true;
        gameOK = false;
      }
    }
    return gameOK;
  }
  
  private void battle()
  // Models a battle between player1 and player2. If the battle
  // results in a war, three cards from each player are placed
  // in the prize queue and the battle is continued recursively.
  {
    // cards for this battle
    int p1card;
    int p2card;
    
    // get cards from players and place in prize queue
    p1card = player1.dequeue();
    prize.enqueue(p1card);
    p2card = player2.dequeue();
    prize.enqueue(p2card);
    
    // determine and handle result of battle
    if (p1card > p2card)           // player 1 wins
      while (!prize.isEmpty())
        player1.enqueue(prize.dequeue());
    else
    {
      if (p2card > p1card)         // player 2 wins
        while (!prize.isEmpty())
          player2.enqueue(prize.dequeue());
      else                        
      {
        // it's a war ...
        // each player places 3 cards in prize pile
        for (int i = 0; i < 3; i++)
        {
          prize.enqueue(player1.dequeue());
          prize.enqueue(player2.dequeue());
        }
        // now continue the battle to determine who wins prize
        battle();
      } 
    }
  }
}