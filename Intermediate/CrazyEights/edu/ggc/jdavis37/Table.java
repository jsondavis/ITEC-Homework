package edu.ggc.jdavis37;


public class Table
{
    private Player[] players; 
    private CardDeck playDeck = new CardDeck();

    public Table(int playerCount)
    {
        playDeck.getPlayDeck();
        players = new Player[playerCount];
    }

    private void getPlayerGroup()
    {
        for(int i = 0; i < player.length; i++)
        {
            players[i] = getPlayer();
        }
    }

    private Player getPlayer()
    {
    
    }

}
