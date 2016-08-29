import java.util.Scanner;
public class Scrambler
{
    public static void main()
    {
        while (true)
        {
            System.out.println("Enter Phrase for Scrambler");
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            String output = "";
            while (input.length()>0)
            {
                int randMath = ((int)(Math.random()*input.length()));
                if (randMath!=input.length()-1)
                {
                    String add = input.substring(randMath,randMath+1);
                    if (!(add.equals(" ")))
                        output+=add;
                }
                else
                {
                    String add = input.substring(randMath);
                    if (!(add.equals(" ")))
                        output+=add;
                }
                String p1 = input.substring(0,randMath);
                String p2 = "";
                if (randMath!=input.length()-1)
                    p2 = input.substring(randMath+1);
                input = p1+p2;
            }
            System.out.println(output.toLowerCase());
        }
    }
}