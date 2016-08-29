public class BurgerRunner
{
   public static void main()
   {
      BurgerOrder myOrder = new BurgerOrder();

      System.out.println("Ordering 4 Burgers");
      myOrder.addBurgers(4);
      System.out.println(myOrder.toString());

      System.out.println("\nOrdering 2 fries");
      myOrder.addFries(2);
      System.out.println(myOrder.toString());

      System.out.println("\nOrdering 3 sodas");
      myOrder.addSodas(3);
      System.out.println(myOrder.toString());

      System.out.println("Before tax, there is a total of "+myOrder.getTotal() );
      System.out.println("After tax, there is a total of "+myOrder.totalAfterTax() );


   }
}
