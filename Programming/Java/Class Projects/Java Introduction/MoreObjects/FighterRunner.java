public class FighterRunner
{

   public static void main()
   {
      Fighter player1 = new Fighter("Ryu","Haduoken",100);
      Fighter player2 = new Fighter("Blanka","Electricity",100);


      System.out.println(player1+"\n"+player2+"\n");


      System.out.println(player1.getName()+" hits "+player2.getName()+" with his "+player1.getSuper()+" attack");

      player2.takeDamage(45);

      System.out.println(player1+"\n"+player2+"\n"+"\n");







      System.out.println(player2.getName()+" hits "+player1.getName()+" with his "+player2.getSuper()+" attack");

      player1.takeDamage(25);

      System.out.println(player1+"\n"+player2+"\n"+"\n");





      System.out.println(player1.getName()+" hits "+player2.getName()+" with his "+player1.getSuper()+" attack");

      player2.takeDamage(55);

      System.out.println(player1+"\n"+player2+"\n"+"\n");



      System.out.println(player2.getName()+" loses: ");

      System.out.println(player2.lose());

      System.out.println(player1.getName()+" wins: ");

      System.out.println(player1.win());



   }
}

