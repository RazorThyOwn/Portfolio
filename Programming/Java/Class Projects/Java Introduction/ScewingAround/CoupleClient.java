import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class CoupleClient 
{
    private String filePath;
    private Scanner scan;
    private List<Couple> list = new ArrayList<Couple>();

    public CoupleClient(String fileP)
    {

        if (fileP==null)
        {
            System.out.println("java coupleClient inputFileName");
            return;
        }
        else
        {
            filePath = fileP;
        }

        System.out.println("Program 6, [Dylan], [marc1800]");

        try
        {
            FileReader file_to_read = new FileReader(filePath);
            BufferedReader br = new BufferedReader(file_to_read);

            int nLines = 0;

            while (br.readLine()!=null)
            {
                nLines++;
            }

            FileReader fr = new FileReader(filePath);
            BufferedReader newBR = new BufferedReader(fr);

            for (int i = 0; i < nLines; i++)
            {
                int indexOfSpace = -1;
                String thisLine = newBR.readLine();
                String fBit = "";
                String sBit = "";

                indexOfSpace = thisLine.indexOf(" ");
                fBit = thisLine.substring(0,indexOfSpace);
                sBit = thisLine.substring(indexOfSpace+1);

                if (isDouble(fBit) && isDouble(sBit))
                {
                    list.add(new Couple<Double>(Double.parseDouble(fBit),Double.parseDouble(sBit)));
                }
                else if (isInt(fBit) && isInt(sBit))
                {
                    list.add(new Couple<Integer>(Integer.parseInt(fBit),Integer.parseInt(sBit)));
                }
                else 
                {
                    list.add(new Couple<String>(fBit,sBit));
                }
            }
        }
        catch (IOException e)
        {
            System.out.println(e.toString());
        }
    }

    public boolean isInt(String s) 
    {
        try 
        {
            Integer.parseInt(s);
            return true;
        }
        catch(Exception e) 
        {
            return false;
        }
    }

    public boolean isDouble(String s)
    {
        try
        {
            Double.parseDouble(s);
            if (!isInt(s))
                return true;
            else
                return false;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}