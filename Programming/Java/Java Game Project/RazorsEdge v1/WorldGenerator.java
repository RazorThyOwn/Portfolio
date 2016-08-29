import java.awt.Color;
import sacco.*;
public class WorldGenerator
{
    Tile[][] outTerrain;
    int worldSize;
    int pCount;
    public Tile[][] worldGen(int biomeType, int worldSizeIn, int playerCount)
    {
        System.out.println("= = = = = W O R L D G E N = = = = =");
        worldSize = worldSizeIn;
        outTerrain = new Tile[worldSize][worldSize];
        pCount = playerCount;

        if (biomeType == 0)
        {
            // Desert Generation
            desertGen();
        }
        if (biomeType == 1)
        {
            // Forest Generation
            forestGen();
        }
        if (biomeType == 2)
        {
            // Jungle Generation
            jungleGen();
        }
        if (biomeType == 3)
        {
            // Tundra Generation
            tundraGen();
        }
        if (biomeType == 4)
        {
            // Island Generation
            islandGen();
        }
        if (biomeType == 5)
        {
            // Swamp Generation
            swampGen();
        } 
        System.out.println("= = = = = = = = = = = = = = = = = =");
        return outTerrain;
    }

    public void desertGen()
    {
        Tile[] desertTiles = new Tile[5];

        // Tile One
        Color color = new Color(100,100,0);
        Tile rockyDesert = new Tile(color);
        rockyDesert.setName("Rocky Desert");
        desertTiles[0] = rockyDesert;

        // Tile Two
        color = new Color(150,150,0);
        Tile sandDunes = new Tile(color);
        sandDunes.setName("Sand Dunes");
        sandDunes.moveSpeed = 2;
        desertTiles[1] = sandDunes;

        // Tile Three
        color = new Color(100,100,50);
        Tile deadLake = new Tile(color);
        deadLake.setName("Dead Lake");
        desertTiles[2] = deadLake;

        // Tile Four
        color = new Color(100,100,100);
        Tile desertMountain = new Tile(color);
        desertMountain.setName("Desert Mountains");
        desertMountain.moveSpeed = 2;
        desertTiles[3] = desertMountain;

        // Tile Five
        color = new Color(0,0,200);
        Tile oasis = new Tile(color);
        oasis.setName("Oasis");
        oasis.moveSpeed = 5;
        desertTiles[4] = oasis;

        // World Filling
        Picture[] picArray0 = {Picture.loadFromJar("tilePictures/00_0.jpg"),Picture.loadFromJar("tilePictures/00_1.jpg"),
                Picture.loadFromJar("tilePictures/00_2.jpg"),Picture.loadFromJar("tilePictures/00_3.jpg")};

        Picture[] picArray1 = {Picture.loadFromJar("tilePictures/01_0.jpg"),Picture.loadFromJar("tilePictures/01_1.jpg"),
                Picture.loadFromJar("tilePictures/01_2.jpg"),Picture.loadFromJar("tilePictures/01_3.jpg")};

        Picture[] picArray2 = {Picture.loadFromJar("tilePictures/02_0.jpg"),Picture.loadFromJar("tilePictures/02_1.jpg"),
                Picture.loadFromJar("tilePictures/02_2.jpg"),Picture.loadFromJar("tilePictures/02_3.jpg")};

        Picture[] picArray3 = {Picture.loadFromJar("tilePictures/03_0.jpg"),Picture.loadFromJar("tilePictures/03_1.jpg"),
                Picture.loadFromJar("tilePictures/03_2.jpg"),Picture.loadFromJar("tilePictures/03_3.jpg")};

        Picture[] picArray4 = {Picture.loadFromJar("tilePictures/04_0.jpg"),Picture.loadFromJar("tilePictures/04_1.jpg"),
                Picture.loadFromJar("tilePictures/04_2.jpg"),Picture.loadFromJar("tilePictures/04_3.jpg")};

        fillWorld(desertTiles[0],picArray0);
        //generateBiome(sandDunes,picArray1,8,125*(worldSize/500),15,1);
        //generateLake(deadLake,picArray2,3,45*(worldSize/500));
        //generateBiome(desertMountain,picArray3,2,75*(worldSize/500),2,2);
        //generateLake(oasis,picArray4,1,20*(worldSize/500));

        //genCorn(pCount,desertTiles[0],picArray0);

        // Testing
        //generateCircle(desertTiles[1],picArray1,250,250,100);
        //erodeAddition(desertTiles[1],picArray1,250,250,100,10,1);
        generateRiver(desertTiles[4],picArray4,1,10,1);
    }

