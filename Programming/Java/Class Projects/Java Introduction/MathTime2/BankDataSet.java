public class BankDataSet
{
    private double sum;
    private int max;
    private int count;

    public void add(BankAccount bnkCnt)
    {
        sum += bnkCnt.getBalance();

        if( count == 0 || bnkCnt.getBalance() > max)
            max = (int)bnkCnt.getBalance();

        count++;
    }

    public int getCount()
    {
        return count;
    }

    public int getMaximum()
    {
        return max;
    }

    public String toString()
    {
        return "The average of the "+count+" items is "+sum/count+", with the largest value being "+max;
    }
    
}