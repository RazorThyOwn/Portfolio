import java.util.Scanner;
public class NestedLoops
{
    public static void SquareGrid()
    {
        System.out.println("How many rows/columns?");
        Scanner scan = new Scanner(System.in);
        int input = Integer.parseInt(scan.nextLine());

        for (int i = 0;i<input;i++)
        {
            for (int a = 1;a<=input;a++)
            {
                System.out.print(a + " ");
            }
            System.out.println("");
        }
    }

    public static void Triangle()
    {
        System.out.println("How many rows/columns?");
        Scanner scan = new Scanner(System.in);
        int input = Integer.parseInt(scan.nextLine());

        for (int i = 1;i<=input;i++)
        {
            for (int a = 1;a<=i;a++)
            {
                System.out.print(a + " ");
            }
            System.out.println("");
        }
    }

    public static void Rectangles()
    {
        System.out.println("Length\tWidth\tPerimeter  Area");
        System.out.println("");
        for (int i = 1;i<=10;i++)
        {
            for (int a = 1;a<=10;a++)
            {
                int p = (i*2)+(a*2);
                int ar = (i*a);
                System.out.println(i + "\t" + a + "\t" + p + "\t    " + ar);
            }
        }
    }

    public static void SquareDesign()
    {
        System.out.println("Enter value for N: ");
        Scanner scan = new Scanner(System.in);
        int input = Integer.parseInt(scan.nextLine());

        // Top Bar //
        System.out.print("+");
        for (int topBar = 0;topBar<(2*input)+1;topBar++)
        {
            System.out.print("-");
        }
        System.out.println("+");
        for (int i = 0;i<input;i++)
        {
            System.out.print("I");
            for (int middleSection = 0;middleSection<input;middleSection++)
            {
                System.out.print("-X");
            }
            System.out.print("-I");
            System.out.println("");
        }
        System.out.print("+");
        for (int topBar2 = 0;topBar2<(2*input)+1;topBar2++)
        {
            System.out.print("-");
        }
        System.out.print("+");
    }

    public static void Arrow(int input)
    {
        for (int i = 0;i<input;i++)
        {
            for (int a = 0;a<=i;a++)
            {
                System.out.print("* ");
            }          
            System.out.println("");
        }

        for (int x = input;x>=0;x--)
        {
            for (int y = 0;y<=x;y++)
            {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    public static void WordPrinter(String input)
    {
        int length = input.length();
        for (int fuckYouMax = 0;fuckYouMax<input.length();fuckYouMax++)
        {
            System.out.print(input.substring(fuckYouMax,fuckYouMax+1) + " ");
        }
        System.out.println("");
        for (int i = 0;i<input.length()-2;i++)
        {
            System.out.print(input.substring(i+1,i+2));
            for (int x = 0;x<input.length()-2;x++)
            {
                System.out.print("  ");
            }
            System.out.print(" ");
            System.out.print(input.substring(length-i-2,length-i-1));
            System.out.println("");
        }
        for (int x = 0;x<input.length();x++)
        {
            System.out.print(input.substring(length-x-1,length-x));
            System.out.print(" ");
        }
    }
}
