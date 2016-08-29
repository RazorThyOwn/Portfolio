import sacco.*;
public class JumpMan
{
    private double pX, pY, fallSpeed, gravity;
    private int width, heigth;
    private Picture myPic;

    public JumpMan(int tmpX, int tmpY)
    {
        myPic = Picture.loadFromJar("mariosprites.png").getSubPicture(112,16,16,32).resize(48,96);
        myPic.flipHorizontal();
        width = 48;
        heigth = 96;
        pX = tmpX;
        pY = tmpY;
        gravity = 1;
    }

    public double getX()
    {
        return pX;
    }

    public double getY()
    {
        return pY;
    }

    public int getWidth()
    {
        return width;
    }

    public void setGrav(int grav)
    {
        gravity = grav;
    }

    public int getHeigth()
    {
        return heigth;
    }

    public void setX(double tmpX)
    {
        pX = tmpX;
    }

    public void setY(double tmpY)
    {
        pY = tmpY;
    }

    public void setFallSpeed(double speed)
    {
        fallSpeed = speed;
    }

    public void paintSelf(PaintBrush brush)
    {
        brush.drawPicture(myPic, (int)pX, (int)pY);
    }

    public BoundingBox getBounds()
    {
        BoundingBox box = new BoundingBox((int)pX, (int)pY, width, heigth);
        return box;
    }

    public void fall()
    {
        pY+=fallSpeed;
        fallSpeed+=gravity;
    }

    public void jump()
    {
        fallSpeed = -10;
    }

    public void moveRight()
    {
        this.setX(pX+=5);
    }

    public void moveLeft()
    {
        this.setX(pX-=5);
    }    
}

    