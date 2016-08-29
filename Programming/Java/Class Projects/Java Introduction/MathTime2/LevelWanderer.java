import sacco.*;
public class LevelWanderer extends Wanderer
{
    private int targetY;

    public LevelWanderer(int inX, int inY)
    {
        super(inX, inY);
        targetY = 250;
    }

    public void setTargetY(int yVal)
    {
        targetY = yVal;
    }

    public void update()
    {
        if (this.getY() < targetY+5 && this.getY() > targetY-5)
        {
            this.setY(targetY);
            while (this.getState()==0 || this.getState()==1)
            {
                int random = (int)(Math.random()*8);
                this.setState(random);
            }
        }
        else 
        {
            if (this.getY() < targetY)
                this.setState(1);
            else if (this.getY() > targetY)
                this.setState(0);
        }
        super.update();
    }
}