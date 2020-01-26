package ds;
public class SortingNR
{
	private static void merge(int arr[],int l,int m,int r)
	{
		int i,j,k,s1=m-l+1,s2=r-m;
		int a[]=new int[s1],b[]=new int[s2];
		for(i=l;i<=m;++i)
			a[i-l]=arr[i];
		for(i=m+1;i<=r;++i)
			b[i-m-1]=arr[i];
		i=l;
		j=0;
		k=0;
		while(j<s1&&k<s2)
		{
			if(a[j]>b[k])
			{
				arr[i++]=b[k++];
			}
			else
			{
				arr[i++]=a[j++];
			}
		}
		while(j<s1)
			arr[i++]=a[j++];
		while(k<s2)
			arr[i++]=b[k++];
	}
	public static void MergeSort(int arr[])
	{
		int i,l;
		for(i=1;i<=arr.length-1;i=2*i)
		{
			for(l=0;l<arr.length-1;l+=2*i)
			{
				int m,r;
				if(l+i-1<arr.length-1)
					m=l+i-1;
				else
					m=arr.length-1;
				if(l+2*i-1<arr.length-1)
					r=l+2*i-1;
				else
					r=arr.length-1;
				merge(arr,l,m,r);
			}
		}
	}
	private static int partition(int arr[],int l,int r)
	{
		int pivot=arr[r],i=l,j=l;
		while(i<=r)
		{
			if(arr[i]<pivot)
			{
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
				++i;
				++j;
			}
			else
				++i;
		}
		int temp=arr[j];
		arr[j]=arr[r];
		arr[r]=temp;
		return j;
	}
	public static void QuickSort(int arr[])
	{
		int l=0,r=arr.length-1,i=0;
		int a[]=new int[r-l+1];
		a[i++]=l;
		a[i++]=r;
		while(i>0)
		{
			r=a[--i];
			l=a[--i];
			int p=partition(arr,l,r);
			if(p-1>l)
			{
				a[i++]=l;
				a[i++]=p-1;
			}
			if(r>p+1)
			{
				a[i++]=p+1;
				a[i++]=r;	
			}
		}
	}
}