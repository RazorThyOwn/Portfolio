import sacco.*;

public class Balance
{
    public static void main()
    {
        ShapeOrganizer shpOrg  = new ShapeOrganizer();
        
        //shpOrg.showGrid();
        
        // Circle
        shpOrg.showCircle();
        shpOrg.setCircleX(200);
        shpOrg.setCircleY(300);
        shpOrg.setCircleRadius(50);
        shpOrg.setCircleColor("blue");
        // Triangle
        shpOrg.showTriangle();
        shpOrg.setTriangleX(150);
        shpOrg.setTriangleY(150);
        shpOrg.setTriangleHeight(150);
        shpOrg.setTriangleBase(200);
        shpOrg.setTriangleColor("red");
        // Rectangle
        shpOrg.showRectangle();
        shpOrg.setRectangleX(175);
        shpOrg.setRectangleY(0);
        shpOrg.setRectangleWidth(150);
        shpOrg.setRectangleHeight(150);
        shpOrg.setRectangleColor("green");
    }
}