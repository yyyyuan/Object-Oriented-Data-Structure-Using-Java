//----------------------------------------------------------------------
// RankCardDeck.java        by Dale/Joyce/Weems                Chapter 5
//
// Models a deck of cards. 
// Returns a random card upon request.
// Cards are represented by rank only .. an integer between 0 and 12.
//----------------------------------------------------------------------

package support;

import java.util.Random;

public class RankCardDeck
{
  private static final int numCards = 52;
  
  protected int[] carddeck = new int[numCards];
  protected int curCardPos = 0;           // position of the next card to be dealt
  
  protected Random rand = new Random();   // to generate random numbers 

  public RankCardDeck()
  {
    for (int i = 0; i < numCards; i++)
      carddeck[i] = i / 4;     // there are 4 cards of each rank
  }

  public void shuffle()
  // Randomizes the order of the cards in the deck and resets the
  // position of the current card to card 0.
  {
    int randLoc;  // random location in card deck
    int temp;     // for swap of cards
    
    for (int i = (numCards - 1); i > 0; i--)
    {
      randLoc = rand.nextInt(i);  // random integer between 0 and i - 1
      temp = carddeck[randLoc];
      carddeck[randLoc] = carddeck[i];
      carddeck[i] = temp;
    }
   
    curCardPos = 0;
  }
  
  public boolean hasMoreCards()
  // Returns true if there are still cards left to be dealt; 
  // otherwise, returns false.
  {
    return (curCardPos != numCards);
  }
  
  public int nextCard()
  // Precondition:  curCardPos != numCards
  //
  // Models a card being dealt by returning an integer representing 
  // its rank and incrementing the position of the current card.
  {
    curCardPos = curCardPos + 1;
    return (carddeck[curCardPos - 1]);
  }
}
 