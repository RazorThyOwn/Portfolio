import sacco.*;
public class RollDie implements QuickButton
{
    public String buttonLabel()
    {
        return "Roll Die";
    }
    
    public void whenPressed()
    {
        int x = (int)(1+(Math.random()*5));
        System.out.println("You rolled a(n) "+x+"!");
    }
}