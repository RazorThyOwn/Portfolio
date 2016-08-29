import sacco.*;
public class HelloButton implements QuickButton
{
    public String buttonLabel()
    {
        return "Hello";
    }

    public void whenPressed()
    {
        System.out.println("Hello World!!!");
    }

    public static void main()
    {
        QuickButtonFrame qBF = new QuickButtonFrame(2,2);
        
        HelloButton hb = new HelloButton();
        CountUp cU = new CountUp();
        RollDie rD = new RollDie();
        DailyAffirmation dA = new DailyAffirmation();
        
        qBF.addQuickButton(hb);
        qBF.addQuickButton(cU);
        qBF.addQuickButton(rD);
        qBF.addQuickButton(dA);
        
        qBF.launch();
    }
    
}