    public void forestGen()
    {
        Tile[] forestTiles = new Tile[5];

        // Tile One
        Color color = new Color(0,143,0);
        Tile forest = new Tile(color);
        forest.setName("Forest");
        forestTiles[0] = forest;

        // Tile Two
        color = new Color(0,143,0);
        Tile praire = new Tile(color);
        praire.setName("Praire");
        forestTiles[1] = praire;

        // Tile Three
        color = new Color(0,143,0);
        Tile river = new Tile(color);
        river.setName("River");
        river.moveSpeed=5;
        forestTiles[2] = river;

        // Tile Four
        color = new Color(0,143,0);
        Tile mountains = new Tile(color);
        mountains.setName("Mountains");
        mountains.moveSpeed=2;
        forestTiles[3] = mountains;

        // Tile Five
        color = new Color(0,143,0);
        Tile lake = new Tile(color);
        lake.setName("Lake");
        lake.moveSpeed=5;
        forestTiles[4] = lake;

        // World Filling
        Picture[] picArray0 = {Picture.loadFromJar("tilePictures/10_0.jpg"),Picture.loadFromJar("tilePictures/10_1.jpg"),
                Picture.loadFromJar("tilePictures/10_2.jpg"),Picture.loadFromJar("tilePictures/10_3.jpg")};

        Picture[] picArray1 = {Picture.loadFromJar("tilePictures/11_0.jpg"),Picture.loadFromJar("tilePictures/11_1.jpg"),
                Picture.loadFromJar("tilePictures/11_2.jpg"),Picture.loadFromJar("tilePictures/11_3.jpg")};

        Picture[] picArray2 = {Picture.loadFromJar("tilePictures/12_0.jpg"),Picture.loadFromJar("tilePictures/12_1.jpg"),
                Picture.loadFromJar("tilePictures/12_2.jpg"),Picture.loadFromJar("tilePictures/12_3.jpg")};

        Picture[] picArray3 = {Picture.loadFromJar("tilePictures/13_0.jpg"),Picture.loadFromJar("tilePictures/13_1.jpg"),
                Picture.loadFromJar("tilePictures/13_2.jpg"),Picture.loadFromJar("tilePictures/13_3.jpg")};

        Picture[] picArray4 = {Picture.loadFromJar("tilePictures/14_0.jpg"),Picture.loadFromJar("tilePictures/14_1.jpg"),
                Picture.loadFromJar("tilePictures/14_2.jpg"),Picture.loadFromJar("tilePictures/14_3.jpg")};

        fillWorld(forestTiles[0],picArray0);
        generateBiome(praire,picArray1,15,100*(worldSize/500),15,1);
        generateBiome(mountains,picArray3,5,120*(worldSize/500),2,2);
        generateRiver(river,picArray2,3,10,1);
        generateLake(lake,picArray4,1,200*(worldSize/500));

        genCorn(pCount,forestTiles[1],picArray1);
        //genCorn(playerCount);
    }

