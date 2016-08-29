import sacco.*;
public class InventoryEdit extends Display
{
    int slot;
    Player player;
    int t;

    Button[] upBt;
    Button[] dwBt;

    Button Btname;

    boolean typing = false;
    boolean capital = false;

    public InventoryEdit(int inSlot, Player p, int type)
    {
        slot = inSlot;
        player = p;
        t = type;
    }

    public void paintWindow(PaintBrush brush)
    {

        if (t==0)
        {
            // General Setup
            brush.setColor(100,100,100);
            brush.fillRectangle(0,0,320,20);
            brush.fillRectangle(0,0,20,390);
            brush.fillRectangle(250,0,280,400);
            brush.fillRectangle(0,350,300,400);

            brush.setColor(211,184,152);
            brush.fillRectangle(20,20,280,360);
            this.setSize(320,400);

            brush.setThickness(10);

            upBt = new Button[5];
            dwBt = new Button[5];
            // Weapon edit
            Weapon weapon = player.getWeapons().get(slot);
            String name = weapon.getName();
            int damage = weapon.getDamage();
            int accuracy = weapon.getAccuracy();
            int blocking = weapon.getBlocking();
            int distance = weapon.getDistance();
            int weight = weapon.getWeight();

            for (int i = 0; i < 6; i++)
            {            
                brush.setThickness(10);
                brush.setColor("black");
                brush.drawRectangle(50,40 + 55*i,220,40);
                brush.setThickness(10);
                brush.setColor(0,143,0);
                brush.fillRectangle(50,40 + 55*i,220,40);
            }

            brush.setFontSize(30);
            brush.setColor(254,194,63);

            int nameLength = brush.getStringWidth(name);
            brush.drawString(name,160-(nameLength)/2,70);

            nameLength = brush.getStringWidth("Damage: "+damage);
            brush.drawString("Damage: "+damage,160-(nameLength)/2,125);

            nameLength = brush.getStringWidth("Accuracy: "+accuracy);
            brush.drawString("Accuracy: "+accuracy,160-(nameLength)/2,180);

            nameLength = brush.getStringWidth("Blocking: "+blocking);
            brush.drawString("Blocking: "+blocking,160-(nameLength)/2,235);

            nameLength = brush.getStringWidth("Distance: "+distance);
            brush.drawString("Distance: "+distance,160-(nameLength)/2,290);

            nameLength = brush.getStringWidth("Weight: "+weight);
            brush.drawString("Weight: "+weight,160-(nameLength)/2,345);

            // Drawing increase/decrease buttons

            brush.setThickness(5);
            brush.setFontSize(15);

            for (int i = 0; i < 5; i++)
            {        
                brush.setColor("black");
                brush.drawRectangle(282,95 + 55*i,10,10);
                brush.drawRectangle(282,120 + 55*i,10,10);
                brush.setColor(0,143,0);
                brush.fillRectangle(282,95 + 55*i,10,10);
                brush.fillRectangle(282,120 + 55*i,10,10);
                Button tmpButton = new Button(282,95+55*i,10,10);
                upBt[i] = tmpButton;
                tmpButton = new Button(282,120+55*i,10,10);
                dwBt[i] = tmpButton;
                brush.setColor("black");                
                brush.drawString("+",282,105+55*i);
                brush.drawString("-",285,130+55*i);
            }
        }
        if (t==1)
        {
            // General Setup
            brush.setColor(100,100,100);
            brush.fillRectangle(0,0,320,20);
            brush.fillRectangle(0,0,20,340);
            brush.fillRectangle(300,0,320,340);
            brush.fillRectangle(0,300,300,340);

            brush.setColor(211,184,152);
            brush.fillRectangle(20,20,280,300);
            this.setSize(320,340);

            brush.setThickness(10);

            upBt = new Button[4];
            dwBt = new Button[4];
            // Weapon edit
            Apparel apparel = player.getApparel().get(slot);
            String name = apparel.getName();
            int agil = apparel.getAgility();
            int health = apparel.getHealth();
            int speed = apparel.getSpeed();
            int weight = apparel.getWeight();

            for (int i = 0; i < 5; i++)
            {            
                brush.setThickness(10);
                brush.setColor("black");
                brush.drawRectangle(50,40 + 55*i,220,40);
                brush.setThickness(10);
                brush.setColor(0,143,0);
                brush.fillRectangle(50,40 + 55*i,220,40);
            }

            brush.setFontSize(30);
            brush.setColor(254,194,63);

            int nameLength = brush.getStringWidth(name);
            brush.drawString(name,160-(nameLength)/2,70);

            nameLength = brush.getStringWidth("Agility: "+agil);
            brush.drawString("Agility: "+agil,160-(nameLength)/2,125);

            nameLength = brush.getStringWidth("Health: "+health);
            brush.drawString("Health: "+health,160-(nameLength)/2,180);

            nameLength = brush.getStringWidth("Speed: "+speed);
            brush.drawString("Speed: "+speed,160-(nameLength)/2,235);

            nameLength = brush.getStringWidth("Weight: "+weight);
            brush.drawString("Weight: "+weight,160-(nameLength)/2,290);

            // Drawing increase/decrease buttons

            brush.setThickness(5);
            brush.setFontSize(15);

            for (int i = 0; i < 4; i++)
            {        
                brush.setColor("black");
                brush.drawRectangle(282,95 + 55*i,10,10);
                brush.drawRectangle(282,120 + 55*i,10,10);
                brush.setColor(0,143,0);
                brush.fillRectangle(282,95 + 55*i,10,10);
                brush.fillRectangle(282,120 + 55*i,10,10);
                Button tmpButton = new Button(282,95+55*i,10,10);
                upBt[i] = tmpButton;
                tmpButton = new Button(282,120+55*i,10,10);
                dwBt[i] = tmpButton;
                brush.setColor("black");                
                brush.drawString("+",282,105+55*i);
                brush.drawString("-",285,130+55*i);
            }
        }
        if (t==2)
        {
            // General Setup
            brush.setColor(100,100,100);
            brush.fillRectangle(0,0,320,20);
            brush.fillRectangle(0,0,20,390);
            brush.fillRectangle(250,0,280,400);
            brush.fillRectangle(0,350,300,400);

            brush.setColor(211,184,152);
            brush.fillRectangle(20,20,280,360);
            this.setSize(320,400);

            brush.setThickness(10);

            upBt = new Button[3];
            dwBt = new Button[3];
            // Weapon edit
            Consumable c = player.getConsumable().get(slot);
            String name = c.getName();
            int drink = c.getDrink();
            int food = c.getFood();
            int weight = c.getWeight();

            for (int i = 0; i < 4; i++)
            {            
                brush.setThickness(10);
                brush.setColor("black");
                brush.drawRectangle(50,40 + 55*i,220,40);
                brush.setThickness(10);
                brush.setColor(0,143,0);
                brush.fillRectangle(50,40 + 55*i,220,40);
            }

            brush.setFontSize(30);
            brush.setColor(254,194,63);

            int nameLength = brush.getStringWidth(name);
            brush.drawString(name,160-(nameLength)/2,70);

            nameLength = brush.getStringWidth("Drink: "+drink);
            brush.drawString("Drink: "+drink,160-(nameLength)/2,125);

            nameLength = brush.getStringWidth("Food: "+food);
            brush.drawString("Food: "+food,160-(nameLength)/2,180);

            nameLength = brush.getStringWidth("Weight: "+weight);
            brush.drawString("Weight: "+weight,160-(nameLength)/2,235);

            // Drawing increase/decrease buttons

            brush.setThickness(5);
            brush.setFontSize(15);

            for (int i = 0; i < 3; i++)
            {        
                brush.setColor("black");
                brush.drawRectangle(282,95 + 55*i,10,10);
                brush.drawRectangle(282,120 + 55*i,10,10);
                brush.setColor(0,143,0);
                brush.fillRectangle(282,95 + 55*i,10,10);
                brush.fillRectangle(282,120 + 55*i,10,10);
                Button tmpButton = new Button(282,95+55*i,10,10);
                upBt[i] = tmpButton;
                tmpButton = new Button(282,120+55*i,10,10);
                dwBt[i] = tmpButton;
                brush.setColor("black");                
                brush.drawString("+",282,105+55*i);
                brush.drawString("-",285,130+55*i);
            }
        }

        Btname = new Button(50,40,220,40);
    }

