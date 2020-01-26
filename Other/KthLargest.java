import ds.MaxHeap;
import ds.Heap;
import java.util.Scanner;
public class KthLargest
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int i,k,n;
		n=sc.nextInt();
		int[] arr=new int[n];
		for(i=0;i<n;++i)
			arr[i]=sc.nextInt();
		k=sc.nextInt();
		Heap m=new MaxHeap();
		for(i=0;i<n;++i)
		{
			m.insert(arr[i]);
		}
		m.buildHeap();
		for(i=1;i<k;++i)
		{
			m.remove();
			m.buildHeap();
		}
		System.out.println(m.top());
	}
}