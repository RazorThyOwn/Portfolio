import sacco.*;
public class TrainMenu extends Display
{
    Button[] btList = new Button[5];
    Player player;
    int index;
    public TrainMenu(Player pl, int indexIn)
    {
        index = indexIn;
        player = pl;
    }

    public void paintWindow(PaintBrush brush)
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

        // General Blocks

        for (int i = 0; i < 5; i++)
        {            
            brush.setThickness(10);
            brush.setColor("black");
            brush.drawRectangle(50,40 + 55*i,220,40);
            brush.setThickness(10);
            brush.setColor(0,143,0);
            brush.fillRectangle(50,40 + 55*i,220,40);
            btList[i] = new Button(50,40+55*i,220,40);
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
    }    

    public void onMousePress(MouseEvent m)
    {
        for (int i = 0; i < 5; i++)
        {
            if (btList[i].press(m.getX(),m.getY()))
            {
                player.train(i);
                CharDisplay.changePlayer(player,index);
                return;
            }
        }
    }
}