import sacco.*;
public class BoundedWanderer extends Wanderer
{
    public int minX, minY, maxX, maxY;
    public BoundedWanderer(int minX, int minY, int maxX, int maxY )
    {
        super(Math.random()*(maxX-minX)+minX,Math.random()*(maxY-minY)+minY);

        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;

    }
    
    public void update()
    {
        super.update();
        if (this.getX()<minX)
        {
            this.setX(minX);
        }
        if (this.getX()>maxX)
        {
            this.setX(maxX);
        }
        if (this.getY()<minY)
        {
            this.setY(minY);
        }
        if (this.getY()>maxY)
        {
            this.setY(maxY);
        }
    }
}