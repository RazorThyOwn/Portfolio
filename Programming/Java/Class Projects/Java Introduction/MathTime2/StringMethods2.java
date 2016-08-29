import java.util.Scanner;

public class StringMethods2
{
    public static void sentenceMaker()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a phrase to recapitalize");
        String str1 = scan.nextLine();
        str1 = str1.toLowerCase();
        String str2 = str1.substring(0,1);
        str2 = str2.toUpperCase();
        String str3 = str1.substring(1);
        System.out.print(str2);
        System.out.print(str3);
    }

    public static void wordGrabber()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a phrase to split");
        String str1 = scan.nextLine();
        int index1 = str1.indexOf(" ");
        System.out.println(str1.substring(0,index1));
        System.out.println(str1.substring(index1+1,(str1.length())));

    }

    public static void getInitials()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter ye name!");
        String str1 = scan.nextLine();
        int index1 = str1.indexOf(" ");
        String firstID = str1.substring(0,1);
        String secondID = str1.substring(index1+1,index1+2);
        str1 = str1.substring(index1+1);
        index1 = str1.indexOf(" ");
        String thirdID = str1.substring(index1+1,index1+2);
        System.out.println("Your initials are: "+firstID+". "+secondID+". "+thirdID+".");
    }

    public static void goFalcons()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter ye SRHS phrase!");
        String str1 = scan.nextLine();
        int index = str1.indexOf("srhs");
        String strFH = str1.substring(0,index);
        String strLH = str1.substring(index+4);
        String strSRHS = str1.substring(index,index+4);
        strSRHS = strSRHS.toUpperCase();
        System.out.print(strFH);
        System.out.print(strSRHS);
        System.out.print(strLH);

    }
}