public class Apparel extends Item
{
    int agil;
    int hpb;
    int spdc;
    int rarityMod;
    double rarity;
    public Apparel(String n, int w, int a, int h, int s, int rMod, String dsc)
    {
        name = n;
        weight = w;
        agil = a;
        hpb = h;
        spdc = s;
        rarityMod = rMod;
        if (rarity != 0)
            rarity = 1/rarityMod;
        else
            rarity = -1;
        desc = dsc;
    }

    public void setVal(int valNum, int val)
    {
        if (valNum==0)
            agil = val;
        if (valNum==1)
            hpb = val;
        if (valNum==2)
            spdc = val;
        if (valNum==3)
            weight = val;
    }

    public int getVal(int valNum)
    {
        if (valNum==0)
            return agil;
        if (valNum==1)
            return hpb;
        if (valNum==2)
            return spdc;
        if (valNum==3)
            return weight;
        else
            return -1;
    }

    public int getAgility()
    {
        return agil;
    }

    public int getHealth()
    {
        return hpb;
    }

    public int getSpeed()
    {
        return spdc;
    }

    public String toString()
    {
        return (name+", Agility Bonus: "+agil+", Speed Bonus: "+spdc+", Health Bonus: "+hpb+", Weight: "+weight);
    }
}