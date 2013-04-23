package edu.ggc.jdavis37;

import java.util.ArrayList;


/**
 * class CardDeck
 * 
 * @author Jason Davis (jdavis37@ggc.edu)
 * @version 1.0 Course : ITEC 2150 Spring 2013 Written : February 18, 2013
 * 
 *          This class creates a card deck and has the methods to shuffle the
 *          deck / deal a card from the deck and select a single card from the
 *          deck.
 * 
 *          The purpose of this class is intended to represent a deck of 52
 *          cards and to perform similar operations on the deck of cards. These
 *          operations currently include dealing the top card, shuffling the
 *          deck, choosing a card from the deck, adn also determining whether or
 *          not you have reached the end of the deck.
 */

public class CardDeck
{

	/**
	 * constant DECKSIZE may be useful in the future for creating larger decks.
	 * Card[] deck is used to store all of the Card objects created by this
	 * class. deckPosition is the internal position of the last called Card.
	 */
	public final int				DECKSIZE		= 52;

	public Card[]					deck			= new Card[DECKSIZE];

	/**
	 * Static Constant RANK contains every rank possible in a standard card
	 * deck. Please note all of the non numeric card ranks have been replaced
	 * with a representative letter. In addition the number 10 has been replaced
	 * with the capital T for cleanliness of display.
	 * 
	 * Static Constant SUIT contains every suit possible in a standard card
	 * deck. The suit names have been written in short hand to clean up display.
	 * Spades = S / Hearts = H Diamonds = D / Clubs = C
	 * 
	 */
	public static final String[]	RANK			=
														{ "A", "2", "3", "4",
			"5", "6", "7", "8", "9", "T", "J", "Q", "K" };

	public static final String[]	SUIT			=
														{ "S", "H", "D", "C" };

	private int						deckPosition	= 0;

	/**
	 * constructor : CardDeck uses the buildDeck method to populate the deck
	 * array with Card objects.
	 */
	public CardDeck()
	{
		this.buildDeck("regular");
	}

	/**
	 * constructor : CardDeck uses the buildDeck method to populate the deck
	 * array with Card objects for the specified deck type.
	 */
	public CardDeck(String deckType)
	{
		this.buildDeck(deckType);
	}

	/**
	 * method : buildDeck buildDeck uses the constant RANK and SUIT values
	 * defined by the Card class to create one Card of each RANK and SUIT
	 * totaling 52. Each Card is then stored int the deck array.
	 */
	private void buildDeck(String deckType)
	{
		if (deckType.equals("regular"))
		{
			int count = 0;
			for (String suit : SUIT)
			{
				for (String rank : RANK)
				{
					deck[count] = new Card(rank, suit);
					count++;
				}
			}
		}
	}

	private void resetPosition()
	{
		this.deckPosition = 0;
	}

	/**
	 * method : hasNext
	 * 
	 * @return a boolean value used to determine if the end of the deck has been
	 *         reached.
	 */
	public boolean hasNext()
	{
		if (this.deckPosition < DECKSIZE)
		{
			return true;
		}
		this.resetPosition();
		return false;
	}

	/**
	 * method : deal
	 * 
	 * @return the Card at the next internally recorded deck position. This
	 *         position is stored by deckPosition defined above.
	 */
	public Card deal()
	{
		if (this.hasNext())
		{
			this.deckPosition++;
			return this.deck[this.deckPosition - 1];
		}
		this.resetPosition();
		return null;
	}

	/**
	 * method : shuffle shuffle method uses an ArrayList to store each card in
	 * the deck temporarily. Next the shuffled array is created and each element
	 * stored in the temp ArrayList is selected randomly and stored in the
	 * shuffled array. This is done using the Fisher-Yates shuffle algorithm (if
	 * I implemented it properly). Finally the original deck array is
	 * overwritten with the shuffled array.
	 */
	public void shuffle()
	{
		ArrayList<Card> temp = new ArrayList<Card>();
		for (Card card : this.deck)
		{
			temp.add(card);
		}

		Card[] shuffled = new Card[52];
		for (int i = 0; i < shuffled.length; i++)
		{
			int random = (int) (Math.random() * (deck.length - i));
			while (random < 0 || random > temp.size())
			{
				random = (int) (Math.random() * (deck.length - i));
			}
			shuffled[i] = temp.get(random);
			temp.remove(random);
		}
		this.deck = shuffled;
	}

	/**
	 * method : selectCard
	 * 
	 * @param cardNumber
	 *            the index( + 1) of the card selected by the user's input
	 * @return the Card from the deck at the selected position
	 * 
	 *         selectCard returns the card object from the position specified by
	 *         cardNumber - 1.
	 */
	public Card selectCard(int cardNumber)
	{
		cardNumber--;
		cardNumber = (cardNumber < deck.length) ? cardNumber
				: deck.length - 1;
		cardNumber = (cardNumber > 0) ? cardNumber : 0;
		return deck[cardNumber];
	}

	/**
	 * Method : cardValue
	 * 
	 * This method is used for comparison of the card objects using a standard
	 * deck (no jokers). The cards are all numbered and the integer value
	 * corresponding to the card is returned.
	 * 
	 * @param card
	 *            the Card object to find the integer representation of
	 * @return the integer value representing the card parameter
	 */

	public static int cardValue(Card card)
	{
		String[] theRank =
			{ "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A" };
		int count = 0;
		int value = 0;
		for (String rank : theRank)
		{
			for (String suit : SUIT)
			{
				if (card.getCard().equals(rank + suit))
				{
					value = count;
				}
				count++;
			}
		}

		return value;
	}
}
