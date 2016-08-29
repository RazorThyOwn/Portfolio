import sacco.*;

public class CenteredCircles extends SaccoObject
{
    private Circle[] circles;

    public CenteredCircles()
    {
        circles = new Circle[50];

        for(int i=0; i<circles.length; i++)
        {
            circles[i] = new Circle(250,250);
        }

    }

    public void onMousePress(MouseEvent m)
    {
        Sorter.selectionSort(circles);
    }

    public void paintWindow(PaintBrush brush)
    {
        for(int i=circles.length-1; i>=0; i--)
        {
            circles[i].paintSelf(brush);
        }
    }

    public static void main()
    {
        CenteredCircles c = new CenteredCircles();
        c.setVisible(true);
    }

}