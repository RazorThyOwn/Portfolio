import sacco.*;
public class HomeworkList
{
    public static void main()
    {
        // OoOoooOoO \\
        
        
        
        TodoList myList = new TodoList();
        myList.addItem("Math: p253 1-35 odd");
        myList.addItem("History: Read chapter 7");
        myList.addItem("English: Compare and Contrast essay");
        myList.addItem("Science: Finish lab report");
        myList.addItem("PE: Take a lap");
        
        int count = myList.getItemCount();
        System.out.println("There are " + count + " tasks to do");
        String list = myList.toString();
        System.out.println(list);
        
        myList.completeItemByNumber(5);
        myList.completeItemByNumber(2);
        
        list = myList.toString();
        System.out.println(list);
        myList.removeCompletedItems();
        
        list = myList.toString();
        System.out.println(list);
        
        
    } 
}
