import sacco.*;
public class WanderWorld extends SaccoObject
{
    public Wanderer[] wanderers;

    public WanderWorld(Wanderer[] wanderers)
    {       
        this.wanderers = wanderers;
    }

    public void onTimerTick()
    {
        for(int i = 0; i<wanderers.length;i++)
        {
            wanderers[i].update();
        }
    }

    public void paintWindow(PaintBrush brush)
    {
        for(int i = 0; i < wanderers.length;i++)
        {
            wanderers[i].paintSelf(brush);
        }
    }

    public void launch()
    {
        this.setVisible(true);
        this.start();
    }

    public static void main()
    {
        Wanderer[] wanderers = new Wanderer[20];

        for(int i = 0; i < 20; i++)
            wanderers[i] = new Wanderer(250,250);

        WanderWorld w = new WanderWorld(wanderers);
        w.launch();
    }

    public static void antiGhostRunner()
    {
        Wanderer[] wanderers = new Wanderer[20];

        for(int i = 0; i < wanderers.length; i++)
            wanderers[i] = new AntiGhostWanderer(250,250);

        WanderWorld w = new WanderWorld(wanderers);
        w.launch();
    }

    public static void SprintingWanderer()
    {
        Wanderer[] wanderers = new Wanderer[20];
        for(int i = 0; i < wanderers.length; i++)
            wanderers[i] = new SprintingWanderer(250,250);

        WanderWorld w = new WanderWorld(wanderers);
        w.launch();
    }

    public static void boundedRunner()
    {
        Wanderer[] wanderers = new Wanderer[40];

        for(int i = 0; i < wanderers.length; i++)
            wanderers[i] = new BoundedWanderer(150,150,350,350);

        WanderWorld w = new WanderWorld(wanderers);
        w.launch();
    }

    public static void levelRunner()
    {
        LevelWanderer[] wanderers = new LevelWanderer[100];

        for(int i = 0; i < wanderers.length; i++)
        {
            wanderers[i] = new LevelWanderer(250,250);

            int y = 500*wanderers[i].getCharacterNumber()/9;
            wanderers[i].setTargetY(y);
        }
        WanderWorld w = new WanderWorld(wanderers);
        w.launch();
    }

    public static void clockwiseRunner()
    {
        Wanderer[] wanderers = new Wanderer[80];

        for(int i = 0; i < wanderers.length; i++)
            wanderers[i] = new ClockwiseWanderer(250,250);

        WanderWorld w = new WanderWorld(wanderers);
        w.launch();
    }
}