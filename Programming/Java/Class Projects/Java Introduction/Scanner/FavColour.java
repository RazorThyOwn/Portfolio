import java.util.Scanner;
public class FavColour
{

    public static void main()
    {   
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your favorite colour?");
        String fvclr = scan.nextLine();
        System.out.println( fvclr + " is a good colour, but my favorite is red");

    }
}