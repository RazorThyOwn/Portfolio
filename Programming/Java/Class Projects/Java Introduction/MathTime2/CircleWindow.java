import sacco.*;
public class CircleWindow extends SaccoObject
{
    private CenteredCircle cC;
    
    public CircleWindow()
    {
        CenteredCircle cX = new CenteredCircle(250, 250, 800, "Red");
        cC = cX;
    }
    
    public static void main()
    {
        CircleWindow cW = new CircleWindow();
        cW.showWindow();
        cW.setDelay(10);
        cW.start();
    }
    
    public void paintWindow(PaintBrush brush)
    {
        cC.paintSelf(brush);
    }
    
    public void onTimerTick()
    {
        cC.grow();
    }
}