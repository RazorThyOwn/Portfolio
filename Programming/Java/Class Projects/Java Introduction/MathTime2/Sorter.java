public class Sorter 
{
    public static void selectionSort(Comparable[] arr)
    {
        for (int i = 0;i<arr.length;i++)
        {
            int num = indexOfLowest(arr,i);
            Comparable smallest = arr[i];
            arr[i]=arr[num];
            arr[num]=smallest;
        }
    }

    public static int indexOfLowest(Comparable[] arr, int startIndex)
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

    public static Comparable findGreatest(Comparable[] arr)
    {
        Comparable storedVar = arr[0];
        for (int i = 0;i<arr.length;i++)
        {
            if (arr[i].compareTo(storedVar)>0)
                storedVar = arr[i];
        }
        return storedVar;
    }

    public static Comparable findLowest(Comparable[] arr)
    {
        Comparable storedVar = arr[0];
        for (int i = 0;i<arr.length;i++)
        {
            if (arr[i].compareTo(storedVar)<0)
                storedVar = arr[i];
        }
        return storedVar;
    }

    public static void stringTest()
    {
        String[] strs = new String[20];

        for( int i =0; i < strs.length;i++)
        {
            int val = (int)(Math.random()*26)+65;
            strs[i] = (char)val+"";
        }

        System.out.println("Before sort: "+java.util.Arrays.toString(strs));
        System.out.println("Lowest Value: "+Sorter.findLowest(strs));
        System.out.println("Greatest Value: "+ Sorter.findGreatest(strs)); 
        System.out.println("Unchanged Array: "+java.util.Arrays.toString(strs));
        Sorter.selectionSort(strs);
        System.out.println("Sorted Array: "+java.util.Arrays.toString(strs)); 
    }

    public static void integerTest()
    {
        Integer[] ints = new Integer[10];

        for( int i =0; i < ints.length;i++)
        {
            ints[i] = new Integer((int)(Math.random()*100)); 
        }

        System.out.println("Before sort: "+java.util.Arrays.toString(ints));
        System.out.println("Lowest Value: "+Sorter.findLowest(ints));
        System.out.println("Greatest Value: "+ Sorter.findGreatest(ints)); 
        System.out.println("Unchanged Array: "+java.util.Arrays.toString(ints));
        Sorter.selectionSort(ints);
        System.out.println("Sorted Array: "+java.util.Arrays.toString(ints)); 
    }

    public static void doubleTest()
    {
        Double[] dubs = new Double[10];

        for( int i =0; i < dubs.length;i++)
        {
            dubs[i] = new Double(Math.random()*100); 
        }

        System.out.println("Before sort: "+java.util.Arrays.toString(dubs));
        System.out.println("Lowest Value: "+Sorter.findLowest(dubs));
        System.out.println("Greatest Value: "+ Sorter.findGreatest(dubs)); 
        System.out.println("Unchanged Array: "+java.util.Arrays.toString(dubs));
        Sorter.selectionSort(dubs);
        System.out.println("Sorted Array: "+java.util.Arrays.toString(dubs));
    }

}