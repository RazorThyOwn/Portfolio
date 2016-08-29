import java.awt.Color;
import sacco.*;

import java.awt.event.KeyEvent;

public class Legacy 
{
    // Input old, lost code :(
    public static void main()
    {
        Picture pic = Picture.loadFromJar("tilePictures/00_0.jpg");
        pic.display();
    }

    public static void test()
    {
        String test = "Shortsword   |   15  |   7   |   3   |   -1  |   15  |   37  |   A short sword, made of iron";
        System.out.println(test);
        System.out.println(test.indexOf("   "));
    }

    /*public void animalAi()
    {
    int randMath = (int)Math.random()*8;
    if (randMath == 0)
    moveUpL();
    if (randMath == 1)
    moveUpU();
    if (randMath == 2)
    moveUpR();
    if (randMath == 3)
    moveLeft();
    if (randMath == 4)
    moveRight();
    if (randMath == 5)
    moveDownL();
    if (randMath == 6)
    moveDownD();
    if (randMath == 7)
    moveDownR();
    }*/
}
/*    public static void charInput()
{
Scanner scan = new Scanner(System.in);

// Setting up Base Characteristics
for (int i = 0; i < playerList.length; i++)
{
System.out.println("Input player "+(i+1)+" name");
String name = scan.nextLine();
Player tmpPlayer = new Player();
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
tmpPlayer.setVal(j,nFinal);
}
playerList[i]=tmpPlayer;
}

// Setting up Total HP
for (int i = 0; i < playerList.length; i++)
{
double endr = playerList[i].getEndurance();
playerList[i].setHitpoints( (int) (endr*10) );
}
allCharString();
}*/

//Grid Backup
/*
import sacco.*;
import java.awt.Color;
public class Grid extends Display
{
static Object[][] globalObjArray;
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
Object[][] preCulledObjList;
Object[][] drawObjList;

//static Object[][] preCulledObjList;
//static Object[][] drawObjList;

int scaleIndex = 0;
int[] intAr = {1, 2, 3, 4, 5, 6, 8, 10, 12, 15, 16, 20, 24, 25, 30, 32, 40, 48, 50, 60, 75, 80, 96, 100, 120, 150, 160, 200, 240, 300, 400, 480, 600, 800, 1200, 2400};

public Grid(int widthIn, int heightIn, int sizePerSquareIn, int scaleIn, int startXIn, int startYIn, Object[][] objIn)
{
width = widthIn;
height = heightIn;
sizePerSquare = sizePerSquareIn;
scale = scaleIn;
startX = startXIn;
startY = startYIn;

globalObjArray = objIn;     
localObjArray = new Object[width][height];

btList = new Button[width][height];

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
this.setSize(width*sizePerSquare*ppS,(height*sizePerSquare*ppS));

for (int i = 0; i < width; i++)
{
brush.drawLine(i*sizePerSquare*ppS,0,i*sizePerSquare*ppS,height*sizePerSquare*ppS);
}
for (int i = 0; i < height; i++)
{
brush.drawLine(0,i*sizePerSquare*ppS,height*sizePerSquare*ppS,i*sizePerSquare*ppS);
}
if (updateCounter==0)
{
// Populating preCulledObjList with objects
preCulledObjList = new Object[width*scale][height*scale];
for (int i = startX; i < startX + (width*scale);i++)
{
for (int k = startY; k < startY + (height*scale);k++)
{
if (i < 0 || k <0 || i >= globalObjArray.length || k >= globalObjArray[i].length)
{
Object wallObj = new Object();
preCulledObjList[i-startX][k-startY] = wallObj;
}
else
{
preCulledObjList[i-startX][k-startY] = globalObjArray[i][k];
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
/*
drawObjList = new Object[width][height];
for (int i = 0; i < width*scale; i++)
{
for (int k = 0; k < height*scale; k++)
{
Object culledObj = preCulledObjList[i][k];
if (culledObj!=null)
{
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
}
}
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
brush.fillRectangle(i*ppS*sizePerSquare,k*ppS*sizePerSquare,ppS*sizePerSquare,ppS*sizePerSquare);
if (drawObjList[i][k].objectType == 1)
{
brush.fillRectangle(i*ppS*sizePerSquare,k*ppS*sizePerSquare,ppS*sizePerSquare,ppS*sizePerSquare);
Button tmpButton = new Button(i*ppS*sizePerSquare,k*ppS*sizePerSquare,ppS*sizePerSquare,ppS*sizePerSquare);
btList[i][k] = tmpButton;
brush.setColor(254,194,63);
brush.setFontSize(sizePerSquare*ppS);
PlayerActor tmpAct = (PlayerActor)(drawObjList[i][k]);
String name = tmpAct.getPlayer().getName().substring(0,1);
brush.drawString(name,i*ppS*sizePerSquare + sizePerSquare,k*ppS*sizePerSquare + sizePerSquare*ppS - sizePerSquare);
}
}
}
}

updateCounter++;
if (updateCounter>1)
updateCounter=0;
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
PlayerActor act = (PlayerActor)localObjArray[i][k];
Player player = act.getPlayer();
Player[] playerArray = {player};
CharDisplay cD = new CharDisplay(playerArray,1);
cD.launch();
}
if (m.getButton()==1)
{
PlayerActor act = (PlayerActor)localObjArray[i][k];
Player player = act.getPlayer();
System.out.println(intAr[scaleIndex]);
MovementScreen mScreen = new MovementScreen(player,intAr[scaleIndex],globalObjArray.length,globalObjArray[i].length);
mScreen.launch();
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
Grid deeperGrid = new Grid(width*newScale,height*newScale,sizePerSquare/newScale,newScale,newY,newX,globalObjArray);
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
Grid nGrid = new Grid(width,height,sizePerSquare,scale,startX,startY,objIn);
nGrid.launch();
}

public static void moveObject(int oldX, int oldY, int newX, int newY)
{
Object oldObj = globalObjArray[oldX][oldY];
globalObjArray[newX][newY] = oldObj;
globalObjArray[oldX][oldY] = null;
}
}

public Tile[] getAdjacentTiles(int x, int y)
{
Tile[] adjacentTiles = new Tile[8];
int index = 0;
for (int tx = 0; tx < 3; tx++)
{
for (int ty = 0; ty < 3; ty++)
{
// Legacy version that returns 8
int tmpX = x + (tx-1);
int tmpY = y + (ty-1);

if ( (tmpX>=0 && tmpY >=0 && tmpX<worldSize && tmpY<worldSize) )
{
if (tmpX!=x || tmpY!=y)
{
adjacentTiles[index] = outTerrain[tmpX][tmpY];
System.out.println(tmpX+","+tmpY);
index++;
}
}
}
}
return adjacentTiles;
}*/
