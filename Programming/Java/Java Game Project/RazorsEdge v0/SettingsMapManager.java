import sacco.*;
public class SettingsMapManager extends Display
{
    Button[] minus = new Button[4];
    Button[] plus = new Button[4];

    int[] intAr;
    int globalScaleIndex = 0;
    int localScaleIndex = 0;
    int globalWidth;
    int globalHeight;
    int playerWidth;
    int playerHeight;

    public SettingsMapManager(int gScale,int lScale,int gwScale,int lwScale)
    {
        globalScaleIndex = gScale;
        localScaleIndex = lScale;
        globalHeight = gwScale;
        globalWidth = gwScale;
        playerWidth = lwScale;
        playerHeight = lwScale;
        intAr = factorsList(globalWidth);
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

        for (int i = 0; i < 4; i++)
        {
            brush.setColor("black");
            brush.setThickness(8);
            brush.drawRectangle(30,i*50 + 30,30,30);                   
            brush.drawRectangle(80,i*50 + 30,160,30);
            brush.drawRectangle(260,i*50 + 30,30,30);

            brush.setColor(0,143,0);
            brush.fillRectangle(30,i*50 + 30, 30, 30);
            brush.fillRectangle(30,i*50 + 30,30,30);
            brush.fillRectangle(80,i*50 + 30,160,30);
            brush.fillRectangle(260,i*50 + 30,30,30);

            Button tmpButton = new Button(30,i*50 + 30,30,30);
            minus[i] = tmpButton;
            tmpButton = new Button(260,i*50 + 30,30,30);
            plus[i] = tmpButton;
        }

        brush.setColor(254,194,63);
        brush.setFontSize(30);
        for (int i = 0; i < 4; i++)
        {
            brush.drawString("-",38,i*50 + 53);
            brush.drawString("+",267,i*50+54);
        }

        brush.setFontSize(20);
        brush.drawString("GlobalScale: "+intAr[globalScaleIndex],85,55);
        brush.drawString("LocalScale: "+intAr[localScaleIndex],85,105);
        brush.drawString("Global Dim: "+globalWidth,85,155);
        brush.drawString("Local Dim: "+playerWidth,85,205);
    }

    public void onMousePress(MouseEvent m)
    {
        for (int i = 0; i < 4; i ++)
        {
            if (minus[i].press(m.getX(),m.getY()))
            {
                if (i==0 && globalScaleIndex>0)
                    globalScaleIndex--;
                if (i==1 && localScaleIndex>0)
                    localScaleIndex--;
                if (i==2 && globalWidth>0)
                    globalWidth--;
                if (i==3 && playerWidth>0)
                    playerWidth--;
                Controller.updateMapSettings(globalScaleIndex,localScaleIndex,globalWidth,playerWidth);
            }
            if (plus[i].press(m.getX(),m.getY()))
            {
                if (i==0 && globalScaleIndex<intAr.length)
                    globalScaleIndex++;
                if (i==1 && localScaleIndex<5)
                    localScaleIndex++;
                if (i==2)
                    globalWidth++;
                if (i==3)
                    playerWidth++;
                Controller.updateMapSettings(globalScaleIndex,localScaleIndex,globalWidth,playerWidth);
            }
        }
    }

    public static int[] factorsList(int size)
    {
        int[] factList = new int[1];
        for (int i = 1; i < size+1;i++)
        {
            if (size%i ==0)
            {
                int[] newFactList = new int[factList.length+1];
                for (int j = 0; j < factList.length; j++)
                {
                    newFactList[j] = factList[j];
                }
                newFactList[factList.length]=i;
                factList = newFactList;
            }
        }
        return factList;
    }
}