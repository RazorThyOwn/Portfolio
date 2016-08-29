public class CoinFlipperRunner
{
    public static void main()
    {
       
        CoinFlipper myFlipper = new CoinFlipper();
       
       System.out.println("Flipping 5 times...");
        myFlipper.flipIt(5);
       
        System.out.println("Results: "+myFlipper);
       
        System.out.println("Heads was flipped "+ myFlipper.numHeads()+" times, which is "+myFlipper.headsPercent()+"%");
        System.out.println("Tails was flipped "+ myFlipper.numTails()+" times, which is "+myFlipper.tailsPercent()+"%");
        System.out.println("The longest Heads streak is: "+myFlipper.headsStreak());
        System.out.println("The longest Tails streak is: "+myFlipper.tailsStreak());
       
        System.out.println("\nFlipping 4 more times...");
        myFlipper.flipIt(4);
        System.out.println("Results: "+myFlipper);
       
      
        System.out.println("Heads was flipped "+ myFlipper.numHeads()+" times, which is "+myFlipper.headsPercent()+"%");
        System.out.println("Tails was flipped "+ myFlipper.numTails()+" times, which is "+myFlipper.tailsPercent()+"%");
        System.out.println("The longest Heads streak is: "+myFlipper.headsStreak());
        System.out.println("The longest Tails streak is: "+myFlipper.tailsStreak());
       
 
        System.out.println("\nFlipping 10 more times...");
        myFlipper.flipIt(10);
        System.out.println("Results: "+myFlipper);
       
      
        System.out.println("Heads was flipped "+ myFlipper.numHeads()+" times, which is "+myFlipper.headsPercent()+"%");
        System.out.println("Tails was flipped "+ myFlipper.numTails()+" times, which is "+myFlipper.tailsPercent()+"%");
        System.out.println("The longest Heads streak is: "+myFlipper.headsStreak());
        System.out.println("The longest Tails streak is: "+myFlipper.tailsStreak());
       
        System.out.println("\nThe 6th result was "+myFlipper.resultNumber(6));
    }
 
}