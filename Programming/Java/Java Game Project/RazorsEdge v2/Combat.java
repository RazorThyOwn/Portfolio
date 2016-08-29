import sacco.*;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
public class Combat extends Display
{
    static Player[] playerList;
    Player p1;
    Player p2;
    Weapon weapA;
    Weapon weapB;
    static int index1;
    static int index2;
    static int weapIndex1;
    static int weapIndex2;
    static int logIndex;

    List<String> battleLog = new ArrayList<String>();

    Button[] lBt = new Button[4];
    Button[] rBt = new Button[4];
    Button attackUp;
    Button attackDown;
    Button[] logB = new Button[2];    

    public Combat(Player[] pList)
    {
        playerList = pList;
        index1 = 0;
        index2 = 0;
        weapIndex1 = 0;
        weapIndex2 = 0;
        logIndex = 0;
        p1 = pList[index1];
        p2 = pList[index2];
        if (p1.getWeapons().size()==0)
        {
            Weapon w = new Weapon("Hands",5,5,5,-1,0,-1,"Your hands");
            p1.addWeapon(w);
            Controller.updatePlayer(p1);
        }

        if (p2.getWeapons().size()==0)
        {
            Weapon w = new Weapon("Hands",1,5,5,-1,0,-1,"Your hands");
            p2.addWeapon(w);
            Controller.updatePlayer(p2);
        }
        weapA = p1.getWeapons().get(weapIndex1);
        weapB = p2.getWeapons().get(weapIndex2);    
        battleLog.add("Start...");
    }

