import java.util.Scanner;
public class DistanceDescriber
{
    public static void main()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a distance in miles");
        String inputS = scan.nextLine();
        double dMiles = Double.parseDouble(inputS);
        int mMiles = (int)dMiles;
        double dFeet = (dMiles-(double)mMiles)*5280;
        int mFeet = (int)dFeet;
        double dInch = (dFeet-(double)mFeet)*12;
        int mInch = (int)dInch;
        //
        System.out.println("That is "+mMiles+" miles, "+mFeet+" feet, "+mInch+" inches");
    }
}