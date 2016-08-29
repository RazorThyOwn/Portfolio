public class Rotor
{
    private String rotorField;
    
    public Rotor(String tmpString)
    {
        rotorField = tmpString;
    }
    
    public int getCharacterIndex(String character)
    {
        return rotorField.indexOf(character);
    }
    
    public String getCharacterAt(int index)
    {
        return rotorField.substring(index,index+1);
    }
    
    public void rotate()
    {
        String str1 = rotorField.substring(rotorField.length()-1,rotorField.length());
        String str2 = rotorField.substring(0,rotorField.length()-1);
        rotorField = str1+str2;
    }
    
    public void setStartingLetter(String letter)
    {
        int index = rotorField.indexOf(letter);
        String str1 = rotorField.substring(index);
        String str2 = rotorField.substring(0,index);
        rotorField = str1+str2;
    }
    
    public void rotateBackwards()
    {
        String str1 = rotorField.substring(0,1);
        String str2 = rotorField.substring(1);
        rotorField = str2+str1;
    }
    
    public String toString()
    {
        return rotorField;
    }
}