    public void paintWindow(PaintBrush brush)
    {        
        // Initializing Buttonlist

        // Setting up borders //
        brush.setThickness(4);
        brush.setColor(100,100,100);
        brush.fillRectangle(0,0,10000,50);
        brush.fillRectangle(0,0,50,10000);

        brush.setColor(211,184,152);
        brush.fillRectangle(50,50,10050,10050);

        brush.setColor("black");
        brush.setThickness(10);
        brush.drawRectangle(350,60,290,640);
        brush.setColor(150,100,100);
        brush.fillRectangle(350,60,290,640);

        brush.setFontSize(40);

        brush.setColor(254,194,63);
        String name = p1.getName();
        int nameLength = brush.getStringWidth(name);
        brush.drawString(name,350+( (290-nameLength)/2),120);

        brush.setFontSize(30);
        brush.setColor("black");
        name = "Using";
        nameLength = brush.getStringWidth(name);
        brush.drawString(name,350+( (290-nameLength)/2),190);

        // Weapon A
        brush.setFontSize(30);
        brush.setColor(254,194,63);
        name = weapA.getName();
        nameLength = brush.getStringWidth(name);
        brush.drawString(name,350+( (290-nameLength)/2),240);

        brush.setFontSize(15);
        brush.setColor(150,150,150);

        name = "Damage "+weapA.getDamage();
        nameLength = brush.getStringWidth(name);
        brush.drawString(name,350+( (290-nameLength)/2),270);
        name = "Accuracy "+weapA.getAccuracy();
        nameLength = brush.getStringWidth(name);
        brush.drawString(name,350+( (290-nameLength)/2),290);
        name = "Blocking "+weapA.getBlocking();
        nameLength = brush.getStringWidth(name);
        brush.drawString(name,350+( (290-nameLength)/2),310);
        name = "Distance "+weapA.getDistance();
        nameLength = brush.getStringWidth(name);
        brush.drawString(name,350+( (290-nameLength)/2),330);

        //

        brush.setFontSize(30);
        brush.setColor("black");
        name = "Versus";
        nameLength = brush.getStringWidth(name);
        brush.drawString(name,350+( (290-nameLength)/2),390);

        brush.setFontSize(40);
        brush.setColor(254,194,63);
        name = p2.getName();
        nameLength = brush.getStringWidth(name);
        brush.drawString(name,350+( (290-nameLength)/2),450);

        brush.setFontSize(30);
        brush.setColor("black");
        name = "Using";
        nameLength = brush.getStringWidth(name);
        brush.drawString(name,350+( (290-nameLength)/2),520);

        // Weapon B
        brush.setFontSize(30);
        brush.setColor(254,194,63);
        name = weapB.getName();
        nameLength = brush.getStringWidth(name);
        brush.drawString(name,350+( (290-nameLength)/2),570);

        brush.setFontSize(15);
        brush.setColor(150,150,150);

        name = "Damage "+weapB.getDamage();
        nameLength = brush.getStringWidth(name);
        brush.drawString(name,350+( (290-nameLength)/2),600);
        name = "Accuracy "+weapB.getAccuracy();
        nameLength = brush.getStringWidth(name);
        brush.drawString(name,350+( (290-nameLength)/2),620);
        name = "Blocking "+weapB.getBlocking();
        nameLength = brush.getStringWidth(name);
        brush.drawString(name,350+( (290-nameLength)/2),640);
        name = "Distance "+weapB.getDistance();
        nameLength = brush.getStringWidth(name);
        brush.drawString(name,350+( (290-nameLength)/2),660);

        int xPos = 60;
        int yPos = 60;
        int width = 50;

        for (int i = 0; i < 2; i++)
        {
            // Drawing Squares

            Player playerX;
            if (i==0)
                playerX = p1;
            else
                playerX = p2;

            brush.setThickness(4);
            brush.setBold(true);
            brush.setFontSize(40);
            name = "";
            if (i==0)
                name = p1.getName();
            if (i==1)
                name = p2.getName();

            nameLength = brush.getStringWidth(name);
            if (nameLength>250)
            {
                name = name.substring(0,11);
            }
            nameLength = brush.getStringWidth(name);

            brush.setColor(0,143,0);
            if ( playerX.getExhausted() > 1)
                brush.setColor(150,150,150);
            if ( playerX.getIsControlSleeping())
                brush.setColor(0,0,80);
            if ( playerX.getIsSleeping())
                brush.setColor(0,0,80);
            if (playerX.getHitpoints()<1)
                brush.setColor(143,0,0);

            brush.fillRectangle(xPos,yPos,270,50);
            brush.setColor("black");
            brush.drawRectangle(xPos,yPos,270,50);

            // Drawing Names

            brush.setColor(254,194,63);
            if ( playerX.getExhausted() > 1)
                brush.setColor(50,50,50);
            if ( playerX.getIsControlSleeping())
                brush.setColor(0,0,180);
            if ( playerX.getIsSleeping())
                brush.setColor(0,0,180);
            if ( playerX.getHitpoints()<1)
                brush.setColor("black");
            brush.drawString(name, xPos+125-(nameLength/2) ,yPos+width-10);

            // Drawing Stats Title

            brush.setThickness(12);
            brush.setColor("black");
            brush.drawRectangle(xPos+50,yPos+width+80,170,25);     
            brush.setColor(0,143,0);
            brush.fillRectangle(xPos+50,yPos+width+80,170,25);

            brush.setFontSize(23);
            brush.setColor(254,194,63);
            brush.drawString("Stats",xPos+104,yPos+width+100);

            // Drawing Stats Names

            brush.setColor("black");
            brush.setFontSize(23);
            brush.drawString("HP:",xPos+25,yPos+width+150);
            brush.drawString("STR:",xPos+25,yPos+width+180);
            brush.drawString("INT:",xPos+25,yPos+width+210);
            brush.drawString("SPD:",xPos+25,yPos+width+240);
            brush.drawString("END:",xPos+25,yPos+width+270);
            brush.drawString("AGL:",xPos+25,yPos+width+300);

            // Drawing Stats Scores

            Player player =playerX;
            brush.drawString(""+(player.getHitpoints()+player.getHPBonus())+"/"+((player.getEndurance()*10)+player.getHPBonus()),xPos+90,yPos+width+150);
            brush.drawString(""+(player.getStrength()),xPos+90,yPos+width+180);
            brush.drawString(""+(player.getIntelligence()),xPos+90,yPos+width+210);
            brush.drawString(""+(player.getSpeed()+player.getSpeedBonus()),xPos+90,yPos+width+240);
            brush.drawString(""+(player.getEndurance()),xPos+90,yPos+width+270);
            brush.drawString(""+(player.getAgility()+player.getAgilityBonus()),xPos+90,yPos+width+300);

            // Drawing Class

            String className = player.getClassName();
            brush.setColor(0,143,0);
            brush.drawString(className,xPos+25,yPos+width+55);

            // Drawing Difficulty

            int diff = player.getDifficulty();

            String diffS;

            if (diff==0)
                diffS = "Easy";
            else if (diff==1)
                diffS = "Medium";
            else
                diffS = "Hard";

            String diffName = diffS+"-Mode";
            brush.setColor(0,143,0);
            brush.drawString(diffName,xPos+25,yPos+width+27);

            // Drawing Info Title

            brush.setThickness(12);
            brush.setColor("black");
            brush.drawRectangle(xPos+50,yPos+width+320,170,25);
            brush.setColor(0,143,0);
            brush.fillRectangle(xPos+50,yPos+width+320,170,25);

            brush.setFontSize(23);
            brush.setColor(254,194,63);
            brush.drawString("Info",xPos+113,yPos+width+340);

            // Drawing Info Text

            brush.setColor("black");
            brush.drawString("",xPos+25,yPos+width+350);
            brush.drawString("Sleep:",xPos+25,yPos+width+380);
            brush.drawString("Thirst:",xPos+25,yPos+width+410);
            brush.drawString("Hunger:",xPos+25,yPos+width+440);
            //brush.drawString("",xPos+25,yPos+width+470);
            //brush.drawString("",xPos+25,yPos+width+500);

            // Drawing Info Scores

            brush.drawString(""+player.getSleep()+"/"+player.getEndurance(),xPos+150,yPos+width+380);
            brush.drawString(""+player.getThirst()+"/"+player.getEndurance(),xPos+150,yPos+width+410);
            brush.drawString(""+player.getHunger()+"/"+player.getEndurance(),xPos+150,yPos+width+440);

            // Drawing Player Co-ords

            brush.setThickness(12);
            brush.setColor("black");
            brush.drawRectangle(xPos+50,yPos+width+460,170,25);
            brush.setColor(0,143,0);
            brush.fillRectangle(xPos+50,yPos+width+460,170,25);

            brush.setFontSize(23);
            brush.setColor(254,194,63);
            brush.drawString("Co-Ords",xPos+90,yPos+width+480);

            brush.setFontSize(23);
            brush.setColor("black");
            brush.drawString("X-Pos: "+player.getXPos(),xPos+25,yPos+width+520);
            brush.drawString("Y-Pos: "+player.getYPos(),xPos+25,yPos+width+550);
            brush.drawString("Speed Left: "+player.getSpeedLeft(),xPos+25,yPos+width+580);

            // Displaying Apparel bonuses

            Color clr = new Color(0,143,0);
            brush.setColor(clr);
            brush.drawString("("+player.getHPBonus()+")",xPos+220,yPos+width+150);
            brush.drawString("("+player.getSpeedBonus()+")",xPos+220,yPos+width+240);
            brush.drawString("("+player.getAgilityBonus()+")",xPos+220,yPos+width+300);

            //Final Increase
            xPos+=600;
        }

        // Drawing Player Buttons

        brush.setThickness(8);

        brush.setColor("black");
        brush.drawRectangle(465,134,20,20);
        brush.drawRectangle(505,134,20,20);
        brush.setColor(0,143,0);
        brush.fillRectangle(465,134,20,20);
        brush.fillRectangle(505,134,20,20);
        brush.setColor(254,194,63);
        brush.drawString("<",470,152);
        brush.drawString(">",510,152);

        brush.setColor("black");
        brush.drawRectangle(465,464,20,20);
        brush.drawRectangle(505,464,20,20);
        brush.setColor(0,143,0);
        brush.fillRectangle(465,464,20,20);
        brush.fillRectangle(505,464,20,20);
        brush.setColor(254,194,63);
        brush.drawString("<",470,482);
        brush.drawString(">",510,482);

        // Drawing Weapon Buttons
        brush.setFontSize(10);

        brush.setColor("black");
        brush.drawRectangle(475,344,10,10);
        brush.drawRectangle(505,344,10,10);
        brush.setColor(0,143,0);
        brush.fillRectangle(475,344,10,10);
        brush.fillRectangle(505,344,10,10);
        brush.setColor(254,194,63);
        brush.drawString("<",478,352);
        brush.drawString(">",508,352);

        brush.setColor("black");
        brush.drawRectangle(475,674,10,10);
        brush.drawRectangle(505,674,10,10);
        brush.setColor(0,143,0);
        brush.fillRectangle(475,674,10,10);
        brush.fillRectangle(505,674,10,10);
        brush.setColor(254,194,63);
        brush.drawString("<",478,682);
        brush.drawString(">",508,682);

        Button tmpLButton = new Button(465,134,20,20);
        Button tmpRButton = new Button(505,134,20,20);
        lBt[0] = tmpLButton;
        rBt[0] = tmpRButton;

        tmpLButton = new Button(465,464,20,20);
        tmpRButton = new Button(505,464,20,20);
        lBt[1] = tmpLButton;
        rBt[1] = tmpRButton;

        tmpLButton = new Button(475,344,10,10);
        tmpRButton = new Button(505,344,10,10);
        lBt[2] = tmpLButton;
        rBt[2] = tmpRButton;

        tmpLButton = new Button(475,674,10,10);
        tmpRButton = new Button(505,674,10,10);
        lBt[3] = tmpLButton;
        rBt[3] = tmpRButton;

        setSize(xPos-250,900);
        setResizable(false);

        // Borders

        brush.setColor(100,100,100);
        brush.fillRectangle(xPos-296,0,xPos-246,1000);
        brush.fillRectangle(0,710,xPos-246,1000);

        // Attack Down Button

        brush.setColor("black");
        brush.drawRectangle(350,730,290,50);
        brush.setColor(140,80,80);
        brush.fillRectangle(350,730,290,50);
        brush.setColor("black");
        brush.setFontSize(50);
        brush.drawString("A T T A C K",358,774);
        attackDown = new Button(350,730,290,50);

        // Attack Up Button
        brush.setColor("black");
        brush.drawRectangle(680,730,50,50);
        brush.setColor(140,80,80);
        brush.fillRectangle(680,730,50,50);
        brush.setColor("black");
        brush.setFontSize(50);
        brush.drawString("R",688,774);
        attackUp = new Button(680,730,50,50);

        brush.setColor("black");
        brush.drawRectangle(50,800,910,75);
        brush.setColor(0,143,0);
        brush.fillRectangle(50,800,910,75);
        
         // Combat Log
        
        brush.setFontSize(20);
        brush.setColor(254,194,63);
        String log = battleLog.get(logIndex);
        brush.drawString(log,70,830);        
    }

