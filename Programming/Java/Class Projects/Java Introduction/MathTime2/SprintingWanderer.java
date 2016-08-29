import sacco.*;
public class SprintingWanderer extends Wanderer
{
    public SprintingWanderer(double x, double y)
    {
        super(x,y);
        this.setCharacterNumber(2);
        this.setSpeed(10);
    }
    
    public void setState(int state)
    {
        while(state>3)
        {
            state = (int)(Math.random()*8);
        }
        super.setState(state);
    }
}