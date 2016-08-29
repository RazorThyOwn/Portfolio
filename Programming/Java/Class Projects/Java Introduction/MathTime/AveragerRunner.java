public class AveragerRunner
{
    public static void main()
    {
        Averager av = new Averager();
        av.registerValue(5);
        av.registerValue(2);
        av.registerValue(7);
        double count = av.getCount();
        double ave = av.getAverage();
        System.out.println("The average for "+count+" amount of numbers is "+ave);
        av.registerValue(4);
        av.registerValue(6);
        count = av.getCount();
        ave = av.getAverage();
        System.out.println("The average for "+count+" amount of numbers is "+ave);
    }
}