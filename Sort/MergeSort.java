import java.util.*;
public class MergeSort
{

	public static void Merge(int a[],int l,int m,int r)
	{
		int n1=m-l+1;
		int n2=r-m;
		int l1[]=new int[n1];
		int r1[]=new int[n2];

		int i=0,j=0;
		for(i=0;i<n1;i++)
		{
			l1[i]=a[l+i];
		}
		for(j=0;j<n2;j++)
		{
			r1[j]=a[m+1+j];
		}
		i=j=0;
		int k=l;
		while(i<n1&&j<n2)
		{
			if(l1[i]<r1[j])
			{
				a[k++]=l1[i++];
			}
			else
				a[k++]=r1[j++];
		}

		while(i<n1)
		{
			a[k++]=l1[i++];
		}
		while(j<n2)
		{
			a[k++]=r1[j++];
		}
	}

	public static void MergeSort(int a[],int l,int r)
	{
		if(l<r)
		{	
			int m=(l+r)/2;
			MergeSort(a,l,m);
			MergeSort(a,m+1,r);
		
			Merge(a,l,m,r);
		}
	}
	public static void print(int a[])
	{
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
	}
	public static void main(String agrs[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The Size of Array :- ");
		int n=sc.nextInt();
		int a[]=new int[n];
		int i;
		for(i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		MergeSort(a,0,n-1);
		print(a);
	}
}