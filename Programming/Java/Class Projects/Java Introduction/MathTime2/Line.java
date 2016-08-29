import java.awt.Point;
public class Line
{
    private Point pnt1, pnt2;
    
    public Line(Point p1, Point p2)
    {
        pnt1 = p1;
        pnt2 = p2;
    }
    
    public double getSlope()
    {
        double topPart = (pnt2.getY() - pnt1.getY());
        double bottomPart = (pnt2.getX() - pnt1.getX());
        return (topPart)/(bottomPart);
    }
    
    public double getDistance()
    {
        double fPart = Math.pow(pnt2.getX()-pnt1.getX(), 2);
        double sPart = Math.pow(pnt2.getY()-pnt1.getY(), 2);
        double tPart = fPart + sPart;
        return Math.sqrt(tPart);    
    }
    
    public double getYIntercept()
    {
        //
        double b = pnt2.getY() - (this.getSlope()*pnt2.getX());
        return b;
    }
    
    public double getYFromX(int x)
    {
        double y = (this.getSlope()*x)+this.getYIntercept();
        return y;
    }
    
    public Point getMidPoint()
    {
        int fPart = (int)Math.round((pnt2.getX()+pnt1.getX())/2);
        int sPart = (int)Math.round(((pnt2.getY()+pnt1.getY())/2));
        Point pnt3 = new Point(fPart,sPart);
        return pnt3;
    }
    
    public static String formatPoint(Point p)
    {
        double iX = p.getX();
        double iY = p.getY();
        String str = "("+iX+", "+iY+")";
        return str;
    }
    
}