import sacco.*;
public class Shell extends AnimatedSprite
{
    public Shell(double x, double y)
    {
        super(x,y,32,32);
        this.setXVelocity(15);
        Picture[] pics = SpriteLoader.greenShellPics();
        super.setPictureStrip(pics);
    }

    public void horizontalBounce()
    {
        this.setXVelocity(0-this.getXVelocity());
    }

    public void verticalBounce()
    {
        this.setYVelocity(0-this.getYVelocity());
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
        }
        if (this.getY() > box.getY()+box.getHeigth())
        {
            this.setY(box.getY()+box.getHeigth());
            this.verticalBounce();
        }
    }

    public void fall()
    {

    }
}