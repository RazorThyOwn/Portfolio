public abstract class Worker extends Human
{
    private double hoursWorked;

    public Worker(String name)
    {
        super(name);
        hoursWorked = 0;
    }

    public double getHoursWorked()
    {
        return hoursWorked;
    }

    public void work(double dubs)
    {
        hoursWorked+=dubs;
    }

    public boolean isHappy()
    {
        if (hoursWorked<=40)
            return true;
        else
            return false;
    }

    public String toString()
    {
        if (isHappy())
            return super.getName()+" has worked "+hoursWorked+" hours this week and has earned "+this.computePay()+". He is happy";
        else
            return super.getName()+" has worked "+hoursWorked+" hours this week and has earned "+this.computePay()+". He is not happy";
    }

    public abstract double computePay();
}