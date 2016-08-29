import sacco.*;

public class HomeSweetHome
{
    public static void main()
    {
        ShapeOrganizer shpOrg  = new ShapeOrganizer();
        // Sun (Circle)
        shpOrg.showCircle();
        shpOrg.setCircleX(25);
        shpOrg.setCircleY(25);
        shpOrg.setCircleRadius(50);
        shpOrg.setCircleColor("yellow");
        // House Roof (Triangle)
        shpOrg.showTriangle();
        shpOrg.setTriangleX(125);
        shpOrg.setTriangleY(100);
        shpOrg.setTriangleBase(300);
        shpOrg.setTriangleHeight(125);
        shpOrg.setTriangleColor("red");
        // House Base (Rectangle)
        shpOrg.showRectangle();
        shpOrg.setRectangleX(175);
        shpOrg.setRectangleY(225);
        shpOrg.setRectangleWidth(200);
        shpOrg.setRectangleHeight(150);
        shpOrg.setRectangleColor("yellow");
    }
}