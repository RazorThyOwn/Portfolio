public class LoopTestMethods
{
    public static void evenCounter(int n)
    {
        for (int i = 2;i<n-2;i+=2)
        {
            System.out.print(i+",");
        }
        if (n%2==0)
            System.out.print(n-2);
        else
            System.out.print(n-1);
    }

    public static boolean confirmX(String input)
    {
        for (int i = 0;i<input.length();i++)
        {
            String phrase = input.substring(i,i+1);
            if (phrase.equals("X"))
            {
                if(input.length()-i<=1)
                    return false;
                else if (!(input.substring(i+1,i+2).equals("x")))
                    return false;
            }
        }
        return true;
    }

    public static void NameBorder(String name)
    {
        for (int i = 0;i<name.length()+2;i++)
        {
            System.out.print("*");            
        }
        System.out.println("");
        System.out.print("*");
        System.out.print(name);
        System.out.print("*");
        System.out.println("");
        for (int a = 0;a<name.length()+2;a++)
        {
            System.out.print("*");            
        }
    }

    public static boolean winCounter(String record)
    {
        int win = 0;
        int loss = 0;
        for (int i = 0;i<record.length();i++)
        {
            String phrase = record.substring(i,i+1);
            if (phrase.equals("W"))
                win ++;
            else if (phrase.equals("L"))
                loss ++;
        }
        if (win>loss)
            return true;
        else
            return false;
    }

    public static void diceGame()
    {
        int rollCount = 0;
        int diceOne = 1;
        int diceTwo = 6;
        while (diceOne!=diceTwo)
        {
            rollCount++;
            diceOne = (int)((Math.random())*6)+1;
            diceTwo = (int)((Math.random())*6)+1;
            System.out.println(diceOne + " " + diceTwo);
        }
        System.out.println("Game over, it took " + rollCount + " rolls!");
    }
}