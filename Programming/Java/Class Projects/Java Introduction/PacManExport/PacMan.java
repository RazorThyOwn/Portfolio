import sacco.*;
public class PacMan extends StateBasedAnimatedSprite
{
    int speed = 6;
    public static final int LEFT=0,RIGHT=1,UP=2,DOWN=3;

    public PacMan(BoundingBox inBox)
    {
        super(230,230,40,40);
        super.setBoundary(inBox);
        Picture[][] strip = SpriteLoader.getPacManPics();
        setStrips(strip);
        this.setState(0);
    }

    public void processBoundary()
    {
        BoundingBox b = getBoundary();

        if( this.getX() > b.getX()+b.getWidth())
            this.setX(b.getX()-this.getWidth());

        if( this.getY() > b.getY()+b.getHeigth())
            this.setY(b.getY()-this.getHeight());

        if(this.getX() < b.getX()-this.getWidth())
            this. setX(b.getX()+b.getWidth());

        if(this.getY() < b.getY()-this.getHeight())
            this.setY(b.getY()+b.getHeigth());
    }

    public void fall()
    {

    }

    public void setState(int state)
    {
        super.setState(state);
        setXVelocity(0);
        setYVelocity(0);
        if (state==2)
        {
            setYVelocity(-speed*1.0);
        }
        if (state==3)
        {
            setYVelocity(speed*1.0);
        }
        if (state==0)
        {
            setXVelocity(-speed*1.0);
        }
        if (state==1)
        {
            setXVelocity(speed*1.0);
        }
    }
}