import sacco.*;
public class SettingsCombat extends Display
{
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
    }
}