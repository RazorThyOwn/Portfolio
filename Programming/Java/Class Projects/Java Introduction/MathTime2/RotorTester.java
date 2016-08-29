public class RotorTester
{
    public static void rotorTest()
    {
        System.out.println("Constructing a Rotor with the key GNUAHOVBIPWCJQXDKRYELSZFMT");
        Rotor rot = new Rotor("GNUAHOVBIPWCJQXDKRYELSZFMT");

        System.out.println(rot);
        System.out.println("A is at index "+rot.getCharacterIndex("A"));

        System.out.println("\nRotating...");
        rot.rotate();        
        System.out.println(rot);
        System.out.println("A is at index "+rot.getCharacterIndex("A"));

        System.out.println("\nRotating...");
        rot.rotate();             
        System.out.println(rot);
        System.out.println("The letter at index 10 is "+rot.getCharacterAt(10));

        System.out.println("\nSetting the starting letter to Q");
        rot.setStartingLetter("Q");             
        System.out.println(rot);
    }
}