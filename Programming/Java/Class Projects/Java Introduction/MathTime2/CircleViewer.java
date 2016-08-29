import sacco.*;

public class CircleViewer extends SaccoObject
{
    private Circle[] circles;

    public CircleViewer(Circle[] myCircles)
    {
        circles = myCircles;
    }

    public void paintWindow(PaintBrush brush)
    {
        for(int i=circles.length-1; i>=0; i--)
        {
            circles[i].paintSelf(brush);
        }
    }

    //Constructs an array of Circles centered around 250,250 and passes it to a CircleViewer
    public static void centeredRunner()
    {
        Circle[] circs = new Circle[50];

        for(int i=0; i<circs.length; i++)
        {
            circs[i] = new Circle(250,250);
        }

        CircleViewer c = new CircleViewer(circs);
        c.setVisible(true);
    }

    public static void randRunner()
    {
        Circle[] circs = new Circle[50];

        for(int i=0; i<circs.length; i++)
        {
            circs[i] = new Circle();
        }

        CircleViewer c = new CircleViewer(circs);
        c.setVisible(true);
    }

    public static void colorRunner()
    {
        Circle[] circs = new Circle[50];

        for(int i=0; i<circs.length; i++)
        {
            circs[i] = new Circle(255,150,80);
        }

        CircleViewer c = new CircleViewer(circs);
        c.setVisible(true);
    }

    public static void grayRunner()
    {
        Circle[] circs = new Circle[50];

        for(int i=0; i<circs.length; i++)
        {
            circs[i] = new Circle(200);
        }

        CircleViewer c = new CircleViewer(circs);
        c.setVisible(true);
    }

    public static void diagonalCircles()
    {

        Circle[] circs = new Circle[300];

        for(int i=0; i < circs.length; i++)
        {
            circs[i] = new Circle(0,0);
        }

        Sorter.selectionSort(circs);

        for( int i = 0 ; i < circs.length; i++)
        {

            int x = (circs[i].getRadius()-20)*500/180;
            int y = x;  //diagonals are on the x-y line

            if( i < circs.length/2)
            {
                circs[i].setLocation(x,y);
            }
            else
            {
                Point p = new Point(x,y);
                circs[i].setLocation(p);
            }

        }

        CircleViewer c = new CircleViewer(circs);
        c.setVisible(true);
    }
}