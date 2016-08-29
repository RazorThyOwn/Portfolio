public class StoreGreeterRunner
{
    public static void main()
    {
        StoreGreeterObj sgo = new StoreGreeterObj();
        String str = sgo.toString();
        System.out.println(str);
        sgo.setSpecialItem("Milk");
        str = sgo.toString();
        System.out.println(str);
        
    }


}