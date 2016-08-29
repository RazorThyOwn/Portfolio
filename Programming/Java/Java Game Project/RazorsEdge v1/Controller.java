import java.lang.Math.*;
import java.util.Scanner;
import sacco.*;
public class Controller extends Display
{
    // Stored Settings
    int nPerPage = 4;

    static int globalScaleIndex;
    static int localScaleIndex;
    static int globalWidth;
    static int globalHeight;
    static int localWidth;
    static int localHeight;
    static int sightRange = 250;
    static int mapSize; 
    
    int turnCount = 1;
    int time = 8;

    // Every square, at a scale of 1, is 5 feet, so scale 1 shows 250x250 feet

    static Player[] playerList;

    static Object[][] objectArray;
    static Tile[][] terrain;

    Button charB = new Button(150,400,200,50);
    Button invB = new Button(150,500,200,50);
    Button mapB = new Button(150,600,200,50);
    Button comB = new Button(150,700,200,50);  
    Button turnB = new Button(100,330,300,42);

    Button[] settingsButtons = new Button[4];

    public Controller(Player[] pList, int mapSizeIn, Tile[][] ter)
    {
        playerList = pList;
        objectArray = new Object[mapSizeIn][mapSizeIn];

        globalScaleIndex = 4;
        localScaleIndex = 1;
        globalWidth = mapSizeIn;
        globalHeight = mapSizeIn;
        localWidth = 51;
        localHeight = 51;
        mapSize = mapSizeIn;
        terrain = ter;
        this.isSightRange();
    }

    public void launch()
    {
        super.launch();
    }

    public void paintWindow(PaintBrush brush)
    {
        int length = 500;
        this.setSize(length,800);

        // Drawing Background

        brush.setColor(100,100,100);
        brush.fillRectangle(0,0,5000,5000);

        // Drawing Title Square

        brush.setColor("black");

        brush.setThickness(8);
        brush.drawRectangle(60,70,380,240);
        brush.setColor(0,155,0);
        brush.fillRectangle(60,70,380,240);

        // Drawing title
        brush.setColor("black");

        brush.setFontSize(50);        
        int strLength = brush.getStringWidth("Welcome to");
        brush.drawString("Welcome to",(length-strLength)/2,125);
        brush.setFontSize(100);
        strLength = brush.getStringWidth("Razor's");
        brush.drawString("Razor's",(length-strLength)/2,210);
        brush.setFontSize(70);
        strLength = brush.getStringWidth("Edge!");
        brush.drawString("Edge!",(length-strLength)/2,280);

        // Drawing buttons
        brush.setColor("black");
        brush.setThickness(8);
        brush.drawRectangle(150,400,200,50);
        brush.drawRectangle(150,500,200,50);
        brush.drawRectangle(150,600,200,50);
        brush.drawRectangle(150,700,200,50);

        brush.setColor(0,155,0);
        brush.fillRectangle(150,400,200,50);
        brush.fillRectangle(150,500,200,50);
        brush.fillRectangle(150,600,200,50);
        brush.fillRectangle(150,700,200,50);

        // Drawing text

        brush.setColor("black");
        brush.setFontSize(40);
        brush.drawString("Characters",155,440);
        brush.drawString("Inventory",155,540);
        brush.drawString("Map",155,640);
        brush.drawString("Combat",155,740);

        // Drawing Turn Button

        brush.setColor("black");
        brush.drawRectangle(100,330,300,42);
        brush.setColor(255,190,60);
        brush.fillRectangle(100,330,300,42);
        brush.setColor("black");
        brush.setBold(true);

        brush.drawString("T U R N",175,365);
        brush.setBold(false);     

        // Drawing Settings Button

        brush.setFontSize(20);
        for (int i = 0; i < 4; i++)
        {
            int height = 415 + 100*i;
            brush.setColor("black");
            brush.drawRectangle(365,height,20,20);
            brush.setColor(0,143,0);
            brush.fillRectangle(365,height,20,20);
            brush.setColor("black");
            brush.drawString("S",368,height+18);

            Button tmpButton = new Button(365,height,20,20);
            settingsButtons[i] = tmpButton;
        }
    }

