package edu.ggc.jdavis37;

public class CardDeck 
{
	private Card[] deck = new Card[52];
	private static final char[] SUITS = {'S', 'H', 'D', 'C'};
	private static final int[] VALUES = {14, 13, 12, 11, 10, 9, 8,
										 7, 6, 5, 4, 3, 2, 1};
	
	public CardDeck()
	{
		int counter = 0;
		while(counter < deck.length)
		{
			for(char suit : SUITS)
			{
				for(int value : VALUES)
				{
					Card card = new Card(suit, value);
					deck[counter] = card;
					counter++;
				}
			}
		}
		
	}
	
	public void shuffle()
	{
		
	}
	
	public Card deal()
	{
		return null;
	}
	
	public Card selectCard(int cardNumber)
	{
		return null;
	}
}