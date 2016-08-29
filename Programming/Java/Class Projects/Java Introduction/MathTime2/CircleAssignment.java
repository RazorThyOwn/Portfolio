import sacco.*;
public class CircleAssignment extends SaccoObject
{
    private CenteredCircle cC1, cC2, cC3;

    public CircleAssignment()
    {
        CenteredCircle cX1 = new CenteredCircle(125, 375, 60, "Red");
        CenteredCircle cX2 = new CenteredCircle(250, 250, 120, "Blue");
        CenteredCircle cX3 = new CenteredCircle(375, 375, 60, "Red");
        cC1 = cX1;
        cC2 = cX2;
        cC3 = cX3;
    }

    public static void main()
    {
        CircleAssignment cW = new CircleAssignment();
        cW.showWindow();
        cW.setDelay(10);
        cW.start();
    }

    public void paintWindow(PaintBrush brush)
    {
        cC1.paintSelf(brush);
        cC2.paintSelf(brush);
        cC3.paintSelf(brush);
    }

    public void onTimerTick()
    {
        cC1.grow();
        cC2.grow();
        cC3.grow();
    }
}