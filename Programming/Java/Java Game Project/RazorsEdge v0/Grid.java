import sacco.*;
import java.awt.Color;
public class Grid extends Display
{
    static Object[][] globalObjArray; // Used for players
    static Tile[][] terrain; // Used for terrain
    static Object[][] localObjArray;

    static int width;
    static int height;
    static double sizePerSquare;
    int scale;
    static int startX;
    static int startY;
    int ppS = 10;

    int updateCounter = 0;    

    static Button[][] btList;

    //static Object[][] preCulledObjList;
    //static Object[][] drawObjList;

    int scaleIndex = 0;
    int[] intAr = new int[width];

    public Grid(int widthIn, int heightIn, double sizePerSquareIn, int scaleIn, int startXIn, int startYIn, Object[][] objIn, Tile[][] terr)
    {
        width = widthIn;
        height = heightIn;
        scale = scaleIn;
        startX = startXIn;
        startY = startYIn;

        globalObjArray = objIn;     
        localObjArray = new Object[width][height];

        btList = new Button[width][height];

        if (sizePerSquare!=-1)
        {
            sizePerSquare = ( 100.0/ (double)width );
        }
        else
        {
            sizePerSquare = sizePerSquareIn;
        }

        terrain = terr;

        intAr = factorsList(globalObjArray.length);
        this.assignScaleIndex();
    }

    public void setWidth(int widthIn)
    {
        width = widthIn;
    }

    public void setHeight(int heightIn)
    {
        height = heightIn;
    }

    public void setGlobalObjArray(Object[][] objIn)
    {
        globalObjArray = objIn;
    }

    public void setLocalObjArray(Object[][] objIn)
    {
        localObjArray = objIn;
    }

    public void paintWindow(PaintBrush brush)
    {        
        int sqPPS = (int)(sizePerSquare*ppS);
        brush.setColor("black");
        this.setSize((width*sqPPS),(height*sqPPS));

        // Populating preCulledObjList with objects
        Object[][] preCulledObjList = new Object[width*scale][height*scale];
        for (int i = startX; i < startX + (width*scale);i++)
        {
            for (int k = startY; k < startY + (height*scale);k++)
            {
                if (i < 0 || k <0 || i >= globalObjArray.length || k >= globalObjArray[i].length)
                {
                    Color color = new Color(100,100,100);
                    Object wallObj = new Tile(color);
                    preCulledObjList[i-startX][k-startY] = wallObj;
                }
                else
                {
                    if (globalObjArray[i][k]!=null)
                        preCulledObjList[i-startX][k-startY] = globalObjArray[i][k];
                    else
                    {
                        preCulledObjList[i-startX][k-startY] = terrain[i][k];
                    }
                }
            }
        }

        // Printing out published preCulledObjList
        /*for (int i = 0; i < preCulledObjList.length; i++)
        {
        for (int k = 0; k < preCulledObjList[i].length; k++)
        {
        Object obj = preCulledObjList[i][k];
        System.out.println("PC "+i + ", "+k+": "+obj);
        }
        }*/

        // Populating over to drawnObjList
        Object[][] drawObjList = new Object[width][height];
        for (int i = 0; i < width*scale; i++)
        {
            for (int k = 0; k < height*scale; k++)
            {
                Object culledObj = preCulledObjList[i][k];
                if (culledObj.getObjectType()==1)
                {
                    drawObjList[ (k/scale) ][ (i/scale) ] = culledObj;
                }
                else if (culledObj!=null)
                {
                    boolean lock = false;
                    if ( drawObjList[k/scale][i/scale]!=null && drawObjList[ (k/scale) ][i/scale ].getObjectType()==1)
                        lock = true;
                    if (!lock)
                        drawObjList[ (k/scale) ][ (i/scale) ] = culledObj;
                }
            }
        }
        localObjArray = drawObjList;

        // Printing out published drawObjList
        /*for (int i = 0; i < drawObjList.length; i++)
        {
        for (int k = 0; k < drawObjList[i].length; k++)
        {
        Object obj = drawObjList[i][k];
        System.out.println("C "+i + ", "+k+": "+obj);
        }
        }*/

        // Drawing drawObjList
        for (int i = 0; i < drawObjList.length;i++)
        {
            for (int k = 0; k < drawObjList[0].length;k++)
            {
                Object obj = drawObjList[i][k];
                if (obj!=null)
                    brush.setColor(obj.getColor());
                if (drawObjList[i][k]!=null )
                {
                    if (drawObjList[i][k].objectType == 0)
                        brush.fillRectangle((i*sqPPS),(k*sqPPS),(sqPPS),(sqPPS));
                    if (drawObjList[i][k].objectType == 1)
                    {
                        brush.setColor("black");
                        brush.fillRectangle((i*sqPPS),(k*sqPPS),(sqPPS),(sqPPS));
                        Button tmpButton = new Button((i*sqPPS),(k*sqPPS),(sqPPS),(sqPPS));
                        if (i < btList.length && k < btList.length)
                            btList[i][k] = tmpButton;
                        brush.setColor(254,194,63);
                        brush.setFontSize((sqPPS));
                        PlayerActor tmpAct = (PlayerActor)(drawObjList[i][k]);
                        String name = tmpAct.getPlayer().getName().substring(0,1);
                        brush.drawString(name,(int) ((i*sqPPS) + sizePerSquare),(int)((k*sqPPS) + (sqPPS) - sizePerSquare));
                    }
                    else if (drawObjList[i][k].objectType == 2 && drawObjList[i][k]!=null)
                    {
                        Tile terrTile = (Tile)(drawObjList[i][k]);
                        //if (terrTile!=null)
                        if (terrTile.getPicture()!=null)
                        {
                            brush.drawPicture(terrTile.getPicture(),(i*sqPPS),(k*sqPPS),(sqPPS),(sqPPS));
                            //brush.fillRectangle((i*sqPPS),(k*sqPPS),(sqPPS),(sqPPS));
                        }
                        if (terrTile.getPicture()==null)
                        {
                            brush.setColor("black");
                            brush.fillRectangle((i*sqPPS),(k*sqPPS),(sqPPS),(sqPPS));
                        }
                        if (i == drawObjList.length/2 && k == drawObjList.length/2)
                        {
                            Color clr = new Color(250,0,0);
                            brush.setColor(clr);
                            brush.fillRectangle((i*sqPPS),(k*sqPPS),sqPPS,sqPPS);
                        }
                    }
                }
            }
        }

        brush.setColor("black");

        for (int i = 0; i < width; i++)
        {
            brush.drawLine((i*sqPPS),0,(i*sqPPS),(height*sqPPS));
        }
        for (int i = 0; i < height; i++)
        {
            brush.drawLine(0,(i*sqPPS),(height*sqPPS),(i*sqPPS));
        }

        brush.setColor("black");
        brush.setFontSize(25);
        brush.drawString("Total Squares: "+localObjArray.length,5,30);
        brush.drawString("Visual distance: "+(localObjArray.length*5*scale)+"ft",5,60);
    }

