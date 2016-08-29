public class SkillTypes {
    
    public static void main() {
        String[] list = {"Strength","Intelligence","Speed","Endurance","Agility"};
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(list[i]+" "+list[j] + "    ");
            }
            System.out.println("\n");
        }
    }
    
}