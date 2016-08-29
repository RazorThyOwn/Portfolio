public class SalariedWorker extends Worker
{
    private double salary;
    
    public SalariedWorker(String name, double salary)
    {
        super(name);
        this.salary = salary;
    }
    
    public double getWeeklySalary()
    {
        return salary;
    }
    
    public double computePay()
    {
        return salary;
    }
}