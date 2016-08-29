import java.util.Scanner;
public class Squarer
{
    public static void main()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number to be squared");
        String inpt = scan.nextLine();
        int in = Integer.parseInt(inpt);
        int sqr = in*in;
        System.out.println("The square of " + in + " is " + sqr);
    }
}