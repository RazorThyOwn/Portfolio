import sacco.*;
public class DailyAffirmation implements QuickButton
{
    public String buttonLabel()
    {
        return "Get Daily Affirmation";
    }
    
    public void whenPressed()
    {
        String phrase = "";
        int randInt = (int)(Math.random()*3);
        if (randInt==0)
        {
            phrase = "You're so handsome today. Oh wait thats everyday.";
        }
        if (randInt==1)
        {
            phrase = "Wow, you really have good taste in clothes!";
        }
        if (randInt==2)
        {
            phrase = "The entire female population of the world called asking for you.";
        }
        System.out.println(phrase);
    }
}