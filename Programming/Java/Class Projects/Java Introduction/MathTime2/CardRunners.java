import sacco.*;
public class CardRunners
{
    public static void manyCards()
    {
        SCard[] cards = new SCard[50];
        for( int i =0; i < cards.length; i++)
        {
            cards[i] = new SCard();
        }
        Sorter.selectionSort(cards);
        printCards(cards);
    }

    public static void printCards(SCard[] theCards)
    {
        System.out.print("["+theCards[0]);
        for( int i = 1; i < theCards.length; i++)
        {
            System.out.print(", "+theCards[i]);
        }
        System.out.println("]");
    }

    public static SCard[] deckOfCards()
    {
        String[] vals = {"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
        String[] suits = {"D","C","H","S"};
        SCard[] deckArr = new SCard[52];
        for (int i = 0;i<4;i++)
        {
            int count = i*13;
            for (int a = 0;a<13;a++)
            {
                deckArr[a+count]=new SCard(vals[a],suits[i]);
            }
        }
        return deckArr;
    }

    public static void deckTest()
    {
        SCard[] deck = deckOfCards();
        printCards(deck);
    }

    public static void cardView()
    {
        SCard[] deck = CardRunners.deckOfCards();
        CardViewer view = new CardViewer(deck);
        view.setVisible(true);
    }
}