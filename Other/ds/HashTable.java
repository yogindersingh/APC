package ds;
public class HashTable<E>
{
	SinglyLinkedList s[]=new SinglyLinkedList[97];
	public HashTable()
	{
		for(int i=0;i<97;++i)
			s[i]=new SinglyLinkedList();
	}
	private int getKey(E data)
	{
		String s=data.toString();
		int i,sum=0;
		for(i=0;i<s.length();++i)
			sum+=s.charAt(i);
		return sum%97;
	}
	public void insert(E data)
	{
		int key=getKey(data);
		s[key].addLast(data);
	}
	public E get(E data)
	{
		int i=1,key=getKey(data);
		while(s[key].NodeFromFirst(i)!=null)
		{
			if((s[key].NodeFromFirst(i).toString()).equals(data.toString()))
				return data;
			++i;
		}
		return null;
	}
}