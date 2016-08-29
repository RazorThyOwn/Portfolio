import java.io.IOException;
class ArrayList<E extends Comparable<E>> implements ListT<E>
{
    private E[] array;
    private int size;

    ArrayList()
    {
        this.array = (E[]) new Comparable[10];
        this.size = 0;
    }

    public boolean add(E data)
    {
        if (data!=null && (size<array.length) /* replace with size not at end */ )
        {
            // Resizing
            this.trimToSize();
            // Adding data to the array at index of size
            array[size] = data;
            // Increasing size
            size++;
            return true;
        }
        return false;
    }

    public void clear()
    {
        this.array = (E[]) new Object[array.length];
    }

    public boolean contains(E data)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (data.compareTo(array[i])==1)
                return true;
        }
        return false;
    }

    public E get(int index)
    {
        try
        {
            if (index<0)
                throw new IllegalArgumentException("ERROR: Below zero");
            if (index>array.length)
                throw new IndexOutOfBoundsException("ERROR: Out of bounds");
            return (array[index]);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public int indexOf(E data)
    {
        int count = 0;
        if (data!=null)
        {
            for (int i = 0; i < array.length; i++)
            {
                if (array[i].equals(data))
                    count++;
            }

        }
        return count;
    }

    public boolean isEmpty()
    {
        return (size==0);
    }

    public void trimToSize()
    {
        try
        {
            E[] tmpArray = (E[]) new Comparable[this.array.length+1];
            for (int i = 0; i < array.length; i++)
            {
                tmpArray[i] = array[i];
            }
            array = tmpArray;
        }
        catch (OutOfMemoryError e)
        {
            e.printStackTrace();
        }
    }

    public int size()
    {
        return size;
    }
}