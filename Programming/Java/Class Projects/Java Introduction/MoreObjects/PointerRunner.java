import java.util.Scanner;
public class PointerRunner
{
    public static void main()
    {
        
        PointerObj pb = new PointerObj();
        Scanner scan = new Scanner(System.in);
        /*
        System.out.println(pb.getCoords()+" (toString)");
        pb.setCoords(10, 25);
        System.out.println(pb.getCoords()+" (setCoords)");
        pb.setX(5);
        pb.setY(10);
        System.out.println(pb.getCoords()+" (setX, setY)");
        System.out.println("The X coord is "+pb.getX()+" (getX)");
        System.out.println("The Y coord is "+pb.getY()+" (getY)");
        pb.translate(-53, 25);
        System.out.println(pb.getCoords()+" (translate(-53, 25))");
        System.out.println("\n\n==== PROJ ====\n\n");
        */
        pb.setCoords(5, 8);
        System.out.println(pb.getCoords());
        pb.setY(-8);
        pb.translate(4, 7);
        int vX = pb.getX();
        int vY = pb.getY();
        System.out.println("The X coord is now "+vX+" and the Y coord is now "+vY);
    }
}