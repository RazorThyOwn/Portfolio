import sacco.*;
public class Circle implements Dragable,Comparable<Circle>
{
    private int x,y,centerX,centerY,width,height,red,green,blue;

    //constructs a new Circle with a random x,y,width,height, and color
    public Circle()                                                                                                                                                                                                                                                 
    {
        width = (int)(Math.random()*180);
        width+=20;
        height = width;

        x = (int)(Math.random()*500);
        y = (int)(Math.random()*500);

        this.randomizeColor();
    }

    public Circle(int Tred, int Tgreen, int Tblue)
    {
        this();
        this.red = Tred;
        this.green = Tgreen;
        this.blue = Tblue;
    }

    public Circle(int tx, int ty)
    {
        this();
        y = ty;
        x = tx;
    }
    
    public Circle(int grayVal)
    {
        this();
        this.red = grayVal;
        this.green = grayVal;
        this.blue = grayVal;
    }

    public double getArea()
    {
        return 3.14159*(this.getRadius()*this.getRadius());
    }

    public int compareTo(Circle cir)
    {
        if (cir.getRadius()>width)
            return -1;
        else if (cir.getRadius()==width)
            return 0;
        else
            return 1;
    }

    public int getRadius()
    {
        return width;
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
        brush.fillOval(x-width/2,y-height/2,width,height);

        brush.setColor(0,0,0);
        brush.drawOval(x-width/2,y-height/2,width,height);
    }

    //moves the Circle by the given amount in each direction
    public void translate(int tmpX, int tmpY)
    {
        x += tmpX;
        y += tmpY;
    }

    //returns true if both x and y are within the boundaries of the Circle
    public boolean containsPoint(int tmpX, int tmpY)
    {
        if ((width/2.0)>(Math.sqrt(Math.pow(tmpX-(x),2)+Math.pow(tmpY-(y),2))))
        {
            return true;
        }
        else
            return false;
    }
    
    public void setLocation(int tX, int tY)
    {
        x = tX;
        y = tY;
    }
    
    public void setLocation(Point P)
    {
        this.setLocation(P.getX(), P.getY());
    }
}