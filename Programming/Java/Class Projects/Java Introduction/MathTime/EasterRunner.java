import java.util.Scanner;
public class EasterRunner
{
    public static void main()
    {
        System.out.println("Enter a year to find what day is easter");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int inputString = Integer.parseInt(str);
        Easter est = new Easter(inputString);
        System.out.println(est.getEaster());
    }
}