    public void attack(boolean isUp)
    {
        Player storedPlayer1 = p1;
        Player storedPlayer2 = p2;
        Weapon storedWeapon1 = weapA;
        Weapon storedWeapon2 = weapB;

        if (isUp)
        {
            p1 = p2;
            p2 = storedPlayer1;
            weapA = weapB;
            weapB = storedWeapon1;
        }
        String log = (p1.getName()+ " using "+weapA.getName()+" v. "+p2.getName()+" using "+weapB.getName());
        int attackHit = (int)p1.getAgility() + (4*weapA.getAccuracy()) + d20();
        int defense = (int)p2.getAgility() + (4*weapB.getBlocking()) + d20();
        if (attackHit >= defense)
        {            
            int damage = weapA.getDamage() + (int)p1.getStrength() + (10-d20())/2;
            p2.setHitpoints( p2.getHitpoints()-damage);

            log = log+(": HIT! ("+attackHit+" v. "+defense+"), Damage: "+damage);
        }  
        else
        {
            log = log+(": MISS! ("+attackHit+" v. "+defense+")");
        }
        battleLog.add(log);
        logIndex = (logIndex+1);
        if (isUp)
        {
            p1 = storedPlayer1;
            p2 = storedPlayer2;
            weapA = storedWeapon1;
            weapB = storedWeapon2;
        }
    }

