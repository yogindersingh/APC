package ds;
public class MultiQueue<E> 
{
    public static final int CAPACITY = 1000;      

    private E[] data;                             

    private int f1 = 0;                            
    private int f2 = 999;

    private int sz1 = 0;
    private int sz2 = 0;                           

    public MultiQueue() 
    { 
        data = (E[])new Object[CAPACITY];
    }

    public MultiQueue(int capacity) 
    {
        data = (E[])new Object[capacity];
        f2=capacity-1;
    }

    public int size1() 
    { 
        return sz1;
    }

    public int size2() 
    { 
        return sz2;
    }

    public boolean isEmpty1() 
    {
        if(sz1==0)
            return true;
        return false; 
    }

    public boolean isEmpty2() 
    {
        if(sz2==0)
            return true;
        return false; 
    }

    public void enqueue1(E e) throws IllegalStateException 
    {
        if(f1+sz1<f2-sz2-1)
        {
            data[f1+sz1]=e;
            ++sz1;
        }
        else
        {
            System.out.println("Queue1 is full");
        }
    }

    public void enqueue2(E e) throws IllegalStateException 
    {
        if(f1+sz1-1<f2-sz2)
        {
            data[f2-sz2]=e;
            ++sz2;
        }
        else
        {
            System.out.println("Queue2 is full");
        }
    }

    public E first1() 
    {
        if(!isEmpty1())
            return data[f1];
        return null;
    }

    public E first2() 
    {
        if(!isEmpty2())
            return data[f2];
        return null;
    }

    public E dequeue1() 
    {
        if(!isEmpty1())
        {
            --sz1;
            return data[f1++];
        }
        return null;
    }

    public E dequeue2() 
    {
        if(!isEmpty2())
        {
            --sz2;
            return data[f2--];
        }
        return null;
    }

    public String toString1() 
    {
        StringBuilder s=new StringBuilder("(");
        for(int i=f1;i<sz1+f1;++i)
        {
            s=s.append(data[i]);
            if(i+1!=sz1+f1)
                s=s.append(", ");
        }
        s=s.append(")");
        return s.toString();
    }

    public String toString2() 
    {
        StringBuilder s=new StringBuilder("(");
        for(int i=f2;i>f2-sz2;--i)
        {
            s=s.append(data[i]);
            if(i-1!=f2-sz2)
                s=s.append(", ");
        }
        s=s.append(")");
        return s.toString();
    }
}