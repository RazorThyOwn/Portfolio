import java.awt.Color;
import sacco.*;
import java.awt.event.KeyEvent;
public class InventoryDisplay extends Display
{
    Button pgUp;
    Button pgDown;
    Button[] topB = new Button[3];
    Button[] bottomB = new Button[3];

    Button[] removeB = new Button[15];
    Button[] editB = new Button[15];
    Button[] addB = new Button[15];
    
    Button scavengeB;

    int pageNumber = 1;
    int pgAmount = 0;
    int nPerPage = 1;

    int[] nList = {0,0,0};
    int totaln = 20;

    static boolean testing = true;

    static Player[] playerList;
    public InventoryDisplay(Player[] pList)
    {
        playerList = pList;
    }

    public void paintWindow(PaintBrush brush)
    {        
        // Setting up borders //
        brush.setThickness(4);
        brush.setColor(100,100,100);
        brush.fillRectangle(0,0,10000,50);
        brush.fillRectangle(0,0,50,10000);

        brush.setColor(211,184,152);
        brush.fillRectangle(50,50,10050,10050);

        // Drawing Page Buttons

        brush.setThickness(10);
        brush.setFontSize(45);
        brush.setColor("black");
        brush.drawRectangle(10,10,25,25);

        if (pageNumber>1)
            brush.setColor(0,143,0);
        else
            brush.setColor(150,150,150);

        brush.fillRectangle(10,10,25,25);

        if (pageNumber>1)
            brush.setColor(254,194,63);
        else
            brush.setColor(150,150,150);

        brush.drawString("<",10,38);
        pgDown = new Button(10,10,25,25);

        brush.setColor("black");
        brush.drawRectangle(50,10,25,25);

        if (( pageNumber*nPerPage) < playerList.length)
            brush.setColor(0,143,0);
        else
            brush.setColor(150,150,150);

        brush.fillRectangle(50,10,25,25);

        if (( pageNumber*nPerPage) < playerList.length)
            brush.setColor(254,194,63);
        else
            brush.setColor(150,150,150);

        brush.drawString(">",50,38);
        pgUp = new Button(50,10,25,25);

        int xPos = 1000;
        int yPos = 60;
        int width = 50;

        int diviser = playerList.length / nPerPage;
        int remainder = playerList.length%nPerPage;

        int calc = playerList.length - ( nPerPage * (pageNumber-1) );
        if (calc>nPerPage)
            pgAmount = nPerPage;
        else
            pgAmount = calc;

        // Drawing time!

        brush.setColor("black");
        brush.setThickness(10);
        brush.drawRectangle(425,60,200,50);

        brush.setColor(0,143,0);
        brush.fillRectangle(425,60,200,50);

        brush.setColor(254,194,63);

        Player player = playerList[(nPerPage* (pageNumber-1))];
        String name = player.getName();

        int nameLength = brush.getStringWidth(name);
        if (nameLength>250)
        {
            name = name.substring(0,11);
        }
        nameLength = brush.getStringWidth(name);

        brush.drawString(player.getName(),522 - (nameLength/2),100);
        /////////////////////////
        // Drawing Inventories //
        /////////////////////////

        for (int i = 0; i < 3; i++)
        {
            Color topColor = new Color(0,0,0);
            Color bottomColor = new Color(0,0,0);
            Color green = new Color(0,143,0);

            brush.setThickness(8);
            Color gray = new Color(150,150,150);

            if (nList[i]==0)
                topColor = gray;
            else
                topColor = green;

            if (nList[i] < totaln-5)
                bottomColor = green;
            else
                bottomColor = gray;

            // Squares
            Color color = new Color(50,50,100);
            brush.setColor(color);
            brush.fillRectangle(60,130+195*i,930,180);

            // Interior
            brush.setColor(gray);
            brush.fillRectangle(60,130+195*i,45,180);

            // Blocks
            brush.setColor("black");
            brush.drawRectangle(60,130 + 195*i,930,180);
            brush.drawRectangle(60,130+195*i,45,180);

            // Button top
            brush.setColor("black");
            brush.drawRectangle(70,140+195*i,25,25);
            brush.setColor(gray);
            brush.setColor(topColor);
            brush.fillRectangle(70,140+195*i,25,25);
            topB[i] = new Button(70,140+195*i,25,25);

            // Button Down
            brush.setColor("black");
            brush.drawRectangle(70,275+195*i,25,25);
            brush.setColor(bottomColor);
            brush.fillRectangle(70,275+195*i,25,25);   
            bottomB[i] = new Button(70,275+195*i,25,25);

        }
        // Inventory Display

        brush.setThickness(5);

        // Weapons

        for (int i = 0; i < 5; i++)
        {
            brush.setFontSize(20);
            String weaponName = "Empty slot";
            if (nList[0]+i < player.getWeapons().size())
                weaponName = player.getWeapons().get(nList[0]+i).toString();

            int yLVal = 165+35*i;
            int ySVal = 155+35*i;
            brush.setColor("black");

            if (i!=4)
                brush.drawLine(110,yLVal,990,yLVal);

            Color colr = new Color(254,194,63);
            brush.setColor(colr);
            brush.drawString(nList[0]+i+1+": "+weaponName,120,ySVal);

            // Buttons
            brush.setColor("black");
            brush.drawRectangle(930,ySVal-10,10,10);
            brush.drawRectangle(950,ySVal-10,10,10);
            brush.drawRectangle(970,ySVal-10,10,10);

            if (nList[0]+i<player.getWeapons().size())
                brush.setColor("red");
            else
                brush.setColor("black");
            brush.fillRectangle(930,ySVal-10,10,10);
            if (nList[0]+i<player.getWeapons().size())
                colr = new Color(0,143,0);
            else
                colr = new Color(0,0,0);
            brush.setColor(colr);
            brush.fillRectangle(950,ySVal-10,10,10);
            if (nList[0]+i<player.getWeapons().size())
                brush.setColor("black");
            else
                brush.setColor("blue");
            brush.fillRectangle(970,ySVal-10,10,10);

            brush.setColor("black");
            brush.setFontSize(10);
            brush.drawString("X",931,ySVal-1);
            brush.drawString("E",951,ySVal-1);
            brush.drawString("A",971,ySVal-1);

            Button tmpButton = new Button(930,ySVal-10,10,10);
            removeB[i] = tmpButton;
            tmpButton = new Button(950,ySVal-10,10,10);
            editB[i] = tmpButton;
            tmpButton = new Button(970,ySVal-10,10,10);
            addB[i] = tmpButton;
        }

        // Apparel
        for (int i = 0; i < 5; i++)
        {
            brush.setFontSize(20);
            String apparelName = "Empty slot";
            if (nList[1]+i < player.getApparel().size())
                apparelName = player.getApparel().get(nList[1]+i).toString();

            int yLVal = 360+35*i;
            int ySVal = 350+35*i;
            brush.setColor("black");

            if (i!=4)
                brush.drawLine(110,yLVal,990,yLVal);

            Color colr = new Color(254,194,63);
            brush.setColor(colr);
            brush.drawString(nList[1]+i+1+": "+apparelName,120,ySVal);

            // Buttons
            brush.setColor("black");
            brush.drawRectangle(930,ySVal-10,10,10);
            brush.drawRectangle(950,ySVal-10,10,10);
            brush.drawRectangle(970,ySVal-10,10,10);

            if (nList[1]+i<player.getApparel().size())
                brush.setColor("red");
            else
                brush.setColor("black");
            brush.fillRectangle(930,ySVal-10,10,10);
            if (nList[1]+i<player.getApparel().size())
                colr = new Color(0,143,0);
            else
                colr = new Color(0,0,0);
            brush.setColor(colr);
            brush.fillRectangle(950,ySVal-10,10,10);
            if (nList[1]+i<player.getApparel().size())
                brush.setColor("black");
            else
                brush.setColor("blue");
            brush.fillRectangle(970,ySVal-10,10,10);

            brush.setColor("black");
            brush.setFontSize(10);
            brush.drawString("X",931,ySVal-1);
            brush.drawString("E",951,ySVal-1);
            brush.drawString("A",971,ySVal-1);

            Button tmpButton = new Button(930,ySVal-10,10,10);
            removeB[i+5] = tmpButton;
            tmpButton = new Button(950,ySVal-10,10,10);
            editB[i+5] = tmpButton;
            tmpButton = new Button(970,ySVal-10,10,10);
            addB[i+5] = tmpButton;
        }

        // Misc
        for (int i = 0; i < 5; i++)
        {
            brush.setFontSize(20);
            String cName = "Empty slot";
            if (nList[2]+i < player.getConsumable().size())
                cName = player.getConsumable().get(nList[2]+i).toString();

            int yLVal = 555+35*i;
            int ySVal = 545+35*i;
            brush.setColor("black");

            if (i!=4)
                brush.drawLine(110,yLVal,990,yLVal);

            Color colr = new Color(254,194,63);
            brush.setColor(colr);
            brush.drawString(nList[2]+i+1+": "+cName,120,ySVal);

            // Buttons
            brush.setColor("black");
            brush.drawRectangle(930,ySVal-10,10,10);
            brush.drawRectangle(950,ySVal-10,10,10);
            brush.drawRectangle(970,ySVal-10,10,10);

            if (nList[2]+i<player.getConsumable().size())
                brush.setColor("red");
            else
                brush.setColor("black");
            brush.fillRectangle(930,ySVal-10,10,10);
            if (nList[2]+i<player.getConsumable().size())
                colr = new Color(0,143,0);
            else
                colr = new Color(0,0,0);
            brush.setColor(colr);
            brush.fillRectangle(950,ySVal-10,10,10);
            if (nList[2]+i<player.getConsumable().size())
                brush.setColor("black");
            else
                brush.setColor("blue");
            brush.fillRectangle(970,ySVal-10,10,10);

            brush.setColor("black");
            brush.setFontSize(10);
            brush.drawString("X",931,ySVal-1);
            brush.drawString("E",951,ySVal-1);
            brush.drawString("A",971,ySVal-1);
            Button tmpButton = new Button(930,ySVal-10,10,10);
            removeB[i+10] = tmpButton;
            tmpButton = new Button(950,ySVal-10,10,10);
            editB[i+10] = tmpButton;
            tmpButton = new Button(970,ySVal-10,10,10);
            addB[i+10] = tmpButton;
        }

        setSize(xPos+50,730);
        setResizable(false);
        
        // Scavenge Button
        
        brush.setThickness(10);
        brush.setColor("black");
        brush.drawRectangle(60,60,57,57);
        brush.setColor(0,143,0);
        brush.fillRectangle(60,60,57,57);
        brush.setColor(254,194,63);
        brush.setFontSize(60);
        brush.drawString("S",65,110);
        scavengeB = new Button(60,60,57,57);

        // Borders

        brush.setColor(100,100,100);
        brush.fillRectangle(xPos+4,0,xPos+54,1000);
        brush.fillRectangle(0,710,xPos+54,1000);
    }

