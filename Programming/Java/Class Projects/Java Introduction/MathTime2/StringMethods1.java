public class StringMethods1
{

    public static void nameMeasure(String str)
    {
        int stringLength = str.length();
        System.out.println("The String has a length of "+stringLength+" characters");
    }

    public static void vertical5(String str)
    {
        System.out.println(str.substring(0,1));
        System.out.println(str.substring(1,2));
        System.out.println(str.substring(2,3));
        System.out.println(str.substring(3,4));
        System.out.println(str.substring(4,5));
    }

    public static void firstAndLast(String str)
    {
        int sL = str.length();
        String sub1 = str.substring(0,1);
        String sub2 = str.substring(sL-1,sL);
        System.out.println(sub1+" "+sub2);
    }

    public static void endChopper(String str)
    {
        int sL = str.length();
        String sub1 = str.substring(3,str.length()-3);
        System.out.println(sub1);
    }

    public static void halfAndHalf(String str)
    {
        int sL = str.length();
        String sub1 = str.substring(0,str.length()/2);
        String sub2 = str.substring(str.length()/2);
        System.out.println(sub1);
        System.out.println(sub2);
    }

}