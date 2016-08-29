import sacco.*;
public class BoundingBoxTester extends SaccoObject
{
    private int x,y;
    private BoundingBox stationary, drag;
    
    public BoundingBoxTester()
    {
        x = Integer.MAX_VALUE;
        y = Integer.MAX_VALUE;  
        stationary = new BoundingBox(170,200,160,100);    
    }

    public void paintWindow(PaintBrush brush)
    {

        if(drag != null && drag.overlaps(stationary))
        {
            brush.setColor("RED");
            brush.fillRectangle(170,200,160,100);    
        }
        
        brush.setThickness(4);
        brush.setColor("black");
        brush.drawRectangle(170,200,160,100);    

        
        brush.drawRectangle(x-50,y-80,100,160);
    }

    public void onMouseMove(MouseEvent m)
    {
        x=m.getX();
        y=m.getY();
        drag = new BoundingBox(x-50,y-80,100,160);
    }

    public static void main()
    {
        BoundingBoxTester b = new BoundingBoxTester();
        b.showWindow();
    }
}