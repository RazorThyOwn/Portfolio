import sacco.*;
public class DragableDragger extends SaccoObject
{
    private Dragable[] drags;
    private Dragable drag;
    private int lastX,lastY;

    //Constructs a new dragsangleDragger that will manage an array of dragsangles
    public DragableDragger(Dragable[] arr)
    {
        drags = arr;
        drag = null; //null means that nothing is being dragged
    }

    @Override
    public void paintWindow(PaintBrush brush)
    {
        //loops through and paints every dragsangle in the array
        for(int i =0; i<drags.length;i++)
        {
            drags[i].paintSelf(brush);
        }

    }

    @Override
    public void onMouseMove(MouseEvent m)
    {
        // when drag is null, there is no object to translate  
        if( drag != null)
        {
            drag.translate(m.getX()-lastX, m.getY()-lastY);
        }

        lastX = m.getX();
        lastY = m.getY();
    }

    @Override
    public void onMousePress(MouseEvent m)
    {
        /*
         * when the mouse is pressed, this code finds whatever dragsangle
         * contains the clicked location and stores it in drag.  Since
         * drag can only hold one object reference at a time, it will
         * have the last one it comes across.
         */
        for( int i=0; i<drags.length; i++)
        {
            if(drags[i].containsPoint(m.getX(),m.getY()))
            {
                drag = drags[i];
            }
        }
    }

    @Override
    public void onMouseRelease(MouseEvent m)
    {
        //when the mouse is released, the currently dragged dragsangle is 'dropped'
        drag =null;
    }

    public static void rtcDragRunner()
    {
        Dragable[] draggables = new Dragable[200];

        for( int i =0; i < draggables.length; i++)
        {
            if(i%3==0)
                draggables[i] = new Triangle();
            else if(i%3 ==1)
                draggables[i] = new Rectangle();
            else
                draggables[i] = new Circle();
        }

        DragableDragger dragger = new DragableDragger(draggables);
        dragger.setVisible(true);
    }
}