    public void onMousePress(MouseEvent m)
    {
        int diviser = playerList.length / nPerPage;
        int remainder = playerList.length%nPerPage;

        int calc = playerList.length - ( nPerPage * (pageNumber-1) );
        Player player = playerList[(nPerPage* (pageNumber-1))];
        // Page Number Buttons
        if (pgUp.press(m.getX(),m.getY()) && calc >nPerPage)
        {            
            pageNumber++;

            int[] tmpList = {0,0,0};
            nList = tmpList;
        }
        if (pgDown.press(m.getX(),m.getY()) && pageNumber>1)
        {
            pageNumber--;

            int[] tmpList = {0,0,0};
            nList = tmpList;
        }

        for (int i = 0 ; i < 3; i++)
        {
            if (topB[i].press(m.getX(),m.getY()) && nList[i]!=0)
                nList[i]--;
            if (bottomB[i].press(m.getX(),m.getY())&& nList[i]<totaln-5)
                nList[i]++;
        }

        boolean updatePlayer = false;
        for (int i = 0; i < 15; i++)
        {
            if (removeB[i].press(m.getX(),m.getY()))
            {
                updatePlayer = true;
                if (i<5)
                {
                    player.removeItem(0,(i%5 + nList[0]));
                }
                else if (i<10)
                {
                    player.removeItem(1,(i%5 + nList[1]));
                }
                else
                {
                    player.removeItem(2,(i%5 + nList[2]));
                }
            }
            if (editB[i].press(m.getX(),m.getY()))
            {
                updatePlayer = true;
                if (i<5)
                {
                    edit(i%5+nList[0],player,0);
                }
                else if (i<10)
                {
                    edit(i%5+nList[1],player,1);
                }
                else
                {
                    edit(i%5+nList[2],player,2);
                }
            }
            if (addB[i].press(m.getX(),m.getY()))
            {
                updatePlayer = true;
                if (i<5)
                {
                    add(i%5+nList[0],player,0);
                }
                else if (i<10)
                {
                    add(i%5+nList[1],player,1);
                }
                else
                {
                    add(i%5+nList[2],player,2);
                }
            }
        }
        
        if (scavengeB.press(m.getX(),m.getY()))
        {
            player.scavenge();
            //Controller.updatePlayer(player);
        }
        
        if (updatePlayer && !testing)
        {
            Controller.updatePlayer(playerList[(nPerPage* (pageNumber-1))]);
        }

        if (calc>nPerPage)
            pgAmount = nPerPage;
        else
            pgAmount = calc;
    }

