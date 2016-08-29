public interface Payment
{
    public double getPaymentAmount();
    
    public void recieveFunds(double funds);
    
    public String toString();
}