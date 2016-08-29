import java.util.List;
import java.util.ArrayList;
public class Player
{
    int difficulty;
    int sleep, hunger, thirst;
    int sponsors = 0;
    int exhausted;
    int thirstMult = 0;
    int hungerMult = 0;

    int maxCarryWeight;
    int currentWeight;

    double speedLeft;
    int speedMultiplier = 5;

    int xPos = (int)(Math.random()*500);
    int yPos = (int)(Math.random()*500);

    double str, intl, spd, endr, agil;
    double hitpoints;

    boolean isSleeping;
    boolean isControlSleeping;

    int index = -1;

    List<Weapon> invWeapons = new ArrayList<Weapon>();
    List<Apparel> invApparel = new ArrayList<Apparel>();
    List<Consumable> invConsum = new ArrayList<Consumable>();
    int hpBonus, spdBonus, agilBonus;

    String className;
    String name;

    public Player(int indexIn, int difficultyIn)
    {
        str = -1;
        intl = -1;
        spd = -1;
        endr = -1;
        agil = -1;
        sleep = (int)endr;
        hunger = (int)endr;
        thirst = (int)endr;
        hitpoints = 10*endr;
        name = "NULL NAME";
        className = "Null-Null";
        exhausted=0;
        speedLeft = (int)spd*speedMultiplier;
        index = indexIn;
        difficulty = difficultyIn;
        maxCarryWeight = (int)str*10;
        currentWeight = 0;
    }

    public Player(int indexIn, int rNum, int difficultyIn)
    {
        xPos = (int)(Math.random()*rNum);
        yPos = (int)(Math.random()*rNum);
        index = indexIn;
        difficulty = difficultyIn;
    }

    public Player(int s, int i, int sp, int e, int a, int indexIn, int difficultyIn)
    {
        str = s;
        intl = i;
        spd = sp;
        endr = e;
        agil = a;
        sleep = (int)endr;
        hunger = (int)endr;
        thirst = (int)endr;
        hitpoints = 10*endr;
        name = "NULL NAME";
        className = "Null-Null";
        exhausted=0;
        speedLeft = (int)spd*speedMultiplier;
        index = indexIn;
        difficulty = difficultyIn;
    }

    public void addWeapon(Weapon tmpWeapon)
    {
        if (currentWeight + tmpWeapon.getWeight() < maxCarryWeight)
        {    
            invWeapons.add(tmpWeapon);
            currentWeight+=tmpWeapon.getWeight();
            //System.out.println("Added weapon");
        }
    }

    public void addApparel(Apparel tmpap)
    {
        if (currentWeight + tmpap.getWeight() < maxCarryWeight)
        {    
            invApparel.add(tmpap);
            currentWeight+=tmpap.getWeight();
            //System.out.println("Added apparel");
        }
        updateBonus();
    }

    public void addConsumable(Consumable cons)
    {
        if (currentWeight + cons.getWeight() < maxCarryWeight)
        {    
            invConsum.add(cons);
            currentWeight+=cons.getWeight();
            //System.out.println("Added consumable");
        }
    }

    public void removeItem(int type, int slot)
    {
        if (type==0)
            invWeapons.remove(slot);
        if (type==1)
            invApparel.remove(slot);
        if (type==2)
            invConsum.remove(slot);
        updateBonus();
    }

    public void setWeapon(Weapon weapon, int slot)
    {
        invWeapons.set(slot,weapon);
    }

    public void setApparel(Apparel apparel, int slot)
    {
        invApparel.set(slot,apparel);
        updateBonus();
    }

    public void setConsumable(Consumable consum, int slot)
    {
        invConsum.set(slot,consum);
    }

    public String toString()
    {
        String out = (name+": Strength: "+str+". Intelligence: "+intl+". Speed: "+spd+". Endurance: "+endr+". Agility: "+agil);
        return out;
    }

