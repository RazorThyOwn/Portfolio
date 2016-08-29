import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class InitCounter
{
    private List<String> initList = new ArrayList<String>();
    private Scanner scan = new Scanner(System.in);

    InitCounter()
    {
        System.out.println("Input player followed by init followed by dex mod");
        String in = scan.nextLine();
        while (! (in.equals("DONE")) )
        {
            initList.add(in);
        }
        
        // Sorting by initiative
        List<String> tmpList = new ArrayList<String>();
        for (int i = 0; i < initList.size(); i++)
        {
            
        }
    }

    public static void main()
    {
        InitCounter iC = new InitCounter();
    }
}