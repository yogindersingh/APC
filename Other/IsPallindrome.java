import ds.*;
public class IsPallindrome
{
	public static void main(String args[])
	{
		SinglyLinkedList s=new SinglyLinkedList();
		s.addFirst(1);
		s.addFirst(2);
		s.addFirst(3);
		s.addLast(1);
		s.addLast(2);
		s.addLast(3);
		int size=s.size();
		int i=1,mid=size/2,flag=1;
		LinkedStack l=new LinkedStack();
		for(i=1;i<=mid;++i)
		{
			l.push(s.NodeFromFirst(i));
		}
			i+=size%2;
		for(;i<=size;++i)
		{
			if(l.pop()!=s.NodeFromFirst(i))
			{
				flag=0;
				break;
			}
		}
		if(flag==0)
			System.out.println("The Linked List is not Pallindrome");
		else
			System.out.println("The Linked List is Pallindrome");
	}
}