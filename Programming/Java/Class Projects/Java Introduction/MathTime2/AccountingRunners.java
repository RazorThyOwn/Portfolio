public class AccountingRunners
{
    public static void employeeRunner()
    {
        Employee[] employees = {
                new Employee("Ned Stark", "Sales Assosciate", 8.89), 
                new Employee("Petyr Baelish","Guest Services",8.48),
                new Employee("Joffrey Baratheon","Cashier",8.52),
                new Employee("Jaime Lannister","Department Manager",11.18),
                new Employee("Theon Greyjoy","Overnight Stocker",9.67),
                new Employee("Dany Targaryen","Queen of Dragons",10.56)
            };
        int[] hoursWorked = {75,80,70,65,80,80};

        for( int i =0; i < employees.length; i++)
        {
            employees[i].work(hoursWorked[i]);
        }

        AccountingDept accounting = new AccountingDept(3000);
        accounting.pay(employees);
    }

    public static void invoiceRunner()
    {
        Invoice[] invoices = {
                new Invoice("Legal Fees",5200), 
                new Invoice("New Cash Registers",1500),
                new Invoice("Cleaning Equipment",2475),
                new Invoice("Uniforms",1985),
                new Invoice("New Neon Sign",1200),
                new Invoice("Receipt Paper Spools",200)
            };

        AccountingDept accounting = new AccountingDept(10000);
        accounting.pay(invoices);
    }

    public static void shadyRunner()
    {
        ShadyDeal[] deals = {
                new ShadyDeal("Congressman Bribery",5200), 
                new ShadyDeal("Mob Protection",1500),
                new ShadyDeal("Hitman Services",2475),
                new ShadyDeal("Insurance Fraud",1985),
                new ShadyDeal("Hostile Takeover",1200),
                new ShadyDeal("Fake Passports",200)
            };

        AccountingDept accounting = new AccountingDept(10000);
        accounting.pay(deals);
    }
}