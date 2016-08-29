import sacco.*;
public class FlipCard extends SCard
{
    private boolean isFaceUp;
    private Picture backOfCard;

    public FlipCard(String rank, String suit)
    {
        super(rank,suit);
        isFaceUp = false;
        backOfCard = Picture.loadFromJar("cards/b1fv.png");
    }

    public FlipCard()
    {
        super();
        isFaceUp = false;
        backOfCard = Picture.loadFromJar("cards/b1fv.png");
    }

    public void flip()
    {
        isFaceUp = !isFaceUp;
    }

    public boolean containsPoint(int tmpX, int tmpY)
    {
        return tmpX >= this.getX() && tmpX<= this.getX()+ this.getWidth() && tmpY>= this.getY() && tmpY <= this.getY()+this.getHeight();
    }

    public void paintSelf(PaintBrush brush)
    {
        if (isFaceUp)
        brush.drawPicture(this.getPic(), this.getX(), this.getY(), this.getWidth(), this.getHeight());
        else
        brush.drawPicture(backOfCard, this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
}