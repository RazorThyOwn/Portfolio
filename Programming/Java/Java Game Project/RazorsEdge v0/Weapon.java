public class Weapon extends Item
{
    int damage;
    int accuracy;
    int blocking;
    int distance;
    int rarityMod;
    double rarity;

    public Weapon(String n, int d, int a, int b, int dis, int we, int rarIn, String description)
    {
        name = n;
        damage = d;
        accuracy = a;
        blocking = b;
        distance = dis;
        weight = we;
        rarityMod = rarIn;
        rarity = 1/rarityMod;
        desc = description;
    }
    
    public void setVal(int valNum, int val)
    {
        if (valNum==0)
            damage = val;
        if (valNum==1)
            accuracy = val;
        if (valNum==2)
            blocking = val;
        if (valNum==3)
            distance = val;
        if (valNum==4)
            weight = val;
    }

    public int getVal(int valNum)
    {
        if (valNum==0)
            return damage;
        if (valNum==1)
            return accuracy;
        if (valNum==2)
            return blocking;
        if (valNum==3)
            return distance;
        if (valNum==4)
            return weight;
        else
            return -1;
    }

    public int getDamage()
    {
        return damage;
    }

    public int getAccuracy()
    {
        return accuracy;
    }

    public int getBlocking()
    {
        return blocking;
    }

    public int getDistance()
    {
        return distance;
    }

    public int getWeight()
    {
        return weight;
    }

    public String toString()
    {
        return (name+", Damage: "+damage+", Accuracy: "+accuracy+", Blocking: "+blocking+", Distance: "+distance+", Weight: "+weight);
    }
}