import java.util.Scanner;

public class Mathematica 
{

    public static void main() 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pick a number to add with 10");
        String npt = scan.nextLine();
        int npti = Integer.parseInt(npt);
        System.out.println(npti+10);
        
    }
}