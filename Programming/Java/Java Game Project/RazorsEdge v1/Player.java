public class Player
{
    int sleep, hunger, thirst;
    int sponsors = 0;
    int exhausted;
    int thirstMult = 0;
    int hungerMult = 0;
    int speedLeft;
    int speedMultiplier = 5;
    
    int xPos = (int)(Math.random()*500);
    int yPos = (int)(Math.random()*500);

    double str, intl, spd, endr, agil;
    double hitpoints;
    
    boolean isSleeping;
    boolean isControlSleeping;
    
    int index = -1;

    String className;
    String name;
    
    public Player(int indexIn)
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
    }
    
    public Player(int indexIn, int rNum)
    {
        xPos = (int)(Math.random()*rNum);
        yPos = (int)(Math.random()*rNum);
        index = indexIn;
    }

    public Player(int s, int i, int sp, int e, int a, int indexIn)
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
    
    public int getSpeedLeft()
    {
        return speedLeft;
    }
    
    public void setSpeedLeft(int spdLeft)
    {
        speedLeft = spdLeft;
    }
    
    public void reduceSpeed(int scale)
    {
        speedLeft-=scale;
    }
}