    public void jungleGen()
    {
        Tile[] jungleTiles = new Tile[5]; 

        Color color = new Color(0,190,30);
        Tile jungle = new Tile(color);
        jungleTiles[0] = jungle;

        Picture[] picArray = {Picture.loadFromJar("tilePictures/00_0.jpg"),Picture.loadFromJar("tilePictures/00_1.jpg"),
                Picture.loadFromJar("tilePictures/00_2.jpg"),Picture.loadFromJar("tilePictures/00_3.jpg")};

        fillWorld(jungleTiles[0],picArray);

        //genCorn(playerCount);
    }

    public void tundraGen()
    {
        Tile[] tundraTiles = new Tile[5];

        // Tile One
        Color color = new Color(128,188,137);
        Tile snowyForest = new Tile(color);
        tundraTiles[0] = snowyForest;

        // World Filling
        Picture[] picArray = {Picture.loadFromJar("tilePictures/00_0.jpg"),Picture.loadFromJar("tilePictures/00_1.jpg"),
                Picture.loadFromJar("tilePictures/00_2.jpg"),Picture.loadFromJar("tilePictures/00_3.jpg")};

        fillWorld(tundraTiles[0],picArray);

        //genCorn(playerCount);
    }

    public void islandGen()
    {
        Tile[] islandTiles = new Tile[5];

        // Tile One
        Color color = new Color(0,167,255);
        Tile ocean = new Tile(color);
        islandTiles[0] = ocean;

        // World Filling
        Picture[] picArray = {Picture.loadFromJar("tilePictures/00_0.jpg"),Picture.loadFromJar("tilePictures/00_1.jpg"),
                Picture.loadFromJar("tilePictures/00_2.jpg"),Picture.loadFromJar("tilePictures/00_3.jpg")};

        fillWorld(islandTiles[0],picArray);

        //genCorn(playerCount);
    }

    public void swampGen()
    {
        Tile[] swampTiles = new Tile[5];

        // Tile One
        Color color = new Color(0,143,0);
        Tile stillWater = new Tile(color);
        swampTiles[0] = stillWater;

        // World Filling
        Picture[] picArray = {Picture.loadFromJar("tilePictures/00_0.jpg"),Picture.loadFromJar("tilePictures/00_1.jpg"),
                Picture.loadFromJar("tilePictures/00_2.jpg"),Picture.loadFromJar("tilePictures/00_3.jpg")};

        fillWorld(swampTiles[0],picArray);

        //genCorn(playerCount);
    }

    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //

    public void fillWorld(Tile tile,Picture[] picArray)
    {
        System.out.println("Filling world with '"+tile.getName()+"'");
        for (int i = 0; i < worldSize; i++)
        {
            for (int k = 0; k < worldSize; k++)
            {
                int randMath = (int)(Math.random()*picArray.length);
                Tile tmpTile = new Tile(tile.getColor());
                tmpTile.setName(tile.getName());
                tmpTile.setPicture(picArray[randMath]);
                tmpTile.moveSpeed = tile.moveSpeed;
                outTerrain[i][k] = tmpTile;
            }
        }
    }

    public void generateBiome(Tile tile, Picture[] picArray, int count, int biomeSize, int cycles, int cyclesPer)
    {
        for (int i = 0; i < count; i++)
        {
            int randX = (int)(Math.random()*worldSize);
            int randY = (int)(Math.random()*worldSize);
            System.out.println("Generating '"+tile.getName()+"' generic biome, number "+(i+1+": "+randX+","+randY));
            for (int xCord = -(biomeSize/2); xCord < biomeSize/2; xCord++)
            {
                for (int yCord = -(biomeSize/2); yCord < biomeSize/2; yCord++)
                {
                    int randMath = (int)(Math.random()*picArray.length);
                    Tile tmpTile = new Tile(tile.getColor());
                    tmpTile.setName(tile.getName());
                    tmpTile.setPicture(picArray[randMath]);
                    tmpTile.moveSpeed = tile.moveSpeed;
                    int distance = distanceFormula(randX,randY,randX+xCord,randY+yCord);
                    if (xCord+randX >= 0 && xCord+randX < worldSize && yCord +randY >= 0 && yCord + randY < worldSize && distance<biomeSize/2)
                        outTerrain[xCord+randX][yCord+randY] = tmpTile;
                }                
            }
            erodeAddition(tile,picArray,randX,randY,biomeSize,cycles,cyclesPer);
        }
    }

