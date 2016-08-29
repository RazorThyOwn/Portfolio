import sacco.*;

public class JumpManWorld extends SaccoObject
{   
    private Platform plat;
    private JumpMan man;

    public JumpManWorld()
    {
        plat = new Platform(0,400,400,100);
        man = new JumpMan(50,50);
    }

    public void onTimerTick()
    {
        BoundingBox bBoxMan = man.getBounds();
        BoundingBox bBoxPlat = plat.getBounds();

        if (bBoxPlat.overlaps(bBoxMan))
        {
            man.setY(301);
            man.setFallSpeed(0);
            man.setGrav(0);
        }
        else
            man.fall();
    }

    public void paintWindow(PaintBrush brush)
    {      
        plat.paintSelf(brush);
        man.paintSelf(brush);
    }

    public static void main()
    {
        JumpManWorld world = new JumpManWorld();
        world.showWindow();
        world.start();
    }

    public void onMousePress(MouseEvent m)
    {
        man.setGrav(1);
        man.setFallSpeed(0);
        man.setX(m.getX());
        man.setY(m.getY());
    }

    public void onKeyPress(int keyCode)
    {
        if (keyCode == 38)
        {
            man.setFallSpeed(0);
            man.setGrav(1);
            man.jump();
        }
        if (keyCode == 39)
        {
            man.moveRight();
        }
        if (keyCode == 37)
        {
            man.moveLeft();
        }
    }

}