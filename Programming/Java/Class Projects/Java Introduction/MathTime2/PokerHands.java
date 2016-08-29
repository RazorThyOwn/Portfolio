import sacco.*;
public class PokerHands implements HandChecker
{
    public boolean isFlush(sacco.Card[] cards)
    {
        String suitVal = cards[0].getSuit();
        for (int i = 0;i<cards.length;i++)
        {
            if (cards[i].getSuit()!=suitVal)
            {
                return false;
            }
        }
        return true;
    }

    public boolean isPair(sacco.Card[] cards)
    {
        int isPair = 0;
        for (int i = 0;i<cards.length;i++)
        {
            for (int a = i;a<cards.length;a++)
            {
                if (cards[i].getRank()==cards[a].getRank())
                {
                    isPair++;
                }
            }
        }
        if (isPair>5)
        {
            return true;
        }
        else
            return false;
    }

    public boolean isThreeOfAKind(sacco.Card[] cards)
    {
        int isThree = 0;
        for (int i = 0;i<cards.length;i++)
        {
            for (int a = i;a<cards.length;a++)
            {
                if (cards[i].getRank()==cards[a].getRank())
                {
                    isThree++;
                }
            }
        }
        if (isThree>7)
        {
            return true;
        }
        else
            return false;
    }

    public boolean isTwoPair(sacco.Card[] cards)
    {
        int thisRank = 0;
        boolean isPairBooleanOne = false;
        boolean isPairBooleanTwo = false;
        for (int i = 0;i<cards.length;i++)
        {
            for (int a = i;a<cards.length;a++)
            {
                if (cards[i].getRank()==cards[a].getRank() && i!=a)
                {
                    isPairBooleanOne = true;
                    thisRank = cards[i].getRank();
                }
            }
        }
        for (int i = 0;i<cards.length;i++)
        {
            for (int a = i;a<cards.length;a++)
            {
                if (cards[i].getRank()==cards[a].getRank() && i!=a && thisRank!=cards[i].getRank())
                {
                    isPairBooleanTwo = true;
                }
            }
        }
        if (isPairBooleanOne && isPairBooleanTwo)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean isStraight(sacco.Card[] cards)
    {
        boolean firstPart = false;
        boolean secondPart = false;
        boolean thirdPart = false;
        boolean fourthPart = false;
        int topNumber= 0;
        for (int i = 0;i<cards.length;i++)
        {
            if (cards[i].getRank()>topNumber)
            {
                topNumber = cards[i].getRank();
            }
        }
        for (int i = 0;i<cards.length;i++)
        {
            if(topNumber - cards[i].getRank() == 1)
            {
                firstPart = true;
            }
            if(topNumber - cards[i].getRank() == 2)
            {
                secondPart = true;
            }
            if(topNumber - cards[i].getRank() == 3)
            {
                thirdPart = true;
            }
            if(topNumber - cards[i].getRank() == 4)
            {
                fourthPart = true;
            }
        }
        if(firstPart && secondPart && thirdPart && fourthPart)
            return true;
        else
            return false;
    }

    public static void main()
    {
        HandCheckerRunner.main(new PokerHands());
    }
}