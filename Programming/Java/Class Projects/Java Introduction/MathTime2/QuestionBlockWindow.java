import sacco.*;

public class QuestionBlockWindow extends SaccoObject
{
    private QuestionBlock myBlock1, myBlock2, myBlock3;
    private StandingMario myMario;
    public static final int RED_BLOCK = 2475;
    public static final int YELLOW_BLOCK = 9999;
    //

    public QuestionBlockWindow()
    {
        myBlock1 = new QuestionBlock();
        myBlock2 = new QuestionBlock(RED_BLOCK);
        myBlock3 = new QuestionBlock();
        myBlock1.setX(240);
        myBlock1.setY(192);
        myBlock1.setScale(3);
        myBlock2.setX(288);
        myBlock2.setY(192);
        myBlock2.setScale(3);
        myBlock3.setX(336);
        myBlock3.setY(192);
        myBlock3.setScale(3);
        
        StandingMario newMario = new StandingMario(144, 240, 3);
        myMario = newMario;
    }

    public void onTimerTick()
    {
        myBlock1.update();
        myBlock2.update();
        myBlock3.update();
    }
    
    public static void main()
    {
        QuestionBlockWindow myWindow = new QuestionBlockWindow();
        myWindow.showWindow();
        myWindow.setDelay(300);
        myWindow.start();
    }
    
    public void paintWindow(PaintBrush brush)
    {
        //draw sky
        brush.setColor("blue");
        brush.fillRectangle(0,0,500,500);

        //draw grass
        brush.setColor("green");
        brush.fillRectangle(0,336,500,200);

        //draw border line
        brush.setColor("black");
        brush.setThickness(3);
        brush.drawLine(0,336,500,336);

        //draw cloud
        brush.setColor("white");
        brush.fillOval(288,48,144,48);

        brush.setColor("black");
        brush.drawOval(288,48,144,48);
        
        myBlock1.paintSelf(brush);
        myBlock2.paintSelf(brush);
        myBlock3.paintSelf(brush);
        myMario.paintSelf(brush);
    }
}
