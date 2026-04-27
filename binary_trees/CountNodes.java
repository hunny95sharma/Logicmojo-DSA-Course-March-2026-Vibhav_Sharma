package binary_trees;

public class CountNodes {
	
	public static int fetchCountNodes(BinaryTreeNode<Integer>root) {
		if(root==null)
			return 0;
		int ans=1;
		ans=ans+fetchCountNodes(root.left);
		ans=ans+fetchCountNodes(root.right);
		return ans;
	}

}
