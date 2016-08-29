public class BettingClass
{
    private int p1Points, p2Points;
    private int p1chip100, p1chip50, p1chip10, p1chip5, p1chip1;
    private int p2chip100, p2chip50, p2chip10, p2chip5, p2chip1;
    public BettingClass()
    {
        p1chip100 = 1;
        p1chip50 = 5;
        p1chip10 = 10;
        p1chip5 = 25;
        p1chip1 = 1;

        p2chip100 = 1;
        p2chip50 = 5;
        p2chip10 = 10;
        p2chip5 = 25;
        p2chip1 = 1;
    }

    public int getPointsOne(int player)
    {
        if (player==1)
            return ((p1chip100*100)+(p1chip50*50)+(p1chip10*10)+(p1chip5*5)+(p1chip1));
        else if (player==2)
            return ((p2chip100*100)+(p2chip50*50)+(p2chip10*10)+(p2chip5*5)+(p2chip1));
        else
            return -1;
    }
}