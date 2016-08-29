import sacco.*;
public class RandomCard
{
    private Picture acePic, backOfCard, SaccoPic;
    private int pX, pY, pWidth, pHeight;
    private boolean isFaceUp;
    private String picSt;

    public RandomCard(int x, int y)
    {
        backOfCard = Picture.loadFromJar("/cards/b1fv.png");
        SaccoPic = Picture.loadFromJar("/Sacco.jpg");
        isFaceUp = false;
        pX = x;
        pY = y;
        pWidth = 110;
        pHeight = 148;
        picSt = "AS";
    }

    public void flipCard(int x, int y)
    {
        if (x>=pX && x<=pX+pWidth && y>pY && y<=pY+pHeight)
        {
            isFaceUp = !isFaceUp;
            int randInt = (int)Math.round(Math.random()*13);
            if (randInt<=1 && randInt>0)
                picSt = "A";
            else if (randInt<=2 && randInt>1)
                picSt = "2";
            else if (randInt<=3 && randInt>2)
                picSt = "3";
            else if (randInt<=4 && randInt>3)
                picSt = "4";
            else if (randInt<=5 && randInt>4)
                picSt = "5";
            else if (randInt<=6 && randInt>5)
                picSt = "6";
            else if (randInt<=7 && randInt>6)
                picSt = "7";
            else if (randInt<=8 && randInt>7)
                picSt = "8";
            else if (randInt<=9 && randInt>8)
                picSt = "9";
            else if (randInt<=10 && randInt>9)
                picSt = "T";
            else if (randInt<=11 && randInt>10)
                picSt = "J";
            else if (randInt<=12 && randInt>11)
                picSt = "Q";
            else
                picSt = "K";

            int randIntTwo = (int)Math.round(Math.random()*4);
            if (randIntTwo<=1 && randIntTwo>0)
                picSt+="S";
            else if (randIntTwo<=2 && randIntTwo>1)
                picSt+="C";
            else if (randIntTwo<=3 && randIntTwo>2)
                picSt+="H";
            else
                picSt+="D";
        }

    }

    public void paintSelf(PaintBrush brush)
    {
        acePic = Picture.loadFromJar("/cards/"+picSt+".png");
        if (isFaceUp)
            brush.drawPicture( acePic, pX, pY, pWidth, pHeight);
        else
            brush.drawPicture( backOfCard, pX, pY, pWidth, pHeight);
    }

    public boolean containsPoint(int x, int y)
    {
        if (x >= pX && x <= pX+pWidth && y >= pY && y <= pY+pHeight)
            return true;
        else
            return false;
    }

    public void redraw()
    {
        isFaceUp = false;
        this.flipCard(pX+1,pY+1);
    }

    public void flipFace(int x, int y)
    {
        if (x>=pX && x<=pX+pWidth && y>pY && y<=pY+pHeight)
            isFaceUp = !isFaceUp;
    }

    public void setDown()
    {
        isFaceUp = false;
    }
}