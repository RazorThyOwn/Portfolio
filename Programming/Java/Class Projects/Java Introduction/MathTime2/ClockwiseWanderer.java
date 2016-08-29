import sacco.*;
public class ClockwiseWanderer extends Wanderer
{
    private int[] directions = {Wanderer.RUN_UP,Wanderer.RUN_RIGHT,Wanderer.RUN_DOWN,Wanderer.RUN_LEFT};    
    private int count = 0;
    public ClockwiseWanderer(int inX, int inY)
    {
        super(inX, inY);
    }

    public void changeState()
    {
        super.setState(directions[count]);
        if (count<3)
            count++;
        else if (count>=3)
            count=0;
    }
}