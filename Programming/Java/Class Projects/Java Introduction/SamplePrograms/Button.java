import sacco.*;
public class Button
{
    private int pX, pY, pWidth, pHeight;

    public Button(int tmpX, int tmpY, int tWid, int tHei)
    {
        pX = tmpX;
        pY = tmpY;
        pWidth = tWid;
        pHeight = tHei;
    }

    public boolean containsPoint(int x, int y)
    {
        if (x >= pX && x <= pX+pWidth && y >= pY && y <= pY+pHeight)
            return true;
        else
            return false;
    }
    
    public boolean press(int x, int y)
    {
        if (this.containsPoint(x, y))
            return true;
        else
            return false;
    }
}