import java.util.ArrayList;

public class GradeRunner2
{
    public static void main()
    {
        ArrayList<Grade> grades = new ArrayList<Grade>();
        ArrayList<Grade> unsorted= new ArrayList<Grade>();
        
        System.out.println("Creating 50 random grades...");
        
        for( int i =0; i<50; i++)
        {
            String[] grade = {"A","B","C","D","F"};
            String[] plusOrMinus = {"+","","-"};
            
            int gradeNum = (int)(Math.random()*grade.length);
            int sign = (int)(Math.random()*plusOrMinus.length);
            
            Grade tmp = new Grade(grade[gradeNum]+plusOrMinus[sign]);
            unsorted.add(tmp);
            grades.add(tmp);
            
        }
        
        
        System.out.println("Sorting using compareTo...\n");
        for(int i = 0; i < grades.size()-1;i++)
        {
            
            int bigIndex = i;
            for(int j =i; j < grades.size();j++)
            {
                
                if(grades.get(j).compareTo(grades.get(bigIndex))>0)
                   bigIndex = j;
                              
            }
            
            Grade tmp = grades.remove(bigIndex);
            grades.add(i,tmp);
            
        }
        System.out.println("Unsorted\t\tSorted");
        for(int i = 0; i < grades.size() ; i++)
        {
         System.out.println( "   "+unsorted.get(i)+" \t\t\t   "+grades.get(i));   
        }
        
    }
}
