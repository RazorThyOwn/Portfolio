public class Coin implements Measurable
{

    private double coinValue;
    private String coinName;

    public Coin(String name, double value )
    {
        coinValue = value;
        coinName = name;
    }

    public double getMeasure()
    {
        return this.getValue();
    }
        
    public double getValue()
    {
        return coinValue;
    }

    public String getName()
    {
        return coinName;
    }

    public String toString()
    {
        return coinName+":"+coinValue;
    }

    public static void coinRunner()
    {
        Coin[] coins = {new Coin("dime",.1),new Coin("quarter",.25),new Coin("penny",.01),new Coin("quarter",.25),new Coin("nickel",.05)};

        MeasurableDataSet mds = new MeasurableDataSet();

        for( int i=0; i<coins.length; i++)
        {
            mds.add(coins[i]);
        }
        System.out.println(mds);
    }

}