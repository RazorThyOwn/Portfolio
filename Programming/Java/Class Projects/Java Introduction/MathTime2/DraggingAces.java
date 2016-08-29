import sacco.*;
public class DraggingAces extends SaccoObject
{
    private Ace myAce;
    private boolean isHeld;
    private int lastX, lastY;

    public DraggingAces()
    {
        myAce = new Ace();
    }

    public void paintWindow(PaintBrush brush)
    {
        myAce.paintSelf(brush);
    }

    public static void main()
    {
        DraggingAces dA = new DraggingAces();
        dA.showWindow();
    }   

    public void onMousePress(MouseEvent m)
    {
        if (myAce.containsPoint(m.getX(), m.getY()))
        {
            isHeld = true;
            lastX = m.getX();
            lastY = m.getY();
        }
    }

    public void onMouseRelease(MouseEvent m)
    {
        isHeld = false;
    }

    public void onMouseMove(MouseEvent m)
    {
        if (isHeld)
        {
            int posX = m.getX() - lastX;
            int posY = m.getY() - lastY;
            myAce.translate(posX, posY);
            lastX = m.getX();
            lastY = m.getY();
        }
    }

}