public class MeasurableDataSet
{
    private double sum;
    private double max;
    private int count;

    public void add(Measurable mCat)
    {
        sum += mCat.getMeasure();

        if( count == 0 || mCat.getMeasure() > max)
            max = mCat.getMeasure();

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
    
}