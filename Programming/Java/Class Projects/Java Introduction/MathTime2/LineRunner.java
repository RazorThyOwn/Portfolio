import java.util.Scanner;
import java.awt.Point;
public class LineRunner
{
    public static void main()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Put in the first point");
        String x1 = scan.nextLine();
        int x1I = Integer.parseInt(x1);
        System.out.println("Put in the second point");
        String x2 = scan.nextLine();
        int x2I = Integer.parseInt(x2);
        System.out.println("Put in the third point");
        String x3 = scan.nextLine();
        int x3I = Integer.parseInt(x3);
        System.out.println("Put in the fourth point");
        String x4 = scan.nextLine();
        int x4I = Integer.parseInt(x4);
        Point pnt1 = new Point(x1I, x2I);
        Point pnt2 = new Point(x3I, x4I);
        Line ln = new Line(pnt1, pnt2);
        double gYFX = ln.getYFromX(13);
        System.out.println("Point A: "+ln.formatPoint(pnt1));
        System.out.println("Point B: "+ln.formatPoint(pnt2));
        System.out.println("Distance: "+ln.getDistance());
        System.out.println("Slope: "+ln.getSlope());
        System.out.println("Y-Intercept: "+ln.getYIntercept());
        System.out.println("When X is 13, y is "+gYFX);
        System.out.println("MidPoint: "+ln.formatPoint(ln.getMidPoint()));

    }
}