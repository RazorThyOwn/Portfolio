public class RankedCardRunner
{
    public static void main()
    {
        String[] suits = {"C","D","H","S"};
        String[] vals = {"A","2","3","4","5","6","7","8","9","T","J","Q","K"};
        
        for( int i =0; i < 15 ;i++)
        {
            String randVal1 = vals[(int)(Math.random()*vals.length)];
            String randSuit1 = suits[(int)(Math.random()*suits.length)];
            
            String randVal2 = vals[(int)(Math.random()*vals.length)];
            String randSuit2 = suits[(int)(Math.random()*suits.length)];
            
            Card c1 = new Card(randVal1+randSuit1);
            Card c2 = new Card(randVal2+randSuit2);
        
            System.out.println(c1+ " is " +(c1.isHigherRank(c2)?"":"not ")+ "a higher rank than "+c2);
            System.out.println(c1+ " is " +(c1.isLowerRank(c2)?"":"not ")+"a lower rank than "+c2);
            System.out.println(c1+ " is " +(c1.isEqualRank(c2)?"":"not ")+"the same rank as "+c2+"\n");

        }
    }
}