    public int d20()
    {
        int rMath = (int)((Math.random())*20);
        return rMath;
    }

    public void onMousePress(MouseEvent m)
    {
        if (attackDown.press(m.getX(),m.getY()))
        {
            attack(false);
        }
        if (attackUp.press(m.getX(),m.getY()))
        {
            attack(true);
        }
        for (int i = 0; i < 4; i++)
        {
            if (lBt[i].press(m.getX(),m.getY()))
            {
                if (i==0 && index1!=0)
                {
                    index1--;
                    p1 = playerList[index1];
                    if (p1.getWeapons().size()==0)
                    {
                        weapA = new Weapon("Hands",5,5,5,-1,0,-1,"Your hands");
                    }
                    else
                    {
                        weapA = p1.getWeapons().get(0);
                        weapIndex1 = 0;
                    }
                }
                if (i==1 && index2!=0)
                {
                    index2--;
                    p2 = playerList[index2];
                    if (p2.getWeapons().size()==0)
                    {
                        weapB = new Weapon("Hands",1,5,5,-1,0,-1,"Your hands");
                    }
                    else
                    {
                        weapB = p2.getWeapons().get(0);
                        weapIndex2 = 0;
                    }
                }
                if (i==2 && weapIndex1!=0)
                {
                    weapIndex1--;
                    weapA = p1.getWeapons().get(weapIndex1);
                }
                if (i==3 && weapIndex2!=0)
                {
                    weapIndex2--;
                    weapB = p2.getWeapons().get(weapIndex2);
                }
            }
            if (rBt[i].press(m.getX(),m.getY()))
            {
                if (i==0 && index1<playerList.length-1)
                {
                    index1++;
                    p1 = playerList[index1];
                    if (p1.getWeapons().size()==0)
                    {
                        weapA = new Weapon("Hands",5,5,5,-1,0,-1,"Your hands");
                    }
                    else
                    {
                        weapA = p1.getWeapons().get(0);
                        weapIndex1 = 0;
                    }
                }
                if (i==1 && index2<playerList.length-1)
                {
                    index2++;
                    p2 = playerList[index2];
                    if (p2.getWeapons().size()==0)
                    {
                        weapB = new Weapon("Hands",1,5,5,-1,0,-1,"Your hands");
                    }
                    else
                    {
                        weapB = p2.getWeapons().get(0);
                        weapIndex2 = 0;
                    }
                }
                if (i==2 && weapIndex1<p1.getWeapons().size()-1)
                {
                    weapIndex1++;
                    weapA = p1.getWeapons().get(weapIndex1);
                }
                if (i==3 && weapIndex2<p1.getWeapons().size()-1)
                {
                    weapIndex2++;
                    weapB = p2.getWeapons().get(weapIndex2);
                }
            }     
        }
    }
}