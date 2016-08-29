import java.util.Scanner;
public class EightBall
{
    public static void main()
    {
        System.out.println("Welcome to Magic 8 Ball!");
        boolean willLoop = true;
        while (willLoop)
        {
            System.out.println("Would you like to shake the 8-ball?");
            Scanner scan1 = new Scanner(System.in);
            String scan = scan1.nextLine();
            if (scan.equals("Yes")||scan.equals("yes"))
            {
                int rand = (int)(Math.random()*3)+1;
                if (rand==1)
                {
                    rand = (int)(Math.random()*5)+1;
                    if (rand==1)
                    {
                        System.out.println( "Reply hazy, try again" );
                    }
                    else if (rand==2)
                    {
                        System.out.println( "My reply is no" );
                    }
                    else if (rand==3)
                    {
                        System.out.println( "My sources say no" );
                    }
                    else if (rand==4)
                    {
                        System.out.println( "Outlook not so good" );
                    }
                    else if (rand==5)
                    {
                        System.out.println( "Very doubtful" );
                    }
                    else
                        System.out.println( "LOSER_BAD" );
                }
                else if (rand==2)
                {
                    rand = (int)(Math.random()*5)+1;
                    if (rand==1)
                    {
                        System.out.println( "Reply hazy, try again loser" );
                    }
                    else if (rand==2)
                    {
                        System.out.println( "Ask again later" );
                    }
                    else if (rand==3)
                    {
                        System.out.println( "Better not tell you now" );
                    }
                    else if (rand==4)
                    {
                        System.out.println( "Cannot predict now" );
                    }
                    else if (rand==5)
                    {
                        System.out.println( "Concentrate and ask again" );
                    }
                    else
                        System.out.println( "LOSER_NEUTRAL" );
                }
                else if (rand==3)
                {
                    rand = (int)(Math.random()*5)+1;
                    if (rand==1)
                    {
                        System.out.println( "it is certain" );
                    }
                    else if (rand==2)
                    {
                        System.out.println( "it is decidely so" );
                    }
                    else if (rand==3)
                    {
                        System.out.println( "Without a doubt" );
                    }
                    else if (rand==4)
                    {
                        System.out.println( "Yes - definetly" );
                    }
                    else if (rand==5)
                    {
                        System.out.println( "You may rely on it" );
                    }
                    else
                        System.out.println( "LOSER_GOOD" );
                }
                else
                    System.out.println( "LOSER_ITSALLSCERWEDUP" );
            }
            else
            {
                willLoop = false;
                System.out.println("Goodbye");
            }
        }
    }
}