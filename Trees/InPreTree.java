import ds.*;
public class InPreTree
{
public static void main(String agrs[])
	{
		int in[]=new int[]{4,2,5,1,3};
		int pre[]=new int[]{1,2,3,4,5};
		int len=in.length;
		BinarySearchTree root=new BinarySearchTree();
    	root.buildTree(in,pre,0,len-1);
    	root.inOrder();
	}
}