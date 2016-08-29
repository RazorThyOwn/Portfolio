public interface ListT<E>
{
    boolean add(E data);
    
    void clear();
    
    boolean contains(E data);
    
    E get(int index) throws Exception;
    
    int indexOf(E data);
    
    boolean isEmpty();

    void trimToSize();

    int size();

}