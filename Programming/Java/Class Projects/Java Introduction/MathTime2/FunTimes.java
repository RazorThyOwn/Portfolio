import java.util.Scanner;
import sacco.*;
public class FunTimes
{
    public static void main()
    {   
        while (true)
        {
            SaccoTools.pauseFor(1000);
            int num = (int)(Math.random()*3)+1;
            System.out.println(num);
        }
    }
}