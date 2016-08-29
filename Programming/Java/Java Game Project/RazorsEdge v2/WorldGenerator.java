import java.awt.Color;
import sacco.*;
public class WorldGenerator
{
    static Tile[][] outTerrain;
    Tile concrete;
    static int worldSize;
    int pCount;
    int sightRange;

    public Tile[][] worldGen(int biomeType, int worldSizeIn, int playerCount)
    {
        System.out.println("= = = = = W O R L D G E N = = = = =");
        Color gray = new Color(200,200,200);
        concrete = new Tile(gray);
        concrete.setName("Concrete");
        worldSize = worldSizeIn;
        outTerrain = new Tile[worldSize][worldSize];
        pCount = playerCount;

        if (biomeType == 0)
        {
            // Desert Generation
            desertGen();
            sightRange = 500;
        }
        if (biomeType == 1)
        {
            // Forest Generation
            forestGen();
            sightRange = 500;
        }
        if (biomeType == 2)
        {
            // Jungle Generation
            jungleGen();
            sightRange = 500;
        }
        if (biomeType == 3)
        {
            // Tundra Generation
            tundraGen();
            sightRange = 500;
        }
        if (biomeType == 4)
        {
            // Island Generation
            islandGen();
            sightRange = 500;
        }
        if (biomeType == 5)
        {
            // Swamp Generation
            swampGen();
            sightRange = 500;
        } 
        if (biomeType == -1)
        {
            autunite();
            sightRange = 500;
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
        rockyDesert.sight = 1;
        desertTiles[0] = rockyDesert;

        // Tile Two
        color = new Color(150,150,0);
        Tile sandDunes = new Tile(color);
        sandDunes.setName("Sand Dunes");
        sandDunes.moveSpeed = 1.5;
        sandDunes.sight = 1.2;
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
        desertMountain.sight = 3;
        desertTiles[3] = desertMountain;

        // Tile Five
        color = new Color(0,0,200);
        Tile oasis = new Tile(color);
        oasis.setName("Oasis");
        oasis.moveSpeed = 5;
        oasis.sight = 0.8;
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
        generateBiome(sandDunes,picArray1,8,125*(worldSize/500),15,1);
        generateLake(deadLake,picArray2,3,45*(worldSize/500));
        generateBiome(desertMountain,picArray3,2,75*(worldSize/500),2,2);
        generateLake(oasis,picArray4,1,20*(worldSize/500));

        genCorn(pCount,desertTiles[0],picArray0);

        // Testing
        //generateCircle(desertTiles[1],picArray1,250,250,100);
        //erodeAddition(desertTiles[1],picArray1,250,250,100,10,1);
        //generateRiver(desertTiles[4],picArray4,1,10,20);
    }

    public void forestGen()
    {
        Tile[] forestTiles = new Tile[5];

        // Tile One
        Color color = new Color(0,143,0);
        Tile forest = new Tile(color);
        forest.setName("Forest");
        forest.sight = 0.8;
        forestTiles[0] = forest;

        // Tile Two
        color = new Color(0,143,0);
        Tile praire = new Tile(color);
        praire.setName("Praire");
        praire.sight = 1;
        forestTiles[1] = praire;

        // Tile Three
        color = new Color(0,143,0);
        Tile river = new Tile(color);
        river.setName("River");
        river.moveSpeed=5;
        river.sight = 1;
        forestTiles[2] = river;

        // Tile Four
        color = new Color(0,143,0);
        Tile hills = new Tile(color);
        hills.setName("Forested Hills");
        hills.moveSpeed=2;
        hills.sight = 2;
        forestTiles[3] = hills;

        // Tile Five
        color = new Color(0,143,0);
        Tile lake = new Tile(color);
        lake.setName("Lake");
        lake.moveSpeed=5;
        lake.sight = 0.5;
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
        generateBiome(hills,picArray3,5,120*(worldSize/500),2,2);
        generateRiver(river,picArray2,1,7,50);
        generateLake(lake,picArray4,1,200*(worldSize/500));

        genCorn(pCount,forestTiles[1],picArray1);        
    }

    public void jungleGen()
    {
        Tile[] jungleTiles = new Tile[5]; 

        // Tile One
        Color color = new Color(0,143,0);
        Tile jungle = new Tile(color);
        jungle.setName("Jungle");
        jungle.sight = 0.8;
        jungleTiles[0] = jungle;

        // Tile Two
        color = new Color(0,143,0);
        Tile deepJungle = new Tile(color);
        deepJungle.setName("Deep Jungle");
        deepJungle.moveSpeed=2;
        deepJungle.sight = 0.5;
        jungleTiles[1] = deepJungle;

        // Tile Three
        color = new Color(0,143,0);
        Tile river = new Tile(color);
        river.setName("River");
        river.moveSpeed=5;
        river.sight = 0.8;
        jungleTiles[2] = river;

        // Tile Four
        color = new Color(0,143,0);
        Tile jungleHills = new Tile(color);
        jungleHills.setName("Jungle Hills");
        jungleHills.moveSpeed=2;
        jungleHills.sight = 3;
        jungleTiles[3] = jungleHills;

        // Tile Five
        color = new Color(0,143,0);
        Tile ruins = new Tile(color);
        ruins.setName("Ruins");
        ruins.moveSpeed=1;
        ruins.sight = 1;
        jungleTiles[4] = ruins;

        Picture[] picArray0 = {Picture.loadFromJar("tilePictures/20_0.jpg"),Picture.loadFromJar("tilePictures/20_1.jpg"),
                Picture.loadFromJar("tilePictures/20_2.jpg"),Picture.loadFromJar("tilePictures/20_3.jpg")};

        Picture[] picArray1 = {Picture.loadFromJar("tilePictures/21_0.jpg"),Picture.loadFromJar("tilePictures/21_1.jpg"),
                Picture.loadFromJar("tilePictures/21_2.jpg"),Picture.loadFromJar("tilePictures/21_3.jpg")};

        Picture[] picArray2 = {Picture.loadFromJar("tilePictures/22_0.jpg"),Picture.loadFromJar("tilePictures/22_1.jpg"),
                Picture.loadFromJar("tilePictures/22_2.jpg"),Picture.loadFromJar("tilePictures/22_3.jpg")};

        Picture[] picArray3 = {Picture.loadFromJar("tilePictures/23_0.jpg"),Picture.loadFromJar("tilePictures/23_1.jpg"),
                Picture.loadFromJar("tilePictures/23_2.jpg"),Picture.loadFromJar("tilePictures/23_3.jpg")};

        Picture[] picArray4 = {Picture.loadFromJar("tilePictures/24_0.jpg"),Picture.loadFromJar("tilePictures/24_1.jpg"),
                Picture.loadFromJar("tilePictures/24_2.jpg"),Picture.loadFromJar("tilePictures/24_3.jpg")};

        fillWorld(jungleTiles[0],picArray0);
        generateBiome(jungleTiles[1],picArray1,6,150*(worldSize/500),5,5);
        generateBiome(jungleTiles[3],picArray3,3,90*(worldSize/500),2,2);
        generateRuins(jungleTiles[4],picArray4,2,25,25,10);
        generateRiver(jungleTiles[2],picArray2,1,20,100);

        Picture[] picArrayCon = {Picture.loadFromJar("tilePictures/Misc/99_0.jpg")};
        genCorn(pCount,concrete,picArrayCon);        
        //genCorn(playerCount);
    }

    public void tundraGen()
    {
        Tile[] tundraTiles = new Tile[5]; 

        // Tile One
        Color color = new Color(0,143,0);
        Tile snowyForest = new Tile(color);
        snowyForest.setName("Snowy Forest");
        snowyForest.sight = 0.8;
        tundraTiles[0] = snowyForest;

        // Tile Two
        color = new Color(0,143,0);
        Tile tundra = new Tile(color);
        tundra.setName("Tundra");
        tundra.sight = 1;
        tundraTiles[1] = tundra;

        // Tile Three
        color = new Color(0,143,0);
        Tile frozenRiver = new Tile(color);
        frozenRiver.setName("FrozenRiver");
        frozenRiver.sight = 1;
        tundraTiles[2] = frozenRiver;

        // Tile Four
        color = new Color(0,143,0);
        Tile icyCrags = new Tile(color);
        icyCrags.setName("Icy Crags");
        icyCrags.moveSpeed=2;
        icyCrags.sight = 3;
        tundraTiles[3] = icyCrags;

        // Tile Five
        color = new Color(0,143,0);
        Tile geyser = new Tile(color);
        geyser.setName("Geyser");
        geyser.moveSpeed=1;
        geyser.sight = 1;
        tundraTiles[4] = geyser;

        Picture[] picArray0 = {Picture.loadFromJar("tilePictures/30_0.jpg"),Picture.loadFromJar("tilePictures/30_1.jpg"),
                Picture.loadFromJar("tilePictures/30_2.jpg"),Picture.loadFromJar("tilePictures/30_3.jpg")};

        Picture[] picArray1 = {Picture.loadFromJar("tilePictures/31_0.jpg"),Picture.loadFromJar("tilePictures/31_1.jpg"),
                Picture.loadFromJar("tilePictures/31_2.jpg"),Picture.loadFromJar("tilePictures/31_3.jpg")};

        Picture[] picArray2 = {Picture.loadFromJar("tilePictures/32_0.jpg"),Picture.loadFromJar("tilePictures/32_1.jpg"),
                Picture.loadFromJar("tilePictures/32_2.jpg"),Picture.loadFromJar("tilePictures/32_3.jpg")};

        Picture[] picArray3 = {Picture.loadFromJar("tilePictures/33_0.jpg"),Picture.loadFromJar("tilePictures/33_1.jpg"),
                Picture.loadFromJar("tilePictures/33_2.jpg"),Picture.loadFromJar("tilePictures/33_3.jpg")};

        Picture[] picArray4 = {Picture.loadFromJar("tilePictures/34_0.jpg"),Picture.loadFromJar("tilePictures/34_1.jpg"),
                Picture.loadFromJar("tilePictures/34_2.jpg"),Picture.loadFromJar("tilePictures/34_3.jpg")};

        fillWorld(tundraTiles[0],picArray0);
        generateBiome(tundraTiles[1],picArray1,6,175*(worldSize/500),8,4);
        generateBiome(tundraTiles[3],picArray3,3,60*(worldSize/500),2,2);
        generateBiome(tundraTiles[4],picArray4,2,25,0,0);

        genCorn(pCount,tundraTiles[1],picArray1); 
        generateRiver(tundraTiles[2],picArray2,2,10,20);
        //genCorn(playerCount);
    }

    public void islandGen()
    {
        Tile[] islandTiles = new Tile[5]; 

        // Tile One
        Color color = new Color(0,143,0);
        Tile beach = new Tile(color);
        beach.setName("Beach");
        beach.sight = 1;
        beach.moveSpeed = 0.5;
        islandTiles[0] = beach;

        // Tile Two
        color = new Color(0,143,0);
        Tile ocean = new Tile(color);
        ocean.setName("Ocean");
        ocean.sight = 0.5;
        ocean.moveSpeed = 3;
        islandTiles[1] = ocean;

        // Tile Three
        color = new Color(0,143,0);
        Tile forest = new Tile(color);
        forest.setName("Forest");
        forest.sight = 0.8;
        forest.moveSpeed = 1.5;
        islandTiles[2] = forest;

        // Tile Four
        color = new Color(0,143,0);
        Tile grassland = new Tile(color);
        grassland.setName("Grasslands");
        grassland.moveSpeed = 1;
        grassland.sight = 1.2;
        islandTiles[3] = grassland;

        // Tile Five
        color = new Color(0,143,0);
        Tile mountain = new Tile(color);
        mountain.setName("Mountains");
        mountain.moveSpeed = 2;
        mountain.sight = 1.5;
        islandTiles[4] = mountain;

        Picture[] picArray0 = {Picture.loadFromJar("tilePictures/40_0.jpg"),Picture.loadFromJar("tilePictures/40_1.jpg"),
                Picture.loadFromJar("tilePictures/40_2.jpg"),Picture.loadFromJar("tilePictures/40_3.jpg")};

        Picture[] picArray1 = {Picture.loadFromJar("tilePictures/41_0.jpg"),Picture.loadFromJar("tilePictures/41_1.jpg"),
                Picture.loadFromJar("tilePictures/41_2.jpg"),Picture.loadFromJar("tilePictures/41_3.jpg")};

        Picture[] picArray2 = {Picture.loadFromJar("tilePictures/42_0.jpg"),Picture.loadFromJar("tilePictures/42_1.jpg"),
                Picture.loadFromJar("tilePictures/42_2.jpg"),Picture.loadFromJar("tilePictures/42_3.jpg")};

        Picture[] picArray3 = {Picture.loadFromJar("tilePictures/43_0.jpg"),Picture.loadFromJar("tilePictures/43_1.jpg"),
                Picture.loadFromJar("tilePictures/43_2.jpg"),Picture.loadFromJar("tilePictures/43_3.jpg")};

        Picture[] picArray4 = {Picture.loadFromJar("tilePictures/44_0.jpg"),Picture.loadFromJar("tilePictures/44_1.jpg"),
                Picture.loadFromJar("tilePictures/44_2.jpg"),Picture.loadFromJar("tilePictures/44_3.jpg")};

        fillWorld(islandTiles[1],picArray1);
        generateBiome(islandTiles[3],picArray3,10,40*(worldSize/500),2,3);
        generateBiome(islandTiles[2],picArray2,5,60*(worldSize/500),2,3);
        generateBiome(islandTiles[4],picArray4,3,80*(worldSize/500),2,2);

        Picture[] picArrayCon = {Picture.loadFromJar("tilePictures/Misc/99_0.jpg")};
        genCorn(pCount,islandTiles[3],picArray3);     

        generateLip(islandTiles[0],picArray0,islandTiles[1],3,-1);
        //genCorn(playerCount);
    }

    public void swampGen()
    {
        Tile[] swampTiles = new Tile[5]; 

        // Tile One
        Color color = new Color(0,143,0);
        Tile stillWater = new Tile(color);
        stillWater.setName("Stagnate Water");
        stillWater.moveSpeed = 2;
        stillWater.sight = 0.8;
        swampTiles[0] = stillWater;

        // Tile Two
        color = new Color(0,143,0);
        Tile mud = new Tile(color);
        mud.setName("Mud");
        mud.moveSpeed = 1.5;
        mud.sight = 1;
        swampTiles[1] = mud;

        // Tile Three
        color = new Color(0,143,0);
        Tile fWater = new Tile(color);
        fWater.moveSpeed = 2;
        fWater.setName("Fresh Water");
        fWater.sight = 0.8;
        swampTiles[2] = fWater;

        // Tile Four
        color = new Color(0,143,0);
        Tile marsh = new Tile(color);
        marsh.setName("Marsh");
        marsh.moveSpeed = 1.5;
        marsh.sight = 0.5;
        swampTiles[3] = marsh;

        // Tile Five
        color = new Color(0,143,0);
        Tile forest = new Tile(color);
        forest.setName("Sick Forest");
        forest.moveSpeed=1;
        forest.sight = 0.8;
        swampTiles[4] = forest;

        Picture[] picArray0 = {Picture.loadFromJar("tilePictures/50_0.jpg"),Picture.loadFromJar("tilePictures/50_1.jpg"),
                Picture.loadFromJar("tilePictures/50_2.jpg"),Picture.loadFromJar("tilePictures/50_3.jpg")};

        Picture[] picArray1 = {Picture.loadFromJar("tilePictures/51_0.jpg"),Picture.loadFromJar("tilePictures/51_1.jpg"),
                Picture.loadFromJar("tilePictures/51_2.jpg"),Picture.loadFromJar("tilePictures/51_3.jpg")};

        Picture[] picArray2 = {Picture.loadFromJar("tilePictures/52_0.jpg"),Picture.loadFromJar("tilePictures/52_1.jpg"),
                Picture.loadFromJar("tilePictures/52_2.jpg"),Picture.loadFromJar("tilePictures/52_3.jpg")};

        Picture[] picArray3 = {Picture.loadFromJar("tilePictures/53_0.jpg"),Picture.loadFromJar("tilePictures/53_1.jpg"),
                Picture.loadFromJar("tilePictures/53_2.jpg"),Picture.loadFromJar("tilePictures/53_3.jpg")};

        Picture[] picArray4 = {Picture.loadFromJar("tilePictures/54_0.jpg"),Picture.loadFromJar("tilePictures/54_1.jpg"),
                Picture.loadFromJar("tilePictures/54_2.jpg"),Picture.loadFromJar("tilePictures/54_3.jpg")};

        fillWorld(swampTiles[0],picArray0);
        generateBiome(swampTiles[3],picArray3,50,50*(worldSize/500),5,15);
        generateBiome(swampTiles[4],picArray4,1,70*(worldSize/500),5,5);
        generateLake(swampTiles[2],picArray2,1,50*(worldSize/500));
        generateLip(swampTiles[1],picArray1,swampTiles[0],5,-5);

        Picture[] picArrayCon = {Picture.loadFromJar("tilePictures/Misc/99_0.jpg")};
        genCorn(pCount,concrete,picArrayCon);        
    }

    public void autunite()
    {
        Color color = new Color(150,0,0);
        Tile lava = new Tile(color);
        lava.setName("Lava");
        lava.moveSpeed = 1;
        lava.sight = 1;
        
        Picture[] lavaPic = {Picture.loadFromJar("tilePictures/Misc/Lava/lava0.jpg"),Picture.loadFromJar("tilePictures/Misc/Lava/lava1.jpg"),
                Picture.loadFromJar("tilePictures/Misc/Lava/lava2.jpg"),Picture.loadFromJar("tilePictures/Misc/Lava/lava3.jpg")};

        fillWorld(lava,lavaPic);
        Picture[] picArrayCon = {Picture.loadFromJar("tilePictures/Misc/99_0.jpg")};
        genCorn(pCount,concrete,picArrayCon); 
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
                tmpTile.setSight(tile.getSight());
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
                    tmpTile.setSight(tile.getSight());
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
                    tmpTile.setSight(tile.getSight());
                    int distance = distanceFormula(randX,randY,randX+xCord,randY+yCord);
                    if (xCord+randX >= 0 && xCord+randX < worldSize && yCord +randY >= 0 && yCord + randY < worldSize && distance<biomeSize/2)
                        outTerrain[xCord+randX][yCord+randY] = tmpTile;
                }                
            }
            erodeAddition(tile,picArray,randX,randY,biomeSize,1,3);
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
                    tmpTile.setSight(tile.getSight());
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

