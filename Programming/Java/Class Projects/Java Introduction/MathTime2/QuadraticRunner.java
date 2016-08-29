public class QuadraticRunner
{
    public static void main()
    {
        Quadratic qR = new Quadratic(14, 23, 3);
        int S = qR.getVal(13);
        //System.out.println(S);
        System.out.println(qR.toString());
        
    }
}