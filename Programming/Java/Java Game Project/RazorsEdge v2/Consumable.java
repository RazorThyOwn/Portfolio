public class Consumable extends Item
{
    int drink;
    int food;
    int[] biomes;

    public Consumable(String n, int[] bio, int d, int f, int w, String dsc)
    {
        name = n;
        biomes = bio;
        drink = d;
        food = f;
        weight = w;
        desc = dsc;
    }

    public void setVal(int valNum, int val)
    {
        if (valNum==0)
            drink = val;
        if (valNum==1)
            food = val;
    }

    public int getVal(int valNum)
    {
        if (valNum==0)
            return drink;
        if (valNum==1)
            return food;
        else
            return -1;
    }

    public void setFood(int f)
    {
        food = f;
    }

    public void setDrink(int d)
    {
        drink = d;
    }

    public int getFood()
    {
        return food;
    }

    public int getDrink()
    {
        return drink;
    }

    public String toString()
    {
        return (name+": Drink: "+drink+", Food: "+food+", Weight: "+weight);
    }
}