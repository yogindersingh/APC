import ds.*;
public class BST
{
	public static void main(String agrs[])
	{
		BinarySearchTree root=new BinarySearchTree();
		root.insert(4);
		root.insert(3);
		root.insert(1);
		root.insert(2);
		root.insert(9);
		root.insert(6);
		root.insert(5);
		root.insert(7);
		root.insert(8);
		System.out.println("Inorder:-");
		root.inOrder();
		System.out.println("Height :-");
		System.out.println(root.height());
		System.out.println("Paths:-");
		root.printPaths();
        System.out.println("Level Order");
		root.printLevelOrder();
		System.out.println("Reverse Level Order");
		root.printRevLevelOrder();
		System.out.println("mirror");
		root.mirror();
		root.inOrder();
		root.mirror();
		System.out.println("Tree is BST :- "+root.isBST());
		System.out.println("Diameter = "+root.diameter());
		System.out.println("Vertical Order :- ");
		root.verticalOrder();
		System.out.println("After Deleting 5");
		root.deleteKey(5);
		root.inOrder();
		System.out.println("lsa of 3&9 is"+root.lca(3,9));
		root.delete();
	}
}