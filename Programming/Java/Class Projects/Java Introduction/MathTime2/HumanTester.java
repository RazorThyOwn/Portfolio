public class HumanTester
{
    public static void studentTester()
    {
        Freshman f1 = new Freshman("George");
        Freshman f2 = new Freshman("Helen");
        Senior s1 = new Senior("Isaac");
        Senior s2 = new Senior("Jennifer");

        s1.setSenioritis(true);

        System.out.println(f1);
        System.out.println(f2);
        System.out.println(s1);
        System.out.println(s2);
    }

    public static void salaryTester()
    {
        SalariedWorker sw1 = new SalariedWorker("David", 1000);
        SalariedWorker sw2 = new SalariedWorker("Elizabeth", 1500);
        SalariedWorker sw3 = new SalariedWorker("Frances", 700);
        sw1.work(32);
        sw2.work(40);
        sw3.work(48);

        System.out.println(sw1);
        System.out.println(sw2);
        System.out.println(sw3);
    }

    public static void hourlyTester()
    {
        HourlyWorker hw1 = new HourlyWorker("Anna", 10.25);
        HourlyWorker hw2 = new HourlyWorker("Brian", 15.00);
        HourlyWorker hw3 = new HourlyWorker("Carol", 9.50);
        hw1.work(32);
        hw2.work(40);
        hw3.work(48);

        System.out.println(hw1);
        System.out.println(hw2);
        System.out.println(hw3);
    }
}