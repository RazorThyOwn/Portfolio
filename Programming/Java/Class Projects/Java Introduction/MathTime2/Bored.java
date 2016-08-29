import sacco.*;
public class Bored
{
    static int i=0;
    static double mathSum=0;

    public static void main()
    {
        while (i < 300)
        {
            i++;
            double math = Math.random();
            System.out.println(math);
            //SaccoTools.pauseFor(200);
            mathSum +=math;
        }
        
        if (i==300)
        {
            System.out.println("\n\n\nThe sum of 300 random numbers is "+mathSum);
            System.out.println("The average number choosen was "+mathSum/300);
        }
    }
}