public class Averager
{
    private double total;
    private int count;
    
    public Averager()
    {
        total = 0;   
        count = 0;
    }
    
    public void registerValue(double tmpInt)
    {
        total+=tmpInt;
        count++;
    }
    
    public double getAverage()
    {
        return total/count;
    }
    
    public double getSum()
    {
        return total;
    }
    
    public double getCount()
    {
        return count;
    }
}