public class Cat implements Speaker
{
    private int count = 0;

    public void speak()
    {

        if( count < 5)
            System.out.println("mew");
        else
            System.out.println("MEOW");

        count++;
    }
}