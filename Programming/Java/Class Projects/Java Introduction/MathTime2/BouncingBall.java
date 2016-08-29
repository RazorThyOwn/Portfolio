import sacco.*;
public class BouncingBall extends Sprite
{
    public int red, green, blue;
    public int gravity = 0;

    public BouncingBall(BoundingBox bounds)
    {
        super(0,0,0,0);
        this.setWidth(20);
        this.setHeight(20);
        red = (int)(Math.random()*256);
        green = (int)(Math.random()*256);
        blue = (int)(Math.random()*256);
        this.setX(bounds.getX()+Math.random()*bounds.getWidth());
        this.setY(bounds.getY()+Math.random()*bounds.getHeigth());

        this.setXVelocity(-8 + (Math.random()*16));
        this.setYVelocity(-8 + (Math.random()*16));

        this.setBoundary(bounds);
    }

    public void horizontalBounce()
    {
        this.setXVelocity( (0-this.getXVelocity())/2 * (Math.random()*1.5));
    }

    public void verticalBounce()
    {
        this.setYVelocity( (0-this.getYVelocity())/2 * (Math.random()*1.5));
    }

    public void paintSelf(PaintBrush brush)
    {
        brush.setColor(red,green,blue);
        brush.fillOval((int)this.getX(),(int)this.getY(),this.getWidth(),this.getHeight());
    }

    public void processBoundary()
    {
        BoundingBox box = super.getBoundary();
        if (this.getX() < box.getX())
        {
            this.setX(box.getX());
            this.horizontalBounce();
        }
        if (this.getX() > box.getX()+box.getWidth())
        {
            this.setX(box.getX()+box.getWidth());
            this.horizontalBounce();
        }
        if (this.getY() < box.getY())
        {
            this.setY(box.getY());
            this.verticalBounce();
            gravity = 0;
        }
        if (this.getY() > box.getY()+box.getHeigth())
        {
            this.setY(box.getY()+box.getHeigth());
            this.verticalBounce();
            gravity = 0;
        }
    }

    public void fall()
    {
        gravity=5;
        this.setYVelocity(this.getYVelocity()+gravity);
    }
}
