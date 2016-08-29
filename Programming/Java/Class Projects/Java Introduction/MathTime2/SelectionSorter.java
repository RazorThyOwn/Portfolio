public class SelectionSorter
{

    //compares all of the Strings in arr at or after the startIndex and returns
    //the index of the lowest value.  Use compareTo to help determine this.
    public static int indexOfLowest(String[] arr, int startIndex)
    {
        for(int i = startIndex;i<arr.length;i++)
        {
            if (arr[startIndex].compareTo(arr[i])>0)
            {
                startIndex = i;
            }
        }
        return startIndex;
    }

    //Uses a selection sort strategy to sort arr
    //briefly: loop through every index and swap it with the lowest value in the array at or after that index
    public static void selectionSort(String[] arr)
    {
        for (int i = 0;i<arr.length;i++)
        {
            int num = indexOfLowest(arr,i);
            String smallest = arr[i];
            arr[i]=arr[num];
            arr[num]=smallest;
        }
    }
    //Tests the two methods above by creating an array of 30 random letters  
    //and attempting to sort them using the selectionSort method.
    public static void main()
    {

        //Create an array of random letters using char trickery (you do not have to understand
        String[] arr = new String[30];
        for( int i=0; i< arr.length; i++)
        {
            arr[i] = (char)(Math.random()*26+65)+"";
        }

        //print the array before sorting
        System.out.print("Unsorted:  ");
        for( int i=0; i< arr.length; i++)
            System.out.print(arr[i]+" ");
        System.out.println();

        //sort the array
        selectionSort(arr);

        //print the array after sorting
        System.out.print("Sorted:    ");
        for( int i=0; i< arr.length; i++)
            System.out.print(arr[i]+" ");
    }

}
