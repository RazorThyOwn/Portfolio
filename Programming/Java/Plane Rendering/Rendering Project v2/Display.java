import sacco.*;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math.*;

public class Display extends SaccoObject
{
    private int windowSize;
    private int pixelScale = 30;
    private int windowMod = 20;

    private int vDeg = 0;
    private int rotDeg = 0;

    boolean incLeft = false, incRight = false, incUp = false, incDown = false;

    int[][] xCords;
    int[][] yCords;

    private int[] edgeCordsX = new int[4];
    private int[] edgeCordsY = new int[4];

    private int[][] heightVals;

    // Boolean to print when stuff happens
    private boolean readCommands = true;

    static void main()
    {
        Display dP = new Display(19);
        dP.setVisible(true);
    }

    Display()
    {
        setup(50);
    }

    Display(int scale)
    {
        setup(scale);
    }

    private void setup(int scale)
    {            
        WorldGen wGen = new WorldGen();
        heightVals = wGen.genZero(scale);
        //heightVals = wGen.genCHill(scale,60);
        //heightVals = wGen.genCValley(scale,60);
        heightVals = wGen.genRandom(scale,60);

        // Randomly generating height values

        xCords = new int[scale][scale];
        yCords = new int[scale][scale];

        windowSize = (scale+1)*pixelScale + 2*windowMod;
    }

    public void paintWindow(PaintBrush brush)
    {
        // Rotating shit

        if (vDeg!=0 && incUp)
            vDeg--;
        if (vDeg< (xCords.length*2) && incDown)
            vDeg++;

        if (incLeft)
            rotDeg-=2;
        if (incRight)
            rotDeg+=2;

        // Setup...
        this.setSize(windowSize,windowSize);
        ////////////////////////////
        // DETERMINING EDGE CORDS //
        ///////////////////////////

        for (int i = 0; i < 4; i++)
        {
            // Determining X offset...
            int degree = 90*i + rotDeg +45;
            double radian = ( ((double)degree)/180.0 )*3.14159;
            double cos = java.lang.Math.cos(radian);
            double moveNumberX = cos*pixelScale*(xCords.length/2 + 1);
            int mNX = (int)moveNumberX;

            // Determining Y offset...
            double sin = java.lang.Math.sin(radian);
            double moveNumberY = sin*pixelScale*(xCords.length/2 + 1);
            int mNY = (int)moveNumberY;           

            edgeCordsX[i] = (windowSize/2 + mNX);
            edgeCordsY[i] = (windowSize/2 + mNY);
        }

        ////////////////////////////////
        // DETERMINING X and Y SLOPES //
        ////////////////////////////////

        double ySlope = 999999;
        double xSlope = 999999;

        if (edgeCordsX[2]-edgeCordsX[3] != 0)
        {
            ySlope = ( (double)edgeCordsY[2]-(double)edgeCordsY[3] )/( (double)edgeCordsX[2]-(double)edgeCordsX[3]);
        }
        if (edgeCordsX[1]-edgeCordsX[2] !=0 )
        {
            xSlope = ( (double)edgeCordsY[1]-(double)edgeCordsY[2])/( (double)edgeCordsX[1]-(double)edgeCordsX[2] );
        }

        ///////////////////////////////////
        // ADJUST X AND Y CORDS FOR TURN //
        //////////////////////////////////

        double distanceX = edgeCordsX[3]-edgeCordsX[2];
        double scaleX = (distanceX/(xCords.length-1));

        double distanceY = edgeCordsY[3]-edgeCordsY[2];
        double scaleY = (distanceY/(xCords.length-1));

        for (int i = 0; i < xCords.length; i++)
        {          
            for (int n = 0; n < xCords.length; n++)
            {                
                xCords[i][n] = edgeCordsX[2] + (int)(scaleX*i) - (int)(scaleY*n);
                yCords[i][n] = edgeCordsY[2] + (int)(scaleX*n) + (int)(scaleY*i);
            }
        }

        /////////////////////////////////////
        // ADJUSTING X AND Y CORDS FOR TILT //
        /////////////////////////////////////

        // Determining largest X and Y

        double largestX = -1;
        double largestY = -1;

        for (int i = 0; i < yCords.length; i++)               
        {
            for (int n = 0; n < yCords.length; n++)
            {
                if (yCords[i][n] > largestY)
                    largestY = yCords[i][n];
                if (xCords[i][n] > largestX)
                    largestX = xCords[i][n];
            }
        }

        for (int i = 0; i < xCords.length; i++)
        {
            for (int n = 0; n < xCords.length; n++)
            {                               
                double yDistance = yCords[i][n] - (double)windowSize/2;                
                yDistance = yDistance/ (xCords.length);

                yCords[i][n] = yCords[i][n] - (int)( (vDeg*yDistance)/2.0 );
            }
        }

        ////////////////////////////
        // DRAWING ALL OF THE SHIT //
        ////////////////////////////

        for (int i = 0; i < xCords.length - 1; i++)
        {
            double useVdeg = (double)vDeg/(double)xCords.length;
            for (int n = 0; n < yCords.length - 1; n++)
            {
                int iIndex = i;
                int nIndex = n;

                // Determining which side to render via camera angle

                if (rotDeg>=0 && rotDeg<90)
                {
                    iIndex = i;
                    nIndex = n;
                }
                else if (rotDeg>=90 && rotDeg<180)
                {
                    iIndex = i;
                    nIndex = xCords.length - 2 - n;
                }
                else if (rotDeg>=180 && rotDeg<270)
                {
                    iIndex = xCords.length - 2 - i;
                    nIndex = xCords.length - 2 - n;
                }
                else if (rotDeg>=270 && rotDeg<360)
                {
                    iIndex = xCords.length - 2 - i;
                    nIndex = n;
                }

                int p1yPlus = (int)(useVdeg * (double)heightVals[iIndex][nIndex] );
                int p2yPlus = (int)(useVdeg * (double)heightVals[iIndex+1][nIndex] );
                int p3yPlus = (int)(useVdeg * (double)heightVals[iIndex][nIndex+1] );                
                int p4yPlus = (int)(useVdeg * (double)heightVals[iIndex+1][nIndex+1] );

                Point p1 = new Point(xCords[iIndex][nIndex],yCords[iIndex][nIndex]);
                Point p2 = new Point(xCords[iIndex+1][nIndex],yCords[iIndex+1][nIndex]);
                Point p3 = new Point(xCords[iIndex][nIndex+1],yCords[iIndex][nIndex+1]);
                Point p4 = new Point(xCords[iIndex+1][nIndex+1],yCords[iIndex+1][nIndex+1]);

                Polygon pG1 = new Polygon();
                Polygon pG2 = new Polygon();

                pG1.addPoint(p1.getX(),p1.getY()+p1yPlus);
                pG1.addPoint(p2.getX(),p2.getY()+p2yPlus);
                pG1.addPoint(p3.getX(),p3.getY()+p3yPlus);

                pG2.addPoint(p2.getX(),p2.getY()+p2yPlus);
                pG2.addPoint(p3.getX(),p3.getY()+p3yPlus);
                pG2.addPoint(p4.getX(),p4.getY()+p4yPlus);

                //System.out.println(p1yPlus+","+p2yPlus+","+p3yPlus+","+p4yPlus);

                int pg1Difference = (p1yPlus+p2yPlus+p3yPlus)/3 - p1yPlus;
                int pg2Difference = (p1yPlus+p2yPlus+p3yPlus)/3 - p2yPlus;

                // Determining brush color                               

                //Drawing polygons

                int colorScale = (int)(255.0/(double)xCords.length);
                brush.setColor(iIndex*colorScale,nIndex*colorScale,(iIndex+nIndex)*(colorScale/2));

                brush.fillPolygon(pG1);               
                brush.fillPolygon(pG2);                
            }
            if (rotDeg>360)
                rotDeg = 0;
            if (rotDeg<0)
                rotDeg = 360;
        }
    }

