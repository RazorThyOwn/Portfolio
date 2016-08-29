public class GradeRunner1
{
    public static void main()
    {
        String[] grades = {"A+","A","A-","B+","B","B-","C+","C","C-","D+","D","D-","F+","F","F-"};
        
        for( String str: grades)
        {
            Grade g = new Grade(new String(str));
            System.out.println(str+(str.length()==2?"":" ")+" is worth "+g.gpaVal());
        }
    }
}