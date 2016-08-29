import sacco.*;
public class CardViewer extends SaccoObject
{
    private SCard[] cards;

    public CardViewer(SCard[] cards)
    {
        this.cards = cards;
        this.setSize(800,140);
        this.spaceCards();
    }

    public void paintWindow(PaintBrush brush)
    {
        brush.setColor(4,180,4);
        brush.fillRectangle(-50,-50,900,240);

        for( int i = 0; i<cards.length; i++)
        {
            cards[i].paintSelf(brush);
        }
    }

    public void spaceCards()
    {
        for (int i = 0;i<cards.length;i++)
        {
            cards[i].setX(10+(14*i));
            cards[i].setY(15);
        }
    }

    public void onMousePress(MouseEvent m)
    {
        Sorter.selectionSort(cards);
        this.spaceCards();
    }

    public SCard[] getCards()
    {
        return cards;
    }
}