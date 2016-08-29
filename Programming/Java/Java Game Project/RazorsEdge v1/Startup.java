import java.util.Scanner;
public class Startup
{
    static int playerCount;
    static Player[] playerList; 
    static Scanner scan = new Scanner(System.in);
    static Controller iS;
    static int mapSize;

    static Tile[][] terrain;

    public static void main()
    {
        System.out.println("Welcome to Labyrinth!");
        System.out.println("Enter the amount of players");
        String in = scan.nextLine();
        playerCount = Integer.parseInt(in);
        playerList = new Player[playerCount];

        Scanner scan = new Scanner(System.in);
        System.out.println("Choose map size");
        System.out.println("0: Small (2,500 feet)");
        System.out.println("1: Medium (5,000 feet");
        System.out.println("2: Large (10,000 feet");
        String scanIn = scan.nextLine();
        if (scanIn.equals("0"))
            mapSize = 500;
        if (scanIn.equals("1"))
            mapSize = 1000;
        if (scanIn.equals("2"))
            mapSize = 2000;

        WorldGenerator worldGen = new WorldGenerator();    

        System.out.println("Choose terrain type");    
        System.out.println("0: Desert");
        System.out.println("1: Forest");
        System.out.println("2: Jungle");
        System.out.println("3: Tundra");
        System.out.println("4: Islands");
        System.out.println("5: Swamp");

        scanIn = scan.nextLine();
        if (scanIn.equals("0"))
            terrain = worldGen.worldGen(0,mapSize,playerCount);
        if (scanIn.equals("1"))
            terrain = worldGen.worldGen(1,mapSize,playerCount);
        if (scanIn.equals("2"))
            terrain = worldGen.worldGen(2,mapSize,playerCount);
        if (scanIn.equals("3"))
            terrain = worldGen.worldGen(3,mapSize,playerCount);
        if (scanIn.equals("4"))
            terrain = worldGen.worldGen(4,mapSize,playerCount);
        if (scanIn.equals("5"))
            terrain = worldGen.worldGen(5,mapSize,playerCount);

        System.out.println("Choose player creation...");
        System.out.println("0: Random");
        System.out.println("1: Random Specialized");
        System.out.println("2: Quiz");
        System.out.println("3: Poll");
        System.out.println("4: Class");
        System.out.println("5: Manual");
        scanIn = scan.nextLine();

        Startup startUp = new Startup();
        if (scanIn.equals("0"))
            startUp.randomInput();
        if (scanIn.equals("1"))
            startUp.randomSInput();
        if (scanIn.equals("2"))
            startUp.quizInput();
        if (scanIn.equals("3"))
            startUp.pollInput();
        if (scanIn.equals("4"))
            startUp.classInput();
        if (scanIn.equals("5"))
            startUp.selcInput();
    }

    public static void playerCordsInit()
    {
        System.out.println("Updating player cords");
        int centerX = mapSize/2;
        int centerY = mapSize/2;
        int radius = 10 + playerList.length/2;
        double angleIncrement = 2*3.14159 / playerList.length;
        double angCount = 0;
        //System.out.println(angleIncrement);
        for (int i = 0; i < playerList.length; i++)
        {
            // Generating Pedastals...           
            double tileY = java.lang.Math.sin(angCount);
            double tileX = java.lang.Math.cos(angCount);
            angCount+=angleIncrement;
            tileY = tileY*radius;
            tileX = tileX*radius;
            tileY+=centerY;
            tileX+=centerX;
            Player tmpPlayer = playerList[i];
            tmpPlayer.setXPos( (int)(tileX) );
            tmpPlayer.setYPos( (int)(tileY) );
            playerList[i]=tmpPlayer;
            System.out.println("Moving player "+i+" to "+tileX+","+tileY);
        }
    }

    // Gap for document viewing
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
    //
    //
    //
    //

