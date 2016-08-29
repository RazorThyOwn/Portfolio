import sacco.*;
public class Platform
{
    private int pX, pY, pHeigth, pWidth;
    
    public Platform(int x, int y, int height, int width)
    {
        pX = x;
        pY = y;
        pHeigth = height;
        pWidth = width;
    }
    
    public void paintSelf(PaintBrush brush)
    {
        brush.setColor("Green");
        brush.fillRectangle(pX, pY, pHeigth, pWidth);
    }
    
    public BoundingBox getBounds()
    {
        BoundingBox box = new BoundingBox(pX, pY, pHeigth, pWidth);
        return box;
    }
    
    public int getY()
    {
        return pY-pHeigth;
    }
}