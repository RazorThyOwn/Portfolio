import java.awt.Color;
class Tile
{
    private Color color;
    private String name;
    private int height;

    Tile(Color color,String nme)
    {
        this.color = color;
        name = nme;
    }

    Color getColor()
    {
        return color;
    }

    void setColor(Color c)
    {
        color = c;
    }
    
    int getHeight()
    {
        return height;
    }
    
    void setHeight(int h)
    {
        height = h;
    }
}