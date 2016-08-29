public class Item
{
    String name;
    String desc;
    int weight;

    public void Item(String nameIn, String descIn, int weightIn)
    {
        name = nameIn;
        desc = descIn;
        weight = weightIn;
    }
        
    public void setName(String str)
    {
        name = str;
    }

    public int getWeight()
    {
        return weight;
    }

    public String getName()
    {
        return name;
    }

    public String getDesc()
    {
        return desc;
    }
}