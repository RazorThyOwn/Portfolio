import java.util.Scanner;
import sacco.*;
public class DiceGame
{
    public static void main()
    {
        System.out.println("Time to play craps!");
        boolean loop = true;
        SaccoTools.pauseFor(1000);
        System.out.println("Rolling...");
        SaccoTools.pauseFor(1000);
        boolean didWin = false;
        int point1 = (int)(Math.random()*5)+1;
        int point2 = (int)(Math.random()*5)+1;
        int answer = point1+point2;
        if (point1+point2==7)
        {
            System.out.println("YOU WIN! POINT IS 7!!!");
            return;
        }
        System.out.println("Point is "+(point1+point2));
        while (loop)
        {
            System.out.println("Rolling...");
            SaccoTools.pauseFor(1000);
            point1 = (int)(Math.random()*5)+1;
            point2 = (int)(Math.random()*5)+1;
            int sum = point1+point2;
            System.out.println("You rolled a "+point1+" and a "+point2+" to get "+sum);
            if (sum==answer)
            {
                loop = false;
                didWin = true;
            }
            if (sum==7)
            {
                loop = false;
                didWin = false;
            }
        }

        if (didWin)
        {
            System.out.println("You win!");
        }
        if (!didWin)
        {
            System.out.println("You lose!");
        }
        else
            return;
    }
}