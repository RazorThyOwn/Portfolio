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

}