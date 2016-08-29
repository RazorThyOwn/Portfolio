import sacco.*;
public abstract class AnimatedSprite extends Sprite
{
    private Picture[] pic;
    private int index;
    public AnimatedSprite(double x, double y, int w, int h)
    {
        super(x,y,w,h);
    }
    
    public void setPictureStrip(Picture[] strip)
    {
        pic = strip;
    }
    
    public Picture currentImage()
    {
        return pic[index];
    }
    
    public void changeImage()
    {
        if (index>-3+pic.length)
            index = 0;
        else
            index++;
    }
    
    public void paintSelf(PaintBrush brush)
    {
        brush.drawPicture(pic[index],(int)super.getX(),(int)super.getY(),super.getWidth(),super.getHeight());
    }
    
    public void update()
    {
        this.changeImage();
        super.update();
    }
}