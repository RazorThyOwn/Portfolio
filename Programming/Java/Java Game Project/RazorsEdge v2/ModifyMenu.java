import sacco.*;
public class ModifyMenu extends Display
{
    Button[] increaseList = new Button[9];
    Button[] decreaseList = new Button[9];
    Player player;
    int index;

    public ModifyMenu(Player pl, int indexIn)
    {
        index = indexIn;
        player = pl;
    }

    public void paintWindow(PaintBrush brush)
    {
        // General Setup
        brush.setColor(100,100,100);
        brush.fillRectangle(0,0,360,20);
        brush.fillRectangle(0,0,20,540);
        brush.fillRectangle(360,0,380,540);
        brush.fillRectangle(0,540,380,340);

        brush.setColor(211,184,152);
        brush.fillRectangle(20,20,340,520);
        this.setSize(380,560);

        // General Blocks

        for (int i = 0; i < 9; i++)
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

        int nameLength = brush.getStringWidth("Strength");
        brush.drawString("Strength",160-(nameLength)/2,70);

        nameLength = brush.getStringWidth("Intelligence");
        brush.drawString("Intelligence",160-(nameLength)/2,125);

        nameLength = brush.getStringWidth("Speed");
        brush.drawString("Speed",160-(nameLength)/2,180);

        nameLength = brush.getStringWidth("Endurance");
        brush.drawString("Endurance",160-(nameLength)/2,235);

        nameLength = brush.getStringWidth("Agility");
        brush.drawString("Agility",160-(nameLength)/2,290);
        
        nameLength = brush.getStringWidth("Hitpoints");
        brush.drawString("Hitpoints",160-(nameLength)/2,345);
        
        nameLength = brush.getStringWidth("Sleep");
        brush.drawString("Sleep",160-(nameLength)/2,400);
        
        nameLength = brush.getStringWidth("Thirst");
        brush.drawString("Thirst",160-(nameLength)/2,455);
        
        nameLength = brush.getStringWidth("Hunger");
        brush.drawString("Hunger",160-(nameLength)/2,510);

        // Drawing Update Buttons

        for (int i = 0; i < 9; i++)
        {
            // Increase Buttons
            brush.setThickness(10);
            brush.setColor("black");
            brush.drawRectangle(285,50 + 55*i,20,20);
            brush.setThickness(10);
            brush.setColor(0,143,0);
            brush.fillRectangle(285,50 + 55*i,20,20);
            brush.setColor(254,194,63);
            brush.drawString("+",287,70+55*i);
            increaseList[i] = new Button(285,50+55*i,20,20);

            // Decrease Buttons
            brush.setThickness(10);
            brush.setColor("black");
            brush.drawRectangle(320,50 + 55*i,20,20);
            brush.setThickness(10);
            brush.setColor(0,143,0);
            brush.fillRectangle(320,50 + 55*i,20,20);
            brush.setColor(254,194,63);
            brush.drawString("-",326,68+55*i);
            decreaseList[i] = new Button(320,50+55*i,20,20);
        }                
    }    

    public void onMousePress(MouseEvent m)
    {
        for (int i = 0; i < 9; i++)
        {
            if (increaseList[i].press(m.getX(),m.getY()))
            {
                player.adjustVal(i,1);
                CharDisplay.changePlayer(player,index);
                return;
            }
            
            if (decreaseList[i].press(m.getX(),m.getY()))
            {
                player.adjustVal(i,-1);
                CharDisplay.changePlayer(player,index);
            }
        }
    }
}