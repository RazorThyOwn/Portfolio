public class Dog implements Speaker
{
   private String sound = "Howl";
   public void speak()
   {
       System.out.println(sound);
       sound = sound.substring(0,sound.length()-1)+"wl";
   }
}