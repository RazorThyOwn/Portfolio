import sacco.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class TexasHold extends SaccoObject
{
    private RandomCard myCardOne, myCardTwo, myCardThree, myCardFour, myCard1, myCard2, myCard3, myCard4, myCard5;
    private Picture feltBackground, table1, table2, playerOne, playerTwo;
    private Button bt1, bt2;
    private FoldButton fb1, fb2;
    private ResetButton resetpl1, resetpl2;
    public TexasHold()
    {
        System.out.println("TexasHoldem Initialized");
        feltBackground = Picture.loadFromJar("/holdem/felt.jpg");
        table1 = Picture.loadFromJar("/holdem/table2.png");
        table2 = Picture.loadFromJar("/holdem/table2.png");
        playerOne = Picture.loadFromJar("/holdem/pl1.png");
        playerTwo = Picture.loadFromJar("/holdem/pl2.png");
        bt1 = new Button(535, 175, 110, 50, Picture.loadFromJar("/holdem/drawpl1.png"));
        bt2 = new Button(535, 855, 110, 50, Picture.loadFromJar("/holdem/drawpl2.png"));
        resetpl1 = new ResetButton(400, 175, 125, 50, Picture.loadFromJar("/holdem/resetpl1.png"));
        resetpl2 = new ResetButton(400, 855, 125, 50, Picture.loadFromJar("/holdem/resetpl2.png"));
        myCard1 = new RandomCard(35, 400);
        myCard2 = new RandomCard(160, 400);
        myCard3 = new RandomCard(285, 400);
        myCard4 = new RandomCard(410, 400);
        myCard5 = new RandomCard(535, 400);
        myCardOne = new RandomCard(535, 20);
        myCardTwo = new RandomCard(410, 20);
        myCardThree = new RandomCard(535, 700);
        myCardFour = new RandomCard(410, 700);
        fb1 = new FoldButton(225, 175, 155, 50, playerOne);
        fb2 = new FoldButton(225, 855, 155, 50, playerTwo);
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
        myCardOne.paintSelf(brush);
        myCardTwo.paintSelf(brush);
        myCardThree.paintSelf(brush);
        myCardFour.paintSelf(brush);
        fb1.paintSelf(brush);
        fb2.paintSelf(brush);
    }

    public static void main()
    {
        TexasHold cR = new TexasHold();
        cR.showWindow();
    }   

    public void onMousePress(MouseEvent m)
    {
        if( fb1.press(m.getX(), m.getY()))
        {
        }
        if( fb2.press(m.getX(), m.getY()))
        {
        }
        if( bt1.press(m.getX(), m.getY()))
        {
            System.out.println("Are you sure?");
            Scanner scan = new Scanner(System.in);
            if (scan.equals("yes"))
            {
                myCardOne.redraw();
                myCardTwo.redraw();
            }
        }
        if (bt2.press(m.getX(), m.getY()))
        {
            myCardThree.redraw();
            myCardFour.redraw();
        }
        if (resetpl1.press(m.getX(), m.getY()))
        {
            myCardOne.setDown();
            myCardTwo.setDown();
        }
        if (resetpl2.press(m.getX(), m.getY()))
        {

            myCardThree.setDown();
            myCardFour.setDown();
        }

        myCardOne.flipFace(m.getX(), m.getY());
        myCardTwo.flipFace(m.getX(), m.getY());
        myCardThree.flipFace(m.getX(), m.getY());
        myCardFour.flipFace(m.getX(), m.getY());
        myCard1.flipCard(m.getX(), m.getY());
        myCard2.flipCard(m.getX(), m.getY());
        myCard3.flipCard(m.getX(), m.getY());
        myCard4.flipCard(m.getX(), m.getY());
        myCard5.flipCard(m.getX(), m.getY());
    }

}