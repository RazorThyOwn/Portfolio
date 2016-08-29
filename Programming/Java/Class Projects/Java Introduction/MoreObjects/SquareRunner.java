import sacco.*;
public class SquareRunner extends SaccoObject
{
    public static void main()
    {

        
        Square sqr = new Square();
        String str = sqr.toString();
        System.out.println(str);
        //
        sqr.showWindow();
        SaccoTools.pauseFor(2000);
        //
        sqr.doubleSide();
        str = sqr.toString();
        System.out.println(str);
        //
        sqr.showWindow();
        SaccoTools.pauseFor(2000);
        //
        
        sqr = new Square(25, 40, 80);
        SaccoTools.pauseFor(2000);
        str = sqr.toString();
        System.out.println(str);
        //
        sqr.showWindow();
        SaccoTools.pauseFor(2000);
        //
        sqr.setColor("Red");
        str = sqr.toString();
        System.out.println(str);
        //
        sqr.showWindow();
        SaccoTools.pauseFor(2000);
        //
    }
}