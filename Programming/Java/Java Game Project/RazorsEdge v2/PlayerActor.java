import java.awt.Color;
public class PlayerActor extends Object
{
    Player player;
    int index;
    
    public PlayerActor(Player playerIn)
    {
        player = playerIn;
        x = player.getXPos();
        y = player.getYPos();
        index = player.getIndex();
        Color gray = new Color(150,150,150);
        this.color = (gray);
        this.objectType = 1;
    }
    
    public Player getPlayer()
    {
        return player;
    }
}