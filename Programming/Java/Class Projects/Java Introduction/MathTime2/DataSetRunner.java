public class DataSetRunner
{
    public static void main()
    {
        DataSet dS = new DataSet();
        dS.registerValue(10);
        dS.registerValue(2);
        dS.registerValue(3);
        dS.registerValue(8);
        dS.registerValue(-9);
        dS.registerValue(-5);
        dS.registerValue(12);
        dS.registerValue(15);
        System.out.println(dS.toString());
        System.out.println("Your range is "+dS.getRange());
    }
}