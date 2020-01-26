package ds;
import ds.Queue;
import ds.CircularQueue;
public class CircularQueue<E extends Comparable <E>> implements Queue<E> 
{
    private CircularLinkedList<E> list = new CircularLinkedList<>();   

    public CircularQueue() { }

    @Override
    public int size() 
    { 
        return list.size();
    }

    @Override
    public boolean isEmpty() 
    { 
        return list.isEmpty();
    }

    @Override
    public void enqueue(E element) 
    { 
        list.addLast(element);
    }

    @Override
    public E first() 
    { 
        return list.first();
    }

    @Override
    public E dequeue() 
    {
        return list.removeFirst(); 
    }

    public String toString() 
    {
        return list.toString();
    }
}
