import sacco.*;
public interface Dragable
{
    public void translate(int tmpX, int tmpY);
    
    public boolean containsPoint(int tmpX, int tmpY);
    
    public void paintSelf(PaintBrush brush);
}