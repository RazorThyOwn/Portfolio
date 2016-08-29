public class Grade
{
    private String grade, sign;

    public Grade(String str)
    {
        grade = str.substring(0,1);
        if (str.length() == 2)
            sign = str.substring(1,2);
        else
            sign = "";
    }

    public double gpaVal()
    {
        double totalVal = 0;
        // Exceptions
        if (grade.equals("A") && !sign.equals("-"))
        {
            totalVal = 4.0;
            return 4.0;
        }
        // Sign Calculation
        if (sign.equals("+"))
            totalVal += 0.3;
        else if (sign.equals("-"))
            totalVal -= 0.3;
        else
            totalVal += 0;
        // Grade Calculation
        if (grade.equals("A"))
        {
            totalVal += 4;
            return totalVal;
        }
        else if (grade.equals("B"))
        {
            totalVal += 3;
            return totalVal;
        }
        else if (grade.equals("C"))
        {
            totalVal += 2;
            return totalVal;
        }
        else if (grade.equals("D"))
        {
            totalVal += 1;
            return totalVal;
        }
        else return 0;
    }

    public String toString()
    {
        return grade+sign;
    }

    public int compareTo(Grade gr)
    {
        if (this.gpaVal() > gr.gpaVal())
            return 1;
        else if (this.gpaVal() < gr.gpaVal())
            return -1;
        else return 0;
    }
}