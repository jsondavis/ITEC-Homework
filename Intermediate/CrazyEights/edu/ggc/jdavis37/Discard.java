package edu.ggc.jdavis37;

public class Discard extends CardDeck
{
    private ArrayList<Card> pile = new ArrayList<Card>();

    public Discard(card)
    {
        pile.add(card);
    }

    public int getDiscardPileSize()
    {
        return this.pile.size();
    }

    public ArrayList<Card> addToDraw()
    {
        int pileSize = pile.size() - 1;
        Card topCard = pile.get(pileSize);
        pile.remove(pileSize);
        ArrayList<Card> discardCopy = pile.clone();
        pile.clear();
        pile.add(topCard);
        return discardCopy;
    }
}
