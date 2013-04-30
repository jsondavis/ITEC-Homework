package edu.ggc.jdavis37;

import java.util.ArrayList;
import java.util.Collections;


public class CardDeck
{
    private static int DECKSIZE = 52;
    private static String[] RANKS = {"A", "2", "3", "4", "5", "6", "7",
                                   "8", "9", "T", "J", "Q", "K"};
    private static String[] SUITS = {"C", "D", "H", "S"};    


    private ArrayList<Card> deck = new ArrayList<Card>();
    
    private int deckIndex = 0;
    
    public void getPlayDeck()
    {
        buildDeck("regular"); 
    }
   
    private void buildDeck(String deckType)
    {
        if(deckType.equals("regular"))
        {
            for(String suit : SUITS)
            {
                for(String rank : RANKS)
                {
                    Card c = new Card(rank, suit);
                    deck.add(c);
                }
            }
        }
    }

    public Card deal()
    {
        if(deckIndex < DECKSIZE)
        {
            return deck.get(deckIndex++);
        }
        return null;
    }

    public Card playCard(int index)
    {
        return deck.get(index);
    }

    public void addCard(Card someCard)
    {
        deck.add(someCard);
    }


    public void shuffle()
    {
        Collections.shuffle(deck); 
    }

}
