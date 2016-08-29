import java.awt.Color;
import sacco.*;
public class Tile extends Object
{       
    Picture pic;
    public Tile(Color colorIn)
    {
        objectType = 2;
        this.setColor(colorIn);
    }    
}