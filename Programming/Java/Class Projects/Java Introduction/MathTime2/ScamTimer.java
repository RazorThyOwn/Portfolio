import sacco.*;
public class ScamTimer
{
    public static void main()
    {
        int number = 0;
        while (true)
        {
            number++;
            System.out.println("PRINT NUMBER: " + number);
            SaccoTools.pauseFor(90000);
        }
    }
}