public class Cara
{
    // General Information //
    private int age;
    private double mood;
    private double movement;
    
    // Physical Damage //
    // 0 - 100 is the range
    
    // 1: Head
    // 2: Neck
    // 3: Right Arm
    // 4: Right Hand
    // 5: Left Arm
    // 6: Left Hand
    // 7: Upper Torso
    // 8: Lower Torso
    // 9: Right Leg
    // 10: Right Foot
    // 11: Left Leg
    // 12: Left Foot
    
    private double[] bodyparts = new double[12];
    
    // Physical Health Misc//
    private double bloodLevel; 
    private double heartRate;
    private double oxyLevels;
    
    // Psychological Health //

    public Cara(int age)
    {
        this.age = age;
    }
}