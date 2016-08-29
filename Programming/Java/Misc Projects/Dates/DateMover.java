import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Date;
import java.util.Calendar;

public class DateMover {
    
    public static void main()
    {
        int friday = 0;
        int numDays = 0;
        BufferedReader inputStream = null;
        
        try {
            inputStream = new BufferedReader(new FileReader("dates.txt"));
            Calendar cal = null;
            String l;
            while ((l = inputStream.readLine()) != null) {
                int firstSpace = l.indexOf(' ');
                String month = l.substring(0,firstSpace);
                
                l = l.substring(firstSpace);
                int comma = l.indexOf(',');
                int day = Integer.parseInt(l.substring(1,comma));
                
                l = l.substring(comma+2);
                int year = Integer.parseInt(l);
                
                int intMonth = 0;
                if (month.equals("January")) {intMonth = 1;}
                if (month.equals("February")) {intMonth = 2;}
                if (month.equals("March")) {intMonth = 3;}
                if (month.equals("April")) {intMonth = 4;}
                if (month.equals("May")) {intMonth = 5;}
                if (month.equals("June")) {intMonth = 6;}
                if (month.equals("July")) {intMonth = 7;}
                if (month.equals("August")) {intMonth = 8;}
                if (month.equals("September")) {intMonth = 9;}
                if (month.equals("October")) {intMonth = 10;}
                if (month.equals("November")) {intMonth = 11;}
                if (month.equals("December")) {intMonth = 12;}
                
                
                Date date = new Date(year,intMonth,day);
                cal = Calendar.getInstance();
                cal.setTime(date);
                cal.add(Calendar.DATE, 365);
                
                if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                    friday++;
                }
                numDays ++;
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
        
        System.out.println(friday);
        System.out.println(numDays);
    }
}