import java.util.Scanner;
public class Command
{
    public static void math()
    {
        System.out.println("Enter a number");
        Scanner scan = new Scanner(System.in);
        int in = Integer.parseInt(scan.nextLine());
        System.out.println(in+" plus "+5+" equals "+(in+5));
    }
}