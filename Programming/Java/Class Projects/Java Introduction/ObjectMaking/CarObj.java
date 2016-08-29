public class CarObj
{
    private int myMileage;
    private String myPlate;
    
    public CarObj()
    {
        myMileage = 0;
        myPlate = "DEALER";
    }
    
    public String toString()
    {
        String str = "The car with license plate "+myPlate+" has "+myMileage+" miles.";
        return str;
    }
    
    public void setPlate(String plateString)
    {
        myPlate = plateString;
    }
    public void addMileage(int Mileage)
    {
        myMileage = myMileage + Mileage;
    }
    
    
    
}