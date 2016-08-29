import java.util.Scanner;
public class WhileLoops
{

    public static void oddCounter()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number to count odds");
        String stringLimit = scan.nextLine();
        int intLimit = Integer.parseInt(stringLimit);
        int number = 1;
        while(number<=intLimit)
        {
            System.out.println(number);
            number+=2;
        }     
    }

    public static void verticalString()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a jumble of letters");
        String stringIn = scan.nextLine();
        int length = stringIn.length();
        int number = 0;
        while (length>number)
        {
            System.out.println(stringIn.substring(number,number+1));
            number++;
        }
    }

    public static void sentenceSplitter()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a phrase");
        String stringIn = scan.nextLine();
        int outOfBounds = 0;
        int spacePos = stringIn.indexOf(" ");
        while (outOfBounds==0)
        {
            System.out.println(stringIn.substring(0, spacePos));
            stringIn = stringIn.substring(spacePos+1);
            spacePos = stringIn.indexOf(" ");
            if (spacePos == -1)
            {
                System.out.println(stringIn);
                outOfBounds++;
            }
        }
    }
    
    public static void safeDivider()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter numerator");
        int num = Integer.parseInt(scan.nextLine());
        int breakA = 1;
        int denom = 0;
        do
        {
        System.out.println("Enter denominator");
        int denomOut = Integer.parseInt(scan.nextLine());
        denom = denomOut;
        if (denom==0)
            {
                System.out.println("Input a non-zero denominator");
            }
        else
            {
                breakA=0;
            }
        } while (breakA==1 );
        int div = num/denom;
        int rem = num%denom;
        System.out.println("The number " + num + " divided by " + denom + " has a quotient of " + div + " with a remainder of " + rem);
    }
}