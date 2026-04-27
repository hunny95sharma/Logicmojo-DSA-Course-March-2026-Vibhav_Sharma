package binary_trees;

public class MaxPathSum {
	

	int maxi=Integer.MIN_VALUE;
	public int maxPathSum(BinaryTreeNode<Integer> root) {
        maxi=Integer.MIN_VALUE;
        helper(root);
		return maxi;
	}
	private int helper(BinaryTreeNode<Integer> root) {
		
		if(root==null)
		return Integer.MIN_VALUE;
		int left=Math.max(0, helper(root.left));
		int right=Math.max(0, helper(root.right));
		maxi=Math.max(maxi, left+right+root.data);
		return root.data+Math.max(left, right);
	}
}