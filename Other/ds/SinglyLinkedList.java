package ds;
public class SinglyLinkedList<E>
{
    private static class Node<E>
    {
        private E element;            
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
    }
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    public SinglyLinkedList() 
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
        head=n;
        if(tail==null)
            tail=n;
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
    public E mid()
    {
        if(!isEmpty())
        {
            int mid=size/2,i=1;
            if(size%2==1)
                ++mid;
            Node<E> n=head;
            while(true)
            {
                if(i==mid)
                    break;
                n=n.getNext();
                ++i;
            }
            return n.getElement();
        }
        return null;
    }
    public E NodeFromFirst(int m)
    {
        if(!isEmpty())
        {
            int s=m,i=1;
            Node<E> n=head;
            while(true&&n!=null)
            {
                if(i==s)
                    break;
                n=n.getNext();
                ++i;
            }
            if(n!=null&&m>0)
                return n.getElement();
            return null;
        }
        return null;
    }
    public E NodeFromEnd(int m)
    {
        if(!isEmpty())
        {
            int s=size-m+1,i=1;
            Node<E> n=head;
            while(true&&n!=null)
            {
                if(i==s)
                    break;
                n=n.getNext();
                ++i;
            }
            if(n!=null)
                return n.getElement();
            return null;
        }
        return null;   
    }
    private void reverseRecursive(Node<E> n1,Node<E> n2)
    {
        if(n2!=null)
        {
            reverseRecursive(n2,n2.getNext());
            n2.setNext(n1);
        }
        else
        {
            head=n1;
        }
    }
    private void reverseIterative()
    {
        Node<E> n1=null,n2=null,n3=head;
        while(n3!=null)
        {
            n1=n3;
            n3=n1.getNext();
            n1.setNext(n2);
            n2=n1;
        }
        head=n1;
    }
    public void reverse()
    {
        if(!isEmpty())
        {
            reverseRecursive(null,head);
        }
    }
    public void reverse2()
    {
        if(!isEmpty())
        {
            reverseIterative();
        }
    }
    public void reverse3()
    {
        if(!isEmpty())
        {
            Node<E>[] data=new Node[size];
            Node<E> n=head;
            int i=0;
            while(n!=null)
            {
                data[i++]=n;
                n=n.getNext();
            }
            head=data[i-1];
            n=data[--i];
            while(i>=0)
            {
                if(i==0)
                {
                    n.setNext(null);
                    break;
                }
                else
                {
                    n.setNext(data[i-1]);
                }
                n=data[--i];
            }
        }
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