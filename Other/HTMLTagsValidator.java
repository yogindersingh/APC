import ds.*;
import java.util.Scanner;
import java.io.*;
public class HTMLTagsValidator
{
	public static void main(String[] args) {
		try{
			int i,j,flag=0,line=0;
			LinkedStack stack=new LinkedStack();
			File f=new File("HtmlCase.txt");
			Scanner sc=new Scanner(f);
			while(sc.hasNext()&&flag==0)
			{
				++line;
				String s=sc.nextLine();
				i=s.indexOf('<');
				while(i!=-1)
				{
					String temp;
					j=s.indexOf('>',i);
					temp=s.substring(i,j+1);
					if(temp.charAt(1)=='/')
					{
						temp=temp.substring(0,1)+temp.substring(2);
						if(((String)stack.top()).compareTo(temp)!=0)
						{
							flag=1;
							break;
						}
						else
						{
							stack.pop();
						}
					}
					else
					{
						stack.push(temp);
					}
					i=s.indexOf('<',j);
				}
			}
			sc.close();
			if(flag==1)
				System.out.println("Error on line : "+line);
			else
				System.out.println("All tags are valid");
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}