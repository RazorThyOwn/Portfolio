import java.util.Scanner;
public class RandNum
{
    public static int stdSum;
    public static void main()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of trials");
        int numTrials = Integer.parseInt(scan.nextLine());
        System.out.println("Enter number of tickets");
        int numTickets = Integer.parseInt(scan.nextLine());

        int[] TrialNumCount = new int[numTrials];

        int toCount = 0;
        System.out.println("==========Trial Count==========");
        for (int i = 0;i<numTrials;i++)
        {
            int targetNum = (int)(Math.random()*numTickets);
            int trialCount = 0;
            int randNum = -1;
            for (int x = 0;randNum!=targetNum;x++)
            {
                randNum = (int)(Math.random()*numTickets);
                trialCount++;
            }
            toCount+= trialCount;
            TrialNumCount[i] = trialCount;
            System.out.println(trialCount);
        }
        int xBar = toCount/numTrials;

        System.out.println("========End Trial========");
        System.out.println("XBar == "+xBar);
    }
}