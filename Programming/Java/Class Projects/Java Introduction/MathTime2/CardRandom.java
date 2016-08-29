import sacco.*;
import java.util.List;
import java.util.ArrayList;
public class CardRandom extends SaccoObject
{
    private RandomCard myCard1, myCard2, myCard3, myCard4, myCard5;
    private RandomCard myCard6, myCard7, myCard8, myCard9, myCard10;
    private Picture feltBackground, table1, table2, playerOne, playerTwo;
    private Button bt1, bt2;
    private ResetButton resetpl1, resetpl2;
    public CardRandom()
    {
        feltBackground = Picture.loadFromJar("/holdem/felt.jpg");
        table1 = Picture.loadFromJar("/holdem/table2.png");
        table2 = Picture.loadFromJar("/holdem/table2.png");
        playerOne = Picture.loadFromJar("/holdem/pl1.png");
        playerTwo = Picture.loadFromJar("/holdem/pl2.png");
        bt1 = new Button(535, 175, 110, 50, Picture.loadFromJar("/holdem/drawpl1.png"));
        bt2 = new Button(535, 855, 110, 50, Picture.loadFromJar("/holdem/drawpl2.png"));
        resetpl1 = new ResetButton(400, 175, 125, 50, Picture.loadFromJar("/holdem/resetpl1.png"));
        resetpl2 = new ResetButton(400, 855, 125, 50, Picture.loadFromJar("/holdem/resetpl2.png"));
        myCard1 = new RandomCard(35, 20);
        myCard2 = new RandomCard(160, 20);
        myCard3 = new RandomCard(285, 20);
        myCard4 = new RandomCard(410, 20);
        myCard5 = new RandomCard(535, 20);
        myCard6 = new RandomCard(35, 700);
        myCard7 = new RandomCard(160, 700);
        myCard8 = new RandomCard(285, 700);
        myCard9 = new RandomCard(410, 700);
        myCard10 = new RandomCard(535, 700);
    }

    public void paintWindow(PaintBrush brush)
    {
        brush.drawPicture( feltBackground, 0, -30, 700, 1000);
        brush.drawPicture( table1, 0, 0, 677, 250 );
        brush.drawPicture( table2, 0, 680, 675, 250 );
        brush.drawPicture( playerOne, 35, 175, 175, 50 );
        brush.drawPicture( playerTwo, 35, 855, 175, 50 );
        bt1.paintSelf(brush);
        bt2.paintSelf(brush);
        resetpl1.paintSelf(brush);
        resetpl2.paintSelf(brush);
        myCard1.paintSelf(brush);
        myCard2.paintSelf(brush);
        myCard3.paintSelf(brush);
        myCard4.paintSelf(brush);
        myCard5.paintSelf(brush);
        myCard6.paintSelf(brush);
        myCard7.paintSelf(brush);
        myCard8.paintSelf(brush);
        myCard9.paintSelf(brush);
        myCard10.paintSelf(brush);
    }

    public static void main()
    {
        CardRandom cR = new CardRandom();
        cR.showWindow();
    }   

    public void onMousePress(MouseEvent m)
    {
        if( bt1.press(m.getX(), m.getY()))
        {
            myCard1.redraw();
            myCard2.redraw();
            myCard3.redraw();
            myCard4.redraw();
            myCard5.redraw();
        }
        if (bt2.press(m.getX(), m.getY()))
        {
            myCard6.redraw();
            myCard7.redraw();
            myCard8.redraw();
            myCard9.redraw();
            myCard10.redraw();
        }
        if (resetpl1.press(m.getX(), m.getY()))
        {
            myCard1.setDown();
            myCard2.setDown();
            myCard3.setDown();
            myCard4.setDown();
            myCard5.setDown();
        }
        if (resetpl2.press(m.getX(), m.getY()))
        {
            myCard6.setDown();
            myCard7.setDown();
            myCard8.setDown();
            myCard9.setDown();
            myCard10.setDown();
        }
        
        myCard1.flipCard(m.getX(), m.getY());
        myCard2.flipCard(m.getX(), m.getY());
        myCard3.flipCard(m.getX(), m.getY());
        myCard4.flipCard(m.getX(), m.getY());
        myCard5.flipCard(m.getX(), m.getY());
        myCard6.flipCard(m.getX(), m.getY());
        myCard7.flipCard(m.getX(), m.getY());
        myCard8.flipCard(m.getX(), m.getY());
        myCard9.flipCard(m.getX(), m.getY());
        myCard10.flipCard(m.getX(), m.getY());
    }

}