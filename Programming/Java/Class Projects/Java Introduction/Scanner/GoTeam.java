import java.util.Scanner;
public class GoTeam
{
    public static void main()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your favorite sports team?");
        String inptG = scan.nextLine();
        System.out.println("What is your rival sports team?");
        String inptB = scan.nextLine();
        System.out.println("I hope that " + inptG + " beats " + inptB + ". Go " + inptG + "!");
    }
}