    public void quizInput()
    {       
        // Form: https://docs.google.com/forms/d/1Gn3moiEtavZQiNNFwKTTGwJTbByNVueUZrj4wqdtO_E/edit
        // Least favorite choice for character creation because it assumes my biases associated with activites and choices
        // Decently Specialized Character Creation

        // Alex 1 4 5 1 5 3 4 3 2 2
        // Drew 1 1 3 2 1 1 5 1 5 1
        
        int[][][] quizKey = 
            {{  /*Place*/ {1,0,1,2,0},{0,2,2,0,2},{0,2,0,1,2},{2,0,2,2,0},{2,1,0,0,1} }, {
                    /*Crate*/ {3,0,0,1,1},{2,0,3,2,3},{0,1,0,0,1},{0,3,0,0,0},{0,1,2,2,0} }, {
                    /*Foods*/ {1,2,0,1,0},{0,0,0,3,2},{2,0,0,0,0},{2,2,3,1,2},{0,1,2,0,1} }, {
                    /*Fight*/ {1,2,4,4,0},{4,0,0,0,0},{0,1,1,1,1},{0,2,0,0,0},{0,0,0,0,4} }, {
                    /*Hobby*/ {1,0,4,4,0},{0,4,0,0,2},{3,0,0,0,0},{1,0,0,1,3},{0,1,1,0,0} }, {
                    /*Music*/ {3,0,1,2,0},{0,0,2,0,3},{0,5,0,0,0},{2,0,0,1,1},{0,0,2,2,1} }, {
                    /*Fears*/ {-1,-1,0,-2,-2},{-2,0,0,0,0},{0,-2,-2,-3,-2},{0,-2,-2,0,-1},{-2,0,-1,0,0} }, {
                    /*Movie*/ {3,0,1,2,0},{0,2,0,2,0},{0,0,1,0,5},{1,0,2,1,0},{0,3,1,0,0} }, {
                    /*Vacat*/ {1,0,1,2,0},{0,1,0,1,2},{0,0,4,2,1},{0,4,0,0,0},{4,0,0,0,2} }, {
                    /*Color*/ {5,0,0,0,0},{0,5,0,0,0},{0,0,5,0,0},{0,0,0,5,0},{0,0,0,0,5} }, };

        for (int i = 0; i <playerCount; i++)
        { 
            Player newPlayer = new Player(i);
            System.out.println("Input Data: ");
            String quizString = scan.nextLine();
            int indexOf = quizString.indexOf(" ");
            String name = quizString.substring(0,indexOf);
            newPlayer.setName(name);
            quizString = quizString.substring(indexOf+1) + " ";
            int[] quizResults = new int[10];

            for (int j = 0; j < 10; j++) // Turning string into int array
            {
                int index = quizString.indexOf(" ");
                int parsedInt = Integer.parseInt(quizString.substring(0,index));
                quizResults[j] = parsedInt;
                quizString = quizString.substring(index+1);
            }

            int strCount = 0;
            int intCount = 0;
            int spdCount = 0;
            int endCount = 0;
            int aglCount = 0;

            for (int j = 0; j <10; j++)
            {
                for (int k = 0; k<5;k++)
                {
                    //System.out.println("Comparing "+quizResults[j]+" to "+(k+1));
                    if (quizResults[j]==k+1)
                    {
                        //System.out.println("==========");                        
                        //System.out.println("Answer was "+(quizResults[j])+", so grabbing index of ["+j+"]["+k+"]");
                        //System.out.println("==========");

                        strCount+=quizKey[j][k][0];
                        //System.out.println("Adding strength of "+quizKey[j][k][0]);
                        intCount+=quizKey[j][k][1];
                        //System.out.println("Adding intelligence of "+quizKey[j][k][1]);
                        spdCount+=quizKey[j][k][2];
                        //System.out.println("Adding speed of "+quizKey[j][k][2]);
                        endCount+=quizKey[j][k][3];
                        //System.out.println("Adding endurance of "+quizKey[j][k][3]);
                        aglCount+=quizKey[j][k][4];
                        //System.out.println("Adding agility of "+quizKey[j][k][4]);
                    }
                }
            }
            // Figuring out class Title

            String[] classIndex = {"Warrior","Scientist","Gazelle","Tank","Ninja"};

            int[] charArray = {strCount,intCount,spdCount,endCount,aglCount};

            for (int z = 0; z < 5; z++)
            {
                System.out.print(charArray[z]+" ");
            }

            int highestIndex = highestOf(charArray);
            System.out.println("Highest index is "+highestIndex);
            charArray[highestIndex] = -9999;
            int secondHighestIndex = highestOf(charArray);

            String firstClass = classIndex[highestIndex];
            String secondClass = classIndex[secondHighestIndex];

            newPlayer.setClassName(firstClass+"-"+secondClass);

            // Setting up an array to asign values with
            int[] charList = new int[5];
            for(int x = 0; x < 5; x++)
            {
                charList[x] = 10;
                charList[x] += (int)( (Math.random()*5)-2);
                charList[x] += (int)( (Math.random()*5)-2);
            }

            int highestChar = charList[highestIndex];
            highestChar += 8;            
            int secondHighestChar = charList[secondHighestIndex];
            secondHighestChar += 6;

            while (highestChar<=secondHighestChar)
            {
                highestChar++;
            }

            charList[highestIndex] = highestChar;
            charList[secondHighestIndex] = secondHighestChar;

            // Assigning Values!
            for (int x = 0; x < 5; x++)
            {
                newPlayer.setVal(x,charList[x]);
            }
            newPlayer.cUpdate();
            playerList[i]=newPlayer;
        }
        Player[] newPlayerList = contestMode();
        playerList = newPlayerList;
        playerCordsInit();
        iS = new Controller(playerList,mapSize,terrain);
        iS.launch();
    }

