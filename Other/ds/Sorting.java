package ds;
public class Sorting
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
	private static void sort(int arr[],int l,int r)
	{
		if(l<r)
		{
			int m=(l+r)/2;
			sort(arr,l,m);
			sort(arr,m+1,r);
			merge(arr,l,m,r);
		}
	}
	public static void MergeSort(int arr[])
	{
		sort(arr,0,arr.length-1);
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
	private static void setPivot(int arr[],int l,int r)
	{
		int mid=(l+r)/2;
		int x=arr[l],y=arr[mid],z=arr[r],c=0,flag=0;
		if((x<y&&x<z)||(z<y&&y<x))
		{
			arr[mid]=z;
			arr[r]=y;
		}  
   		else if((y<x&&x<z)||(z<x&&x<y)) 
       	{
       		arr[l]=z;
			arr[r]=x;
       	}
	}
	private static void qsort(int arr[],int l,int r)
	{
		if(l<r)
		{
			setPivot(arr,l,r);
			int p=partition(arr,l,r);
			qsort(arr,l,p-1);
			qsort(arr,p+1,r);
		}
	}
	public static void QuickSort(int arr[])
	{
		qsort(arr,0,arr.length-1);
	}
	private static void Heapify(int arr[],int size,int p)
	{
		int max=p;
		int x=2*p+1,y=2*p+2;
		if(x<size&&arr[x]>arr[max])
			max=x;
		if(y<size&&arr[y]>arr[max])
			max=y;
		if(max!=p)
		{
			int temp=arr[p];
			arr[p]=arr[max];
			arr[max]=temp;
			Heapify(arr,size,max);
		}
	}
	public static void HeapSort(int arr[])
	{
		int i;
		for(i=arr.length/2-1;i>=0;--i)
			Heapify(arr,arr.length,i);
		for(i=arr.length-1;i>=0;--i)
		{
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			Heapify(arr,i,0);
		} 
	}
}