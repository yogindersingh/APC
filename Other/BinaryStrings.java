import java.util.Scanner;
public class BinaryStrings
{
	public static void generate(char arr[],int index,int n)
	{
		if(index==n)
		{
			System.out.println(arr);
		}
		else
		{
			char i;
			for(i='0';i<='1';++i)
			{
				arr[index]=i;
				generate(arr,index+1,n);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n;
		System.out.print("Enter the length of binary string required : ");
		n=sc.nextInt();
		char arr[]=new char[n+1];
		generate(arr,0,n);
	}
}