package binary_trees;

public class PathSumRootToLeaf {


	public boolean hasPathSum(BinaryTreeNode<Integer> root, int targetSum) {
		if(root==null)
			return false;
		return hasPathSum(root,targetSum,0);
	}

	private boolean hasPathSum(BinaryTreeNode<Integer> root, int targetSum, int currSum) {
		
		if(root==null)
			return false;
		currSum=currSum+root.data;
		if(root.right==null && root.left==null && currSum==targetSum)
			return true;
			return hasPathSum(root.left,targetSum,currSum) || hasPathSum(root.right,targetSum,currSum);
		
	}

}