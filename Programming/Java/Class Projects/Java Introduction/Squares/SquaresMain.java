import sacco.*;
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;
import java.util.List;
import java.util.ArrayList;

public class SquaresMain
{
    static List<WaterTile> waterList = new ArrayList<WaterTile>();
    static Grid mapGrid;

    public static void main(int numCol, int numRow)
    {
        World mainWorld = new World();
        BoundedGrid mainGrid = newGrid(numCol,numRow);
        mainWorld.setGrid(mainGrid);
        mainWorld.show();
    }

    public static BoundedGrid newGrid(int col, int row)
    {
        BoundedGrid rGrid = new BoundedGrid(col,row);
        riverGen(rGrid);

        return rGrid;
    }

    public static Grid riverGen(Grid inGrid)
    {
        List<Location> locList = new ArrayList<Location>();

        Location loc1 = sideLoc(-1,inGrid);             
        Location loc2 = sideLoc(-1,inGrid);

        while (loc2.getCol() == loc1.getCol() || loc2.getRow() == loc1.getRow())
            loc2 = sideLoc(-1,inGrid);

        //System.out.println(loc1.toString());
        //System.out.println(loc2.toString());

        //WaterTile tar1 = new WaterTile();
        //tar1.putSelfInGrid(inGrid,loc1);
        //WaterTile tar2 = new WaterTile();
        //tar2.putSelfInGrid(inGrid,loc2);

        //System.out.println("Loc1 Row: "+loc1.getRow()+" Loc1 Col: "+loc1.getCol());
        //System.out.println("Loc1 Row: "+loc2.getRow()+" Loc1 Col: "+loc2.getCol());

        double topCalc = loc2.getCol()-loc1.getCol();
        double bottomCalc = loc2.getRow()-loc1.getRow();
        double slope = topCalc/bottomCalc;
        double yint = loc1.getCol() - (slope*loc1.getRow());

        System.out.println("y="+slope+"x+"+yint);
        // Generating Locations to draw river from
        for (int i=0;i<inGrid.getNumCols();i++)
        {
            //System.out.println("Attempting Rivergen (Y)...");
            //WaterTile tmpTile = new WaterTile();
            int rA = (int)(Math.random()*5-2);
            int sY = (int)((slope*i)+yint);
            //System.out.println(i+","+sY);
            if (sY>=0 && sY<inGrid.getNumCols())
            {
                while (sY+rA>inGrid.getNumCols()||sY+rA<0)
                    rA = (int)(Math.random()*5-2);
                Location slopeLoc = new Location(i,sY);
                locList.add(slopeLoc);
                //tmpTile.putSelfInGrid(inGrid,slopeLoc);
                //waterList.add(tmpTile);
            }
        }
        for (int i=0;i<inGrid.getNumRows();i++)
        {
            //System.out.println("Attempting Rivergen (X)...");
            //WaterTile tmpTile = new WaterTile();
            int rA = (int)(Math.random()*5-2);
            int sX = (int)((i-yint)/slope);
            //System.out.println(sX+","+i);
            if (sX>=0 && sX<inGrid.getNumRows())
            {
                while (sX+rA>inGrid.getNumRows()||sX+rA<0)
                    rA = (int)(Math.random()*5-2);
                Location slopeLoc = new Location(sX+rA,i);
                locList.add(slopeLoc);
                //tmpTile.putSelfInGrid(inGrid,slopeLoc);
                //waterList.add(tmpTile);
            } 
        }
        System.out.println(locList.toString());
        for (int i = 0; i<locList.size();i++)
        {
            WaterTile wTmp = new WaterTile();
            wTmp.putSelfInGrid(inGrid,locList.get(i));
        }
        //inGrid = tileGen(locList,inGrid);

        return inGrid;
    }

    public static Grid tileGen(List<Location> locList, Grid inGrid)
    {
        for (int x = 0;x<locList.size()-1;x++)
        {
            Location loc1 = locList.get(x);
            Location loc2 = locList.get(x+1);
            System.out.println("Run "+x);
            double topCalc = loc2.getCol()-loc1.getCol();
            double bottomCalc = loc2.getRow()-loc1.getRow();
            double slope = topCalc/bottomCalc;
            double yint = loc1.getCol() - (slope*loc1.getRow());

            for (int i=0;i<inGrid.getNumCols();i++)
            {
                System.out.println("Attempting Rivergen (Y)...");
                WaterTile tmpTile = new WaterTile();
                int sY = (int)((slope*i)+yint);
                System.out.println(i+","+sY);
                if (sY>=0 && sY<inGrid.getNumCols())
                {
                    Location slopeLoc = new Location(i,sY);
                    tmpTile.putSelfInGrid(inGrid,slopeLoc);
                    waterList.add(tmpTile);
                }
            }
            for (int i=0;i<inGrid.getNumRows();i++)
            {
                System.out.println("Attempting Rivergen (X)...");
                WaterTile tmpTile = new WaterTile();
                int sX = (int)((i-yint)/slope);
                System.out.println(sX+","+i);
                if (sX>=0 && sX<inGrid.getNumRows())
                {
                    Location slopeLoc = new Location(sX,i);
                    tmpTile.putSelfInGrid(inGrid,slopeLoc);
                    waterList.add(tmpTile);
                } 
            }
        }
        return inGrid;
    }

    public static Location sideLoc(int avoid,Grid inGrid)
    {
        // Setting up first location for watertile
        Location loc1;

        int col = inGrid.getNumCols();
        int row = inGrid.getNumRows();
        // Setting up random numbers so we don't have to do it in the ifs
        int randCol = (int)(Math.random()*col);
        int randRow = (int)(Math.random()*row); 
        int rand = avoid;
        while (rand==avoid)
            rand = (int)(Math.random()*4);

        // Testing for vert (0=top, 1=bottom)
        if (rand==0)
            loc1 = new Location(0,randRow);
        else if (rand==1)
            loc1 = new Location(col-1,randRow);  

        // Testing for vert (2=left, 3=right)
        else if (rand==2)
            loc1 = new Location(randCol,0);
        else
            loc1 = new Location(randCol,row-1); 

        return loc1;
    }
}