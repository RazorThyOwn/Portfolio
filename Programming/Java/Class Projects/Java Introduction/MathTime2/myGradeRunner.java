import java.util.Scanner;
public class myGradeRunner
{
    public static void main()
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Input first grade");
        String inputString1 = scan.nextLine();
        Grade gr1 = new Grade(inputString1);

        System.out.println("Input second grade");
        String inputString2 = scan.nextLine();
        Grade gr2 = new Grade(inputString2);

        if (gr1.compareTo(gr2) > 0 )
        {
            System.out.println(inputString1 + " is greater than "+inputString2);
        }
        else if (gr1.compareTo(gr2) < 0 )
        {
            System.out.println(inputString2 + " is greater than "+inputString1);
        }
        else
        {
            System.out.println(inputString1 + " is the same as "+inputString2);
        }
    }

}