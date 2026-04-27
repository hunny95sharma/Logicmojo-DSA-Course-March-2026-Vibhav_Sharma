package binary_trees;

public class DiameterOfBinaryTree {
	
	public static class Pair{
		int height;
		int diameter;
		
		Pair(int height,int diameter){
			this.height=height;
			this.diameter=diameter;
		}
	}
	
	public static Pair fetchDiameterOfBinaryTreeOptimized(BinaryTreeNode<Integer>root) {
		if(root==null)
			return new Pair(0,0);
		Pair left=fetchDiameterOfBinaryTreeOptimized(root.left);
		Pair right=fetchDiameterOfBinaryTreeOptimized(root.right);
		int op1=left.diameter;
		int op2=right.diameter;
		int op3=left.height+right.height;
		return new Pair(Math.max(left.height, right.height)+1,Math.max(op1, Math.max(op2, op3)));
	}
	
	public static int fetchDiameterOfBinaryTreeBruteForce(BinaryTreeNode<Integer>root) {
		if(root==null)
			return 0;
		int op1=fetchDiameterOfBinaryTreeBruteForce(root.left);
		int op2=fetchDiameterOfBinaryTreeBruteForce(root.right);
		int op3=fetchMaximumDepthOfBinaryTree(root.left)+fetchMaximumDepthOfBinaryTree(root.right);
		return Math.max(op1, Math.max(op2, op3));
	}
	
	public static int fetchMaximumDepthOfBinaryTree(BinaryTreeNode<Integer>root) {
		if(root==null)
			return 0;
		int maxDepthLeft=fetchMaximumDepthOfBinaryTree(root.left);
		int maxDepthRight=fetchMaximumDepthOfBinaryTree(root.right);
		return maxDepthLeft>maxDepthRight?maxDepthLeft+1:maxDepthRight+1;
	}
}