    public void edit(int slot, Player p, int x)
    {
        InventoryEdit invEd = new InventoryEdit(slot,p,x);
        invEd.launch();
    }
    
    public void add(int slot, Player p, int x)
    {
        if (x==0)
        {
            Weapon weapon = new Weapon("New Weapon",0,0,0,0,0,-1,"Weapon");
            playerList[p.getIndex()].addWeapon(weapon);
            Controller.updatePlayer(p);
        }
        if (x==1)
        {
            Apparel ap = new Apparel("New Apparel",0,0,0,0,-1,"Apparel");
            playerList[p.getIndex()].addApparel(ap);
            Controller.updatePlayer(p);
        }
        if (x==2)
        {
            int[] n = {-1};
            Consumable c = new Consumable("New Misc",n,0,0,0,"Misc");
            playerList[p.getIndex()].addConsumable(c);
            Controller.updatePlayer(p);
        }
    }

    public static void demo()
    {
        testing = true;
        Player p1 = new Player(0,0);
        p1.setName("Alex");
        //p1.setClassName("Warrior-Tank");

        Player p2 = new Player(1,1);
        p2.setName("James");
        //p2.setClassName("Ninja-Scientist");

        Player p3 = new Player(2,2);
        p3.setName("Jake");
        //p3.setClassName("Ninja-Warrior");

        Player p4 = new Player(3,1);
        p4.setName("Drew");
        //p4.setClassName("Gazelle-Tank");

        Player p5 = new Player(4,1);
        p5.setName("Angela");

        Player p6 = new Player(5,1);
        p6.setName("Josh");

        Player p7 = new Player(6,1);
        p7.setName("Drake");

        Player p8 = new Player(7,1);
        p8.setName("Julian");

        Player p9 = new Player(8,1);
        p9.setName("Alyza");

        Player p10 = new Player(9,1);
        p10.setName("Jessica");

        Player p11 = new Player(10,1);
        p11.setName("Romeo");

        playerList = new Player[11];
        playerList[0]=p1;
        playerList[1]=p2;
        playerList[2]=p3;
        playerList[3]=p4;   
        playerList[4]=p5;
        playerList[5]=p6;
        playerList[6]=p7;
        playerList[7]=p8;
        playerList[8]=p9;
        playerList[9]=p10;
        playerList[10]=p11;

        for (int i = 0; i <playerList.length; i++)
        {
            Player tmpPlayer = new Player(i,playerList[i].getDifficulty());
            tmpPlayer.cUpdate();
            for (int k = 0; k < 5; k++)
            {                
                tmpPlayer.setVal(k,10);
            }
            tmpPlayer.setName(playerList[i].getName());
            tmpPlayer.cUpdate();
            tmpPlayer = addBasic(tmpPlayer);
            playerList[i] = tmpPlayer;
        }
        InventoryDisplay iD = new InventoryDisplay(playerList);
        iD.launch();
    }

    public static Player addBasic(Player inP)
    {
        Apparel shirt = new Apparel("T-Shirt",2,1,4,0,0,"A T-shirt made of wool");
        Apparel underwear = new Apparel("Underwear",2,0,1,0,0,"Underwear made of cloth");
        Apparel pants = new Apparel("Jeans",5,0,5,-2,0,"Pants made of selvedged denim");

        Importer importer = new Importer();
        importer.importing();

        int size = importer.getWAr().length - 1;
        int rMath = (int)((Math.random())*size);

        inP.addWeapon(importer.getWAr()[rMath]);
        inP.addApparel(shirt);
        inP.addApparel(underwear);
        inP.addApparel(pants);

        return inP;
    }

    public static void updatePlayer(Player pl)
    {
        playerList[pl.getIndex()] = pl;
    }
}