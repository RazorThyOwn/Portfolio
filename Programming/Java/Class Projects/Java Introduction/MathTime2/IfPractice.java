public class IfPractice
{

    public static boolean passwordChecker(int num)
    {
        if (num==1337)
            return true;
        else 
            return false;
    }

    public static int compareTo5(int num)
    {
        if (num < 5)
            return 1;
        else if (num > 5)
            return -1;
        else return 0;

    }

    public static boolean speedingTicket(int speed, boolean isRed)
    {
        if (speed>65)
            return true;
        else if (speed>60 && isRed)
            return true;
        else return false;
    }

    public static boolean in1To10(int num, boolean insideMode)
    {
        if (insideMode)
        {
            if (num >= 1 && num <= 10)
                return true;
            else
                return false;
        }

        else
        {
            if (num >10 || num <1)
                return true;
            else
                return false;
        }
    }

    public static int threeIntMax(int a, int b, int c)
    {
        if (a>=b) {
            if (a>=c)
                return a;
            else
                return c;
        }
        else
        {
            if (b>=c)
                return b;
            else
                return c;
        }
    }

    public static int loneSum(int a, int b, int c)
    {
        if (a==c)
        {
            return b;
        }
        if (a!=b)
        {
            int num = 0;
            num +=a;
            if (b!=c && a!=c)
            {
                num+=b;
                num+=c;
                return num;
            }
            else return num;
        }
        else if (a!=c)
        {
            if (a!=b)
            {
                int num = 0;
                num +=a;
                num +=c;
                return num;
            }
            else
                return c;
        }
        else
            return 0;
    }

}