import java.util.Scanner;
public class DecToBinRunner
{
    public static void main()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pick a number between 0 and 64 to convert to binary");
        String str = scan.nextLine();
        int inputNumber = Integer.parseInt(str);
        DecToBin dTB = new DecToBin(inputNumber);
        System.out.println(dTB.toBin());
    }
}