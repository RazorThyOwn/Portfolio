import java.util.Scanner;
public class HourMinSecRunner
{
    public static void main()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Import a number of seconds");
        String inputS = scan.nextLine();
        int inputN = Integer.parseInt(inputS);
        HourMinSec hMS = new HourMinSec(inputN);
        System.out.println(hMS.getTime());
    }

}