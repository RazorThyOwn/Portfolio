import sacco.*;
public class CountUp implements QuickButton
{
    private int x = 0;
    public String buttonLabel()
    {
        return "Count up";
    }
    
    public void whenPressed()
    {
        x++;
        System.out.println(x);
    }
}