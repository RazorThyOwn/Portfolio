import java.util.Scanner;
public class ForLoopsPrograms
{
    public static void Evens()
    {
        for(int i=2;i<=50;i+=2)
        {
            System.out.println(i);
        }
    }

    public static void countDown()
    {
        System.out.println("Enter number to count down from");
        Scanner scan = new Scanner(System.in);
        int input = Integer.parseInt(scan.nextLine());
        for(int i=input;i>0;i--)
        {
            System.out.print(i+", ");

        }
        System.out.println("0");
    }

    public static void factorial()
    {
        System.out.println("Enter number to factorial");
        Scanner scan = new Scanner(System.in);
        int input = Integer.parseInt(scan.nextLine());
        for (int i=(input-1);i>0;i--)
        {
            input*=i;
        }

        System.out.println(input);
    }

    public static void primeChecker()
    {
        System.out.println("Enter number to check for primeness");
        Scanner scan = new Scanner(System.in);
        int input = Integer.parseInt(scan.nextLine());
        int didMod = 0;
        for (int i=1;i<input;i++)
        {
            int checkLoop = (input % i);
            if (checkLoop==0)
                didMod++;
            if (checkLoop==i)
                didMod--;
        }
        if (didMod==1)
            System.out.println("The number "+input+" is prime!");
        else
            System.out.println("The number "+input+" is not prime!");
    }

    public static void triangleMaking()
    {
        System.out.println("Enter word to triangleize!");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println("");
        for (int i=input.length();i>0;i--)
        {
            System.out.println(input.substring(0,i));
        }
    }
}