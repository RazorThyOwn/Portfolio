public class BankAccount implements Measurable
{
    private double balance;
    private String accountName;
    private double interestRate;

    public BankAccount(String name, double initialDeposit)
    {
        accountName=name;
        balance = initialDeposit;
        interestRate = .01;

    }

    public double getMeasure()
    {
        return this.getBalance();
    }
    
    public void gainInterest()
    {
        balance = (1+interestRate)*balance;
    }

    public void deposit(double money)
    {
        balance += money;
    }

    public String getName()
    {
        return accountName;
    }

    public double getBalance()
    {
        return balance;
    }

    public String toString()
    {
        return accountName+":"+balance;
    }

    public static void runner()
    {
        BankAccount[] accounts = {new BankAccount("Allen", 1000), new BankAccount("Beth", 250), new BankAccount("Charlie", 500), new BankAccount("Diana",1235), new BankAccount("Evan",722)};
        int[] years = {3,6,4,5,2}; //Each account gains a different amount of interest

        for( int i = 0; i<accounts.length; i++)
        {
            //uses the number of years to gain interest on each account.
            for( int j = 0; j<years[i]; j++)
                accounts[i].gainInterest();
        }

        BankDataSet data = new BankDataSet();
        //adds each of the accounts to the BankDataSet object
        for( int i =0; i < accounts.length; i++)
        {
            data.add(accounts[i]);
        }

        System.out.println(data);

    }
}