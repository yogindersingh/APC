import java.util.Scanner;
public class WordsInAString
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int i,flag=0,count=0;
		for(i=0;i<s.length();++i)
		{
			if(s.charAt(i)==' ')
			{
				if(flag==1)
					++count;
				flag=0;
			}
			else
			{
				flag=1;
			}
		}
		if(flag==1)
			++count;
		System.out.println("Number of words in string : "+count);
	}
}