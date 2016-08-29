public class Senior extends Student
{
    private boolean Senioritis;
    
    public Senior(String name)
    {
        super(name,12);
        Senioritis = false;
    }
    
    public void setSenioritis(boolean val)
    {
        Senioritis = val;
    }
    
    public boolean isHappy()
    {
        if (Senioritis)
            return true;
        else if (super.getGPA()>=3.5)
            return true;
        else
            return false;
    }
}