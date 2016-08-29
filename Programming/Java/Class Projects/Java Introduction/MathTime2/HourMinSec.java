public class HourMinSec
{
    private int tTime;
    
    public HourMinSec(int tSeconds)
    {
        tTime = tSeconds;
    }
    
    public String getTime()
    {
        //
        int tHours = tTime / 3600;
        int tLeft = tTime % 3600;
        int tMinutes = tLeft / 60;
        tLeft = tLeft % 60;
        int tSeconds = tLeft;
        return "Your time is "+tHours+" hours, "+tMinutes+" minutes, "+tSeconds+" seconds."; 
    }
}