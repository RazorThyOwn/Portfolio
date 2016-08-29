import sacco.*;
public class CenteredCircle
{
    private int posX, posY, radius, maxRadius;
    private String color;

    public CenteredCircle(int x, int y, int rad, String tcolor)
    {
        radius=50;
        posX = x;
        posY = y;
        color=tcolor;
        maxRadius=rad;
    }

    public void setColor(String colr)
    {
        color = colr;
    }

    public void setRadius(int rad)
    {
        radius=rad;
    }

    public void setMaxRadius(int mxR)
    {
        maxRadius=mxR;
    }

    public void paintSelf(PaintBrush brush)
    {
        int cX = posX - (radius/2);
        int cY = posY - (radius/2);
        brush.setColor(color);
        brush.fillOval(cX, cY, radius, radius);
    }

    public void grow()
    {
        radius+=40/30;
        radius = radius % maxRadius;
    }
}