    public void onKeyPress(int i)
    {
        if ( (i == 38 || i == 87) )
        {
            incUp = true;
        }
        if ( (i == 40 || i == 83) )
        {
            incDown = true;
        }
        if ( (i==37 || i == 65) )
        {
            incLeft = true;
        }
        if ( (i == 39 || i == 68) )
        {
            incRight = true;
        }
    }

    public void onKeyRelease(int i)
    {
        if ( (i == 38 || i == 87) )
        {
            incUp = false;
        }
        if ( (i == 40 || i == 83) )
        {
            incDown = false;
        }
        if ( (i==37 || i == 65) )
        {
            incLeft = false;
        }
        if ( (i == 39 || i == 68) )
        {
            incRight = false;
        }
    }
}

/* Legacy
 *  ###
 *  Version 1.0 @ 11:55 May 2nd 2015
 *  ###
 * this.setSize(windowSize,windowSize);

// Determining point X...
int[][] xCords = new int[bPointList.length+1][bPointList.length+1];
int[][] yCords = new int[bPointList.length+1][bPointList.length+1];
for (int i = 0; i < xCords.length; i++)
{
for (int n = 0; n < xCords.length; n++)
{
// Default values...

yCords[i][n] = windowMod + i*pixelScale;
xCords[i][n] = windowMod + n*pixelScale;
}
}

for (int i = 0; i < xCords.length; i++)
{
for (int n = 0; n < xCords.length; n++)
{
brush.setColor(0,0,0);
brush.fillRectangle(xCords[i][n]-5,yCords[i][n]-5,10,10);
}
}

brush.drawLine(0,0,windowSize,windowSize);
brush.drawLine(windowSize,0,0,windowSize);

for (int x = 0; x < xCords.length/2 +1; x++)
{
int xCord = windowSize/2 - (x)*pixelScale;
int yCord = windowSize/2 - (x)*pixelScale;
brush.drawOval(xCord,yCord,pixelScale*2*x,pixelScale*2*x);
}
int rad = 2*(int)(java.lang.Math.sqrt(2) * (double)(xCords.length/2 * pixelScale));

brush.setColor(250,0,0);
brush.drawOval(windowSize/2 - rad/2,windowSize/2 - rad/2,rad,rad);

DRAWING CORNER CIRCLE ON EDGES (DID NOT WORK)
12:11 May 3rd 2015
int rad = 2*(int)(java.lang.Math.sqrt(2) * (double)(xCords.length/2 * pixelScale));

brush.setColor(250,0,0);
brush.drawOval(windowSize/2 - rad/2,windowSize/2 - rad/2,rad,rad);

Drawing helpers...
for (int i = 0; i < edgeCordsX.length; i++)
{
brush.setColor(0,0,0);

if (i==1)
brush.setColor(255,0,0);
if (i==2)
brush.setColor(0,255,0);
if (i==3)
brush.setColor(0,0,255);
brush.fillRectangle(edgeCordsX[i] - 5, edgeCordsY[i] - 5, 10,10);
brush.setColor(0,0,0);
} 

////////////////////////////////
// DRAWING THE HELPER CIRCLES //
////////////////////////////////

for (int x = 0; x < xCords.length/2 +2; x++)
{
int xCord = windowSize/2 - (x)*pixelScale;
int yCord = windowSize/2 - (x)*pixelScale;
if (x==xCords.length/2 +1)
brush.setColor(255,0,0);

brush.drawOval(xCord,yCord + (vDeg*x)/2,pixelScale*2*x,pixelScale*2*x - vDeg*x);
}
Old height system May 5th 6:10 2015
 *
int yDistance = yCords[i][n] - windowSize/2;
double useVdeg = (double)xCords.length/((double)(vDeg+xCords.length-1));              
yDistance = (int)((double)yDistance*useVdeg);
yCords[i][n] = windowSize/2 + yDistance;      

for (int i = 0; i < xCords.length; i++)
{
double useVdeg = (double)vDeg/(double)xCords.length;
for (int n = 0; n < xCords.length; n++)
{

int p1yPlus = (int)(useVdeg * (double)heightVals[i][n] );
int p2yPlus = (int)(useVdeg * (double)heightVals[i+1][n] );
int p3yPlus = (int)(useVdeg * (double)heightVals[i][n+1] );                
int p4yPlus = (int)(useVdeg * (double)heightVals[i+1][n+1] );

Point p1 = new Point(xCords[i][n],yCords[i][n]);
Point p2 = new Point(xCords[i+1][n],yCords[i+1][n]);
Point p3 = new Point(xCords[i][n+1],yCords[i][n+1]);
Point p4 = new Point(xCords[i+1][n+1],yCords[i+1][n+1]);

Polygon pG = new Polygon();
pG.addPoint(p1.getX(),p1.getY()+p1yPlus);
pG.addPoint(p2.getX(),p2.getY()+p1yPlus);
pG.addPoint(p3.getX(),p3.getY()+p1yPlus);
pG.addPoint(p4.getX(),p4.getY()+p1yPlus);

brush.fillPolygon(pG);

// 'Horizontal'
if (i!=xCords.length-1)
{
int p1yPlus = (int)(useVdeg * (double)heightVals[i][n] );
int p2yPlus = (int)(useVdeg * (double)heightVals[i+1][n] );

Point p1 = new Point(xCords[i][n],yCords[i][n]);
Point p2 = new Point(xCords[i+1][n],yCords[i+1][n]);
brush.drawLine(p1.getX(),p1.getY()+p1yPlus,p2.getX(),p2.getY()+p2yPlus);
}

//'Vertical'
if (n!=xCords.length-1)
{
int p1yPlus = (int)(useVdeg * (double)heightVals[i][n] );
int p2yPlus = (int)(useVdeg * (double)heightVals[i][n+1] );

Point p1 = new Point(xCords[i][n],yCords[i][n]);
Point p2 = new Point(xCords[i][n+1],yCords[i][n+1]);
brush.drawLine(p1.getX(),p1.getY()+p1yPlus,p2.getX(),p2.getY()+p2yPlus);

}
}*/
