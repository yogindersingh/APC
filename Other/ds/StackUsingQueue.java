package ds;
public class StackUsingQueue<E>
{
	LinkedQueue<E> q1=new LinkedQueue();
	LinkedQueue<E> q2=new LinkedQueue();
	public void push(E e)
	{
		q1.enqueue(e);
	}
	public E pop()
	{
		int i,size=q1.size();
		for(i=1;i<size;++i)
		{
			q2.enqueue(q1.dequeue());
		}
		E temp=q1.dequeue();
		q1=q2;
		q2=new LinkedQueue();
		return temp;
	}
}