    public void generateLake(Tile tile, Picture[] picArray, int count,int biomeSize)
    {
        for (int i = 0; i < count; i++)
        {
            int randX = (int)(Math.random()*worldSize);
            int randY = (int)(Math.random()*worldSize);
            System.out.println("Generating '"+tile.getName()+"' lake biome, number "+(i+1)+": "+randX+","+randY);
            for (int xCord = -(biomeSize/2); xCord < biomeSize/2; xCord++)
            {
                for (int yCord = -(biomeSize/2); yCord < biomeSize/2; yCord++)
                {
                    int randMath = (int)(Math.random()*picArray.length);
                    Tile tmpTile = new Tile(tile.getColor());
                    tmpTile.setName(tile.getName());
                    tmpTile.setPicture(picArray[randMath]);
                    tmpTile.moveSpeed = tile.moveSpeed;
                    int distance = distanceFormula(randX,randY,randX+xCord,randY+yCord);
                    if (xCord+randX >= 0 && xCord+randX < worldSize && yCord +randY >= 0 && yCord + randY < worldSize && distance<biomeSize/2)
                        outTerrain[xCord+randX][yCord+randY] = tmpTile;
                }                
            }
        }
    }

    public void generateOcean(Tile tile, Picture[] picArray, int depth)
    {
        System.out.println("Generating '"+tile.getName()+"' ocean biome");
        for (int i = 0; i < worldSize; i++)
        {
            for (int k = 0; k < worldSize; k++)
            {
                if (i<0+depth||k<0+depth||i>worldSize-depth||k>worldSize-depth)
                {
                    int randMath = (int)(Math.random()*picArray.length);
                    Tile tmpTile = new Tile(tile.getColor());
                    tmpTile.setName(tile.getName());
                    tmpTile.setPicture(picArray[randMath]);
                    tmpTile.moveSpeed = tile.moveSpeed;
                    outTerrain[i][k]=tmpTile;

                    int randMath2 = (int)(Math.random()*20);
                    if (randMath2==0)
                    {
                        generateCircle(tile,picArray,i,k,depth*2);
                    }
                }
            }
        }
    }

    public void generateCircle(Tile tile, Picture[] picArray, int xCordIn, int yCordIn, int diameter)
    {

        int randX = xCordIn;
        int randY = yCordIn;

        for (int xCord = -(diameter/2); xCord < diameter/2; xCord++)
        {
            for (int yCord = -(diameter/2); yCord < diameter/2; yCord++)
            {
                int randMath = (int)(Math.random()*picArray.length);
                Tile tmpTile = new Tile(tile.getColor());
                Color black = new Color(0,0,0);
                tmpTile.setColor(black);
                tmpTile.setName(tile.getName());
                tmpTile.setPicture(picArray[randMath]);
                tmpTile.moveSpeed = tile.moveSpeed;
                int distance = distanceFormula(randX,randY,randX+xCord,randY+yCord);
                if (xCord+randX >= 0 && xCord+randX < worldSize && yCord +randY >= 0 && yCord + randY < worldSize && distance<diameter/2)
                    outTerrain[xCord+randX][yCord+randY] = tmpTile;
            }                

        }
    }

