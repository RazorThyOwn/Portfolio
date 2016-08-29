import java.util.Scanner;
public class DigiRunner
{
    public static void main()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a 5 digit integer...");
        String str = scan.nextLine();
        int inputString = Integer.parseInt(str);
        DigiExtractor dE = new DigiExtractor(inputString);
        System.out.println("Your number backwards is: ");
        System.out.print(dE.nextDigit());
        System.out.print(dE.nextDigit());
        System.out.print(dE.nextDigit());
        System.out.print(dE.nextDigit());
        System.out.print(dE.nextDigit());
        
    }
}