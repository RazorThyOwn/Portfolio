import java.util.Scanner;
import sacco.*;
public class BattleRunner
{
   public static void main()
   {
      Fighter[] fighters = new Fighter[2];
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter player one's name:");
      String name = scan.nextLine();
      System.out.println("What is "+name+"'s special move?");
      String special = scan.nextLine();

      fighters[0] = new Fighter(name, special, 100);

      System.out.println("Enter player two's name:");
      name = scan.nextLine();
      System.out.println("What is "+name+"'s special move?");
      special = scan.nextLine();

      fighters[1] = new Fighter(name, special, 100);

      //determine who goes first
      int num = (int)(Math.random()*2);
      int num2 = (num+1)%2;

      if(num == 0)
      {
         System.out.println(fighters[0].getName()+" has won the right to go first");
      }
      else
      {
         System.out.println(fighters[1].getName()+" has won the right to go first");
      }

      while(fighters[0].getHealth()>0 && fighters[1].getHealth()>0)
      {
         System.out.println(fighters[0]+"\n"+fighters[1]+"\n");
         num = (num+1)%2;
         num2 = (num2+1)%2;
         
         SaccoTools.pauseFor(2000);
         int damage = (int)(Math.random()*30);
         System.out.println(fighters[num].getName() + " hits " + fighters[num2].getName()+ " with his "+fighters[num].getSuper()+" attack for "+ damage+ " points.");
         fighters[num2].takeDamage(damage);

      }
   }
}

