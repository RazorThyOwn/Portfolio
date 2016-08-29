import sacco.*;
public class MapManager extends Display
{
    Object[][] objectArray;
    static Tile[][] terrain;

    Player[] playerList;
    Button[] btPlayerList;
    Button globalButton;

    static int globalScaleIndex;
    static int localScaleIndex;
    static int globalWidth;
    static int globalHeight;
    static int playerWidth;
    static int playerHeight;
    int[] intAr;

    public MapManager(Player[] pList, Object[][] objList, int sclIndex, int lScaleIndex, int globalWidthX, int globalHeightX, int playerWidthX, int playerHeightX, Tile[][] terr)
    {
        btPlayerList = new Button[pList.length];
        playerList = pList;
        objectArray = objList;
        globalScaleIndex = sclIndex;
        localScaleIndex = lScaleIndex;
        globalWidth = globalWidthX;
        globalHeight = globalHeightX;
        playerWidth = playerWidthX;
        playerHeight = playerHeightX;
        terrain = terr;

        for (int i = 0; i < playerList.length;i++)
        {
            int x = playerList[i].getXPos();
            int y = playerList[i].getYPos();

            PlayerActor pAct = new PlayerActor(playerList[i]);
            objList[x][y] = pAct;
        }

        intAr = factorsList(globalWidth);
    }

    public void paintWindow(PaintBrush brush)
    {
        int height = 60+(playerList.length+1)*65;

        brush.setColor(100,100,100);
        brush.fillRectangle(0,0,320,20);
        brush.fillRectangle(0,0,20,height);
        brush.fillRectangle(300,0,320,height);
        brush.fillRectangle(0,0,1000,1000);

        brush.setColor(211,184,152);
        brush.fillRectangle(20,20,280,height-40);
        this.setSize(320,height);

        int yPos = 40;

        for (int i = 0; i < playerList.length;i++)
        {
            yPos = 40 + i*65;
            brush.setThickness(10);
            brush.setColor("black");
            brush.drawRectangle(40,yPos,240,40);

            brush.setColor(0,143,0);
            brush.fillRectangle(40,yPos,240,40);

            brush.setColor(254,194,63);
            brush.setFontSize(40);
            String name = playerList[i].getName();
            int nameLength = brush.getStringWidth(name);
            brush.drawString(name,160-(nameLength)/2,yPos+35);

            Button tmpButton = new Button(40,yPos,240,40);
            btPlayerList[i] = tmpButton;
        }

        yPos = 40 + playerList.length*65;
        brush.setThickness(10);
        brush.setColor("black");
        brush.drawRectangle(40,yPos,240,40);

        brush.setColor(0,143,0);
        brush.fillRectangle(40,yPos,240,40);

        brush.setColor(254,194,63);
        brush.setFontSize(40);
        String name = "Global";
        int nameLength = brush.getStringWidth(name);
        brush.drawString(name,160-(nameLength)/2,yPos+35);

        globalButton = new Button(40,yPos,240,40);
    }

    public static void demo()
    {
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

        Player[] playerListDemo = new Player[4];
        playerListDemo[0]=p1;
        playerListDemo[1]=p2;
        playerListDemo[2]=p3;
        playerListDemo[3]=p4;    

        Object obj = new Object();

        Object[][] objList = new Object[100][100];

        for (int i = 0; i < playerListDemo.length;i++)
        {
            int x = playerListDemo[i].getXPos();
            int y = playerListDemo[i].getYPos();

            PlayerActor pAct = new PlayerActor(playerListDemo[i]);
            objList[x][y] = pAct;
        }
        MapManager mS = new MapManager(playerListDemo,objList,2,0,100,100,50,50,terrain);
        mS.launch(); 
    }

    public void onMousePress(MouseEvent m)
    {
        for (int i = 0; i < btPlayerList.length; i++)
        {
            if (btPlayerList[i].press(m.getX(),m.getY()))
            {
                int xCord = playerList[i].getXPos() - playerWidth/2; 
                int yCord = playerList[i].getYPos() - playerHeight/2;
                Grid playerGrid = new Grid(playerWidth,playerHeight,0,localScaleIndex,xCord,yCord,objectArray,terrain);
                playerGrid.launch();
            }
        }

        if (globalButton.press(m.getX(),m.getY()))
        {
            Object[][] objArrayD = new Object[100][100];
            Grid globalGrid = new Grid(globalWidth/intAr[globalScaleIndex],globalHeight/intAr[globalScaleIndex],0,intAr[globalScaleIndex],0,0,objectArray,terrain);
            globalGrid.launch();
        }
    }

    public static int[] factorsList(int size)
    {
        int[] factList = new int[1];
        for (int i = 1; i < size+1;i++)
        {
            if (size%i ==0)
            {
                int[] newFactList = new int[factList.length+1];
                for (int j = 0; j < factList.length; j++)
                {
                    newFactList[j] = factList[j];
                }
                newFactList[factList.length]=i;
                factList = newFactList;
            }
        }
        return factList;
    }
}