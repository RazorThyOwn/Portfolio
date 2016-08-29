public class PointerObj
{
    private int vX;
    private int vY;

    public PointerObj()
    {
        vX = 0;
        vY = 0;

    }

    public int getX()
    {
        return vX;
    }

    public int getY()
    {
        return vY;
    }

    public void setX(int tX)
    {
        vX = tX;
    }

    public void setY(int tY)
    {
        vY = tY;
    }
    
    public void setCoords(int tX, int tY)
    {
        vX = tX;
        vY = tY;
    }
    
    public void translate(int tX, int tY)
    {
        vX = vX+tX;
        vY = vY+tY; 
    }

    public String getCoords()
    {
        String str = "The current location is "+vX+","+vY;
        return str;
    }
}