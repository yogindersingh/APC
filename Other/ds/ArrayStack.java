package ds;
import ds.Stack;
public class ArrayStack<E> implements Stack<E> 
{
    public static final int CAPACITY=1000;   

    private E[] data;                        

    private int t = -1;                      

    public ArrayStack() 
    { 
        data = (E[])new Object[CAPACITY];
    }

    @SuppressWarnings({"unchecked"})
    public ArrayStack(int capacity) {        
        data = (E[])new Object[capacity];
    }

    @Override
    public int size() 
    {  
        return t+1;
    }

    @Override
    public boolean isEmpty() 
    {  
        if(t==-1)
            return true;
        return false;
    }

    @Override
    public void push(E e) throws IllegalStateException 
    {
        data[++t]=e;
    }

    @Override
    public E top() 
    {
        return data[t];
    }

    @Override
    public E pop() 
    {
        if(isEmpty())
            return null;
        return data[t--];
    }

    public String toString() 
    {
        StringBuilder s=new StringBuilder("(");
        for(int i=0;i<=t;++i)
        {
            s=s.append(data[i]);
            if(i!=t)
                s=s.append(", ");
        }
        s=s.append(")");
        return s.toString();
    }
}