    public void setVal(int valNumber, double input)
    {
        // 0 = Strength, 1 = doubleelligence, 2 = Speed, 3 = Endurance, 4 = Agility
        // 5 = Hitpoints, 6 = Sleep, 7 = Thirst, 8 = Hunger

        if (valNumber==0)
            str = input;
        if (valNumber==1)
            intl = input;
        if (valNumber==2)
            spd = input;
        if (valNumber==3)
            endr = input;
        if (valNumber==4)
            agil = input;
        if (valNumber==5)
            hitpoints=input;
        if (valNumber==6)
            sleep=(int)input;
        if (valNumber==7)
            thirst=(int)input;
        if (valNumber==8)
            hunger=(int)input;
    }

    public void adjustVal(int valNumber, double input)
    {
        if (valNumber==0)
            str += input;
        if (valNumber==1)
            intl += input;
        if (valNumber==2)
            spd += input;
        if (valNumber==3)
            endr += input;
        if (valNumber==4)
            agil += input; 
        if (valNumber==5)
            hitpoints+=input;
        if (valNumber==6)
            sleep+=(int)input;
        if (valNumber==7)
            thirst+=(int)input;
        if (valNumber==8)
            hunger+=(int)input;
    }

    public int getVal(int valNumber)
    {
        if (valNumber==0)
            return (int)str;
        if (valNumber==1)
            return (int)intl;
        if (valNumber==2)
            return (int)spd;
        if (valNumber==3)
            return (int)endr;
        if (valNumber==4)
            return (int)agil;
        if (valNumber==5)
            return (int)hitpoints;
        if (valNumber==6)
            return sleep;
        if (valNumber==7)
            return thirst;
        if (valNumber==8)
            return hunger;
        else
            return -1;
    }

    public void setName(String nm)
    {
        name = nm;
    }

    public void setClassName(String nm)
    {
        className = nm;
    }

    public void setStrength(double strength)
    {
        str = strength;
    }

    public void setdoubleelligence(double intelligence)
    {
        intl = intelligence;
    }

    public void setSpeed(double speed)
    {
        spd = speed;
    }

    public void setEndurance(double endurance)
    {
        endr = endurance;
    }

    public void setAgility(double agility)
    {
        agil = agility;
    }

    public void setHitpoints(double hp)
    {
        hitpoints = hp;
    }

    public double getStrength()
    {
        return str;
    }

    public double getIntelligence()
    {
        return intl;
    }

    public double getSpeed()
    {
        return spd;
    }

    public double getEndurance()
    {
        return endr;
    }

    public double getAgility()
    {
        return agil;
    }

    public String getName()
    {
        return name;
    }

    public String getClassName()
    {
        return className;
    }

    public double getHitpoints()
    {
        return hitpoints;
    }

    public int getSleep()
    {
        return sleep;
    }

    public int getHunger()
    {
        return hunger;
    }

    public int getThirst()
    {
        return thirst;
    }

    public void setSleep(int n)
    {
        sleep = n;
    }

    public void setHunger(int n)
    {
        hunger = n;
    }

    public void setThirst(int n)
    {
        thirst = n;
    }

    public void maintenance()
    {
        if (exhausted>0)
            exhausted--;

        if (difficulty>0)
        {
            // General Subtraction
            if (sleep>0 && !isSleeping &&!isControlSleeping)
            {
                sleep--;
            }
            if (thirst>0)
            {
                thirstMult = 0;
                thirst--;
            }
            if (hunger>0)
            {
                hungerMult = 0;
                hunger--;
            }

            // Sleeping

            if (!isControlSleeping)
            {
                if (sleep>(5) && isSleeping)
                {
                    isSleeping = false;
                }
                if (isSleeping)
                {
                    sleep++;
                }
                if (sleep==0)
                {
                    isSleeping = true;
                }
            }
            else if(isControlSleeping)
            {
                sleep+=2;
            }

            // Thirst

            if (thirst==0)
            {
                thirstMult++;
                hitpoints -= thirstMult;
            }

            // Hunger

            if (hunger==0)
            {
                hungerMult++;
                hitpoints -= hungerMult;
            }
        }

        if (hitpoints < 0)
        {
            hitpoints = 0;
        }

        // Resetting movement
        speedLeft = (int)spd*speedMultiplier;
    }

