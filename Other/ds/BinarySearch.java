package ds;
public class BinarySearch
{
	public static int RecursiveSearch(int arr[],int num,int low,int high)
	{
		if(low<=high)
		{
			int index=-1,mid=(high+low)/2;
			if(arr[mid]>=num)
			{
				if(arr[mid]==num)
				{
					index=RecursiveSearch(arr,num,low,mid-1);
					if(index==-1)
						index=mid;
				}
				else
					index=RecursiveSearch(arr,num,low,mid-1);
			}
			else
				index=RecursiveSearch(arr,num,mid+1,high);
			return index;	
		}
		return -1;
	}
	public static int IterativeSearch(int arr[],int num)
	{
		int low,high,index=-1;
		low=0;
		high=arr.length-1;
		while(low<=high)
		{
			int mid=(low+high)/2;
			if(arr[mid]>=num)
			{
				if(arr[mid]==num)
					index=mid;
				high=mid-1;
			}
			else
				low=mid+1;
		}
		return index;
	}
	public static boolean isPresent(int arr[],int num)
	{
		int low,high,index=-1;
		low=0;
		high=arr.length-1;
		while(low<=high)
		{
			int mid=(low+high)/2;
			if(arr[mid]>=num)
			{
				if(arr[mid]==num)
					return true;
				high=mid-1;
			}
			else
				low=mid+1;
		}
		return false;
	}
	private static int count(int arr[],int num,int low,int high)
	{
		if(low<=high)
		{
			int index=-1,mid=(high+low)/2;
			if(arr[mid]>=num)
			{
				if(arr[mid]==num)
					return 1+count(arr,num,low,mid-1)+count(arr,num,mid+1,high);
				else
					return 0+count(arr,num,low,mid-1);
			}
			else
				return 0+count(arr,num,mid+1,high);
		}
		return 0;
	}
	public static int occurence(int arr[],int num)
	{
		return count(arr,num,0,arr.length-1);
	}
	public static int pairsWithSum(int arr[],int sum)
	{
		int i,c=0;
		for(i=0;i<arr.length;++i)
		{
			int req=sum-arr[i];
			c+=count(arr,req,i+1,arr.length-1);
		}
		return c;
	}
	public static int findMissing(int arr[])
	{
		int l=0,r=arr.length-1,mid=0;
		while((r-l)>1)
		{
			mid=(l+r)/2;
			if(arr[l]-l!=arr[mid]-mid)
				r=mid;
			else if(arr[r]-r!=arr[mid]-mid)
				l=mid;
		}
		mid=(l+r)/2;
		return arr[mid]+1;
	}
	private static int RotationCount(int arr[],int l,int r)
	{
		if(r<l) 
			return 0;
		if(r==l) 
			return l; 
		int mid=(l+r)/2;
		if(mid<r&&arr[mid+1]<arr[mid])
			return (mid+1);
		if(mid>l&&arr[mid]<arr[mid-1])
			return mid;
		if (arr[r]>arr[mid]) 
			return RotationCount(arr,l,mid-1); 
		return RotationCount(arr,mid+1,r); 
	}
	public static int countRotations(int arr[])
	{
		return RotationCount(arr,0,arr.length-1);
	}
	public static int RotatedSearch(int arr[],int num,int low,int high)
	{
		if(low>high)
			return -1;
		int mid=(low+high)/2;
		if(arr[mid]==num)
			return mid;
		if(arr[low]<=arr[mid])
		{
			if(num>=arr[low]&&num<=arr[mid])
				return RotatedSearch(arr,num,low,mid-1);
			return RotatedSearch(arr,num,mid+1,high);
		}
		if(num>=arr[mid]&&num<=arr[high])
			return RotatedSearch(arr,num,mid+1,high);	
		return RotatedSearch(arr,num,low,mid-1);
	}
	public static int search(int arr[],int num)
	{
		if(countRotations(arr)==0)
		{
			return RecursiveSearch(arr,num,0,arr.length-1);
		}
		else
		{
			return RotatedSearch(arr,num,0,arr.length);
		}
	}
}