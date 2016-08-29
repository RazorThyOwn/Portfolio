public class DigiExtractor
{
    private int targetInt;
    
    public DigiExtractor(int tmpInt)
    {
        targetInt = tmpInt;
    }
    
    public int nextDigit()
    {
        int modTen = targetInt % 10;
        int divTen = targetInt / 10;
        targetInt = divTen;
        return modTen; 
    }
}