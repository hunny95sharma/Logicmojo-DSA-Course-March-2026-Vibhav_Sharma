package binary_trees;

public class IsNodePresent {
	
	public static boolean fetchIsNodePresent(BinaryTreeNode<Integer>root,int k) {
		if(root==null)
			return false;
		if(root.data==k)
			return true;
		if(fetchIsNodePresent(root.left,k))
			return true;
		if(fetchIsNodePresent(root.right,k))
			return true;
		return false;
	}
}