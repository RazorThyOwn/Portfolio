import sacco.*;

public class BlackAndWhite
{
    public static void main()
    {
        ShapeOrganizer shpOrg  = new ShapeOrganizer();
        // Background (Rectangle)
        shpOrg.showRectangle();
        shpOrg.setRectangleX(25);
        shpOrg.setRectangleY(25);
        shpOrg.setRectangleWidth(350);
        shpOrg.setRectangleHeight(350);
        shpOrg.setRectangleColor("black");
        // Triangle
        shpOrg.showTriangle();
        shpOrg.setTriangleX(50);
        shpOrg.setTriangleY(50);
        shpOrg.setTriangleBase(150);
        shpOrg.setTriangleHeight(150);
        shpOrg.setTriangleColor("white");
        // Circle
        shpOrg.showCircle();
        shpOrg.setCircleX(200);
        shpOrg.setCircleY(200);
        shpOrg.setCircleRadius(75);
        shpOrg.setCircleColor("white");
    }
}
        