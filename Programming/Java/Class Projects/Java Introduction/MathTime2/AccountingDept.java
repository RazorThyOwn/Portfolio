public class AccountingDept
{
    private double funds;

    public AccountingDept(double initialFunds)
    {
        funds = initialFunds;
    }

    public void addFunds(double money)
    {
        funds += money;
    }

    public double getFunds()
    {
        return funds;
    }

    public void pay(Payment[] payees)
    {
        System.out.println("Beginning Payments with "+formatMoney(funds)+"\n");
        for(int i =0; i < payees.length; i++)
        {
            //Get payment amount and format it
            double payment = payees[i].getPaymentAmount();
            String payStr = formatMoney(payment);
            System.out.println(payStr+" is owed to:\n"+payees[i]);

            //Check if it's affordable
            if( payment <= funds )
            {
                payees[i].recieveFunds(payment);
                funds -= payment;
                System.out.println("Payment complete. "+formatMoney(funds)+" remaining\n");
            }
            else
            {
                System.out.println("Insufficient funds: Only "+formatMoney(funds)+" remaining.  Stopping payments");
                return;
            }
        }

        System.out.println("All debts paid with "+formatMoney(funds)+" remaining");
    }

    public static String formatMoney(double money)
    {
        double cash = Math.round(money*100)/100.0;
        String dollars = "$"+cash+"0";
        dollars = dollars.substring(0,dollars.indexOf(".")+3);
        return dollars;
    }


}