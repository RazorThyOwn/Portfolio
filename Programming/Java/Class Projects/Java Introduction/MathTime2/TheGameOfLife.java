import sacco.*;
import sacco.testers.*;
public class TheGameOfLife implements GameOfLife
{
    public boolean[][] gArr = new boolean[125][90];

    public TheGameOfLife()
    {
        boolean[][] arr = new boolean[125][90];
        gArr = arr;
    }

    public void setVals(boolean[][] arr)
    {
        gArr = arr;
    }

    public boolean getValAt(int r, int c)
    {
        return gArr[r][c];
    }

    public void setValAt(int r, int c, boolean val)
    {
        gArr[r][c] = val;
    }

    public void toggle(int r, int c)
    {
        gArr[r][c] = !gArr[r][c];
    }

    public int numRows()
    {
        return gArr.length;
    }

    public int numCols()
    {
        return gArr[0].length;
    }

    public void reset()
    {
        gArr = new boolean[1250][90];
    }

    public int numOfNeighbors(int r, int c)
    {
        int nB = 0;
        for (int row = r-1; row <= r+1;row++)
        {
            for (int col = c-1; col <= c+1; col++)
            {
                if (!(row<0) && !(col<0) && row<this.numRows() && col<this.numCols() && gArr[row][col])
                {
                    nB++;
                }
            }
        }
        if (gArr[r][c])
            return nB-1;
        else
            return nB;
    }

    public void step()
    {
        boolean[][] modGarr = new boolean[125][90];

        for (int row = 0; row < this.numRows(); row++)
        {
            for (int col = 0; col < this.numCols(); col++)
            {
                if (gArr[row][col])
                {
                    modGarr[row][col] = true;
                }
                if (gArr[row][col] && this.numOfNeighbors(row, col) > 3)
                {
                    modGarr[row][col] = false;
                }
                else if (!(gArr[row][col]) && this.numOfNeighbors(row, col) == 3)
                {
                    modGarr[row][col] = true;
                }
                else if (gArr[row][col]  && this.numOfNeighbors(row, col) <= 1)
                {
                    modGarr[row][col] = false;
                }
            }
        }
        
        gArr = modGarr;
    }

    public static void main()
    {
        TheGameOfLife model = new TheGameOfLife();
        GameOfLifeRunner.launchGame(model);
    }
}