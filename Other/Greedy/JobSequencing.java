import java.util.*;
import java.io.*;
class Job
{
	public int id;
	public int deadline;
	public int profit;
}
class SortByProfit implements Comparator<Job>
{
	public int compare(Job a,Job b)
	{
		return a.profit-b.profit;
	}
}
public class JobSequencing
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t--!=0)
		{
			int i,n=sc.nextInt();
			Job j[]=new Job[n];
			int arr[]=new int[n];
			for(i=0;i<n;++i)
			{
				j[i]=new Job();
				j[i].id=sc.nextInt();
				j[i].deadline=sc.nextInt();
				j[i].profit=sc.nextInt();
			}
			Arrays.sort(j,new SortByProfit());
			int k,sum=0,c=0;
			for(i=n-1;i>=0;--i)
			{
				for(k=n-1;k>=0;--k)
				{
					if(arr[k]==0&&k<=j[i].deadline-1)
                	{
                    	arr[k]=j[i].profit;
                    	sum+=j[i].profit;
                    	c++;
                    	break;
                	}
				}
			}
			System.out.println(c+" "+sum);
		}
	}
}