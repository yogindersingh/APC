import ds.*;
import java.util.Scanner;
public class BracketValidation
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t;
		t=sc.nextInt();
		sc.nextLine();
		while(t--!=0)
		{
			int i,flag=0;
			String s;
			s=sc.nextLine();
			ArrayStack a=new ArrayStack();
			for(i=0;i<s.length()&&flag==0;++i)
			{
				if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')
					a.push(s.charAt(i));
				else if(s.charAt(i)==')')
				{
					if(!a.isEmpty()&&(char)a.top()=='(')
						a.pop();
					else
						flag=1;
				}
				else if(s.charAt(i)=='}')
				{
					if(!a.isEmpty()&&(char)a.top()=='{')
						a.pop();
					else
						flag=1;	
				}
				else if(s.charAt(i)==']')
				{
					if(!a.isEmpty()&&(char)a.top()=='[')
						a.pop();
					else
						flag=1;				
				}
			}
			if(flag==1||a.size()!=0)
				System.out.println("Not Balanced");
			else
				System.out.println("Balanced");
		}
	}
}