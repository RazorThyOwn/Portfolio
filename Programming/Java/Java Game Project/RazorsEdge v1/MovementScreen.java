import sacco.*;
public class MovementScreen extends Display
{
    Player player;

    int scale;
    int maxX;
    int maxY;

    Button[] moveList = new Button[4];

    Object standObj;
    static Tile[][] terrainArray;

    public MovementScreen(Player pl, int scaleIn, int maxXIn, int maxYIn, Tile[][] terrainIn)
    {
        player = pl;
        scale = scaleIn;
        maxX = maxXIn;
        maxY = maxYIn;
        standObj = terrainIn[player.getXPos()][player.getYPos()];
        //System.out.println(terrainIn[2][2].getName());
        terrainArray = terrainIn;
    }

    public void paintWindow(PaintBrush brush)
    {
        // General Setup
        brush.setColor(100,100,100);
        brush.fillRectangle(0,0,320,20);
        brush.fillRectangle(0,0,20,390);
        brush.fillRectangle(300,0,420,390);
        brush.fillRectangle(0,300,400,390);

        brush.setColor(211,184,152);
        brush.fillRectangle(20,20,380,350);
        this.setSize(420,390);

        brush.setColor("black");
        brush.setThickness(10);
        brush.drawRectangle(40,40,340,40);
        brush.setColor(0,143,0);        
        brush.fillRectangle(40,40,340,40);

        brush.setFontSize(40);
        String name = player.getName();
        brush.setColor(254,194,63);
        int nameLength = brush.getStringWidth(name);
        brush.drawString(name,210-(nameLength/2),75);

        for (int i = 0; i < 4; i++)
        {
            brush.setColor("black");
            brush.drawRectangle(35 + i*95,300,50,50);
            brush.setColor(0,143,0);
            brush.fillRectangle(35 + i*95,300,50,50);
            Button tmpButton = new Button(35 + i*90,300,50,50);
            moveList[i] = tmpButton;
        }
        brush.setColor(254,194,63);
        brush.drawString("/\\",48,340);
        brush.drawString("\\/",145,340);
        brush.drawString("<",240,340);
        brush.drawString(">",338,340);

        brush.setFontSize(23);
        brush.setColor("black");
        brush.drawString("X-Pos: "+player.getXPos(),60,120);
        brush.drawString("Y-Pos: "+player.getYPos(),60,150);
        brush.drawString("Speed Left: "+player.getSpeedLeft(),60,180);
        String sName;
        int sSpeed;
        if (standObj==null)
        {
            sName = "Null Tile";
            sSpeed = -1;
        }
        else
        {
            sName = standObj.getName();
            sSpeed = standObj.getSpeed();
        }
        brush.drawString("Current Tile:"+sName,60,210);
        
        brush.drawString("Tile Speed: "+sSpeed,60,270);
    }

    public void onMousePress(MouseEvent m)
    {
        for (int i = 0; i < 4; i++)
        {
            if (moveList[i].press(m.getX(),m.getY()) && player.getSpeedLeft()>scale-1)
            {
                if (i==0 && player.getXPos()>0)
                {
                    // Up (Negative X)
                    int newXPos = player.getXPos()-scale;
                    int newYPos = player.getYPos();
                    standObj = Grid.globalObjArray[newXPos][newYPos];
                    Grid.moveObject(player.getXPos(),player.getYPos(),newXPos,newYPos,standObj);
                    Grid.startX = Grid.startX - scale;
                    player.setXPos(newXPos);    
                    player.reduceSpeed(scale);
                }
                if (i==1 && player.getXPos()<maxX-scale)
                {
                    // Down (Positive X)
                    int newXPos = player.getXPos()+scale;
                    int newYPos = player.getYPos();
                    standObj = Grid.globalObjArray[newXPos][newYPos];
                    Grid.moveObject(player.getXPos(),player.getYPos(),newXPos,newYPos,standObj);
                    Grid.startX = Grid.startX + scale;
                    player.setXPos(newXPos);    
                    player.reduceSpeed(scale);
                }
                if (i==2 && player.getYPos()>0)
                {
                    // Left (Negative Y)
                    int newXPos = player.getXPos();
                    int newYPos = player.getYPos()-scale;
                    standObj = Grid.globalObjArray[newXPos][newYPos];
                    Grid.moveObject(player.getXPos(),player.getYPos(),newXPos,newYPos,standObj);
                    Grid.startY = Grid.startY - scale;
                    player.setYPos(newYPos);       
                    player.reduceSpeed(scale);
                }
                if (i==3 && player.getYPos()<maxY-scale)
                {
                    // Right (Positive Y)
                    int newXPos = player.getXPos();
                    int newYPos = player.getYPos()+scale;
                    standObj = Grid.globalObjArray[newXPos][newYPos];
                    Grid.moveObject(player.getXPos(),player.getYPos(),newXPos,newYPos,standObj);
                    Grid.startY = Grid.startY + scale;
                    player.setYPos(newYPos);   
                    player.reduceSpeed(scale);
                }
            }
            if (player.getSpeedLeft()<=0)
            {
                player.setExhausted(2);
            }
        }
    }

    public void onKeyPress(int i)
    {
        if (player.getSpeedLeft()> (scale*standObj.getSpeed()) - 1)
        {
            if ( (i == 38 || i == 87) && player.getXPos()>0)
            {
                // Moving Up
                int newXPos = player.getXPos()-scale;
                int newYPos = player.getYPos();
                standObj = terrainArray[newXPos][newYPos];
                Grid.moveObject(player.getXPos(),player.getYPos(),newXPos,newYPos,standObj);
                Grid.startX = Grid.startX - scale;
                player.setXPos(newXPos);             
                player.reduceSpeed(scale*standObj.getSpeed());
            }
            if ( (i == 40 || i == 83) && player.getXPos()<maxX-scale)
            {
                // Moving Down
                int newXPos = player.getXPos()+scale;
                int newYPos = player.getYPos();
                standObj = terrainArray[newXPos][newYPos];
                Grid.moveObject(player.getXPos(),player.getYPos(),newXPos,newYPos,standObj);
                Grid.startX = Grid.startX + scale;
                player.setXPos(newXPos);  
                player.reduceSpeed(scale*standObj.getSpeed());
            }
            if ( (i == 37 || i == 65) && player.getYPos()>0)
            {
                // Moving Left
                int newXPos = player.getXPos();
                int newYPos = player.getYPos()-scale;
                standObj = terrainArray[newXPos][newYPos];
                Grid.moveObject(player.getXPos(),player.getYPos(),newXPos,newYPos,standObj);
                Grid.startY = Grid.startY - scale;
                player.setYPos(newYPos);      
                player.reduceSpeed(scale*standObj.getSpeed());
            }
            if ( (i == 39 || i ==  68) && player.getYPos()<maxY-scale)
            {
                // Moving Right
                int newXPos = player.getXPos();
                int newYPos = player.getYPos()+scale;
                standObj = terrainArray[newXPos][newYPos];
                Grid.moveObject(player.getXPos(),player.getYPos(),newXPos,newYPos,standObj);
                Grid.startY = Grid.startY + scale;
                player.setYPos(newYPos); 
                player.reduceSpeed(scale*standObj.getSpeed());
            }
        }
        if (player.getSpeedLeft()<=0)
        {
            player.setExhausted(2);
        }
    }

    public static void demo()
    {
        Player pl = new Player(0);
        pl.setName("Zachary");
        MovementScreen mS = new MovementScreen(pl,1,50,50,terrainArray);
        mS.launch();
    }
}
