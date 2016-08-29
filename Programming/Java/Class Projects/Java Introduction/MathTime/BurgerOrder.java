public class BurgerOrder
{
    private int burgerCount, friesCount, sodaCount;
    private final double BURGER_PRICE = 2.00;
    private final double SODA_PRICE = 1.25;
    private final double FRIES_PRICE = 1.50;
    private final double SALES_TAX = 0.0775;
    
    public BurgerOrder()
    {
        burgerCount=0;
        friesCount=0;
        sodaCount=0;
        
    }
    
    public void addBurgers(int tmpInt)
    {
        burgerCount+=tmpInt;
    }
    
    public void addFries(int tmpInt)
    {
        friesCount+=tmpInt;
    }
    
    public void addSodas(int tmpInt)
    {
        sodaCount+=tmpInt;
    }
    
    public String toString()
    {
        String str = "You have "+burgerCount+" burgers, "+friesCount+" fries, "+sodaCount+" sodas";
        return str;
    }
    
    public double getTotal()
    {
        double total=0;
        total += (BURGER_PRICE*burgerCount);
        total += (FRIES_PRICE*friesCount);
        total += (SODA_PRICE*sodaCount);
        return total;
    }
    
    public double totalAfterTax()
    {
        double total = this.getTotal();
        double tax = (total*=SALES_TAX)+this.getTotal();
        return tax;
        
    }
}

