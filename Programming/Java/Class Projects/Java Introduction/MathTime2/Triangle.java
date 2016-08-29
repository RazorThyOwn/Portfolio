import sacco.*;
public class Triangle implements Dragable
{
    private int red,green,blue;
    private Point a,b,c;

    //constructs a new Circle with a random x,y,width,height, and color
    public Triangle()
    {
        int RandX = (int)(Math.random()*500);
        int RandY = (int)(Math.random()*500);
        a = new Point(RandX,RandY);
        b = new Point(RandX,RandY+(int)(Math.random()*200));
        c = new Point(RandX+(int)(Math.random()*200),RandY+(int)(Math.random()*200));
        this.randomizeColor();
    }

    public void randomizeColor()
    {
        red = (int)(Math.random()*256);
        green = (int)(Math.random()*256);
        blue = (int)(Math.random()*256);
    }  

    //when called, this method will paint the current Circle
    public void paintSelf(PaintBrush brush)
    {
        brush.setColor(red,green,blue);
        brush.fillTriangle(a,b,c);
        
        brush.setColor(0,0,0);
        brush.drawTriangle(a,b,c);
    }

    //moves the Circle by the given amount in each direction
    public void translate(int tmpX, int tmpY)
    {
        a.setX(tmpX+a.getX());
        b.setX(tmpX+b.getX());
        c.setX(tmpX+c.getX());

        a.setY(tmpY+a.getY());
        b.setY(tmpY+b.getY());
        c.setY(tmpY+c.getY());
    }

    //returns true if both x and y are within the boundaries of the Circle
    public boolean containsPoint(int x, int y)
    {
        Point d = new Point(x,y);   
        double triArea = this.getTriangleArea(a,b,c);

        double tmpArea = this.getTriangleArea(d,b,c);
        tmpArea += this.getTriangleArea(a,d,c);
        tmpArea += this.getTriangleArea(a,b,d);

        return Math.abs(triArea-tmpArea)<.001;        
    }

    private double getTriangleArea(Point p1, Point p2, Point p3)
    {
        int aX = p2.getX() - p1.getX();
        int aY = p2.getY() - p1.getY();
        int bX = p2.getX() - p3.getX();
        int bY = p2.getY() - p3.getY();

        return Math.abs(aX * bY - bX * aY) / 2.0;
    }
}