    public void erodeAddition(Tile tile, Picture[] picArray, int coreX, int coreY, int diameter, int cycles, int cyclesPer)
    {
        // Cycles is how many times to make the circles decrease size
        // Cycles per is how many similarly sized circles to generate

        int r = diameter/2;
        int h = coreX;
        int k = coreY;
        int x = (int)((Math.random()*(2*r) )+(h-diameter/2));
        int y = (int)((Math.random()*(2*r) )+(k-diameter/2));
        for (int j = 0; j < cycles; j++)
        {
            for (int i = 0; i < cyclesPer; i++)
            {
                while (distanceFormula(h,k,x,y)<(diameter/2))
                {
                    x = (int)((Math.random()*2*r)+(h-diameter/2));
                    y = (int)((Math.random()*2*r)+(k-diameter/2));
                }
                System.out.println("          Generating '"+tile.getName()+"' errosion, size of "+r+", number "+(j+1)+": "+x+","+y);
                generateCircle(tile,picArray,x,y,r);  
                x = (int)((Math.random()*2*r)+(h-diameter/2));
                y = (int)((Math.random()*2*r)+(k-diameter/2));
            }
            int newR = r;
            if (cycles!=1)
                erodeAddition(tile,picArray,x,y,newR,1,1);
        }
    }

    public void generateRiver(Tile tile, Picture[] picArray, int count, int width, int bendCount)
    {
        int[] selc = {0,499};
        double slope = 99;

        for (int i = 0; i < count; i++)
        {

            // 0 = Top, 1 = Bottom, 2 = Left, 3 = Right 

            int startX = (int)(Math.random()*worldSize);
            int startY = (int)(Math.random()*worldSize);

            int sideChoosing = (int)(Math.random()*4);
            if (sideChoosing<2)
                startY = selc[sideChoosing];
            else
                startX = selc[sideChoosing-2];

            int endX = (int)(Math.random()*worldSize);
            int endY = (int)(Math.random()*worldSize);

            sideChoosing = (int)(Math.random()*4);
            if (sideChoosing<2)
                endY = selc[sideChoosing];
            else
                endX = selc[sideChoosing-2];
 
            System.out.println("Generating river, from "+startX+","+startY+" to "+endX+","+endY);
            generateLine(tile,picArray,width,startY,startX,endY,endX);
        }
    }

    public void generateLine(Tile tile, Picture[] picArray, int width, int startX, int startY, int endX, int endY)
    {     
        double slope = getSlope(startX,startY,endX,endY);
        double yInt = (double)startY - (slope*(double)startX);
        for (int xCord = 0; xCord < worldSize; xCord++)
        {
            double yCord = (slope*xCord) + yInt;
            int largestX = endX;
            int smallestX = startX;
            if (startX>endX)
            {
                largestX = startX;
                smallestX = endX;
            }

            if (yCord > 0 && yCord < worldSize && xCord > smallestX && xCord < largestX)
            {
                generateCircle(tile,picArray,(int)yCord,xCord,width);
            }
        }

        for (int yCord = 0; yCord < worldSize; yCord++)
        {
            double xCord = (yCord-yInt)/slope;
            int largestY = endY;
            int smallestY = startY;
            if (startY>endY)
            {
                largestY = startY;
                smallestY = endY;
            }

            if (xCord > 0 && xCord < worldSize && yCord > smallestY && yCord < largestY)
            {
                generateCircle(tile,picArray,(int)yCord,(int)xCord,width);
            }
        }
    }
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //

    public void generateCornCircle(Tile tile, Picture[] picArray, int count,int biomeSize)
    {
        for (int i = 0; i < count; i++)
        {
            int randX = worldSize/2;
            int randY = worldSize/2;

            for (int xCord = -(biomeSize/2); xCord < biomeSize/2; xCord++)
            {
                for (int yCord = -(biomeSize/2); yCord < biomeSize/2; yCord++)
                {
                    int randMath = (int)(Math.random()*picArray.length);
                    Tile tmpTile = new Tile(tile.getColor());
                    tmpTile.setName(tile.getName());
                    tmpTile.setPicture(picArray[randMath]);
                    tmpTile.moveSpeed = tile.moveSpeed;
                    int distance = distanceFormula(randX,randY,randX+xCord,randY+yCord);
                    if (xCord+randX >= 0 && xCord+randX < worldSize && yCord +randY >= 0 && yCord + randY < worldSize && distance<biomeSize/2)
                        outTerrain[xCord+randX][yCord+randY] = tmpTile;
                }                
            }
        }
    }

