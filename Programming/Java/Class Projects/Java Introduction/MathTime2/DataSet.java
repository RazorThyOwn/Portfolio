public class DataSet
{
    private int maxVal, minVal;
    public DataSet()
    {
        maxVal = Integer.MIN_VALUE;
        minVal = Integer.MAX_VALUE;
    }

    public void registerValue(int tmpVal)
    {
        //
        minVal = Math.min(tmpVal, minVal);
        maxVal = Math.max(tmpVal, maxVal);

    }

    public String toString()
    {
        return "Your max value is "+maxVal+" and your min value is "+minVal;
    }

    public int getRange()
    {
        return Math.abs(minVal)+Math.abs(maxVal);
    }
}