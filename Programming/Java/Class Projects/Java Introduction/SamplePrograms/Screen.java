import sacco.*;
public class Screen extends Display
{
    private Button bt;
    public void paintWindow(PaintBrush brush)
    {
        brush.setColor("black");
        brush.fillRectangle(50,50,50,50);
        bt = new Button(50,50,50,50);
        this.setSize(150,150);
    }

    public void onMousePress(MouseEvent m)
    {
        if (bt.press(m.getX(),m.getY()))
        {
            Command.math();
        }
    }
}