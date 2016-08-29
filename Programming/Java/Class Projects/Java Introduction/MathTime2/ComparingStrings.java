public class ComparingStrings
{
    /**Returns either String one or two base on which comes
     * first on the ASCII table.
     * @param one The first String to be passed
     * @param two The second String to be passed
     * @return The String that comes first on the ASCII table
     */
    public static String firstASCII( String one, String two )
    {
        if (one.compareTo(two)<0)
            return one;
        else if (one.compareTo(two)>0)
            return two;
        else
            return null;
    }

    /**Returns either String one or two base on which comes
     * last on the ASCII table.
     * @param one The first String to be passed
     * @param two The second String to be passed
     * @return The String that comes last on the ASCII table
     */
    public static String lastASCII( String one, String two)
    {
        if (one.compareTo(two)<0)
            return two;
        else if (one.compareTo(two)>0)
            return one;
        else
            return null;
    }

    /**Returns either String one or two base on which comes
     * first using the alphabet.
     * @param one The first String to be passed
     * @param two The second String to be passed
     * @return The String that comes first using the alphabet.
     */
    public static String firstAlpha( String one, String two )
    {
        String sOne = one.toLowerCase();
        String sTwo = two.toLowerCase();
        if (sOne.compareTo(sTwo)<0)
            return one;
        else if (sOne.compareTo(sTwo)>0)
            return two;
        else
            return null;

    }

    /**Determines if the passed in String is capitalized or not
     * @param str The String to be considered
     * @return true if the String is capitalized
     */
    public static boolean isCapitalized(String str)
    {
        if(str.toLowerCase().compareTo(str) == 0)
            return false;
        else
            return true;
    }

    /**Determines if the passed in String is made of two words
     * in a row.  For example: "HelloHello"
     * Precondition str's length is even
     * @param str The String to be considered
     * @return true if str is a double word.
     */
    public static boolean isADoubleWord(String str)
    {
        int length = str.length();
        if (str.substring(0,(length/2)).compareTo(str.substring(length/2)) == 0)
            return true;
        else 
            return false;
    }

    /**Returns true if the passed in String is a 3 digit number.
     * @param str The String to be considered
     * @return true if the String is 3 characters long and all characters are digits
     */
    public static boolean isAThreeDigitNumber(String str)
    {
        if (str.length() == 3)
        {
            String slash = "/";
            String colon = ":";
            String p1 = str.substring(0,1);
            String p2 = str.substring(1,2);
            String p3 = str.substring(2,3);
            if (p1.compareTo(slash) > 0 && p2.compareTo(slash) > 0 && p3.compareTo(slash) > 0 && p1.compareTo(colon) < 0 && p2.compareTo(colon) < 0 && p3.compareTo(colon) < 0)
                return true;
            else
                return false;
        }
        else return false;
    }

}