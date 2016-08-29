import sacco.*;
import sacco.testers.*;

public class TwoDArrays implements MatricesAndMagicSquares
{
    public String arrayToString(int[][] arr)
    {
        String output = "";

        for (int row = 0;row<arr.length;row++)
        {
            for (int col = 0;col<arr[row].length;col++)
            {
                output+=(""+arr[row][col]+"\t");
            }
            output+="\n";
        }
        return output;
    }

    public int[][] addMatrices(int[][]a, int[][]b)
    {
        int[][] outputArr = new int[a.length][b.length];

        for (int row = 0; row < a.length; row++)
            for (int col = 0; col < b.length; col++)
            {
                outputArr[row][col] = a[row][col] + b[row][col];
        }

        return outputArr;
    }

    public int[][] multTable(int numRows,int numCols)
    {
        int[][] arr = new int[numRows][numCols];
        for (int row = 0; row < numRows; row++)
        {
            for (int col = 0; col < numCols; col++)
            {
                arr[row][col] = (col+1)*(row+1);
            }
        }
        return arr;
    }

    public int rowSum(int[][] arr, int col)
    {
        int output = 0;
        for (int rRow = 0; rRow<arr.length; rRow++)
        {
            output+=arr[col][rRow];
        }
        return output;
    }

    public int colSum(int[][] arr, int row)
    {
        int output = 0;
        for (int rRow = 0; rRow < arr.length; rRow++)
        {
            output+= arr[rRow][row];
        }
        return output;
    }

    public boolean isMagic(int[][] square)
    {
        boolean first = true;
        int sumCheck = 0;
        int rowSum = 0;
        // Rows
        for (int row = 0; row < square.length; row++)
        {
            rowSum = 0;
            for (int col = 0; col < square.length; col++)
            {
                rowSum += square[row][col];
            }
            if (first)
            {
                first = false;
                sumCheck = rowSum;
            }
            if (!first && rowSum!=sumCheck)
            {
                return false;
            }
        }
        // Columns
        for (int row = 0; row < square.length; row++)
        {
            rowSum = 0;
            for (int col = 0; col < square.length; col++)
            {
                rowSum+= square[col][row];
            }
            if (rowSum!=sumCheck)
            {
                return false;
            }
        }
        // Diagonal
        rowSum=0;
        for (int row = 0; row < square.length; row++)
        {
            rowSum+=square[row][row];
        }
        if (rowSum!=sumCheck)
        {
            return false;
        }
        return true;
    }

    public static void testAll()
    {
        TwoDArrays t = new TwoDArrays();
        MatrixTester.launchTester(t);      
    }

}