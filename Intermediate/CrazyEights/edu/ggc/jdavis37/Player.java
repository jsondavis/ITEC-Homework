public class Player
{
    private Hand playerHand;
    private int playerId;

    public Player()
    {
    
    }

    public Player(Hand h, int id)
    {
        playerHand = h;
        playerId = id;
    }

    public Hand getHand()
    {
        return playerHand;
    }

    public getCard(int id)
    {
        return playerHand.playCard(id);
    }

}
