package binary_trees;

public class BalancedTree {
	
	public static class Pair{
		
		int height;
		boolean isBalancedTree;
		Pair(int height,boolean isBalancedTree){
			this.height=height;
			this.isBalancedTree=isBalancedTree;
		}
	}
	
	public static boolean checkBalancedBruteForce(BinaryTreeNode<Integer> root) {
       if(root==null)
    	   return true;
       int leftHeight=fetchMaximumDepthOfBinaryTree(root.left);
       int rightHeight=fetchMaximumDepthOfBinaryTree(root.right);
       if(Math.abs(rightHeight-leftHeight)>1)
    	   return false;
       if(!checkBalancedBruteForce(root.left))
    	   return false;
       if(!checkBalancedBruteForce(root.right))
    	   return false;
       return true;
	}
	
	public static Pair checkBalancedOptimized(BinaryTreeNode<Integer> root) {
	       if(root==null)
	    	   return new Pair(0,true);
	       Pair left=checkBalancedOptimized(root.left);
	       Pair right=checkBalancedOptimized(root.right);
	       boolean isRootBalanced=Math.abs(left.height-right.height)<=1;
	       return new Pair(Math.max(left.height,right.height)+1,left.isBalancedTree&&right.isBalancedTree&&isRootBalanced);
		}
	
	public static int fetchMaximumDepthOfBinaryTree(BinaryTreeNode<Integer>root) {
		if(root==null)
			return 0;
		int maxDepthLeft=fetchMaximumDepthOfBinaryTree(root.left);
		int maxDepthRight=fetchMaximumDepthOfBinaryTree(root.right);
		return maxDepthLeft>maxDepthRight?maxDepthLeft+1:maxDepthRight+1;
	}

}