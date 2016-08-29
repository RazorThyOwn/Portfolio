import java.util.Scanner;
public class DateRunner
{
    public static void main()
    {
        
        //Object Constuction
        DateObj dt = new DateObj();
        Scanner scan = new Scanner(System.in);
        /*
        System.out.println("==== Date Reading/Writting ====\n\n");
        
        dt.setDate(2, 4, 1901);
        String date = dt.getDate();
        System.out.println(date);
        dt.setDay(25);
        date = dt.getDate();
        System.out.println(date);
        dt.setYear(2013);
        date = dt.getDate();
        System.out.println(date);
        dt.setMonth(9);
        date = dt.getDate();
        System.out.println(date);
        
        int tDay = dt.getDay();
        int tMonth = dt.getMonth();
        int tYear = dt.getYear();
        
        System.out.println("The day is "+tDay+", the month is "+tMonth+", the year is "+tYear);
        */
        
        System.out.println("==== Birthday ====\n\n");
        System.out.println("Enter your birth month...");
        String bMonth = scan.nextLine();
        System.out.println("Enter your birth day...");
        String bDay = scan.nextLine();
        System.out.println("Enter your birth year..");
        String bYear = scan.nextLine();
        
        int iMonth = Integer.parseInt(bMonth);
        int iDay = Integer.parseInt(bDay);
        int iYear = Integer.parseInt(bYear);
        
        System.out.println("You were born on "+iMonth+"/"+iDay+"/"+iYear);
        System.out.println("You can drive on "+iMonth+"/"+iDay+"/"+ (iYear+16) );
        System.out.println("You can vote on "+iMonth+"/"+iDay+"/"+ (iYear+18) );
        System.out.println("You can drink on "+iMonth+"/"+iDay+"/"+ (iYear+21) );
        System.out.println("You can join the AARP on "+iMonth+"/"+iDay+"/"+ (iYear+50) );
        
    }
}