    public void pollInput()
    {
        // My second favorite choice, lets others gauge someone (more people, more close it is to accurate)
        
        Scanner scan = new Scanner(System.in);

        // Setting up Base Characteristics
        for (int i = 0; i < playerList.length; i++)
        {
            System.out.println("Input player "+(i+1)+" name");
            String name = scan.nextLine();
            Player tmpPlayer = new Player(i);
            tmpPlayer.setName(name);
            for (int j = 0; j < 5; j++)
            {
                String charTrib = "";
                if(j==0)
                    charTrib = "strength"; 
                if(j==1)
                    charTrib = "intelligence";
                if(j==2)
                    charTrib = "speed";
                if(j==3)
                    charTrib = "endurance";
                if(j==4)
                    charTrib = "agility";
                System.out.println("Begin polling "+charTrib+" of player "+(i+1)+" for "+(playerList.length-1)+" times");
                double n = 0; // Character Poll Total
                for (int k = 0; (k<playerList.length-1);k++) // This is specific attribute counter
                {
                    n+=Integer.parseInt(scan.nextLine());
                }
                double rand = (Math.random()*9);
                double nRaw = (n/(playerList.length-1) + rand-4);
                double nFinal = decimalReduce(nRaw,2);
                System.out.println("The final value of player "+(i+1)+"'s "+charTrib+" is "+nFinal);  
                tmpPlayer.setVal(j,(int)nFinal);
            }
            tmpPlayer.setHitpoints(tmpPlayer.getEndurance()*10);
            tmpPlayer.cUpdate();
            playerCordsInit();
            playerList[i]=tmpPlayer;
        }

        // Setting up Total HP
        for (int i = 0; i < playerList.length; i++)
        {
            double endr = playerList[i].getEndurance();
            playerList[i].setHitpoints( (int)(endr*10) );
        }
        Player[] newPlayerList = contestMode();
        playerList = newPlayerList;
        playerCordsInit();
        iS = new Controller(playerList,mapSize,terrain);
        iS.launch();
    }

