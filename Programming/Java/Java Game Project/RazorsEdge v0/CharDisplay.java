import sacco.*;
import java.awt.Color;
public class CharDisplay extends Display
{
    static Player[] playerList;

    Button pgUp;
    Button pgDown;

    Button[] sleepList;
    Button[] drinkList;
    Button[] eatList;
    Button[] btTrainList;
    Button[] btModifyList;
    Button[] nameButtonList;

    int pageNumber = 1;
    int pgAmount = 0;
    int nPerPage = 5;

    public CharDisplay()
    {

    }

    public CharDisplay(Player[] pl, int playersPerPage)
    {
        nPerPage = playersPerPage;
        playerList = pl;
    }

    public void importPlayerList(Player[] pl)
    {
        playerList = pl;
    }

    public void paintWindow(PaintBrush brush)
    {        
        // Initializing Buttonlist
        btTrainList = new Button[playerList.length];
        btModifyList = new Button[playerList.length];
        sleepList = new Button[playerList.length];
        drinkList = new Button[playerList.length];
        eatList = new Button[playerList.length];
        nameButtonList = new Button[playerList.length];

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

        int xPos = 60;
        int yPos = 60;
        int width = 50;

        int diviser = playerList.length / nPerPage;
        int remainder = playerList.length%nPerPage;

        int calc = playerList.length - ( nPerPage * (pageNumber-1) );
        if (calc>nPerPage)
            pgAmount = nPerPage;
        else
            pgAmount = calc;

        for (int i = 0; i < pgAmount; i++)
        {
            // Drawing Squares

            brush.setThickness(4);
            brush.setBold(true);
            brush.setFontSize(40);
            String name = playerList[ i + (nPerPage* (pageNumber-1))].getName();
            int nameLength = brush.getStringWidth(name);
            if (nameLength>250)
            {
                name = name.substring(0,11);
            }
            nameLength = brush.getStringWidth(name);

            brush.setColor(0,143,0);
            if ( (playerList[ i + (nPerPage* (pageNumber-1))].getExhausted()) > 1)
                brush.setColor(150,150,150);
            if ( (playerList[ i + (nPerPage* (pageNumber-1))].getIsControlSleeping()))
                brush.setColor(0,0,80);
            if ( (playerList[ i + (nPerPage* (pageNumber-1))].getIsSleeping()))
                brush.setColor(0,0,80);
            if (playerList[ i + (nPerPage* (pageNumber-1))].getHitpoints()<1)
                brush.setColor(143,0,0);

            brush.fillRectangle(xPos,yPos,270,50);
            brush.setColor("black");
            brush.drawRectangle(xPos,yPos,270,50);
            nameButtonList[i] = new Button(xPos,yPos,270,50);

            // Drawing Names

            brush.setColor(254,194,63);
            if ( (playerList[ i + (nPerPage* (pageNumber-1))].getExhausted()) > 1)
                brush.setColor(50,50,50);
            if ( (playerList[ i + (nPerPage* (pageNumber-1))].getIsControlSleeping()))
                brush.setColor(0,0,180);
            if ( (playerList[ i + (nPerPage* (pageNumber-1))].getIsSleeping()))
                brush.setColor(0,0,180);
            if (playerList[ i + (nPerPage* (pageNumber-1))].getHitpoints()<1)
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

            Player player = playerList[ i + (nPerPage* (pageNumber-1))];
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

            // Drawing Misc Buttons

            brush.setColor("black");
            brush.drawRectangle(xPos+10,yPos+width+80,25,25);
            brush.setColor(0,143,0);
            brush.fillRectangle(xPos+10,yPos+width+80,25,25);
            brush.setColor(254,194,63);
            brush.drawString("T",xPos+15,yPos+width+102);
            Button btTrain = new Button(xPos+10,yPos+width+80,25,25);
            btTrainList[ i + (nPerPage* (pageNumber-1))] = btTrain;

            brush.setColor("black");
            brush.drawRectangle(xPos+235,yPos+width+80,25,25);
            brush.setColor(0,143,0);
            brush.fillRectangle(xPos+235,yPos+width+80,25,25);
            brush.setColor(254,194,63);
            brush.drawString("M",xPos+238,yPos+width+102);
            Button btMod = new Button(xPos+235,yPos+width+80,25,25);
            btModifyList[ i + (nPerPage* (pageNumber-1))] = btMod;

            // Sleep, eat, drink buttons
            brush.setColor("black");
            brush.drawRectangle(xPos+238,yPos+width+365,15,15);
            brush.setColor(0,143,0);
            brush.fillRectangle(xPos+238,yPos+width+365,15,15);
            brush.setColor(254,194,63);
            brush.setFontSize(15);
            brush.drawString("S",xPos+241,yPos+width+378);
            Button bTS = new Button(xPos+238,yPos+width+365,15,15);
            sleepList[ i + (nPerPage* (pageNumber-1))] = bTS;

            brush.setColor("black");
            brush.drawRectangle(xPos+238,yPos+width+395,15,15);
            brush.setColor(0,143,0);
            brush.fillRectangle(xPos+238,yPos+width+395,15,15);
            brush.setColor(254,194,63);
            brush.drawString("D",xPos+241,yPos+width+408);
            Button bTD = new Button(xPos+238,yPos+width+395,15,15);
            drinkList[ i + (nPerPage* (pageNumber-1))] = bTD;

            brush.setColor("black");
            brush.drawRectangle(xPos+238,yPos+width+425,15,15);
            brush.setColor(0,143,0);
            brush.fillRectangle(xPos+238,yPos+width+425,15,15);
            brush.setColor(254,194,63);
            brush.drawString("E",xPos+241,yPos+width+438);
            Button bTE = new Button(xPos+238,yPos+width+425,15,15);
            eatList[ i + (nPerPage* (pageNumber-1))] = bTE;

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

            Color clr = new Color(0,143,13);
            brush.setColor(clr);
            brush.drawString("("+player.getHPBonus()+")",xPos+220,yPos+width+150);
            brush.drawString("("+player.getSpeedBonus()+")",xPos+220,yPos+width+240);
            brush.drawString("("+player.getAgilityBonus()+")",xPos+220,yPos+width+300);

            //Final Increase
            xPos+=300;
        }

        setSize(xPos+50,730);
        setResizable(false);

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

        // Train List Loop
        for (int i = 0; i < pgAmount; i++)
        {
            if ( !(btTrainList[ (nPerPage * (pageNumber-1) ) + i]==null) )
                if (btTrainList[ (nPerPage * (pageNumber-1) ) + i].press(m.getX(),m.getY()))
                {
                    TrainMenu tM = new TrainMenu(playerList[ (nPerPage* (pageNumber-1) ) + i],(nPerPage* (pageNumber-1) ) + i);
                    tM.launch();
            }                
        }
        // Modify List Loop
        for (int i = 0; i < pgAmount; i++)
        {
            if ( !(btModifyList[ (nPerPage * (pageNumber-1) ) + i]==null) )
                if (btModifyList[ (nPerPage * (pageNumber-1) ) + i].press(m.getX(),m.getY()))
                {
                    ModifyMenu mM = new ModifyMenu(playerList[ (nPerPage * (pageNumber-1) ) + i],(nPerPage * (pageNumber-1) ) + i);
                    mM.launch();
            }                
        }
        // Sleep Loop
        for (int i = 0; i < pgAmount; i++)
        {
            if ( !(sleepList[ (nPerPage * (pageNumber-1) ) + i]==null) )
            {
                if (sleepList[ (nPerPage * (pageNumber-1) ) + i].press(m.getX(),m.getY()))
                {         
                    boolean opposite = !(playerList[ (nPerPage * (pageNumber-1) ) + i].getIsControlSleeping());
                    playerList[ (nPerPage * (pageNumber-1) ) + i].setIsControlSleeping(opposite);
                }                
            }
        }
        // Drink loop
        for (int i = 0; i < pgAmount; i++)
        {
            if ( !(drinkList[ (nPerPage * (pageNumber-1) ) + i]==null) )
                if (drinkList[ (nPerPage * (pageNumber-1) ) + i].press(m.getX(),m.getY()))
                {         
                    playerList[ (nPerPage * (pageNumber-1) ) + i].drink();
            }                
        }
        // Eat loop
        for (int i = 0; i < pgAmount; i++)
        {
            if ( !(eatList[ (nPerPage * (pageNumber-1) ) + i]==null) )
                if (eatList[ (nPerPage * (pageNumber-1) ) + i].press(m.getX(),m.getY()))
                {         
                    playerList[ (nPerPage * (pageNumber-1) ) + i].eat();
            }                
        }

        // Name Pressing
        for (int i = 0; i < pgAmount; i++)
        {
            if (nameButtonList[i].press(m.getX(),m.getY()) && playerList[ (nPerPage * (pageNumber-1) ) + i].getExhausted()<=1)
            {
                playerList[ (nPerPage * (pageNumber-1) ) + i].setExhausted(2);
            }
            else if (nameButtonList[i].press(m.getX(),m.getY()))
            {
                playerList[ (nPerPage * (pageNumber-1) ) + i].setExhausted(1);
            }
        }
        // Page Number Buttons
        if (pgUp.press(m.getX(),m.getY()) && calc >nPerPage)
        {            
            pageNumber++;
        }
        if (pgDown.press(m.getX(),m.getY()) && pageNumber>1)
        {
            pageNumber--;
        }

        if (calc>nPerPage)
            pgAmount = nPerPage;
        else
            pgAmount = calc;
    }
    
    public static void edit(int slot, Weapon weapon)
    {
        
    }

    public static void changePlayer(Player playr, int index)
    {
        playerList[index] = playr;
    }

    public static void demo()
    {
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
            for (int k = 0; k < 5; k++)
            {
                tmpPlayer.setVal(k,10);
            }
            tmpPlayer.setName(playerList[i].getName());
            tmpPlayer.cUpdate();
            playerList[i] = tmpPlayer;
        }

        CharDisplay cd = new CharDisplay();
        cd.launch();
    }

}