import java.util.Scanner;
public class GuessingGame
{
    public static void main()
    {
        System.out.println("Time to guess! The number is between 1 and 20");
        System.out.println("Guess the number!");
        boolean loop = true;
        int count = 0;
        int answer = (int)(Math.random()*19)+1;
        do
        {
            Scanner scan = new Scanner(System.in);
            int guess = Integer.parseInt(scan.nextLine());
            count ++;
            if (guess==answer)
            {
                loop = false;
            }
            else
            {
                if (guess>answer)
                    System.out.println("The answer is lower!");
                else if (guess<answer)
                    System.out.println("The answer is higher!");
                else
                    System.out.println("YOUR A LOOSER!");
            }

        } while (loop);
        System.out.println("You did it!");
        System.out.println("It took you "+count+" tries!");
    }
}