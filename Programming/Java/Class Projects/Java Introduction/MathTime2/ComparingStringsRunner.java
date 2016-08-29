public class ComparingStringsRunner
{
    public static void main()
    {
        String[] words = {"hello","World","Sacco", "hiphip"}  ; 

        System.out.println("Testing firstASCII");
        for(int i = 0; i<words.length ;i++)
            for(int j = i+1; j<words.length ;j++)
            {

                System.out.println("ComparingStrings.firstASCII(\""+words[i]+"\",\""+words[j]+"\"):\t"+ComparingStrings.firstASCII(words[i],words[j]));   
        }

        System.out.println("\nTesting lastASCII");
        for(int i = 0; i<words.length ;i++)
            for(int j = i+1; j<words.length ;j++)
            {

                System.out.println("ComparingStrings.lastASCII(\""+words[i]+"\",\""+words[j]+"\"):\t"+ComparingStrings.lastASCII(words[i],words[j]));   
        }

        System.out.println("\nTesting firstAlpha");
        for(int i = 0; i<words.length ;i++)
            for(int j = i+1; j<words.length ;j++)
            {

                System.out.println("ComparingStrings.firstAlpha(\""+words[i]+"\",\""+words[j]+"\"):\t"+ComparingStrings.firstAlpha(words[i],words[j]));   
        }

        System.out.println("\nTesting isCapitalized...");
        for(int i = 0; i<words.length ;i++)
        {

            System.out.println( "\""+words[i]+"\" "+(ComparingStrings.isCapitalized(words[i])? "is":"is not")+ " capitalized.");
        }

        System.out.println("\nTesting isADoubleWord...");
        for(int i = 0; i<words.length ;i++)
        {

            System.out.println( "\""+words[i]+"\" "+(ComparingStrings.isADoubleWord(words[i])? "is":"is not")+ " a double word.");
        }

        System.out.println("\nTesting isAThreeDigitNumber...");
        System.out.println( "\"128\""+" "+(ComparingStrings.isAThreeDigitNumber("123")? "is":"is not")+ " a three digit number.");
        System.out.println( "\"ABC\""+" "+(ComparingStrings.isAThreeDigitNumber("ABC")? "is":"is not")+ " a three digit number.");
        System.out.println( "\"9A3\""+" "+(ComparingStrings.isAThreeDigitNumber("9A3")? "is":"is not")+ " a three digit number.");
        System.out.println( "\"12345\""+" "+(ComparingStrings.isAThreeDigitNumber("12345")? "is":"is not")+ " a three digit number.");
        System.out.println( "\"900\""+" "+(ComparingStrings.isAThreeDigitNumber("900")? "is":"is not")+ " a three digit number.");
        

    }
}