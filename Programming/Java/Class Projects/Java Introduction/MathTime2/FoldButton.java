import sacco.*;
public class FoldButton
{
    private Picture buttonPic;
    private int pX, pY, pWidth, pHeight, lastX, lastY;

    public FoldButton(int tmpX, int tmpY, int tWid, int tHei, Picture tmpPic)
    {
        buttonPic = tmpPic;
        pX = tmpX;
        pY = tmpY;
        pWidth = tWid;
        pHeight = tHei;
    }

    public void paintSelf(PaintBrush brush)
    {
        brush.drawPicture( buttonPic, pX, pY, pWidth, pHeight);
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