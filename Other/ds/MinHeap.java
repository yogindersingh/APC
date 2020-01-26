package ds;
import ds.Heap;
public class MinHeap<E extends Comparable<E>> implements Heap<E>
{
	public static final int CAPACITY=1000;
	private E[] data;
	int size=0;

	public MinHeap()
	{
		data = (E[])new Comparable[CAPACITY];
	}

	@SuppressWarnings({"unchecked"})
	public MinHeap(int capacity)
	{
		data = (E[])new Comparable[capacity];	
	}

	@Override
	public boolean doesExist(int pos)
	{
		if(pos>0&&pos<=size)
			return true;
		return false;
	}

	@Override
	public void swap(int pos1,int pos2)
	{
		E temp=data[pos1];
		data[pos1]=data[pos2];
		data[pos2]=temp;
	}

	@Override
	public void Heapify(int pos)
	{
		int lChild=2*pos,rChild=2*pos+1,min=pos;
		if(doesExist(lChild)&&data[min].compareTo(data[lChild])>0)
		{	
			min=lChild;
		}
		if(doesExist(rChild)&&data[min].compareTo(data[rChild])>0)
		{	
			min=rChild;
		}
		if(min!=pos)
		{
			swap(min,pos);
			Heapify(min);
		}
	}

	@Override
	public int length()
	{
		return size;
	} 

	@Override
	public boolean isEmpty()
	{
		if(size==0)
			return true;
		return false;
	}

	@Override
	public void insert(E e)
	{
		data[++size]=e;
	}

	@Override
	public void buildHeap()
	{
		for(int i=size/2;i>=1;--i)
			Heapify(i);
	}

	@Override 
	public E remove()
	{
		if(!isEmpty())
		{
			E temp=data[1];
			data[1]=data[size--];
			Heapify(1);
			return temp;
		}	
		return null;
	}

	@Override 
	public E top()
	{
		if(!isEmpty())
		{
			return data[1];
		}	
		return null;
	}

	public String toString()
	{
		StringBuilder s=new StringBuilder("(");
        for(int i=1;i<=size;++i)
        {
            s=s.append(data[i]);
            if(i!=size)
                s=s.append(", ");
        }
        s=s.append(")");
        return s.toString();
	}
}