    public void genCorn(int pCount, Tile centerTile, Picture[] picArray)
    {
        System.out.println("Generating Cornucoppia");
        int centerX = worldSize/2;
        int centerY = worldSize/2;
        int radius = 10 + pCount/2;
        generateCornCircle(centerTile,picArray,1,radius+30);
        double angleIncrement = 2*3.14159 / pCount;
        double angCount = 0;
        //System.out.println(angleIncrement);
        for (int i = 0; i < pCount; i++)
        {
            // Generating Pedastals...
            Color pedColor = new Color(200,200,200);
            Tile tmpTile = new Tile(pedColor);
            tmpTile.setName("Pedastal");
            tmpTile.moveSpeed = 0;
            double tileY = java.lang.Math.sin(angCount);
            double tileX = java.lang.Math.cos(angCount);
            //System.out.println("AngCount:"+angCount);
            //System.out.println("TILEX,TILEY:"+tileX+","+tileY);
            angCount+=angleIncrement;
            tileY = tileY*radius;
            tileX = tileX*radius;
            tileY+=centerY;
            tileX+=centerX;
            //System.out.println("CORDX,CORDY"+tileX+","+tileY);
            outTerrain[(int)tileX][(int)tileY]=tmpTile;
            //Player tmpPlayer = Controller.getPlayerList()[i];
            //tmpPlayer.setXPos( (int)(tileX) );
            //tmpPlayer.setYPos( (int)(tileY) );
            //Controller.updatePlayer(tmpPlayer);            
        }
        radius = pCount/2;
        angleIncrement = 2*3.14159 / (pCount-1);
        angCount = 0;
        for (int i = 0; i < pCount; i++)
        {                        
            // Generating crates...
            Color crateColor = new Color(0,0,0);
            Tile tmpTile = new Tile(crateColor);
            tmpTile.setName("Crate");
            tmpTile.moveSpeed = 1;
            double tileY = java.lang.Math.sin(angCount);
            double tileX = java.lang.Math.cos(angCount);
            //System.out.println("AngCount:"+angCount);
            //System.out.println("TILEX,TILEY:"+tileX+","+tileY);
            angCount+=angleIncrement;
            tileY = tileY*radius;
            tileX = tileX*radius;
            tileY+=centerY;
            tileX+=centerX;
            //System.out.println("CORDX,CORDY"+tileX+","+tileY);
            outTerrain[(int)tileX][(int)tileY]=tmpTile;
            //Player tmpPlayer = Controller.getPlayerList()[i];
            //tmpPlayer.setXPos( (int)(tileX) );
            //tmpPlayer.setYPos( (int)(tileY) );
            //Controller.updatePlayer(tmpPlayer);
        }
    }

    public int getLargest(int one, int two)
    {
        if (one>two)
            return one;
        else
            return two;
    }

    public int getSmallest(int one, int two)
    {
        if (one>two)
            return two;
        else
            return one;
    }

    public double getSlope(int startX, int startY, int endX, int endY)
    {
        double slope = ((double)endY-(double)startY)/((double)endX-(double)startX);
        return slope;
    }

    public static int distanceFormula(int orX, int orY, int sX, int sY)
    {
        int firstHalf;
        int secondHalf;
        if (orX > sX)
            firstHalf = orX - sX;
        else
            firstHalf = sX - orX;
        firstHalf = firstHalf*firstHalf;
        if (orY>sY)
            secondHalf = orY - sY;
        else    
            secondHalf = sY - orY;
        secondHalf = secondHalf*secondHalf;

        int sqrtPart = firstHalf+secondHalf;
        double distance = java.lang.Math.sqrt(sqrtPart);
        return (int)distance;
    }
}