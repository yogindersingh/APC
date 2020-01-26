package ds;
import ds.Queue;
public class ArrayQueue<E> implements Queue<E> 
{

    public static final int CAPACITY = 1000;      

    private E[] data;

    private int f = 0;

    private int sz = 0; 

    public ArrayQueue() 
    { 
        data = (E[])new Object[CAPACITY];
    }

    @SuppressWarnings({"unchecked"})
    public ArrayQueue(int capacity) 
    {
         data = (E[])new Object[capacity];
    }

    @Override
    public int size() 
    { 
        return sz-f;
    }

    @Override
    public boolean isEmpty() 
    {
        if(sz-f==0)
            return true;
        return false; 
    }

    @Override
    public void enqueue(E e) throws IllegalStateException 
    {
        data[sz++]=e;
    }

    @Override
    public E first() 
    {
        return data[f];
    }

    @Override
    public E dequeue() 
    {
        return data[f++];

    }

    public String toString() 
    {
        StringBuilder s=new StringBuilder("(");
        for(int i=f;i<sz;++i)
        {
            s=s.append(data[i]);
            if(i+1!=sz)
                s=s.append(", ");
        }
        s=s.append(")");
        return s.toString();
    }
}