    public void generateRiver(Tile tile, Picture[] picArray, int count, int width, int bendSize)
    {
        int[] selc = {0,(worldSize-1)};

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

            while (startX==endX)
            {
                sideChoosing = (int)(Math.random()*4);
                if (sideChoosing<2)
                    startY = selc[sideChoosing];
                else
                    startX = selc[sideChoosing-2];
            }

            while (startY==endY)
            {
                sideChoosing = (int)(Math.random()*4);
                if (sideChoosing<2)
                    endY = selc[sideChoosing];
                else
                    endX = selc[sideChoosing-2];
            }

            double startXCord = startX;
            double endXCord = endX;
            if (startX>endX)
            {
                startXCord = endX;
                endXCord = startX;
            }
            double startYCord = startY;
            double endYCord = endY;
            if ((int)startXCord == endX)
            {
                startYCord = endY;
                endYCord = startY;
            }

            double length = java.lang.Math.abs(startX-endX);
            double distance = distanceFormula(startX,startY,endX,endY);
            int bendCount = (int)(distance/50);
            double diviser = length/(bendCount+1);
            double slope = getSlope(startX,startY,endX,endY);
            double yInt = (double)startY - (slope*(double)startX);

            //System.out.println(slope);

            double sXPos = startXCord;
            double sYPos = startYCord;

            System.out.println("Generating river from "+startX+","+startY+" to "+endX+","+endY);
            for (int b = 0; b < bendCount-1; b++)
            {
                double eXPos = startXCord+diviser;
                double eYPos = (eXPos*slope) + yInt;

                double randX = ( (Math.random()*bendSize)-(bendSize/2) );
                double randY = ( (Math.random()*bendSize)-(bendSize/2) );

                eXPos+=randX;
                eYPos+=randY;

                generateLine(tile,picArray,width,(int)sXPos,(int)sYPos,(int)eXPos,(int)eYPos);
                System.out.println("Generating river bend from "+(int)sXPos+","+(int)sYPos+" to "+(int)eXPos+","+eYPos);

                startXCord+=diviser;
                sXPos = eXPos;
                sYPos = eYPos;
            }

            generateLine(tile,picArray,width,(int)sXPos,(int)sYPos,(int)endXCord,(int)endYCord);
        }
    }

    public void generateRuins(Tile tile, Picture[] picArray, int amount, int width, int height, int eNum)
    {
        for (int c = 0; c < amount; c ++)
        {
            int randX = (int)(Math.random()*worldSize);
            int randY = (int)(Math.random()*worldSize);

            generateRectangle(tile,picArray,randX,randY,width,height); 
            for (int i = 0; i < eNum; i++)
            {
                int cordX = (int)(Math.random()*width)+randX;
                int cordY = (int)(Math.random()*height)+randY;
                double distance = distanceFormula( (randX+width)/2,(randY+height)/2,cordX,cordY);
                while (distance < width/2 || distance < height/2)
                {
                    cordX = (int)(Math.random()*width)+randX;
                    cordY = (int)(Math.random()*height)+randY;
                }
                generateRectangle(tile,picArray,cordX,cordY,width/2,height/2);
            }
            System.out.println("Generating '"+tile.getName()+"' rectangle at "+randX+","+randY);
        }
    }

    public void generateLip(Tile tile, Picture[] picArray, Tile tarTile, int depth, int cZ)
    {
        if (depth==1)
            System.out.println("Generating '"+tile.getName()+"' lip on '"+tarTile.getName());
        if (depth>1)
            System.out.println("          Generating sublip");  
        for (int x = 0; x < worldSize; x++)
        {
            for (int y = 0; y < worldSize; y++)
            {
                int count = countAdjacent(tarTile,x,y);
                if (count >= 1)
                {
                    if (!(outTerrain[x][y].getName().equals(tarTile.getName())))
                    {
                        int rMath = (int)(Math.random()*cZ);
                        if (rMath<=0)
                        {
                            int randMath = (int)(Math.random()*picArray.length);
                            Tile tmpTile = new Tile(tile.getColor());
                            Color black = new Color(0,0,0);
                            tmpTile.setColor(black);
                            tmpTile.setName("REPLACEME");
                            tmpTile.setPicture(picArray[randMath]);
                            tmpTile.moveSpeed = tile.moveSpeed;
                            tmpTile.setSight(tile.getSight());
                            outTerrain[x][y]=tmpTile;
                        }
                    }
                }
            }
        }
        // Moving over replaced tiles
        for (int x = 0; x < worldSize; x++)
        {
            for (int y = 0; y < worldSize; y++)
            {
                if (outTerrain[x][y].getName().equals("REPLACEME"))
                {
                    int randMath = (int)(Math.random()*picArray.length);
                    Tile tmpTile = new Tile(tile.getColor());
                    Color black = new Color(0,0,0);
                    tmpTile.setColor(black);
                    tmpTile.setName(tile.getName());
                    tmpTile.setPicture(picArray[randMath]);
                    tmpTile.moveSpeed = tile.moveSpeed;
                    tmpTile.setSight(tile.getSight());

                    outTerrain[x][y]=tmpTile;
                }
            }
        }
        if (depth>0)
        {
            generateLip(tile,picArray,tile,depth-cZ,cZ+1);
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
                int changingWidth = (int)(Math.random()*width/2);
                changingWidth = width+changingWidth;
                generateCircle(tile,picArray,(int)yCord,xCord,changingWidth);
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

    public void generateRectangle(Tile tile, Picture[] picArray, int inX, int inY, int width, int height)
    {
        // Generating rectangle
        for (int w = 0; w < width; w++)
        {
            for (int h = 0; h < height; h++)
            {
                int randMath = (int)(Math.random()*picArray.length);
                Tile tmpTile = new Tile(tile.getColor());
                Color black = new Color(0,0,0);
                tmpTile.setColor(black);
                tmpTile.setName(tile.getName());
                tmpTile.setPicture(picArray[randMath]);
                tmpTile.moveSpeed = tile.moveSpeed;
                tmpTile.setSight(tile.getSight());

                if (h+inY > 0 && h+inY < worldSize && w+inX > 0 && w+inX < worldSize)
                    outTerrain[h+inY][w+inX] = tmpTile;
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
                tmpTile.setSight(tile.getSight());
                
                int distance = distanceFormula(randX,randY,randX+xCord,randY+yCord);
                if (xCord+randX >= 0 && xCord+randX < worldSize && yCord +randY >= 0 && yCord + randY < worldSize && distance<diameter/2)
                {
                    outTerrain[xCord+randX][yCord+randY] = tmpTile;
                }
            }                

        }
    }

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
                    Tile tmpTile = new Tile(tile.getColor());
                    tmpTile.setName(tile.getName());
                    if(picArray!=null)
                    {
                        int randMath = (int)(Math.random()*picArray.length);
                        tmpTile.setPicture(picArray[randMath]);
                    }
                    tmpTile.moveSpeed = tile.moveSpeed;
                    tmpTile.setSight(tile.getSight());
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
        //System.out.println(angleIncrement);xfgnbh
        for (int i = 0; i < pCount; i++)
        {
            // Generating Pedastals...
            Color pedColor = new Color(200,200,200);
            Tile tmpTile = new Tile(pedColor);
            tmpTile.setPicture(Picture.loadFromJar("tilePictures/Misc/99_1.jpg"));
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
        for (int i = 0; i < pCount-1; i++)
        {                        
            // Generating crates...
            Color crateColor = new Color(0,0,0);
            Tile tmpTile = new Tile(crateColor);
            tmpTile.setName("Unopened Crate");
            tmpTile.setPicture(Picture.loadFromJar("tilePictures/Misc/99_2.jpg"));
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

    public static int countAdjacent(Tile tarTile, int x, int y)
    {
        int count = 0;
        Tile t1 = null;
        Tile t2 = null;
        Tile t3 = null;
        Tile t4 = null;

        if (x-1 > 0)
            t1 = outTerrain[x-1][y];
        if (x+1 < worldSize)    
            t2 = outTerrain[x+1][y];
        if (y-1 > 0)
            t3 = outTerrain[x][y-1];
        if (y+1 < worldSize) 
            t4 = outTerrain[x][y+1];

        if (t1!=null && t1.getName().equals(tarTile.getName()))
            count++;
        if (t2!=null && t2.getName().equals(tarTile.getName()))
            count++;
        if (t3!=null && t3.getName().equals(tarTile.getName()))
            count++;
        if (t4!=null && t4.getName().equals(tarTile.getName()))
            count++;

        return count;
    }

    public int getSightRange()
    {
        return sightRange;
    }

    /*public static void testing()
    {
    Tile[] desertTiles = new Tile[5];
    worldSize = 5;
    outTerrain = new Tile[5][5];

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

    color = new Color(100,100,50);
    Tile deadLake = new Tile(color);
    deadLake.setName("Dead Lake");
    desertTiles[2] = deadLake;

    Picture[] picArray0 = {Picture.loadFromJar("tilePictures/50_0.jpg"),Picture.loadFromJar("tilePictures/50_1.jpg"),
    Picture.loadFromJar("tilePictures/50_2.jpg"),Picture.loadFromJar("tilePictures/50_3.jpg")};

    Picture[] picArray1 = {Picture.loadFromJar("tilePictures/51_0.jpg"),Picture.loadFromJar("tilePictures/51_1.jpg"),
    Picture.loadFromJar("tilePictures/51_2.jpg"),Picture.loadFromJar("tilePictures/51_3.jpg")};

    Picture[] picArray2 = {Picture.loadFromJar("tilePictures/02_0.jpg"),Picture.loadFromJar("tilePictures/02_1.jpg"),
    Picture.loadFromJar("tilePictures/02_2.jpg"),Picture.loadFromJar("tilePictures/02_3.jpg")};

    fillWorld(rockyDesert,picArray0);
    outTerrain[2][2]=deadLake;
    outTerrain[2][3]=deadLake;
    outTerrain[2][4]=deadLake;

    generateLip(sandDunes,picArray1,deadLake);
    }*/
}