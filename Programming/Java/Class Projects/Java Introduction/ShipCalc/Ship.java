public class Ship
{
    public double jB, hB, dB, jS, hS, dS, somer;
    public String shipName, tmpInput;
    public int slashIndex;

    //Vargur|5|5|5|2|2|2|6

    public Ship(String input)
    {
        tmpInput = input;

        slashIndex = tmpInput.indexOf("|");
        if (slashIndex==-1)
        {
            shipName = tmpInput;
            tmpInput = "";
        }
        else if (slashIndex!=-1)
        {
            shipName = tmpInput.substring(0,slashIndex);
            tmpInput = tmpInput.substring(slashIndex+1);
        }

        slashIndex = tmpInput.indexOf("|");
        if (slashIndex==-1 && tmpInput.length()!=0)
        {
            jB = Double.parseDouble(tmpInput);
            tmpInput = "";
        }
        else if (slashIndex!=-1)
        {
            jB = Double.parseDouble(tmpInput.substring(0,slashIndex));
            tmpInput = tmpInput.substring(slashIndex+1);
        }

        slashIndex = tmpInput.indexOf("|");
        if (slashIndex==-1 && tmpInput.length()!=0)
        {
            hB = Double.parseDouble(tmpInput);
            tmpInput = "";
        }
        else if (slashIndex!=-1)
        {
            hB = Double.parseDouble(tmpInput.substring(0,slashIndex));
            tmpInput = tmpInput.substring(slashIndex+1);
        }

        slashIndex = tmpInput.indexOf("|");
        if (slashIndex==-1 && tmpInput.length()!=0)
        {
            dB = Double.parseDouble(tmpInput);
            tmpInput = "";
        }
        else if (slashIndex!=-1)
        {
            dB = Double.parseDouble(tmpInput.substring(0,slashIndex));
            tmpInput = tmpInput.substring(slashIndex+1);
        }

        slashIndex = tmpInput.indexOf("|");
        if (slashIndex==-1 && tmpInput.length()!=0)
        {
            jS = Double.parseDouble(tmpInput);
            tmpInput = "";
        }
        else if (slashIndex!=-1)
        {
            jS = Double.parseDouble(tmpInput.substring(0,slashIndex));
            tmpInput = tmpInput.substring(slashIndex+1);
        }

        slashIndex = tmpInput.indexOf("|");
        if (slashIndex==-1 && tmpInput.length()!=0)
        {
            hS = Double.parseDouble(tmpInput);
            tmpInput = "";
        }
        else if (slashIndex!=-1)
        {
            hS = Double.parseDouble(tmpInput.substring(0,slashIndex));
            tmpInput = tmpInput.substring(slashIndex+1);
        }

        slashIndex = tmpInput.indexOf("|");
        if (slashIndex==-1 && tmpInput.length()!=0)
        {
            dS = Double.parseDouble(tmpInput);
            tmpInput = "";
        }
        else if (slashIndex!=-1)
        {
            dS = Double.parseDouble(tmpInput.substring(0,slashIndex));
            tmpInput = tmpInput.substring(slashIndex+1);
        }

        slashIndex = tmpInput.indexOf("|");
        if (slashIndex==-1 && tmpInput.length()!=0)
        {
            int bIndex = tmpInput.indexOf("B");
            if (bIndex==-1)
            {
                somer = Double.parseDouble(tmpInput);
                tmpInput = "";
            }
            else if (bIndex!=-1)
            {
                somer = Double.parseDouble(tmpInput.substring(0,bIndex));
                tmpInput = "";
            }
        }
        else if (slashIndex!=-1)
        {
            somer = Double.parseDouble(tmpInput.substring(0,slashIndex));
            tmpInput = tmpInput.substring(slashIndex+1);
        }
    }

    public String getName()
    {
        return shipName;
    }

    public double getJitaBuy()
    {
        return jB;
    }

    public double getHekBuy()
    {
        return hB;
    }

    public double getDodixieBuy()
    {
        return dB;
    }

    public double getJitaSell()
    {
        return jS;
    }

    public double getHekSell()
    {
        return hS;
    }

    public double getDodixieSell()
    {
        return dS;
    }

    public double getSomerSell()
    {
        return somer;
    }

    public String printShip()
    {
        return (shipName+"|"+jB+"|"+hB+"|"+dB+"|"+jS+"|"+hB+"|"+dB+"|"+somer+"B");
    }
}