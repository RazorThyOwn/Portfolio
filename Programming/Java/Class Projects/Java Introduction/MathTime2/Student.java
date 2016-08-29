public abstract class Student extends Human
{
    private int gradeLevel;
    private double gpa;
    
    public Student(String name, int gradeLevel)
    {
        super(name);
        this.gradeLevel = gradeLevel;
        gpa = 0;
    }
    
    public double getGPA()
    {
        return gpa;
    }
    
    public int getGradeLevel()
    {
        return gradeLevel;
    }
    
    public void setGradeLevel(int newGL)
    {
        gradeLevel = newGL;
    }
    
    public String toString()
    {
        if (isHappy())
        return getName()+": Grade "+gradeLevel+": Happy";
        else
        return getName()+": Grade "+gradeLevel+": Not Happy";
    }
}