public class WorldGen
{
    int[][] genRandom(int scale, int rSize)
    {
        int[][] newVals = new int[scale][scale];

        for (int i = 0; i < scale; i++)
            for (int n = 0; n < scale; n++)
            {
                int random = (scale/2) - (int)(Math.random()*scale);
                newVals[i][n] = random;
        }
        return newVals;
    }

    int[][] genCHill(int scale, int rSize)
    {
        int[][] newVals = new int[scale][scale];

        for (int i = 0; i < scale; i++)
            for (int n = 0; n < scale; n++)
            {
                int middleX = scale/2;
                int middleY = scale/2;

                double distance = java.lang.Math.sqrt( java.lang.Math.pow(i-middleX,2) + java.lang.Math.pow(n-middleY,2) );

                double setVal = -(double)rSize/distance;

                if (setVal > Integer.MAX_VALUE || setVal < Integer.MIN_VALUE)
                {
                    setVal = -rSize;
                }

                newVals[i][n] = (int)setVal;
        }
        return newVals;
    }

    int[][] genCValley(int scale, int rSize)
    {
        int[][] newVals = new int[scale][scale];

        for (int i = 0; i < scale; i++)
            for (int n = 0; n < scale; n++)
            {
                int middleX = scale/2;
                int middleY = scale/2;

                double distance = java.lang.Math.sqrt( java.lang.Math.pow(i-middleX,2) + java.lang.Math.pow(n-middleY,2) );

                double setVal = +(double)rSize/distance;

                if (setVal > Integer.MAX_VALUE || setVal < Integer.MIN_VALUE)
                {
                    setVal = +rSize;
                }

                newVals[i][n] = (int)setVal;
        }
        return newVals;
    }

    int[][] genZero(int scale)
    {
        int[][] newVals = new int[scale][scale];

        for (int i = 0; i < scale; i++)
            for (int n = 0; n < scale; n++)
            {
                newVals[i][n] = 0;
        }

        return newVals;
    }
}