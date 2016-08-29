import sacco.*;
public abstract class StateBasedAnimatedSprite extends AnimatedSprite
{
    int state;
    Picture[][] strip = new Picture[0][0];
    
    public StateBasedAnimatedSprite(int x, int y, int w, int h)
    {
        super(x,y,w,h);
    }
    
    public void setStrips(Picture[][] strips)
    {
        this.strip = strips;
    }
    
    public void setState(int state)
    {
        this.state = state;
        this.setPictureStrip(strip[state]);
    }
}