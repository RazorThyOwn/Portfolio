import java.awt.Color;
public class WorldGen
{
    Tile[][] terrTiles;
    Civ[] civs;

    public void genFlat(int scale)
    {
        terrTiles = new Tile[scale][scale];
        for (int i = 0; i < scale; i++)
        {
            for (int n = 0; n < scale; n++)
            {
                Color color = new Color(100,100,100);
                Tile tmpTile = new Tile(color,"Flatland");
                tmpTile.setHeight(0);
                terrTiles[i][n] = tmpTile;
            }
        }
    }

    public void genDesert(int scale)
    {
        int numCivs = 2;

        terrTiles = new Tile[scale][scale];
        for (int i = 0; i < scale; i++)
        {
            for (int n = 0; n < scale; n++)
            {
                Color color = new Color(255,255,180);
                Tile tmpTile = new Tile(color,"Flatland");
                tmpTile.setHeight(0);
                terrTiles[i][n] = tmpTile;
            }
        }

        for (int i = 0; i < numCivs; i++)
        {
            int randX = (int)(Math.random()*scale);
            int randY = (int)(Math.random()*scale);
            Civ newCiv = new Civ(randX,randY,"Civ #"+i);
        }
    }

    int getHeight(int i, int n)
    {
        return terrTiles[i][n].getHeight();
    }

    Tile[][] getTerrain()
    {
        return terrTiles;
    }

    int[][] genRandom(int scale, int rSize)
    {
        int[][] newVals = new int[scale][scale];

        for (int i = 0; i < scale; i++)
            for (int n = 0; n < scale; n++)
            {
                int random = (scale/2) - (int)(Math.random()*scale);
                newVals[i][n] = random;
            }
        return newVals;
    }
}
/*
 * 

int[][] genCHill(int scale, int rSize)
{
int[][] newVals = new int[scale][scale];

for (int i = 0; i < scale; i++)
for (int n = 0; n < scale; n++)
{
int middleX = scale/2;
int middleY = scale/2;

double distance = java.lang.Math.sqrt( java.lang.Math.pow(i-middleX,2) + java.lang.Math.pow(n-middleY,2) );

double setVal = -(double)rSize/distance;

if (setVal > Integer.MAX_VALUE || setVal < Integer.MIN_VALUE)
{
setVal = -rSize;
}

newVals[i][n] = (int)setVal;
}
return newVals;
}

int[][] genCValley(int scale, int rSize)
{
int[][] newVals = new int[scale][scale];

for (int i = 0; i < scale; i++)
for (int n = 0; n < scale; n++)
{
int middleX = scale/2;
int middleY = scale/2;

double distance = java.lang.Math.sqrt( java.lang.Math.pow(i-middleX,2) + java.lang.Math.pow(n-middleY,2) );

double setVal = +(double)rSize/distance;

if (setVal > Integer.MAX_VALUE || setVal < Integer.MIN_VALUE)
{
setVal = +rSize;
}

newVals[i][n] = (int)setVal;
}
return newVals;
}

int[][] genZero(int scale)
{
int[][] newVals = new int[scale][scale];

for (int i = 0; i < scale; i++)
for (int n = 0; n < scale; n++)
{
newVals[i][n] = 0;
}

return newVals;
}
 */