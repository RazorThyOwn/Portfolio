import sacco.*;
public class Rectangle implements Dragable
{
    private int x,y,width,height,red,green,blue;

    //constructs a new Rectangle with a random x,y,width,height, and color
    public Rectangle()
    {
        width = (int)(Math.random()*100+50);
        height = (int)(Math.random()*100+50);

        x = (int)(Math.random()*500);
        y = (int)(Math.random()*500);

        this.randomizeColor();
    }

    public void randomizeColor()
    {
        red = (int)(Math.random()*256);
        green = (int)(Math.random()*256);
        blue = (int)(Math.random()*256);
    }  

    //when called, this method will paint the current Rectangle
    public void paintSelf(PaintBrush brush)
    {
        brush.setColor(red,green,blue);
        brush.fillRectangle(x,y,width,height);

        brush.setColor(0,0,0);
        brush.drawRectangle(x,y,width,height);
    }

    //moves the rectangle by the given amount in each direction
    public void translate(int tmpX, int tmpY)
    {
        x += tmpX;
        y += tmpY;
    }

    //returns true if both x and y are within the boundaries of the rectangle
    public boolean containsPoint(int tmpX, int tmpY)
    {
        return tmpX >= x && tmpX<= x+ width && tmpY>= y && tmpY <= y+height;
    }
}