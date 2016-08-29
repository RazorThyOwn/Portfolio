import sacco.*;
import java.util.Scanner;
import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ShipCostCalc
{   
    public static Ship[] shipArr = new Ship[0];
    public static Scanner scan = new Scanner(System.in);

    public static void main()
    {
        System.out.println("Directory:");
        System.out.println("1: Input new data");
        System.out.println("2: Save data");
        System.out.println("3: Load data");
        System.out.println("4: Read Data");
        System.out.println("5: Clear Stored Data");
        System.out.println("99: Exit");
        System.out.println("");

        String input = scan.nextLine();

        if (input.equals("1"))
            inputShipData();
        else if (input.equals("2"))
            writeFile();
        else if (input.equals("3"))
            loadData();
        else if (input.equals("4"))
            readFile();
        else if (input.equals("5"))
        {
            shipArr = new Ship[0];
            main();
        }
        else
            exit();
    }

    public static void inputShipData()
    {
        System.out.println("====DATA INPUT====");
        boolean addShip = true;
        System.out.println("Enter X to finish array");
        System.out.println("Format: Ship Name|Jita Buy|Hek Buy|Dodixie Buy|Jita Sell|Hek Sell|Dodixie Sell|Somer");
        while (addShip)
        {    
            String inputString = scan.nextLine();
            if (!(inputString.equals("X")))
            {
                Ship tmpShip = new Ship(inputString);
                Ship[] tmpShipArr = new Ship[shipArr.length+1];

                for (int i = 0; i <tmpShipArr.length-1;i++)
                {
                    tmpShipArr[i] = shipArr[i];
                }
                tmpShipArr[tmpShipArr.length-1]=tmpShip;
                shipArr = tmpShipArr;
            }
            else
            {
                System.out.println("==================");
                main();
            }
        }
    }

    public static void loadData()
    {
        String everything = "";
        System.out.println("====DATA LOAD====");
        System.out.println("Enter file name...");
        String input = scan.nextLine();
        try(BufferedReader br = new BufferedReader(new FileReader(input))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        }
        catch (IOException e)
        {  
            e.printStackTrace();
        }

        int count = 0;

        for (int i = 0;i<everything.length();i++)
        {
            if (everything.substring(i,i+1).equals("B"))
                count++;
        }

        String tmpString = everything;
        Ship[] tmpShipArr = new Ship[count];

        for (int i = 0;i<count;i++)
        {
            int x = 0;
            boolean notFoundB=true;
            while (notFoundB)
            {
                x++;
                if (tmpString.substring(x,x+1).equals("B"))
                {
                    notFoundB=false;
                }
            }
            String shipString = tmpString.substring(0,x+1);
            tmpString = tmpString.substring(x+1);
            Ship tmpShip = new Ship(shipString);
            tmpShipArr[i]=tmpShip;
        }
        shipArr = tmpShipArr;
        main();
    }

    public static void writeFile()
    {
        System.out.println("====SAVING FILE====");
        System.out.println("Input file name");
        String fileName = scan.nextLine();
        System.out.println("Saving...");

        BufferedWriter writer = null;
        try
        {
            writer = new BufferedWriter( new FileWriter(fileName));
            for (int i = 0;i<shipArr.length;i++)
            {
                writer.write(shipArr[i].printShip());
            }

        }
        catch ( IOException e)
        {
        }
        finally
        {
            try
            {
                if ( writer != null)
                    writer.close( );
            }
            catch ( IOException e)
            {
            }
        }
        System.out.println("=============");
        main();
    }

    public static void readFile()
    {
        System.out.println("====READ FILE=====");
        for (int i = 0;i<shipArr.length;i++)
        {
            System.out.println(shipArr[i].printShip());
        }
        SaccoTools.pauseFor(1);
        System.out.println("==================");
        main();
    }

    public static void exit()
    {
        System.out.println("Exiting...");
        return; 
    }
}
