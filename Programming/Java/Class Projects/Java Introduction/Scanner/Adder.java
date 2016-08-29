import java.util.Scanner;
public class Adder
{
    public static void main()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input two numbes to add...");
        System.out.println("Input the first one:");
        String inpts1 = scan.nextLine();
        int in1 = Integer.parseInt(inpts1);
        System.out.println("Input the second one:");
        String inpts2 = scan.nextLine();
        int in2 = Integer.parseInt(inpts2);
        int sum = in1 + in2;
        System.out.println(in1 + " + " + in2 + " = " + sum);
        
    }
}