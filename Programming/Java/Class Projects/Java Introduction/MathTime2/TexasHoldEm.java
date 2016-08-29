import sacco.*;
import java.util.List;
import java.util.ArrayList;
public class TexasHoldEm extends SaccoObject
{
    private RandomCard myCardOne, myCardTwo, myCardThree, myCardFour, myCard1, myCard2, myCard3, myCard4, myCard5;
    private Picture feltBackground, table1, table2, playerOne, playerTwo, fold1, fold2, turn1, turn2;
    private Picture chip1, chip5, chip25, chip100, chip500;
    private Button bt1, bt2;
    private ChipClass p1chip1, p1chip5, p1chip25, p1chip100, p1chip500;
    private ChipClass p2chip1, p2chip5, p2chip25, p2chip100, p2chip500;
    private ChipClass potchip1, potchip5, potchip25, potchip100, potchip500;
    private FoldButton fb1, fb2;
    private ResetButton resetpl1, resetpl2;
    private BettingClass betC;
    private TurnButton turnpl1, turnpl2;
    public TexasHoldEm()
    {
        feltBackground = Picture.loadFromJar("/holdem/felt.jpg");
        table1 = Picture.loadFromJar("/holdem/table2.png");
        table2 = Picture.loadFromJar("/holdem/table2.png");
        playerOne = Picture.loadFromJar("/holdem/pl1.png");
        playerTwo = Picture.loadFromJar("/holdem/pl2.png");
        fold1 = Picture.loadFromJar("/holdem/foldpl1.png");
        fold2 = Picture.loadFromJar("/holdem/foldpl2.png");
        turn1 = Picture.loadFromJar("/holdem/turnpl1.png");
        turn2 = Picture.loadFromJar("/holdem/turnpl2.png");
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
        fb1 = new FoldButton(220, 175, 110, 50, fold1);
        fb2 = new FoldButton(220, 855, 110, 50, fold2);
        betC = new BettingClass();
        //turnpl1 = new TurnButton(335, 175, 60, 50, turn1);
        turnpl2 = new TurnButton(335, 855, 60, 50, turn2);
        chip1 = Picture.loadFromJar("/holdem/chip1.png");
        chip5 = Picture.loadFromJar("/holdem/chip5.png");
        chip25 = Picture.loadFromJar("/holdem/chip25.png");
        chip100 = Picture.loadFromJar("/holdem/chip100.png");
        chip500 = Picture.loadFromJar("/holdem/chip500.png");
        // Player one chips
        p1chip1 = new ChipClass(36, 23, 70, 70, chip1);
        p1chip5 = new ChipClass(111, 23, 70, 70, chip5);
        p1chip25 = new ChipClass(186, 23, 70, 70, chip25);
        p1chip100 = new ChipClass(261, 23, 70, 70, chip100);
        p1chip500 = new ChipClass(336, 23, 70, 70, chip500);
        // Player two chips
        p2chip1 = new ChipClass(36, 703, 70, 70, chip1);
        p2chip5 = new ChipClass(111, 703, 70, 70, chip5);
        p2chip25 = new ChipClass(186, 703, 70, 70, chip25);
        p2chip100 = new ChipClass(261, 703, 70, 70, chip100);
        p2chip500 = new ChipClass(336, 703, 70, 70, chip500);
        // Pot chips
        potchip1 = new ChipClass(0, 0, 15, 15, chip1);
        potchip5 = new ChipClass(0, 0, 15, 15, chip5);
        potchip25 = new ChipClass(0, 0, 15, 15, chip25);
        potchip100 = new ChipClass(0, 0, 15, 15, chip100);
        potchip500 = new ChipClass(0, 0, 15, 15, chip500);
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
        turnpl1.paintSelf(brush);
        turnpl2.paintSelf(brush);
        p1chip1.paintSelf(brush);
        p1chip5.paintSelf(brush);
        p1chip25.paintSelf(brush);
        p1chip100.paintSelf(brush);
        p1chip500.paintSelf(brush);
        p2chip1.paintSelf(brush);
        p2chip5.paintSelf(brush);
        p2chip25.paintSelf(brush);
        p2chip100.paintSelf(brush);
        p2chip500.paintSelf(brush);
        potchip1.paintSelf(brush);
        potchip5.paintSelf(brush);
        potchip25.paintSelf(brush);
        potchip100.paintSelf(brush);
        potchip500.paintSelf(brush);
    }

    public static void main()
    {
        TexasHoldEm cR = new TexasHoldEm();
        cR.showWindow();
    }   

    public void onMousePress(MouseEvent m)
    {
        if( fb1.press(m.getX(), m.getY()))
        {
            betC.playerFolds(1);
            System.out.println("Player One: " + betC.getPointsPlayer(1));
            System.out.println("Player Two: " + betC.getPointsPlayer(2));
        }
        if( fb2.press(m.getX(), m.getY()))
        {
            betC.playerFolds(2);
            System.out.println("Player One: " + betC.getPointsPlayer(1));
            System.out.println("Player Two: " + betC.getPointsPlayer(2));
        }
        if( bt1.press(m.getX(), m.getY()))
        {
            myCardOne.redraw();
            myCardTwo.redraw();
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