    public void assignScaleIndex()
    {
        for (int i = 0; i < intAr.length; i++)
        {
            if (scale == intAr[i])
            {
                scaleIndex = i;
            }
        }
    }

    public void onMousePress(MouseEvent m)
    {
        for (int i = 0; i < localObjArray.length; i++)
        {
            for (int k = 0; k < localObjArray.length; k++)
            {
                if (btList[i][k]!=null && btList[i][k].press(m.getX(),m.getY()))
                { 
                    if (m.getButton()==3)
                    {
                        if (localObjArray[i][k].getObjectType()==1)
                        {
                            PlayerActor act = (PlayerActor)localObjArray[i][k];
                            Player player = act.getPlayer();
                            Player[] playerArray = {player};
                            CharDisplay cD = new CharDisplay(playerArray,1);
                            cD.launch();
                        }
                    }
                    if (m.getButton()==1)
                    {
                        if (localObjArray[i][k].getObjectType()==1)
                        {
                            PlayerActor act = (PlayerActor)localObjArray[i][k];
                            Player player = act.getPlayer();
                            MovementScreen mScreen = new MovementScreen(player,intAr[scaleIndex],globalObjArray.length,globalObjArray[i].length,terrain);
                            mScreen.launch();
                        }
                    }
                }
            }
        }
    }

    public void onKeyPress(int i)
    {
        if (i == 38 || i == 87 )
        {
            // Moving Up
            //System.out.println(intAr[scaleIndex]);
            //System.out.println(scaleIndex);
            //System.out.println(intAr[8]);
            startX-=intAr[scaleIndex];
        }
        if (i == 40 || i==83 )
        {
            // Moving Down
            startX+=intAr[scaleIndex];
        }
        if (i == 37 || i == 65 )
        {
            // Moving Left
            startY-=intAr[scaleIndex];
        }
        if (i == 39 || i ==  68)
        {
            // Moving Right
            startY+=intAr[scaleIndex];
        }
    }

    public void enhance(int x, int y)
    {   
        int newScale = intAr[scaleIndex-1];
        int newX = x - (newScale*width)/2;
        int newY = y - (newScale*height)/2;
        System.out.println("New X: "+newX+" New Y: "+newY);
        Grid deeperGrid = new Grid(width*newScale,height*newScale,sizePerSquare/newScale,newScale,newY,newX,globalObjArray,terrain);
        deeperGrid.assignScaleIndex();
        deeperGrid.launch();
    }

    public static void demo(int width, int height, int sizePerSquare, int scale, int startX, int startY)
    {
        Player joe = new Player(0,1);
        joe.setName("Joe");
        Object obj = new PlayerActor(joe);
        // 10x10 demo obj list for demoing
        Object[][] objIn = {
                {obj ,null,null,null,null,null,null,null,null,null},
                {null,obj ,null,obj ,null,null,null,null,null,null},
                {obj ,null,null,obj ,null,null,null,null,null,null},
                {null,null,obj ,obj ,null,null,null,null,null,null},
                {obj ,null,null,null,obj ,null,null,null,null,null},
                {null,null,null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null,null,null}
            };
        Grid nGrid = new Grid(width,height,sizePerSquare,scale,startX,startY,objIn,terrain);
        nGrid.launch();
    }

    public static void movePlayer(int oldX, int oldY, int newX, int newY, Object obj)
    {
        double sight = terrain[newX][newY].getSight();
        int baseView = Controller.getBaseWidth();
        int vision = (int)( sight*baseView +1);
        width = vision;
        height = vision;

        int xCord = oldX - width/2;
        int yCord = oldY - height/2;

        startX = xCord;
        startY = yCord;

        localObjArray = new Object[width][height];
        btList = new Button[width][height];

        sizePerSquare = ( 100.0/ (double)width );
        Object oldObj = globalObjArray[oldX][oldY];
        globalObjArray[newX][newY] = oldObj;
        globalObjArray[oldX][oldY] = null;
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
        /*for (int i = 0; i < factList.length; i++)
        {
        System.out.println(factList[i]);
        }*/
        return factList;
    }
}