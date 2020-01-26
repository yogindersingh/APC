package ds;
public class QueueUsingStack<E>
{
	LinkedStack<E> l1=new LinkedStack();
	LinkedStack<E> l2=new LinkedStack();
	public void enqueue(E e)
	{
		l1.push(e);
	}
	public E dequeue()
	{
		if(!l2.isEmpty())
			return l2.pop();	
		while(!l1.isEmpty())
		{
			l2.push(l1.pop());
		}
		return l2.pop();
	}
	public E peek()
	{
		if(!l2.isEmpty())
			return l2.top();
		while(!l1.isEmpty())
		{
			l2.push(l1.pop());
		}
		return l2.top();
	}
}