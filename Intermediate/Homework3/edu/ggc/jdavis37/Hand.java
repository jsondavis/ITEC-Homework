package edu.ggc.jdavis37;

/**
 * Class : Hand
 * 
 * @author Jason Davis (jdavis37@ggc.edu)
 * @version 1.0 Course : ITEC 2150 Spring 2013 Written : February 18, 2013
 * 
 *          The Hand class is a container for Card objects. I had initially
 *          planned on extending the CardDeck class as it is also a card
 *          container however this seemed faster at code creation and the
 *          methods inherited from CardDeck seemed unnecessary.
 * 
 *          The purpose of this class is to hold the number of cards passed into
 *          it's constructor in an array and return them on call of getCard.
 * 
 */

public class Hand
{

	/**
	 * heldCards is the Card array which the cards are stored in.
	 */
	protected Card[]	heldCards;

	/**
	 * Method : Constructor
	 * 
	 * @param cardCount
	 *            the number of cards which can be passed into the heldCards
	 *            array
	 */
	public Hand(int cardCount)
	{
		heldCards = new Card[cardCount];
	}

	/**
	 * Method : getCard
	 * 
	 * This method returns the card from the provided index. TODO Future fixes
	 * should verify the existence of an index in the array before return
	 * 
	 * @param cardIndex
	 *            the index of the Card to be returned
	 * @return the Card object from the chosen index
	 */
	public Card getCard(int cardIndex)
	{
		return heldCards[cardIndex];
	}
}
