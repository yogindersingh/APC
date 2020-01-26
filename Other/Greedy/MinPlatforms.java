import java.util.*;
import java.io.*;
public class MinPlatforms
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t--!=0)
		{
			int i,j,max,count,n;
			n=sc.nextInt();
			sc.nextLine();
			String s1,s2;
			s1=sc.nextLine();
			s2=sc.nextLine();
			String str1[]=s1.split("[ ]+");
			String str2[]=s2.split("[ ]+");
			for(i=0;i<str1.length;++i)
			{
				if(str1[i].length()==3)
					str1[i]="0"+str1[i];
				else
				    break;
			}
			for(i=0;i<str2.length;++i)
			{
				if(str2[i].length()==3)
					str2[i]="0"+str2[i];
				else
				    break;
			}
			Arrays.sort(str1);
			Arrays.sort(str2);
			i=j=max=count=0;
			while(i<n&&j<n)
			{
				if(str1[i].compareTo(str2[j])<=0)
	            {
	                ++count;
	                ++i;
	            }
	            else if(str1[i].compareTo(str2[j])>0)
	            {
	                --count;
	                ++j;
	            }
	            if(count>max)
	                max=count;
			}
			System.out.println(max);
		}
	}
}