import sacco.*;
public class Ghost extends StateBasedAnimatedSprite
{
    public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
    int countdown;
    int speed = 3;

    public Ghost(BoundingBox inBox)
    {
        super(250,250,40,40);
        this.setBoundary(inBox);
        int randMath = (int)(Math.random()*4);
        Picture[][] strips = SpriteLoader.getBlinkyPics();
        if (randMath==0)
        {
            strips = SpriteLoader.getInkyPics();
        }
        if (randMath==1)
        {
            strips = SpriteLoader.getPinkyPics();
        }
        if (randMath==2)
        {
            strips = SpriteLoader.getClydePics();
        }
        this.setStrips(strips);
        this.setState(1);
        this.randomizeCounter();
    }

    public void update()
    {
        super.update();
        countdown--;
        if (countdown<1)
        {
            this.randomizeState();
            this.randomizeCounter();
        }
    }

    public void randomizeCounter()
    {
        countdown = ((int)(Math.random()*11)+30);
    }

    public void randomizeState()
    {
        this.setState((int)(Math.random()*4));
    }

    public void fall()
    {

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

    public static void ghostRunner()
    {
        Ghost[] ghosts = new Ghost[64];
        BoundingBox boundary = new BoundingBox(0,0,500,500);
        for( int i =0; i < ghosts.length; i++)
        {
            ghosts[i] = new Ghost(boundary);
            int c = i%8;
            int r = i/8;
            ghosts[i].setX(20+60*c);
            ghosts[i].setY(20+60*r);
            ghosts[i].setState(r%4);
        }

        SpriteViewer view = new SpriteViewer(ghosts);
        view.setVisible(true);
        view.start();
    }

    public void setState(int state)
    {
        super.setState(state);
        setXVelocity(0);
        setYVelocity(0);
        if (state==0)
        {
            setYVelocity(-speed*1.0);
        }
        if (state==1)
        {
            setYVelocity(speed*1.0);
        }
        if (state==2)
        {
            setXVelocity(-speed*1.0);
        }
        if (state==3)
        {
            setXVelocity(speed*1.0);
        }
    }

}