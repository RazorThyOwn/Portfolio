public class DateObj
{
    private int cDay;
    private int cMonth;
    private int cYear;
    
    public DateObj()
    {
        cDay = 1;
        cMonth = 1;
        cYear = 1900;
    }
    
    public String getDate()
    {
        String str = "The date is "+cMonth+"/"+cDay+"/"+cYear;
        return str;
    }
    
    public void setDate(int ttMonth, int ttDay, int ttYear)
    {
        cDay = ttDay;
        cMonth = ttMonth;
        cYear = ttYear;
    }
    // Setting Dates //
    
    public void setDay(int tmpday)
    {
        cDay = tmpday;
    }
    
    public void setMonth(int tmpmonth)
    {
        cMonth = tmpmonth;
    }
    
    public void setYear(int tmpyear)
    {
        cYear = tmpyear;
    }
    
    // Getting Dates //
    
    public int getDay()
    {
        return cDay;    
    }
    
    public int getMonth()
    {
        return cMonth;
    }
    
    public int getYear()
    {
        return cYear;    
    }
    
}