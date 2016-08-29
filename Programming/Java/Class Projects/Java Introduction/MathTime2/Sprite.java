import sacco.*;
public abstract class Sprite
{
    private double xvel, yvel, x, y;
    private int width, height;
    private BoundingBox bBox;
    
    public abstract void paintSelf(PaintBrush brush);
    public abstract void processBoundary();
    public abstract void fall();

    public Sprite(double x, double y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void move()
    {
        x+=xvel;
        y+=yvel;
    }

    public void update()
    {
        this.move();
        this.processBoundary();
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getXVelocity()
    {
        return xvel;
    }

    public double getYVelocity()
    {
        return yvel;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public BoundingBox getBoundary()
    {
        return bBox;
    }

    public void setX(double tmpX)
    {
        x = tmpX;
    }

    public void setY(double tmpY)
    {
        y = tmpY;
    }

    public void setXVelocity(double tmpVel)
    {
        xvel = tmpVel;
    }

    public void setYVelocity(double tmpVel)
    {
        yvel = tmpVel;
    }  

    public void setWidth(int tmpWidth)
    {
        width = tmpWidth;
    }

    public void setHeight(int tmpHeight)
    {
        height = tmpHeight;
    }

    public void setBoundary(BoundingBox bound)
    {
        bBox = bound;
    }
}