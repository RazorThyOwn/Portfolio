import sacco.*;
import java.util.ArrayList;
import java.awt.geom.*;
import java.awt.*;
public class CardDisplay extends SaccoObject
{
    private ArrayList< Card > cardList = new ArrayList< Card >();
    private double a,aV=2;
    private final int CARD_WIDTH = 71, CARD_HEIGHT=96;

    public CardDisplay()
    {
        String[] suits = {"C","D","S","H"};
        String[] vals = {"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
        for(String s: suits)
            for(String v: vals)
            {
                cardList.add(new Card(v+s));
        }

        circle(a);
    }

    public void circle(double startAngle)
    {
        int centerX = this.getWidth()/2 - CARD_WIDTH/2; //offset for default Card width
        int centerY = this.getHeight()/2 - CARD_HEIGHT/2;  //offset for default Card height
        int radius = Math.max(85,centerY-20);

        double dAngle = (double)360/cardList.size();
        for( int i = 0; i < cardList.size(); i++)
        {
            double angle = i*dAngle+startAngle;
            int x =(int)Math.round(centerX +radius*Math.cos(Math.toRadians(angle)));
            int y = (int)Math.round(centerY -radius*Math.sin(Math.toRadians(angle)));

            cardList.get(i).setXY(x,y);
        }

    }

    public Shape getClip()
    {
        GeneralPath sub = new GeneralPath();

        for(int i =0; i< cardList.size()/6; i++)
        {
            Card c = cardList.get(i);
            sub.append(new Rectangle(c.getX(),c.getY(),CARD_WIDTH,CARD_HEIGHT),false);
        }

        Area toRet = new Area(new Rectangle(0,0,getWidth(),getHeight()));
        toRet.subtract(new Area(sub));
        return toRet;
    }


    public void paintWindow(PaintBrush brush)
    {
        Shape clip =getClip();
        for( int i = 0; i < cardList.size(); i++)
        {
            if( i >cardList.size()/2)
                brush.setClip(clip);

            cardList.get(i).paintSelf(brush);

        }
        brush.setClip(null);
    }


    public void onTimerTick()
    {
        circle( a+=aV);
    }

    public static void main()
    {
        CardDisplay c= new CardDisplay();
        c.showWindow();
    }
}