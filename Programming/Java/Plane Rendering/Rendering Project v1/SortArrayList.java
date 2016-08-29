import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortArrayList{

    public static void main(String args[]){

        List<String> sList = new ArrayList<String>();

        System.out.println("Input strings to sort, type END to end");

        Scanner scan = new Scanner(System.in);

        boolean contBoolean = true;

        while (contBoolean)
        {
            String input = scan.nextLine();
            if (input.equals("END"))
                contBoolean = false;
            else
                sList.add(input+" Banner");
        }

        //sort the list
        Collections.sort(sList);

        //after sorted
        System.out.println("ArrayList is sorted");
        for(String temp: sList){
            System.out.println(temp);
        }
    }

}