import sacco.*;
public class CardHolder extends SaccoObject
{
    private Ace myAce;

    public CardHolder()
    {
        myAce = new Ace();
    }

    public void paintWindow(PaintBrush brush)
    {
        myAce.paintSelf(brush);
    }

    public static void main()
    {
        CardHolder ch = new CardHolder();
        ch.showWindow();
    }   

    public void onMousePress(MouseEvent m)
    {
        if (myAce.containsPoint(m.getX(),m.getY()))
        {
            myAce.flipCard();
        }
    }
}