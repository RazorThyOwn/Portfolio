import java.util.ArrayList;
public class CardRunner
{ 
    public static void main()
    {
        String[] suits = {"C","D","H","S"};
        String[] vals = {"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
        ArrayList< Card > cards = new ArrayList< Card >();

        for( int v=0; v < vals.length;v++)
        {
            for( int s=0; s < suits.length;s++)
            {

                cards.add(new Card(vals[v]+suits[s]));
            }
        }

        for( int i =0; i< cards.size(); i++)
        {
            System.out.print(cards.get(i)+"     \t");

            if( i%4==3)
                System.out.println();
        }

        System.out.println("\nChecking getRank...");
        boolean allGood = true;

        for( int i = 0; i < vals.length; i++)
        {
            Card c = new Card(vals[i]+"S");
            int rank = c.getRank();

            if( rank != i+2)
            {
                System.out.println(c+" returned a rank of "+rank+" when it should have returned a "+(i+2));
                allGood = false;
            }
        }

        System.out.printf("getRank is %sfunctional",allGood?"":"not ");
    }
}