    public void onKeyPress(int k)
    {
        if (k==16)
        {
            capital = true;
        }     
        if (typing)
        {
            if (t==0)
            {        
                String input = Character.toString((char)k).toLowerCase();
                if (capital)
                    input = input.toUpperCase();
                if (k==8)
                {
                    Weapon weap = player.getWeapons().get(slot);
                    if (weap.getName().length()>1)
                    {
                        weap.setName(weap.getName().substring(0,weap.getName().length()-1));
                        player.setWeapon(weap,slot);
                    }
                    else
                    {
                        weap.setName("");
                        player.setWeapon(weap,slot);
                    }
                }
                else if (k!=16)
                {
                    // Add letters
                    if (t==0)
                    {
                        Weapon weap = player.getWeapons().get(slot);
                        weap.setName(weap.getName()+input);
                        player.setWeapon(weap,slot);
                    }
                }
            }

            if (t==1)
            {
                String input = Character.toString((char)k).toLowerCase();
                if (capital)
                    input = input.toUpperCase();
                if (k==8)
                {
                    Apparel ap = player.getApparel().get(slot);
                    if (ap.getName().length()>1)
                    {
                        ap.setName(ap.getName().substring(0,ap.getName().length()-1));
                        player.setApparel(ap,slot);
                    }
                    else
                    {
                        ap.setName("");
                        player.setApparel(ap,slot);
                    }
                }
                else if (k!=16)
                {
                    // Add letters
                    Apparel ap = player.getApparel().get(slot);
                    ap.setName(ap.getName()+input);
                    player.setApparel(ap,slot);
                }
            }

            if (t==2)
            {
                String input = Character.toString((char)k).toLowerCase();
                if (capital)
                    input = input.toUpperCase();
                if (k==8)
                {
                    Consumable consum = player.getConsumable().get(slot);
                    if (consum.getName().length()>1)
                    {
                        consum.setName(consum.getName().substring(0,consum.getName().length()-1));
                        player.setConsumable(consum,slot);
                    }
                    else
                    {
                        consum.setName("");
                        player.setConsumable(consum,slot);
                    }
                }
                else if (k!=16)
                {
                    // Add letters
                    Consumable consum = player.getConsumable().get(slot);
                    consum.setName(consum.getName()+input);
                    player.setConsumable(consum,slot);
                }
            }
        }
    }

