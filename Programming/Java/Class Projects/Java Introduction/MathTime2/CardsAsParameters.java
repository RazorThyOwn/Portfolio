public class CardsAsParameters
{

    //sample method, determines if the parameter card is an Ace or not
    public static boolean isAnAce(Card someCard)
    {
        //extract the information you need using methods
        String cardVal = someCard.getValue();

        if( cardVal.equals("Ace") )
            return true;
        else
            return false;

    }

    //returns a true if the parameter is a face card (Jack, Queen, or King), false otherwise
    public static boolean isAFaceCard(Card someCard)
    {
        int cardVal = someCard.getRank();
        return cardVal >= 11;
    }

    //returns a true if the two parameter cards have the same suit
    public static boolean matchingSuits(Card firstCard, Card secondCard)
    {
        return (firstCard.getSuit().equals(secondCard.getSuit()));
    }

    //returns a true if the parameter Card is a Red card
    public static boolean isRed(Card someCard)
    {
        return (someCard.getSuit().equals("Hearts") || someCard.getSuit().equals("Diamonds"));
    }

    //This method tests the isAFaceCard method.  Make sure the outputs make sense
    public static void faceRunner()
    {
        Card a = new Card("6C");
        Card b = new Card("KD");
        Card c = new Card("QH");
        Card d = new Card("2C");

        System.out.println( a +" is "+(isAFaceCard(a)? "":"not ")+"a face card");
        System.out.println( b +" is "+(isAFaceCard(b)? "":"not ")+"a face card");
        System.out.println( c +" is "+(isAFaceCard(c)? "":"not ")+"a face card");
        System.out.println( d +" is "+(isAFaceCard(d)? "":"not ")+"a face card");
    }

    //This method tests the matchingSuits method.  Make sure the outputs make sense
    public static void suitRunner()
    {
        Card a = new Card("4H");
        Card b = new Card("AS");
        Card c = new Card("TH");

        System.out.println( a +" and "+b+(matchingSuits(a,b)?" have ":" don't have ")+"matching suits");
        System.out.println( a +" and "+c+(matchingSuits(a,c)?" have ":" don't have ")+"matching suits");
        System.out.println( b +" and "+c+(matchingSuits(a,b)?" have ":" don't have ")+"matching suits");

    }

    //This method tests the isRed method.  Make sure the outputs make sense
    public static void isRedRunner()
    {
        Card a = new Card("4H");
        Card b = new Card("AS");
        Card c = new Card("TD");
        Card d = new Card("8C");

        System.out.println( a +(isRed(a)?" is ":" is not ")+"a red card");
        System.out.println( b +(isRed(b)?" is ":" is not ")+"a red card");
        System.out.println( c +(isRed(c)?" is ":" is not ")+"a red card");
        System.out.println( d +(isRed(d)?" is ":" is not ")+"a red card");

    }
}
