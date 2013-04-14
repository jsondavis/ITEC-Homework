package edu.ggc.jdavis37;


public class Card
{

    private int rankNum;
    private String rank, suit;

    public Card(String someRank, String someSuit)
    {
        this.rank = someRank;
        this.suit = someSuit;
    }

    public Card(String someRank, String someSuit, int someNumber)
    {
        this.rank = someRank;
        this.suit = someSuit;
        this.rankNum = someNumber;
    }

    public String toString()
    {
        return String.format("%s%s",this.rank, this.suit);  
    }

    public String getRank()
    {
        return this.rank;        
    }

    public String getSuit()
    {
        return this.suit;
    }
}
