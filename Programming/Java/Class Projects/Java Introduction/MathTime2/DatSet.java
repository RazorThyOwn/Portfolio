public class DatSet
{
    private double sum;
    private double max;
    private int count;

    public void add(double num)
    {
        sum += num;

        if( count == 0 || num > max)
            max = num;

        count++;
    }

    public int getCount()
    {
        return count;
    }

    public double getMaximum()
    {
        return max;
    }

    public String toString()
    {
        return "The average of the "+count+" items is "+sum/count+", with the largest value being "+max;
    }

    public static void runner()
    {
        double[] dubs= {24.18236976253404,5.318798095707647,6.057224716497403,3.2088550719106683,8.321992716177688,14.546883109584371,10.787327333696256,4.4931530483393685,2.2494433844237856,4.026296722006039,1.9840089875071631,10.061039409918523,7.63092945128476,7.138566982641584,17.745026359508653,1.0641422353025565,14.87162155392738,16.27645701530634,2.2693370747936785,15.371608415090806};

        DatSet data = new DatSet();

        for( int i = 0; i < dubs.length; i++)
        {
            data.add(dubs[i]);
        }

        System.out.println(data);

    }
}