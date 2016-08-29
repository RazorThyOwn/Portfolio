public class Invoice implements Payment
{
    private double cost;
    private double amountRecieved;
    private String item;

    public Invoice(String itemName,double itemCost)
    {
        cost = itemCost;
        item = itemName;
    }

    public double getPaymentAmount()
    {
        return cost;
    }

    public void recieveFunds(double funds)
    {
        amountRecieved += funds;
    }

    public boolean isPaid()
    {
        return cost <= amountRecieved; 
    }

    public String toString()
    {
        String paidOrDue;
        if( this.isPaid())
            paidOrDue = "Paid";
        else
            paidOrDue = "Due";

        return "Invoice: "+item+"\nAmount:  "+AccountingDept.formatMoney(cost)+"\nStatus:  "+paidOrDue;
    }
}