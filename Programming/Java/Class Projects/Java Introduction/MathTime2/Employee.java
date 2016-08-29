public class Employee implements Payment
{
    private String name, jobTitle;
    private double amountOwed, hourlyRate;

    public Employee(String name, String title, double hourly)
    {
        this.name = name;
        jobTitle = title;
        hourlyRate = hourly;
    }

    public void work(double hours)
    {
        amountOwed += hours*hourlyRate;
    }

    public double getPaymentAmount()
    {
        return amountOwed;
    }

    public void recieveFunds(double funds)
    {
        amountOwed -= funds;
    }

    public String toString()
    {
        return name+" : "+jobTitle+" : Owed "+AccountingDept.formatMoney(amountOwed);
    }

}