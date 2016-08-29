import java.awt.Color;
import sacco.*;
public class Object
{
    Color color = new Color(0,0,0);
    int x;
    int y;
    int objectType = 0;
    Picture pic;
    String name;
    int moveSpeed = 1;

    // 0 = wall, 1 = player

    public void setXPos(int xPos)
    {
        x = xPos;
    }

    public void setYPos(int yPos)
    {
        y = yPos;
    }

    public void setColor(Color inColor)
    {
        color = inColor;
    }

    public int getXPos()
    {
        return x;
    }

    public int getYPos()
    {
        return y;
    }

    public Color getColor()
    {
        return color;
    }

    public int getObjectType()
    {
        return objectType;
    }

    public Picture getPicture()
    {
        return pic;
    }

    public void setPicture(Picture inPic)
    {
        pic = inPic;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String nameIn)
    {
        name = nameIn;
    }
    
    public int getSpeed()
    {
        return moveSpeed;
    }
}