class Couple <T> {
    private T first;
    private T second;
    
    Couple(T f, T s)
    {
        first = f;
        second = s;
    }
    
    T getFirst()
    {
        return first;
    }
    
    T getSecond()
    {
        return second;
    }
    
    void setFirst(T f)
    {
        first = f;
    }
    
    void setSecond(T s)
    {
        second = s;
    }
    
    public String toString()
    {
        return "(" + first.toString() + "," + second.toString() + ")";
    }
    
    @SuppressWarnings("unchecked")
    public boolean equals(Object otherObj)
    {
        boolean isEqual = false;
        Couple<T> o = null;
        if (this.getClass() == otherObj.getClass())
        {
            o = (Couple<T>) otherObj;
            isEqual = (this.first.equals(o.first) && (this.second.equals(o.second)));
        }
        return isEqual;
    }
}