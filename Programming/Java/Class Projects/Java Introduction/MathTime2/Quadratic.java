public class Quadratic
{
    private int numA, numB, numC;
    
    public Quadratic(int tmpA, int tmpB, int tmpC)
    {
        numA=tmpA;
        numB=tmpB;
        numC=tmpC;
    }
    
    public int getVal(int x)
    {
        int sqX = x*x;
        int Y = (numA*sqX)+(numB*x)+numC;
        return Y;
    }
    
    public double rootOne()
    {
        double topPart = -numB + (double)Math.sqrt((numB*numB)-4*numA*numC);
        double result = topPart/(2*numA);
        return result;
    }
    
    public double rootTwo()
    {
        //
        double topPart = -numB - (double)Math.sqrt((numB*numB)-4*numA*numC);
        double result = topPart/(2*numA);
        return result;
    }
    
    public String toString()
    {
        String str = "The equation "+numA+"x^2+"+numB+"x+"+numC+" has roots at "+this.rootTwo()+" and "+this.rootOne();
        return str;
    }
}
    