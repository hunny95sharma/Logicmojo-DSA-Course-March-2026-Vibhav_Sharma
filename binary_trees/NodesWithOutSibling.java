package binary_trees;

public class NodesWithOutSibling {

	public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
		if(root==null)
			return;
		if(root.left==null && root.right!=null)
		{
			System.out.println(root.right.data+" ");
		}
		if(root.right==null && root.left!=null)
		{
			System.out.println(root.left.data+" ");
		}
		printNodesWithoutSibling(root.left);
		printNodesWithoutSibling(root.right);
	}
	
}