    public void onMousePress(MouseEvent m)
    {
        if (charB.press(m.getX(),m.getY()))
        {            
            CharDisplay cD = new CharDisplay(playerList,nPerPage);
            cD.launch();
        }
        else if (invB.press(m.getX(),m.getY()))
        {
            Inventory inv = new Inventory(playerList);
            inv.launch();
        }
        else if (mapB.press(m.getX(),m.getY()))
        {
            MapManager map = new MapManager(playerList,objectArray,globalScaleIndex,localScaleIndex,globalWidth,globalHeight,localWidth,localHeight,terrain);
            map.launch();
        }
        else if (comB.press(m.getX(),m.getY()))
        {
            Combat cB = new Combat(playerList);
            cB.launch();
        }
        else if (turnB.press(m.getX(),m.getY()))
        {
            turn();
            System.out.println("= = = = = = T U R N "+turnCount+" = = = = = =");
            String dayTime;
            int nTime;
            if (time%24<12)
                dayTime = " AM";
            else
                dayTime = " PM";
            if (time%12==0)
                nTime=12;
            else
                nTime = time%12;
            System.out.println("Time: "+nTime+dayTime);
            turnCount++;
            time++;
            
            if (nTime==6 && dayTime.equals(" AM"))
                System.out.println("SUNRISE");
            if (nTime==6 && dayTime.equals(" PM"))
                System.out.println("SUNSET");
            System.out.println("= = = = = = = = = = = = = = = = =");   
        }

        for (int i = 0; i < settingsButtons.length;i++)
        {
            if (settingsButtons[i].press(m.getX(),m.getY()))
            {
                if (i==0)
                {
                    SettingsCharDisplay sCD = new SettingsCharDisplay();
                    sCD.launch();
                }
                if (i==1)
                {
                    SettingsInventory sI = new SettingsInventory();
                    sI.launch();
                }
                if (i==2)
                {
                    SettingsMapManager sMM = new SettingsMapManager(globalScaleIndex,localScaleIndex,globalWidth,localWidth);
                    sMM.launch();
                }
                if (i==3)
                {
                    SettingsCombat sC = new SettingsCombat();
                    sC.launch();
                }
            }
        }
    }

    public void turn()
    {
        for (int i = 0; i < playerList.length;i++)
        {
            Player tmpPlayer = playerList[i];
            tmpPlayer.maintenance();
            playerList[i] = tmpPlayer;
        }
    }

    public static void demo()
    {
        Player[] playerList = new Player[5];

        Player p1 = new Player(0);
        p1.setName("Alex");
        p1.setClassName("Warrior-Tank");

        Player p2 = new Player(1);
        p2.setName("James");
        p2.setClassName("Ninja-Scientist");

        Player p3 = new Player(2);
        p3.setName("Jake");
        p3.setClassName("Ninja-Warrior");

        Player p4 = new Player(3);
        p4.setName("Drew");
        p4.setClassName("Gazelle-Tank");

        playerList = new Player[4];
        playerList[0]=p1;
        playerList[1]=p2;
        playerList[2]=p3;
        playerList[3]=p4;   

        for (int i = 0; i <playerList.length; i++)
        {
            Player tmpPlayer = new Player(i);
            for (int k = 0; k < 5; k++)
            {
                tmpPlayer.setVal(k,10);
            }
            tmpPlayer.setName(playerList[i].getName());
            tmpPlayer.cUpdate();
            playerList[i] = tmpPlayer;
        }

        Controller cO = new Controller(playerList,2400,terrain);
        cO.launch();
    }

    public static void chainPlayerListUp(Player inPlayer, int index)
    {
        playerList[index] = inPlayer;
    }

    public static void updateMapSettings(int gScale, int lScale, int gW, int pW)
    {
        globalScaleIndex = gScale;
        localScaleIndex = lScale;
        globalWidth = gW;
        globalHeight = gW;
        localWidth = pW;
        localHeight = pW;
    }

    public static void updatePlayer(Player pl)
    {
        playerList[pl.getIndex()] = pl;
    }

    public static void isSightRange()
    {
        for (int i = 0; i < playerList.length; i++)
        {
            for (int k = 0; k < playerList.length; k++)
            {
                if (i!=k)
                {
                    double distance;
                    int firstHalf;
                    int secondHalf;

                    Player pI = playerList[i];
                    Player pK = playerList[k];

                    if (pI.getXPos() > pK.getXPos())
                    {
                        firstHalf = pI.getXPos() - pK.getXPos();
                        firstHalf = firstHalf*firstHalf;
                    }
                    else
                    {
                        firstHalf = pK.getXPos() - pI.getXPos();
                        firstHalf = firstHalf*firstHalf;
                    }
                    if (pI.getYPos() > pK.getYPos())
                    {
                        secondHalf = pI.getYPos() - pK.getYPos();
                        secondHalf = secondHalf*secondHalf;
                    }
                    else
                    {
                        secondHalf = pK.getYPos() - pI.getYPos();
                        secondHalf = secondHalf*secondHalf;
                    }
                    double sqrtPart = firstHalf + secondHalf;

                    distance = 5*(java.lang.Math.sqrt(sqrtPart));

                    if ( distance<sightRange)
                    {
                        System.out.println(playerList[i].getName()+" can see "+playerList[k].getName()+" at a distance of "+distance);
                    }
                }
            }
        }
    }
    
    public static Player[] getPlayerList()
    {
        return playerList;
    }
}