    public void randomSInput()
    {
        // Very specialized characters
        
        for (int i = 0; i < playerCount; i++)
        {
            System.out.println("Enter player "+(1+i)+" name");
            String name = scan.nextLine();
            Player tmpPlayer = new Player(i);
            tmpPlayer.setName(name);
            for (int k = 0; k < 5; k++)
            {
                int charT = 10;
                for (int j = 0; j < 4; j++)
                    charT += (int)( (Math.random()*5)-2);
                tmpPlayer.setVal(k,charT);
            }
            tmpPlayer.cUpdate();

            // Assigning Class
            int[] charArray = tmpPlayer.getCharArray();
            String[] classIndex = {"Warrior","Scientist","Gazelle","Tank","Ninja"};

            int highestIndex = highestOf(charArray);
            System.out.println("Highest index is "+highestIndex);
            charArray[highestIndex] = -9999;
            int secondHighestIndex = highestOf(charArray);

            String firstClass = classIndex[highestIndex];
            String secondClass = classIndex[secondHighestIndex];

            tmpPlayer.setClassName(firstClass+"-"+secondClass);

            int highestChar = charArray[highestIndex];
            highestChar += 8;            
            int secondHighestChar = charArray[secondHighestIndex];
            secondHighestChar += 6;

            while (highestChar<=secondHighestChar)
            {
                highestChar++;
            }

            charArray[highestIndex] = highestChar;
            charArray[secondHighestIndex] = secondHighestChar;

            // Assigning Values!
            for (int x = 0; x < 5; x++)
            {
                tmpPlayer.setVal(x,charArray[x]);
            }
            tmpPlayer.cUpdate();
            playerList[i]=tmpPlayer;          
        }
        Player[] newPlayerList = contestMode();
        playerList = newPlayerList;
        playerCordsInit();
        iS = new Controller(playerList,mapSize,terrain);
        
        iS.launch();
    }

    public void randomInput()
    {
        // Very un-specified characters, lots of room for growth
        
        for (int i = 0; i < playerCount; i++)
        {
            System.out.println("Enter player "+(1+i)+" name");
            String name = scan.nextLine();
            Player tmpPlayer = new Player(i);
            tmpPlayer.setName(name);
            for (int k = 0; k < 5; k++)
            {
                int charT = 10;
                for (int j = 0; j < 4; j++)
                    charT += (int)( (Math.random()*5)-2);
                tmpPlayer.setVal(k,charT);
            }
            tmpPlayer.cUpdate();

            // Assigning Class
            int[] charArray = tmpPlayer.getCharArray();
            String[] classIndex = {"Warrior","Scientist","Gazelle","Tank","Ninja"};

            int highestIndex = highestOf(charArray);
            System.out.println("Highest index is "+highestIndex);
            charArray[highestIndex] = -9999;
            int secondHighestIndex = highestOf(charArray);

            String firstClass = classIndex[highestIndex];
            String secondClass = classIndex[secondHighestIndex];

            tmpPlayer.setClassName(firstClass+"-"+secondClass);

            tmpPlayer.cUpdate();
            playerList[i]=tmpPlayer;          
        }
        Player[] newPlayerList = contestMode();
        playerList = newPlayerList;
        playerCordsInit();
        iS = new Controller(playerList,mapSize,terrain);
        iS.launch();
    }

    public void selcInput()
    {
        // Manually create characters
        
        for (int i = 0; i < playerCount; i++)
        {
            // Setting up name, etc
            System.out.println("Enter player "+(1+i)+" name");
            String name = scan.nextLine();
            Player tmpPlayer = new Player(i);
            tmpPlayer.setName(name);
            System.out.println("Enter Characteristics ONE AT A TIME!!!");
            for (int j = 0; j < 5; j++)
            {
                int scanParse = Integer.parseInt(scan.nextLine());
                tmpPlayer.setVal(j,scanParse);
            }

            // Class input
            System.out.println("Enter class");
            String classs = scan.nextLine();

            tmpPlayer.setClassName(classs);

            tmpPlayer.cUpdate();
            playerList[i]=tmpPlayer;            
        }
        Player[] newPlayerList = contestMode();
        playerList = newPlayerList;
        playerCordsInit();
        iS = new Controller(playerList,mapSize,terrain);
        iS.launch();
    }

