import java.util.Scanner;
public class Multiplier
{
    public static void main()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your favorite number");
        String inpt = scan.nextLine();
        int inptI = Integer.parseInt(inpt);
        int favNum = inptI*2;
        System.out.println(inptI + " is a good number, but mine is " + favNum);
        
        
        
    }
}