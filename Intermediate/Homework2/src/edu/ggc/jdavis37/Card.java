package edu.ggc.jdavis37;

public class Card
{

	private char suit = ' ';
	private int value = 0;
	
	public Card(char suit, int val)
	{
		this.suit = suit;
		this.value = val;
	}
	
	/**
	 * @return the suit
	 */
	public char getSuit() {
		return suit;
	}
	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
}
