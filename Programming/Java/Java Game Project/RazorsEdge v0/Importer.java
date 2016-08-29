import java.io.IOException;
public class Importer
{
    static Weapon[] sW;
    static Apparel[] sA;
    static Consumable[] sC;

    public void importing()
    {
        System.out.println("IMPORTING...");
        String baseFile = "C:/Users/Vested/Desktop/Items/";

        ///////////////////
        // Weapon import //
        ///////////////////

        String file_name = baseFile+"Weapons.txt";
        try {
            System.out.println("IMPORTING WEAPONS");
            ReadFile file = new ReadFile(file_name);
            String[] aryLines = file.openFile();
            sW = new Weapon[aryLines.length];
            for (int i = 0; i < aryLines.length; i++)
            {
                // Name
                String line = aryLines[i];
                int indexOf = line.indexOf("|");
                String name = line.substring(0,indexOf-1);
                line = line.substring(indexOf+2);

                // Damage
                indexOf = line.indexOf("|");
                int damage = Integer.parseInt(line.substring(0,indexOf-1));
                line = line.substring(indexOf+2);

                // Agility/Accuracy
                indexOf = line.indexOf("|");
                int agility = Integer.parseInt(line.substring(0,indexOf-1));
                line = line.substring(indexOf+2);

                // Blocking
                indexOf = line.indexOf("|");
                int blocking = Integer.parseInt(line.substring(0,indexOf-1));
                line = line.substring(indexOf+2);

                // Distance
                indexOf = line.indexOf("|");
                int distance = Integer.parseInt(line.substring(0,indexOf-1));
                line = line.substring(indexOf+2);

                // Weight
                indexOf = line.indexOf("|");
                int weight = Integer.parseInt(line.substring(0,indexOf-1));
                line = line.substring(indexOf+2);

                // Rarity
                indexOf = line.indexOf("|");
                int rarityMod = Integer.parseInt(line.substring(0,indexOf-1));
                line = line.substring(indexOf+2);

                // Description
                String desc = line;

                Weapon tmpWeapon = new Weapon(name,damage,agility,blocking,distance,weight,rarityMod,desc);
                sW[i] = tmpWeapon;
            }

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage() );
        }

        ////////////////////
        // Apparel Import //
        ////////////////////

        file_name = baseFile+"Apparel.txt";
        try {
            System.out.println("IMPORTING APPAREL");
            ReadFile file = new ReadFile(file_name);
            String[] aryLines = file.openFile();
            sA = new Apparel[aryLines.length];
            for (int i = 0; i < aryLines.length; i++)
            {
                // Name
                String line = aryLines[i];
                int indexOf = line.indexOf("|");
                String name = line.substring(0,indexOf-1);
                line = line.substring(indexOf+2);

                // Weight
                indexOf = line.indexOf("|");
                int weight = Integer.parseInt(line.substring(0,indexOf-1));
                line = line.substring(indexOf+2);
                
                // Agility/Accuracy
                indexOf = line.indexOf("|");
                int agility = Integer.parseInt(line.substring(0,indexOf-1));
                line = line.substring(indexOf+2);

                // HP Bonus
                indexOf = line.indexOf("|");
                int hpbonus = Integer.parseInt(line.substring(0,indexOf-1));
                line = line.substring(indexOf+2);

                // Speed Change
                indexOf = line.indexOf("|");
                int speedbonus = Integer.parseInt(line.substring(0,indexOf-1));
                line = line.substring(indexOf+2);

                // Rarity
                indexOf = line.indexOf("|");
                int rarityMod = Integer.parseInt(line.substring(0,indexOf-1));
                line = line.substring(indexOf+2);

                // Description
                String desc = line;

                Apparel tmpApparel = new Apparel(name,weight,agility,hpbonus,speedbonus,rarityMod,desc);
                sA[i]=tmpApparel;
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage() );
        }
    }
    
    public Weapon[] getWAr()
    {
        return sW;
    }
    
    public Apparel[] getAAr()
    {
        return sA;
    }
    
    public Consumable[] getCAr()
    {
        return sC;
    }
}
