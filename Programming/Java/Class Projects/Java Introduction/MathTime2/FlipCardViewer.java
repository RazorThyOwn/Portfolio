
import sacco.*;
public class FlipCardViewer extends CardViewer
{

    public FlipCardViewer(FlipCard[] cards)
    {
        super(cards);
        this.setSize(800,140);
    }

    @Override
    public void onMousePress(MouseEvent m)
    {
        //access the SCard array for looping purposes
        SCard[] cards = this.getCards();

        for( int i = 0; i<cards.length; i++)
        {
            //Cast each SCard into a FlipCard
            //We can do this because we already know that they're FlipCards deep down
            FlipCard card = (FlipCard)cards[i];

            //Flip the card if it contains the point
            if(card.containsPoint(m.getX(), m.getY() ) )
                card.flip();
        }

    }

    @Override
    public void spaceCards()
    {
        SCard[] cards = this.getCards();
        //set the spacing of all the cards
        for( int i =0; i < cards.length; i++)
        {
            FlipCard card = (FlipCard)cards[i];
            card.setY(21);
            card.setX(i*86+18);
            card.flip();
        }
    }

    public static void main()
    {
        //Construct an array of "Two of Diamonds"
        FlipCard[] cards = new FlipCard[9];
        for( int i =0; i < cards.length; i++)
            cards[i] = new FlipCard("2","D");

        //put an "Ace of Spades" at a random location in the array
        int randInd = (int)(Math.random()*cards.length);
        FlipCard ace =  new FlipCard("A","S");
        cards[randInd] = ace;

        //Construct and launch the FlipCardViewer with the given cards
        FlipCardViewer view = new FlipCardViewer(cards);
        view.setVisible(true);
    }
}