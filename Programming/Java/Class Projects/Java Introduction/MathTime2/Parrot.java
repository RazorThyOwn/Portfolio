public class Parrot implements Speaker
{
   private String sound1 = "SQUAWK!", sound2 = "Polly want a cracker!";
   private boolean bool = true;

   public void speak()
   {
      if(bool)
         System.out.println(sound1);
      else
         System.out.println(sound2);

      bool = !bool;
   }
}