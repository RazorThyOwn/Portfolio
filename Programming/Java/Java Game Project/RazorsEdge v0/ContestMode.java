import java.util.Scanner;
public class ContestMode
{
    Scanner scan = new Scanner(System.in);
    String[] adj = {"Horrendous","Terrible","Awful","Bad","Sucky","Poor","Mediocre","Below-Avereage","Average",
            "Average","Average","Above-Average","Alright","Decent","Pretty Good","Good","Pretty Great","Great","Awesome",
            "Phenomenal"};
    String[] charList = {"Strength","Intelligence","Speed","Endurance","Agility"}; 
    int[][] scoringList;
    int[][] playerTotal;

    static Player[] playerList;
    public ContestMode(Player[] pl)
    {
        playerList = pl;
        scoringList = new int[playerList.length][5];
        playerTotal = new int[playerList.length][5];
    }

    public Player[] run()
    {

        // Inputting Contest Choices
        Player[] outputPlayerList = playerList;
        System.out.println("Here are our characters scores so far...");
        System.out.println("");
        System.out.println("======================");
        for (int i = 0; i < playerList.length;i++)
        {
            System.out.println(playerList[i].getName()+": "+playerList[i].getClassName());
            for (int k = 0; k < 5; k++)
            {
                int adjScore = 0;
                if (playerList[i].getVal(k) > 19)
                    adjScore = 19;
                else
                    adjScore = playerList[i].getVal(k);

                System.out.print(charList[k]+": "+adj[adjScore]);
                if (k!=4)
                    System.out.print(", ");
            }
            System.out.println("");
            System.out.println("======================");
        }
        for (int i = 0; i < playerList.length;i++)
        {
            System.out.println("How will "+playerList[i].getName()+" spend his 10 points?");
            String charList = scan.nextLine();
            int[] intList = new int[5];
            for (int k = 0; k < 4; k++)
            {
                int indexOf = charList.indexOf(" ");
                charList = charList.substring(indexOf+1);
            }

            scoringList[i] = intList;
        }

        // Combining Values and scores
        for (int i = 0; i < scoringList.length; i++)
        {

            // I = player, K = characteristic
            for (int k = 0; k < 5; k++)
            {
                playerTotal[i][k] = scoringList[i][k] + playerList[i].getVal(k);
            }
        }

        //Printing out results
        for (int i = 0; i < playerTotal.length;i++)
        {
            System.out.println("");
            System.out.println(playerList[i].getName());
            for (int k = 0; k < 5; k++)
            {
                System.out.println(playerTotal[i][k]);
            } 
        }

        int[] winnersList = new int[5];
        // First dimension is places, second is characteristic
        // Second dimension is in order of place that they won in, so if [0][2] = 1, then player 2 got third in strength

        for (int i = 0; i < 5; i++)
        {
            int highestIndex = -1;
            int highestNumber = -999999;
            for (int k = 0; k < playerList.length; k++)
            {
                if (playerTotal[k][i] > highestNumber)
                {
                    highestNumber = playerTotal[k][i];
                    highestIndex = k;
                }
            }
            winnersList[i]=highestIndex;
        }

        // Adding sponsors and characteristic points
        for (int i = 0; i < 5; i++)
        {
            Player tmpPlayer = playerList[winnersList[i]];
            tmpPlayer.addSponsor(1);
            tmpPlayer.adjustVal(i,1);
            tmpPlayer.cUpdate();
            playerList[winnersList[i]] = tmpPlayer;
        }
        
        outputPlayerList = playerList;
        return outputPlayerList;
    }
}
