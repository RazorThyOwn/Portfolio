import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.Scanner;
import sacco.*;
public class SpaceMain
{
    public static void mainInput()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int rows = Integer.parseInt(scan.nextLine());      
        System.out.println("Enter number of columns");
        int columns = Integer.parseInt(scan.nextLine());

        ActorWorld world = new ActorWorld();
        Grid thisGrid = new BoundedGrid(rows,columns);
        
        for (int i = 0; i < rows; i++)
        for (int a = 0; a < columns; a++)
        {
            EmptySpace tmpES = new EmptySpace();
            Location tmpLoc = new Location(i,a);
            tmpES.putSelfInGrid(thisGrid, tmpLoc);
        }
        
        world.setGrid(thisGrid);
        world.show();
    }
    
        public static void main()
    {
        int rows = 25;
        int columns = 25;

        ActorWorld world = new ActorWorld();
        Grid thisGrid = new BoundedGrid(rows,columns);
        
        for (int i = 0; i < rows; i++)
        for (int a = 0; a < columns; a++)
        {
            EmptySpace tmpES = new EmptySpace();
            Location tmpLoc = new Location(i,a);
            tmpES.putSelfInGrid(thisGrid, tmpLoc);
        }
        
        world.setGrid(thisGrid);
        world.show();
    }
}