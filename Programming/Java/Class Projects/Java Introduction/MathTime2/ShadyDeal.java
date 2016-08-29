public class ShadyDeal implements Payment
{
    private double price;
    private String description;
    
    public ShadyDeal(String description, double price)
    {
        this.price = price;
        this.description = description;
    }
    
    public double getPaymentAmount()
    {
        return price;
    }
    
    public void recieveFunds(double funds)
    {
        price -= funds;
    }
    
    public String toString()
    {
        return "Shady Deal: "+description+"\nOwed: "+price;
    }

}
