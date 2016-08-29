public class ScrewingAround
{
    public static void barrelCalc(int logs, int wood)
    {
        int cTotal = logs/7; // Max amount of chests you can make considering only logs
        int loLogs = logs - (cTotal*7);  // Left over logs, aka division of 7 remainder
        int totalWood = wood+(4*loLogs); // Initial wood plus left over log wood

        if (cTotal > (totalWood/8))
        {
            System.out.println("Too many logs, crafting down...");
        }
        if (cTotal < (totalWood/8))
        {
            System.out.println("Not enough logs, get more!");
        }
        if (cTotal == (totalWood/8))
        {
            System.out.println("Perfect log to wood ratio!");
        }      
    }

    public static void woodNeeded(int barrels)
    {
        double logs = barrels*7;
        double wood = barrels*8;
        double slabs = barrels;
        double totalWood = logs+(wood/4)+( 1+(barrels/6) );
        System.out.println("Keep "+logs+" as logs");
        System.out.println("Craft "+wood/4+" logs into wood for chests, make "+barrels+" chest(s)");
        System.out.println("Craft "+ (int)(1+(slabs/6)) +".0 logs into wood for slabs, make "+barrels+" slabs");
        System.out.print("You need "+totalWood+" logs | ");
        for (int i = 64; i <=totalWood;i+=64)
        {
            System.out.print(" 64 +");
        }
        int divAmount = (int)totalWood/64;
        int woodRemainder = (int)totalWood - (divAmount*64);
        System.out.println(" "+woodRemainder);
    }
}