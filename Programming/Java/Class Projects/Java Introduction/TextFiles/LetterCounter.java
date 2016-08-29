import sacco.*;
import java.util.Scanner;
public class LetterCounter
{
    public static void main()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter txt file");
        String in = scan.nextLine();
        TextFileAnalyzer txt = new TextFileAnalyzer(in);
        System.out.println(txt.toString());
        System.out.println("Enter character to count");
        String chae = scan.nextLine();
        int charCount = txt.getCharacterCount(chae);
        System.out.println("There are " + charCount + " of " + chae);
    }
}