    public void cUpdate()
    {
        hitpoints = endr*10;
        sleep = (int)endr;
        hunger = (int)endr;
        thirst = (int)endr;
        speedLeft = (int)spd*speedMultiplier;
        maxCarryWeight = (int)str*10;
    }

    public int[] getCharArray()
    {
        int[] intDex = {(int)str, (int)intl, (int)spd, (int)endr, (int)agil};
        return intDex;
    }

    public void train(int val)
    {
        if (exhausted<=1)
        {
            // Training works by taking a random number between 1-20, adding intelligence,
            // and if its greater than 20, training works!
            // If it does suceede, player must skip the next 2 rounds
            // Attempting to train also takes up a whole round

            int rand20 = (int)( 1 + (Math.random()*20));

            System.out.println("Trying to train, using an intelligence of "+intl+" with random of "+rand20);
            if (rand20 + intl >20)
            {
                exhausted = 3;
                this.adjustVal(val,1);
                System.out.println(name+" sucessfully trained "+val+" from "+(this.getVal(val)-1)+" to "+getVal(val));            
            }
            else
            {
                exhausted = 2;
                System.out.println("Training failed!");
            }
        }
    }

    public int getExhausted()
    {
        return exhausted;
    }

    public void setExhausted(int exh)
    {   
        exhausted = exh;
    }

    public boolean getIsSleeping()
    {
        return isSleeping;
    }

    public void setIsSleeping(boolean is)
    {
        isSleeping = is;
    }

    public boolean getIsControlSleeping()
    {
        return isControlSleeping;
    }

    public void setIsControlSleeping(boolean is)
    {
        isControlSleeping = is;
    }

    public void eat()
    {
        hunger = (int)endr;
    }

    public void drink()
    {
        thirst = (int)endr;
    }

    public void addSponsor(int sponsorIn)
    {
        sponsors+=sponsorIn;
    }

    public int getsponsors()
    {
        return sponsors;
    }

    public int getIndex()
    {
        return index;
    }

    public void setXPos(int x)
    {
        xPos = x;
    }

    public void setYPos(int y)
    {
        yPos = y;
    }

    public int getXPos()
    {
        return xPos;
    }

    public int getYPos()
    {
        return yPos;
    }

    public double getSpeedLeft()
    {
        return speedLeft;
    }

    public void setSpeedLeft(int spdLeft)
    {
        speedLeft = spdLeft;
    }

    public void reduceSpeed(double scale)
    {
        speedLeft-=scale;
    }

    public int getDifficulty()
    {
        return difficulty;
    }

    public void setDifficulty(int d)
    {
        difficulty = d;
    }

    public List<Weapon> getWeapons()
    {
        return invWeapons;
    }

    public List<Apparel> getApparel()
    {
        return invApparel;
    }

    public List<Consumable> getConsumable()
    {
        return invConsum;
    }

    public int getHPBonus()
    {
        return hpBonus;
    }

    public int getSpeedBonus()
    {
        return spdBonus;
    }

    public int getAgilityBonus()
    {
        return agilBonus;
    }

    public void updateBonus()
    {
        hpBonus = 0;
        spdBonus = 0;
        agilBonus = 0;
        for (int i = 0; i < invApparel.size(); i++)
        {
            hpBonus += invApparel.get(i).getHealth();
            spdBonus += invApparel.get(i).getSpeed();
            agilBonus += invApparel.get(i).getAgility();
        }
    }

    public void scavenge()
    {
        boolean find = ((int)intl + (int)(Math.random()*20)>20);
        exhausted = 2;
        if (find)
        {
            int rMath = (int)(Math.random()*2);
            if (rMath==0)
            {
                Weapon[] weapons = Controller.importer.getWAr();
                rMath = (int)(Math.random()*weapons.length);
                Weapon weap = weapons[rMath];
                addWeapon(weap);
            }
            if (rMath==1)
            {
                Apparel[] apparel = Controller.importer.getAAr();
                rMath = (int)(Math.random()*apparel.length);
                Apparel app = apparel[rMath-1];
                addApparel(app);
            }
        }
    }
}