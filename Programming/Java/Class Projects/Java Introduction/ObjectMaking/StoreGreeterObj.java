public class StoreGreeterObj
{
    private String myStoreName;
    private String mySpecialItem;
    
    public StoreGreeterObj()
    {
        myStoreName = "Vons";
        mySpecialItem = "Eggs";
    }

    
    public String toString()
    {
        String str = "Welcome to "+myStoreName+" our special today is "+mySpecialItem+".";
        return str;
    }
    
    public void setStoreName(String tmpStore)
    {
        myStoreName = tmpStore;
    }
    
    public void setSpecialItem(String tmpItem)
    {
        mySpecialItem = tmpItem;
    }

    
}