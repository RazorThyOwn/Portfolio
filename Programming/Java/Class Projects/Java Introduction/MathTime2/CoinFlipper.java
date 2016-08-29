public class CoinFlipper
{
    private String flipTracker;

    /**
     * Default constructor, sets flipTracker to the empty String ""
     */
    public CoinFlipper()
    {
        flipTracker = "";
    }

    /**
     * Simulates flipping numFlips times, storing all results to the end of the instance field String
     */
    public void flipIt(int numFlips)
    {
        for (int i = 0; i < numFlips; i++)
        {
            int randomNumber = (int)(Math.random()*2);            
            if (randomNumber==1)
                flipTracker+="H";
            else if (randomNumber==0)
                flipTracker+="T";
        }
    }

    /**
     * returns an "H" or "T" based on the num.  ex:  resultNumber(2) will return the result of the second flip  
     */
    public String resultNumber(int num)
    {
        return flipTracker.substring(num-1,num);
    }

    /**
     * returns the number of Heads so far
     */
    public int numHeads()
    {
        int output = 0;
        for (int i = 0; i < flipTracker.length(); i++)
        {
            if (flipTracker.substring(i,i+1).equals("H"))
            {
                output++;
            }
        }
        return output;
    }

    /**
     * returns the number of Tails so far
     */
    public int numTails()
    {
        int output = 0;
        for (int i = 0; i < flipTracker.length(); i++)
        {
            if (flipTracker.substring(i,i+1).equals("T"))
            {
                output++;
            }
        }
        return output;
    }

    /**
     * returns the total number of flips
     */
    public int timesFlipped()
    {
        return flipTracker.length();
    }

    /**
     * returns the percent of the flips that are Heads (out of 100)
     */
    public double headsPercent()
    {
        return (this.numHeads()/(double)flipTracker.length())*100.0;
    }

    /**
     * returns the percent of the flips that are Tails (out of 100)
     */
    public double tailsPercent()
    {
        return (this.numTails()/(double)flipTracker.length())*100.0;
    }

    /**
     * returns the largest "streak" of heads.  ex: HTHHHTTHT has a headsStreak of 3.  
     * Make sure that this method works when the longest streak is at the end of the String ("THHH")
     * Hint:  Have an int that counts the 'current streak' of heads.  When you come across a tails or the end of the String then the 
     * streak is over and you should check if it's longer than any other streak you've come across so far.
     */
    public int headsStreak()
    {
        int headStreak = 0;
        for (int i = 0;i<flipTracker.length();i++)
        {
            int currentStreak = 0;
            String substring = flipTracker.substring(i,i+1);  
            boolean cont = true;
            if (substring.equals("H"))
            {
                int a = 0;
                currentStreak++;
                while (cont)
                {
                    a++;
                    if (a+i>=flipTracker.length())
                    {
                        cont = false;
                    }
                    if (cont && flipTracker.substring(i+a,i+a+1).equals("H"))
                    {
                        currentStreak++;
                    }
                    else if (cont && !(flipTracker.substring(i+a,i+a+1).equals("H")))
                    {
                        cont = false;
                    }
                }
            }
            if (currentStreak>headStreak)
            {
                headStreak=currentStreak;
            }            
        }
        return headStreak;
    }

    /**
     * returns the largest "streak" of tails.
     */
    public int tailsStreak()
    {
        int headStreak = 0;
        for (int i = 0;i<flipTracker.length();i++)
        {
            int currentStreak = 0;
            String substring = flipTracker.substring(i,i+1);  
            boolean cont = true;
            if (substring.equals("T"))
            {
                int a = 0;
                currentStreak++;
                while (cont)
                {
                    a++;
                    if (a+i>=flipTracker.length())
                    {
                        cont = false;
                    }
                    if (cont && flipTracker.substring(i+a,i+a+1).equals("T"))
                    {
                        currentStreak++;
                    }
                    else if (cont && !(flipTracker.substring(i+a,i+a+1).equals("T")))
                    {
                        cont = false;
                    }
                }
            }
            if (currentStreak>headStreak)
            {
                headStreak=currentStreak;
            }            
        }
        return headStreak;
    }

    /**
     * returns the record of flips
     */
    public String toString()
    {
        return flipTracker;
    }

}