public class TraversingStrings
{

    public static boolean isACap(String input)
    {
        // Input is single letter
        if (input.compareTo("a")<0)
            return true;
        else
            return false;
    }

    public static boolean isAllInts(String input)
    {
        boolean output = false;
        for (int i = 0;i<input.length();i++)
        {
            String substring = input.substring(i,i+1);
            if (substring.compareTo("9")<=0)
                output = true;
            else
                return false;
        }
        return output;
    }

    public static boolean containsACapital(String input)
    {
        boolean output = false;
        for (int i = 0;i<input.length();i++)
        {
            String substring = input.substring(i,i+1);
            if (substring.compareTo("A")>=0 && substring.compareTo("Z")<=0)
                return true;
        }
        return output;
    }

    public static boolean isAllSameCharacter(String input)
    {
        for (int i = 0;i<input.length();i++)
        {
            String substring = input.substring(i,i+1);
            if (!(substring.compareTo(input.substring(0,1))==0))
            {
                return false;
            }
        }
        return true;
    }

    public static int largestInteger(String input)
    {
        String primaryLargest = input.substring(0,1);
        for (int i = 0;i<input.length();i++)
        {
            String substring = input.substring(i,i+1);
            if (substring.compareTo(primaryLargest)>0)
                primaryLargest = substring;
        }
        return Integer.parseInt(primaryLargest);
    }

    public static int indexOfLargestInteger(String input)
    {
        String primaryLargest = input.substring(0,1);
        for (int i = 0;i<input.length();i++)
        {
            String substring = input.substring(i,i+1);
            if (substring.compareTo(primaryLargest)>0)
                primaryLargest = substring;
        }
        return input.indexOf(primaryLargest);
    }

    public static double getGPA(String input)
    {
        int TotalGPA = 0;
        for (int i = 0;i<input.length();i++)
        {
            String substring = input.substring(i,i+1);
            if (substring.compareTo("A")==0 )
                TotalGPA+=4;
            if (substring.compareTo("B")==0 )
                TotalGPA+=3;
            if (substring.compareTo("C")==0 )
                TotalGPA+=2;
            if (substring.compareTo("D")==0 )
                TotalGPA+=1;
        }       
        return TotalGPA/6.0;
    }

    public static String justTheCaps(String input)
    {
        String output = "";
        for (int i = 0;i<input.length();i++)
        {
            String substring = input.substring(i,i+1);
            if (substring.compareTo("A") >= 0 && substring.compareTo("Z") <= 0)
            {
                output += substring;
            }
        }
        return output;
    }

    public static int catCount(String input)
    {
        int output = 0;
        for (int i = 0;i<input.length()-2;i++)
        {
            if (input.substring(i,i+1).compareTo("c")==0 && input.substring(i+1,i+2).compareTo("a")==0 && input.substring(i+2,i+3).compareTo("t")==0)
            {
                output++;
            }                              
        }
        return output;
    }

    public static int countPeaks(String input)
    {
        int output = 0;
        for (int i = 0;i<input.length()-2;i++)
        {
            if (input.substring(i,i+1).compareTo("a")>=0 && input.substring(i+1,i+2).compareTo("a")<0 && input.substring(i+2,i+3).compareTo("a")>=0)
            {
                output++;
            }                              
        }
        return output;
    }
}