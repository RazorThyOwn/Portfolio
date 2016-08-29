import sacco.*;

public class PacViewer extends SaccoObject
{
    private PacMan pac;
    private Sprite[] sprites;
    public PacViewer()
    {
        BoundingBox bounds = new BoundingBox(0,0,500,500);
        pac = new PacMan(bounds);
        sprites = new Sprite[31];

        for( int i =0; i<sprites.length-1; i++)
            sprites[i] = new Ghost(bounds);

        sprites[sprites.length-1]=pac;

    }

    public void paintWindow(PaintBrush brush)
    {
        brush.setColor(0,0,0);
        brush.fillRectangle(0,0,getWidth(),getHeight());
        
        for(Sprite s: sprites)
            s.paintSelf(brush);
    }

    public void onTimerTick()
    {
        for(Sprite s: sprites)
            s.update();
    }

    public void onMousePress(MouseEvent m)
    {
        for(Sprite s: sprites)
        {
            s.setX(m.getX()-s.getWidth()/2);
            s.setY(m.getY()-s.getHeight()/2);
        }
    }

    public void launch()
    {
        this.setVisible(true);
        this.start();
    }

    public void onKeyPress(int keyCode)
    {
        if( keyCode == 37)
            pac.setState(PacMan.LEFT);
        if( keyCode == 38)
            pac.setState(PacMan.UP);
        if( keyCode == 39)
            pac.setState(PacMan.RIGHT);
        if( keyCode == 40)
            pac.setState(PacMan.DOWN);

    }

    public static void pacRunner()
    {
        PacViewer pv = new PacViewer();
        pv.launch();
    }
}