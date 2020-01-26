package ds;
public class SuffixArrays
{
	public static class Suffix
	{
		String str;
		int index;
	}
	Suffix[] suffix;
	SuffixArrays(String s)
	{
		suffix=new Suffix[s.length()];
		for(int i=0;i<s.length();++i)
		{
			suffix[i].str=s.substring(i);
			suffix[i].index=i;
		}
	}
}