import sacco.*;
import java.awt.Color;
public class Grid extends Display
{
    static Object[][] globalObjArray; // Used for players
    static Tile[][] terrain; // Used for terrain
    Object[][] localObjArray;

    int width;
    int height;
    int sizePerSquare;
    int scale;
    static int startX;
    static int startY;
    int ppS = 10;

    int updateCounter = 0;    

    Button[][] btList;

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
            sizePerSquare = (int) ( 120.0/ (double)width );
        else
            sizePerSquare = (int)sizePerSquareIn;
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
        brush.setColor("black");
        this.setSize((width*sizePerSquare*ppS),(height*sizePerSquare*ppS));

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
                        brush.fillRectangle((i*ppS*sizePerSquare),(k*ppS*sizePerSquare),(ppS*sizePerSquare),(ppS*sizePerSquare));
                    if (drawObjList[i][k].objectType == 1)
                    {
                        brush.setColor("black");
                        brush.fillRectangle((i*ppS*sizePerSquare),(k*ppS*sizePerSquare),(ppS*sizePerSquare),(ppS*sizePerSquare));
                        Button tmpButton = new Button((i*ppS*sizePerSquare),(k*ppS*sizePerSquare),(ppS*sizePerSquare),(ppS*sizePerSquare));
                        btList[i][k] = tmpButton;
                        brush.setColor(254,194,63);
                        brush.setFontSize((sizePerSquare*ppS));
                        PlayerActor tmpAct = (PlayerActor)(drawObjList[i][k]);
                        String name = tmpAct.getPlayer().getName().substring(0,1);
                        brush.drawString(name,(i*ppS*sizePerSquare) + sizePerSquare,(k*ppS*sizePerSquare) + (sizePerSquare*ppS) - sizePerSquare);
                    }
                    if (drawObjList[i][k].objectType == 2 && drawObjList[i][k]!=null)
                    {
                        Tile terrTile = (Tile)(drawObjList[i][k]);
                        //if (terrTile!=null)
                        if (terrTile.getPicture()!=null)
                        {
                            brush.drawPicture(terrTile.getPicture(),(i*ppS*sizePerSquare),(k*ppS*sizePerSquare),(ppS*sizePerSquare),(ppS*sizePerSquare));
                            //brush.fillRectangle((i*ppS*sizePerSquare),(k*ppS*sizePerSquare),(ppS*sizePerSquare),(ppS*sizePerSquare));
                        }
                        if (terrTile.getPicture()==null)
                        {
                            brush.setColor("black");
                            brush.fillRectangle((i*ppS*sizePerSquare),(k*ppS*sizePerSquare),(ppS*sizePerSquare),(ppS*sizePerSquare));
                        }
                    }
                }
            }
        }

        brush.setColor("black");

        for (int i = 0; i < width; i++)
        {
            brush.drawLine((i*sizePerSquare*ppS),0,(i*sizePerSquare*ppS),(height*sizePerSquare*ppS));
        }
        for (int i = 0; i < height; i++)
        {
            brush.drawLine(0,(i*sizePerSquare*ppS),(height*sizePerSquare*ppS),(i*sizePerSquare*ppS));
        }
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
        Player joe = new Player(0);
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

    public static void moveObject(int oldX, int oldY, int newX, int newY, Object obj)
    {
        Object oldObj = globalObjArray[oldX][oldY];
        globalObjArray[newX][newY] = oldObj;
        globalObjArray[oldX][oldY] = obj;
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