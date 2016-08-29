import sacco.*;
public class SCard extends Card implements Comparable<SCard>
{
    private Picture cardPic;
    private int x, y, width, height;
    public SCard(String rank, String suit)
    {
        super(rank, suit);
        width = 72;
        height = 96;
        x = 0;
        y = 0;
        cardPic = Picture.loadFromJar("cards/"+rank+suit+".png");
    }

    public SCard()
    {
        super();
        cardPic = Picture.loadFromJar("cards/"+this.getRank()+this.getSuit()+".png");
    }

    public int compareTo(SCard other)
    {
        if (this.getRank()<other.getRank())
            return -1;
        else if (this.getRank()==other.getRank())
            if (this.getSuitRank()>other.getSuitRank())
                return 1;
            else if (this.getSuitRank()<other.getSuitRank())
                return -1;
            else
                return 0;
            else if (this.getRank()>other.getRank())
                return 1;
            else
                return -1;
    }

    public int getSuitRank()
    {
        if (this.getSuit().equals("Clubs"))
            return 0;
        else if (this.getSuit().equals("Diamonds"))
            return 1;
        else if (this.getSuit().equals("Hearts"))
            return 2;
        else if (this.getSuit().equals("Sppades"))
            return 3;
        else
            return -1;
    }
    
    public Picture getPic()
    {
        return cardPic;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }
    
    public void paintSelf(PaintBrush brush)
    {
         brush.drawPicture(cardPic, x, y, width, height);
    }
}