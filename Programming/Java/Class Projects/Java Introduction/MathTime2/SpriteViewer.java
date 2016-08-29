import sacco.*;
public class SpriteViewer extends SaccoObject
{
    private Sprite[] sprites;

    public SpriteViewer(Sprite[] sprites)
    {
        this.sprites = sprites;
    }

    public void paintWindow(PaintBrush brush)
    {
        for(Sprite sArr: sprites)
            sArr.paintSelf(brush);
    }

    public void onTimerTick()
    {
        for(Sprite sArr: sprites)
        {
            sArr.update();
            sArr.fall();
        }
    }

    public void launch()
    {
        this.setVisible(true);
        this.start();
    }

    public void onMousePress(MouseEvent m)
    {
        /*
        for (Sprite sArr: sprites)
        {
            int sWidth = sArr.getWidth()/2;
            int sHeight = sArr.getHeight()/2;

            sArr.setX(m.getX()-sWidth);
            sArr.setY(m.getY()-sHeight);

            sArr.setXVelocity(-64 + (Math.random()*128));
            sArr.setYVelocity(-64 + (Math.random()*128));
        }*/
    }    

    public static void bounceRunner()
    {
        BouncingBall[] orbs = new BouncingBall[500];
        for(int i =0; i<orbs.length; i++)
        {       
            orbs[i] = new BouncingBall( new BoundingBox(0,0,500,500));
        }

        SpriteViewer view = new SpriteViewer(orbs);
        view.launch();
    }

    public static void bigBounceRunner()
    {
        BouncingBall[] orbs = new BouncingBall[500];
        for( int i =0; i<orbs.length; i++)
        {       
            orbs[i] = new BouncingBall( new BoundingBox(150,150,200,200));
        }

        SpriteViewer view = new SpriteViewer(orbs);
        view.launch();
    }

    public static void shellRunner()
    {
        Shell[] shells = new Shell[1];
        shells[0] = new Shell(0,84);
        shells[0].setBoundary(new BoundingBox(0,0,500,200));
        SpriteViewer sv = new SpriteViewer(shells);
        sv.setSize(500,200);
        sv.launch();
    }
}