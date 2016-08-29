public class CastingWithSorter
{
    public static void initials()
    {
        String[] names = {"John McClain","Marty McFly","Andy Dufresne","Thomas Anderson", "Peter Parker", "Luke Skywalker", "Tyler Durden"};

        //use Sorter's methods to find the lowest String in the array
        String lowest = (String)Sorter.findLowest(names);

        //find and print the initials
        int firstSpace = lowest.indexOf(" ");
        String firstLetter = lowest.substring(0,1);
        String secondLetter = lowest.substring(firstSpace+1,firstSpace+2);
        String firstInits = firstLetter+"."+secondLetter+".";
        System.out.println("The lowest initials in the list are "+firstInits);
    }

    //Calculates and prints out the area of the largest of 50 random Circles
    public static void largestArea()
    {
        //Create an array of 50 random circle objects
        Circle[] circles = new Circle[50];
        for( int i =0 ; i < circles.length; i++)
        {
            circles[i] = new Circle();
        }

        //Find the circle with the largest area and print it out
        Circle circle = (Circle)Sorter.findGreatest(circles);
        System.out.println("The largest area is "+circle.getArea());

    }

    //Calculates and returns the range of 100 random doubles
    public static void getRange()
    {
        //Create an array of 100 random Double objects
        Double[] arr = new Double[100];
        for( int i =0; i < arr.length; i++)
        {
            arr[i] = new Double(Math.random()*100);
        }
        Double dubdub = (Double)Sorter.findGreatest(arr);
        Double dubdubdub = (Double)Sorter.findLowest(arr);
        //Find the highest and the lowest values in the array
        //extract the doubles out using the doubleValue method
        //print out the range
        System.out.println("The range is from "+dubdub+" to "+dubdubdub);

    }

    public static void main()
    {
        CastingWithSorter.initials();
        CastingWithSorter.largestArea();
        CastingWithSorter.getRange();
    }

}