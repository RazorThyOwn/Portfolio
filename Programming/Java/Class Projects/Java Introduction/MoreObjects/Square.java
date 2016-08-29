import sacco.*;
public class Square extends SaccoObject
{
    private int x;
    private int y;
    private int sideLength;
    private String color;
    
    public void paintWindow(PaintBrush brush)
    {
        brush.setColor(color);
        brush.fillRectangle(x, y, sideLength, sideLength);
        brush.setThickness(5);
        brush.setColor("Black");
        brush.drawRectangle(x, y, sideLength, sideLength);
    }
    
    public Square()
    {
        x = 0;
        y = 0;
        color = "Green";
        sideLength = 100;
    }
    
    public Square(int tX, int tY, int tSideLength)
    {
        x = tX;
        y = tY;
        sideLength = tSideLength;
        color = "Blue";
    }
    
    public void setX(int aX)
    {
        x = aX;
    }
    
    public void setY(int aY)
    {
        y = aY;
    }
    
    public void setColor(String tColor)
    {
        color = tColor;
    }
    
    public int getArea()
    {
        int area = sideLength*sideLength;
        return area;
    }
    
    public int getPerimeter()
    {
        int perimeter = sideLength*4;
        return perimeter;
    }
    
    public void doubleSide()
    {
        sideLength = 2*sideLength;
    }
    
    public String toString()
    {
        String str = "The "+color+" square is located at ("+x+"/"+y+") and has a side length of "+sideLength+". It has an area of "+getArea()+" and a perimeter of "+getPerimeter();
        return str;
    }
}