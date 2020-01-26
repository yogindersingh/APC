import ds.Stack;
import ds.Queue;
import ds.*;
public class Test
{
	
	public static void main(String args[])
	{
		int i,arr[]=new int[]{10,9,8,7,6,5,4,3,2,1};
		Sorting.HeapSort(arr);
		for(i=0;i<arr.length;++i)
			System.out.println(arr[i]);
		StackUsingQueue s=new StackUsingQueue();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.pop());
		System.out.println(s.pop());
		QueueUsingStack q=new QueueUsingStack();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		System.out.println(q.peek());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}