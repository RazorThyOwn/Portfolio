public class HourlyWorker extends Worker
{
    private double salary;
    
    public HourlyWorker(String name, double salary)
    {
        super(name);
        this.salary = salary;
    }
    
    public double computePay()
    {
        if (super.getHoursWorked()<=40)
            return salary*super.getHoursWorked();
        else if (super.getHoursWorked()>40)
            return ((super.getHoursWorked()-40)*(1.5*salary)) + (40*salary);
        else
            return -1;
    }
}

