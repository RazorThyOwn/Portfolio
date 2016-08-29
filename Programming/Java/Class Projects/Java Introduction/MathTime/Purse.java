public class Purse
{
    //represents the number of quarters in the Purse
    private int numQuarters;
    //represents the number of dimes in the Purse
    private int numDimes;
    //represents the number of nickels in the Purse
    private int numNickels;
    //
    private final double QUARTER_VALUE = 0.25;
    private final double NICKEL_VALUE = 0.05;
    private final double DIME_VALUE = 0.1;
    public Purse()
    {
        numQuarters=0;
        numDimes=0;
        numNickels=0;
    }
    
    public void addDime(int count)
    {
        numDimes+=count;
    }
    
    public void addNickle(int count)
    {
        numNickels+=count;
    }
    
    public void addQuarter(int count)
    {
        numQuarters+=count;
    }
    
    public void incrementNickel()
    {
        numNickels++;
    }
    
    public int getNumberOfCoins()
    {
        int sum = numQuarters+numNickels+numDimes;
        return sum;
    }
    
    public double getValue()
    {
        double total = 0;
        total += DIME_VALUE*numDimes;
        total += QUARTER_VALUE*numQuarters;
        total += NICKEL_VALUE*numNickels;
        return total;
    }
}