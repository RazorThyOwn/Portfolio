import sacco.*;
public class Ace
{
    private Picture acePic, backOfCard;
    private int pX, pY, pWidth, pHeight, lastX, lastY;
    private boolean isFaceUp, isAceHeld;

    public Ace()
    {
        acePic = Picture.loadFromJar("/cards/AS.png");
        backOfCard = Picture.loadFromJar("/cards/b1fv.png");
        isFaceUp = true;
        pX = 200;
        pY = 200;
        pWidth = 71;
        pHeight = 96;
    }

    public void flipCard()
    {
        isFaceUp = !isFaceUp;
    }

    public void paintSelf(PaintBrush brush)
    {
        if (isFaceUp)
            brush.drawPicture( acePic, pX, pY, pWidth, pHeight);
        else
            brush.drawPicture( backOfCard, pX, pY, pWidth, pHeight);
    }

    public boolean containsPoint(int x, int y)
    {
        if (x >= pX && x <= pX+pWidth && y >= pY && y <= pY+pHeight)
        return true;
        else
        return false;
    }
    
    public void translate(int x, int y)
    {
        pX+=x;
        pY+=y;
    }
}