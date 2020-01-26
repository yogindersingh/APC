import java.util.Scanner;
import java.util.Arrays;
class PermutationsOfString 
{
    static void gen(String s,int index)
    {
        if(s.length()==index)
        {
            System.out.print(s+" ");
        }
        else
        {
            int i;
            for(i=index;i<s.length();++i)
            {
                String str=s;
                if(i!=index)
                {
                    str=s.substring(0,index)+s.charAt(i)+s.substring(index,i)+s.substring(i+1);
                }
                gen(str,index+1);
            }
        }
    }
	public static void main (String[] args) 
	{
	    Scanner sc=new Scanner(System.in);
	    int t;
	    t=sc.nextInt();
	    sc.nextLine();
	    while(t--!=0)
	    {
	        String s;
	        s=sc.nextLine();
	        char arr[]=s.toCharArray();
	        Arrays.sort(arr);
	        s=String.valueOf(arr);
	        gen(s,0);
	        System.out.println();
	    }
	}
}