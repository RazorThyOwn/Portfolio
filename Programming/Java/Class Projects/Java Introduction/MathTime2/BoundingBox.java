public class BoundingBox
{
    private int pX, pY, pWidth, pHeigth;

    public BoundingBox(int tmpX, int tmpY, int tmpWidth, int tmpHeight)
    {
        pX = tmpX;
        pY = tmpY;
        pWidth = tmpWidth;
        pHeigth = tmpHeight;
    }

    public int getX()
    {
        return pX;
    }

    public int getY()
    {
        return pY;
    }

    public int getWidth()
    {
        return pWidth;
    }

    public int getHeigth()
    {
        return pHeigth;
    }

    public boolean overlaps(BoundingBox other)
    {
        if (pY+pHeigth < other.getY() || pY > other.getY()+other.getHeigth() || pX+pWidth < other.getX() || pX > other.getX()+other.getWidth())
        return false;
        else
        return true;
    }
}