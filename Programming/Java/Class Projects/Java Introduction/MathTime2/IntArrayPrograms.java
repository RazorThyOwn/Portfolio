public class IntArrayPrograms
{
    public static int end9(int[] arrOne, int[] arrTwo)
    {
        int count = 0; if (arrOne[arrOne.length-1]==9) { count++; }  if (arrTwo[arrTwo.length-1]==9) { count ++; } return count;
    }

    public static int[] swapEnds(int[] arr)
    {
        int storedVar = arr[0]; arr[0] = arr[arr.length-1]; arr[arr.length-1] = storedVar; return arr;
    }

    public static int[] addA9(int[] arr)
    {
        int[] newArr = new int[arr.length+1]; for (int i = 0;i<arr.length;i++) { newArr[i] = arr[i]; } newArr[newArr.length-1]=9; return newArr;
    }

    public static boolean identicalArrays(int[] arrOne, int[] arrTwo)
    {
        if (arrOne.length!=arrTwo.length) return false; for (int i = 0;i<arrOne.length;i++) {  if(arrOne[i]!=arrTwo[i]) return false; } return true;
    }

    public static boolean containsAPrime(int[] arr)
    {
        for (int a = 0;a<arr.length;a++)
        {
            int input = arr[a];
            int didMod = 0;
            for (int i=1;i<input;i++)
            {
                int checkLoop = (input % i);
                if (checkLoop==0)
                    didMod++;
                if (checkLoop==i)
                    didMod--;
            }
            if (didMod==1)
            {
                return true;
            }
        }
        return false;
    }

    public static int biggestDifference(int[] arr)
    {
        int dif = 0;
        for (int i = 0;i<arr.length-1;i++)
        {
            int difCheck = Math.abs(arr[i]-arr[i+1]);
            if (difCheck>dif)
            {
                dif = difCheck;
            }
        }
        return dif;
    }

    public static int[] post4(int[] arr)
    {
        int fourLocation = -1;
        // Get the last four //
        for (int i = 0;i<arr.length;i++)
        {
            if (arr[i]==4)
                fourLocation = i;
        }
        int[] returnArray = new int[arr.length-fourLocation-1];
        for (int i = 0;i<returnArray.length;i++)
        {
            returnArray[i] = arr[fourLocation+i+1];
        }
        return returnArray;
    }
}