package edu.ggc.jdavis37;

/**
 * class : Card
 * 
 * @author Jason Davis (jdavis37@ggc.edu)
 * @version 1.0 Course : ITEC 2150 Spring 2013 Written : February 18, 2013
 * 
 *          This class holds all of the logic used for statically determining
 *          the possible ranks and suits for any card. An instance of this class
 *          also stores and returns the rank and suit of a Card.
 * 
 *          The purpose of this class is to separate the logic for creating a
 *          card from the logic for a whole deck of cards.
 */

public class Card implements Comparable<Card>
{

	/**
	 * String cardRank contains the rank of the Card object. String cardSuit
	 * contains the suit of the card object.
	 */
	private final String	cardRank;
	private final String	cardSuit;

	public Card(String rankSuit)
	{
		this.cardRank = rankSuit.substring(0, 1);
		this.cardSuit = rankSuit.substring(1);
	}

	/**
	 * constructor : Card
	 * 
	 * @param rank
	 *            one of the ranks from the RANK constant above
	 * @param suit
	 *            one of the suits from the SUIT constant above
	 * 
	 *            Both parameters are used to set the internal cardRank and
	 *            cardSuit properties at Card instantiation.
	 */
	public Card(String rank, String suit)
	{
		this.cardRank = rank;
		this.cardSuit = suit;
	}

	/**
	 * method : getCard
	 * 
	 * @return a String containing cardRank and cardSuit concatenated for
	 *         compact display.
	 */
	public String getCard()
	{
		return cardRank + cardSuit;
	}

	@Override
	public int compareTo(Card otherCard)
	{
		String thisCard = this.getCard();
		String newCard = otherCard.getCard();
		if (thisCard.equals(newCard))
		{
			return 0;
		}
		else if (thisCard.charAt(0) == newCard.charAt(0))
		{
			return thisCard.substring(1).compareTo(newCard.substring(1));
		}
		return thisCard.substring(0).compareTo(newCard.substring(0));
	}
}