    public void classInput()
    {
        
        for (int i = 0; i < playerCount; i++)
        {
            System.out.println("Enter player "+(i+1)+" name");
            String name = scan.nextLine();
            Player tmpPlayer = new Player(i);
            tmpPlayer.setName(name);
            System.out.println("Enter Classes, seperated by a dash, IE: Ninja-Warrior");
            String className = scan.nextLine();
            int indexOf = className.indexOf("-");
            String class1 = className.substring(0,indexOf);
            String class2 = className.substring(indexOf-1);
            tmpPlayer.setClassName(className);

            // Setting class characteristics
            String[] classIndex = {"Warrior","Scientist","Gazelle","Tank","Ninja"};
            int highestClass = -1;
            int secondHighestClass = -1;

            // Randomly generating characteristics
            for (int k = 0; k < 5; k++)
            {
                int charT = 10;
                for (int j = 0; j < 4; j++)
                    charT += (int)( (Math.random()*5)-2);
                tmpPlayer.setVal(k,charT);
            }

            for (int j = 0; j < 5; j++)
            {
                if (classIndex[j].equals(class1))
                    highestClass = j;
                if (classIndex[j].equals(class2))
                    secondHighestClass = j;
            }
            tmpPlayer.adjustVal(highestClass,8);
            tmpPlayer.adjustVal(secondHighestClass,5);
            tmpPlayer.cUpdate();
            playerList[i]=tmpPlayer;
        }
        Player[] newPlayerList = contestMode();
        playerList = newPlayerList;
        playerCordsInit();
        iS = new Controller(playerList,mapSize,terrain);
        iS.launch();
    }

    // Gap for document viewing
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
    //
    //
    //
    //

    public static Player[] contestMode()
    {
        ContestMode cM = new ContestMode(playerList);
        return cM.run();
    }

    public static void allCharString()
    {
        for (int i = 0; i<playerList.length;i++)
        {
            Player pN = playerList[i];
            String pNOut = pN.toString();
            System.out.println(pNOut);
        }
    }

    public static double decimalReduce(double num, int decimalPlace)
    {
        String numIn = Double.toString(num);
        int indexOfDecimal = numIn.indexOf(".");
        String numOut = numIn.substring(0,indexOfDecimal+decimalPlace+1);
        double nOut = Double.parseDouble(numOut);
        return nOut;
    }

    public static int highestOf(int[] intArray)
    {
        int highestIndex = -1;
        int highestNumber = -1;
        for (int i = 0; i < intArray.length; i++)
        {
            if (intArray[i]>highestNumber)
            {
                highestNumber = intArray[i];
                highestIndex = i;
            }
        }
        return highestIndex;
    }

    public static void testLaunch()
    {
        Player[] playerListX = new Player[11];

        Player p1 = new Player(0);
        p1.setName("Alex");
        //p1.setClassName("Warrior-Tank");

        Player p2 = new Player(1);
        p2.setName("James");
        //p2.setClassName("Ninja-Scientist");

        Player p3 = new Player(2);
        p3.setName("Jake");
        //p3.setClassName("Ninja-Warrior");

        Player p4 = new Player(3);
        p4.setName("Drew");
        //p4.setClassName("Gazelle-Tank");

        Player p5 = new Player(4);
        p5.setName("Angela");

        Player p6 = new Player(5);
        p6.setName("Josh");

        Player p7 = new Player(6);
        p7.setName("Drake");

        Player p8 = new Player(7);
        p8.setName("Julian");

        Player p9 = new Player(8);
        p9.setName("Alyza");

        Player p10 = new Player(9);
        p10.setName("Jessica");

        Player p11 = new Player(10);
        p11.setName("Romeo");

        //playerListX = new Player[1];

        playerListX[0]=p1;
        playerListX[1]=p2;
        playerListX[2]=p3;
        playerListX[3]=p4;   
        playerListX[4]=p5;
        playerListX[5]=p6;
        playerListX[6]=p7;
        playerListX[7]=p8;
        playerListX[8]=p9;
        playerListX[9]=p10;
        playerListX[10]=p11;

        for (int i = 0; i <playerListX.length; i++)
        {
            Player tmpPlayer = new Player(i);
            for (int k = 0; k < 5; k++)
            {
                tmpPlayer.setVal(k,10);
            }
            tmpPlayer.setName(playerListX[i].getName());
            tmpPlayer.cUpdate();
            playerListX[i] = tmpPlayer;
        }

        WorldGenerator worldGen = new WorldGenerator();
        terrain = worldGen.worldGen(0,500,playerListX.length);

        Controller cO = new Controller(playerListX,500,terrain);
        cO.launch();
    }
}
