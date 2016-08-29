import java.io.*;
import java.io.IOException;
public class Alphabetizer {
    
    static String[] input;
    static String[] unsortedLine;
    static String[] sortedOutput;
    
    public static void main() {
        String fileDest = "C:/Users/Alex Weber/Desktop/toSort.txt";
        char specChar = '|';
 
        try {
            
            ReadFile file = new ReadFile(fileDest);
            input = file.openFile();
            
            for (int i = 0; i < input.length; i++) {
                
            }
                        
        }
        
        catch (IOException e) {
            System.out.println("You done fucked up!");
        }
    }
}