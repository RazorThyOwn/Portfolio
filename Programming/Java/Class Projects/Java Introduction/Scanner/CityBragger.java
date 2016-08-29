import java.util.Scanner;
public class CityBragger
{
    public static void main()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("What city do you live in?");
        String stng = scan.nextLine();
        System.out.println("I bet the weather in " + stng + " isnt as nice as San Diego");
    }
}