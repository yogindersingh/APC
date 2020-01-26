package ds;
import ds.Stack;
class LinkedList<E extends Comparable <E>>
{
    private static class Node<E>
    {
        private E element;
        private E min;            
        private Node<E> next;
        public Node(E e, Node<E> n) 
        {
            element=e;
            next=n;
        }
        public E getElement() 
        {
            return element;
        }
        public Node<E> getNext() 
        { 
            return next;
        }
        public void setNext(Node<E> n) 
        { 
            next=n;
        }
        public void setMin(E e)
        {
        	min=e;
        }
        public E getMin()
        {
        	return min;
        }
    }
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    public LinkedList() 
    { 
        
    }
    public int size() 
    {  
        return size;
    }
    public boolean isEmpty() 
    { 
        if(size==0)
            return true;
        return false;
    }
    public E first()
    {
        if(head!=null)
            return head.getElement();
        return null;
    }
    public E last() 
    {
        if(tail!=null)
            return tail.getElement();
        return null;
    }
    public void addFirst(E e) 
    {
        Node<E> n=new Node<>(e,head);
        if(head!=null)
       	{
       		E temp=head.getMin();
       		if(temp.compareTo(e)>0)
       			n.setMin(e);
       		else
       			n.setMin(temp);
       	}
        head=n;
        if(tail==null)
        {
            tail=n;
            tail.setMin(e);
        }
        ++size;
    }
    public void addLast(E e) 
    {
        Node<E> n=new Node<>(e,null);
        if(tail==null)
        {
            head=n;
        }
        else
        {
            tail.setNext(n);
        }
        tail=n;
        ++size;
    }
    public E removeFirst() 
    {
        if(head!=null)
        {
            E x=head.getElement();
            head=head.getNext();
            if(head==null)
                tail=null;
            --size;
            return x;
        }
        return null;
    }
    public E min()
    {
    	if(head!=null)
    		return head.getMin();
    	return null;
    }
    public String toString() 
    {
        StringBuilder s=new StringBuilder("(");
        if(head!=null)
        {
            Node<E> n=new Node<>(head.getElement(),head.getNext());
            while(n!=null)
            {
                s=s.append(n.getElement());
                n=n.getNext();
                if(n!=null)
                    s=s.append(", ");
            }
        }
        s=s.append(")");
        return s.toString();
    }
}
public class StackMin<E extends Comparable <E>>
{
    private LinkedList<E> list = new LinkedList<>();   

    public StackMin() { }                   

    
    public int size() 
    {  
        return list.size();
    }

    
    public boolean isEmpty() 
    { 
        return list.isEmpty();
    }

    
    public void push(E element) 
    { 
        list.addFirst(element);
    }

    
    public E top() 
    { 
        return list.first();
    }

    
    public E minimum()
    {
    	return list.min();
    }


    public E pop() 
    { 
        return list.removeFirst();
    }

    
    public String toString() 
    {
        return list.toString();
    }
}
