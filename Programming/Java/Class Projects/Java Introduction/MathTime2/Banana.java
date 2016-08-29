public class Banana implements Speaker
{
    private String sound1 = "BANANA";
    private int count = 0;
    private int ccount = 0;
    public void speak()
    {
        System.out.println("-"+ccount+"-"+sound1.substring(count)+sound1.substring(0,count)+"-"+ccount+"-");
        if (count>5)
        {
            count=0;
        }
        count++;
        ccount++;
    }
}