public class Fighter
{
    private String fighterName;
    private String specialAttack;
    private int healthPoints;

    public Fighter(String fName, String fSpecial, int fHp)
    {
        fighterName = fName;
        specialAttack = fSpecial;
        healthPoints = fHp;

    }
    
    public String toString()
    {
        String str = "Name :"+fighterName+". Health: "+healthPoints;
        return str;
    }
    
    public int getHealth()
    {
        return healthPoints;
    }
    
    public void takeDamage(int points)
    {
        healthPoints = healthPoints - points;
    }
    
    public String getSuper()
    {
        return specialAttack;
    }
    
    public String getName()
    {
        return fighterName;
    }
    
    public String win()
    {
        String str = "You won! Horray!";
        return str;
    }
    
    public String lose()
    {
        String str = "You lost! You're a looser!";
        return str;
    }
}