    public void onKeyRelease(int k)
    {
        if (k==16)
        {
            capital = false;
        }
    }

    public void onMousePress(MouseEvent m)
    {
        if (Btname.press(m.getX(),m.getY()))
        {
            typing = !typing;
        }

        for (int i = 0; i < upBt.length; i++)
        {            
            if (upBt[i].press(m.getX(),m.getY()))
            {
                if (t==0)
                {
                    Weapon weapon = player.getWeapons().get(slot);
                    weapon.setVal(i,weapon.getVal(i)+1);
                    player.setWeapon(weapon,slot);
                }
                if (t==1)
                {
                    Apparel apparel = player.getApparel().get(slot);
                    apparel.setVal(i,apparel.getVal(i)+1);
                    player.setApparel(apparel,slot);
                }
                if (t==2)
                {
                    Consumable c = player.getConsumable().get(slot);
                    c.setVal(i,c.getVal(i)+1);
                    player.setConsumable(c,slot);
                }
            }
            if (dwBt[i].press(m.getX(),m.getY()))
            {
                if (t==0)
                {
                    Weapon weapon = player.getWeapons().get(slot);
                    weapon.setVal(i,weapon.getVal(i)-1);
                    player.setWeapon(weapon,slot);
                }
                if (t==1)
                {
                    Apparel apparel = player.getApparel().get(slot);
                    apparel.setVal(i,apparel.getVal(i)-1);
                    player.setApparel(apparel,slot);
                }
                if (t==2)
                {
                    Consumable c = player.getConsumable().get(slot);
                    c.setVal(i,c.getVal(i)-1);
                    player.setConsumable(c,slot);
                }
            }
        }

        Controller.updatePlayer(player);
        InventoryDisplay.updatePlayer(player);
    }
}