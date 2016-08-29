import sacco.*;
public class TextClass
{
    public static void main()
    {
        TextFileAnalyzer txtfl = new TextFileAnalyzer("Independence.txt");
        int cnt = txtfl.getCharacterCount("e");
        System.out.println("The word count for e in the Declaration of Independence is " + cnt);
        txtfl.loadNewTextFile("IHaveADream.txt");
        cnt = txtfl.getWordCount();
        System.out.println("I have a dream contains " + cnt + " letters.");
        cnt = txtfl.getCharacterCount("e");
        System.out.println("There are this many es in I Have A Dream: " + cnt);
    }
}
