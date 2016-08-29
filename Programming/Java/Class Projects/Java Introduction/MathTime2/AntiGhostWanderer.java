import sacco.*;
public class AntiGhostWanderer extends Wanderer
{
    public AntiGhostWanderer(double x, double y)
    {
        super(x,y);
    }
    
    public void setCharacterNumber(int charNum)
    {
        //keep randomizing until charNum is not 8
        while(charNum == 8)
        {
            charNum = (int)(Math.random()*9);
        }
        
        //Don't forget that you still have to actually
        //set the character number
        super.setCharacterNumber(charNum);
    }

} 