package binary_search_tree;

import binary_trees.BinaryTreeNode;

public class LargestBst {

	public static class Info{

		boolean isBst;
		int max;
		int min;
		int height;
		public Info(boolean isBst, int max, int min, int height) {
			this.isBst = isBst;
			this.max = max;
			this.min = min;
			this.height = height;
		}	
	}



	public static Info largestBSTSubtreeHelper(BinaryTreeNode<Integer> root,int arr[]) {

		if(root==null)
			return new Info(true,Integer.MIN_VALUE,Integer.MAX_VALUE,0);	

		Info left=largestBSTSubtreeHelper(root.left,arr);
		Info right=largestBSTSubtreeHelper(root.right,arr);

		int height=Math.max(left.height, right.height)+1;
		int max=Math.max(root.data, right.max);
		int min=Math.min(root.data, left.min);
		boolean isBst=false;
		if(root.data>left.max&&root.data<right.min)
			isBst=true;
		isBst=isBst&&left.isBst&&right.isBst;
		if(isBst) {
			arr[0]=Math.max(height, arr[0]);
		}
		return new Info(isBst,max,min,height);
	}


	public static int largestBSTSubtreeBruteForce(BinaryTreeNode<Integer> root) {

		if(root==null)
			return 0;
		int height=0;

		boolean isRootBst=isBST(root);
		if(isRootBst) 
			height= fetchMaximumDepthOfBinaryTree(root);
		int leftMaxBstHeight=largestBSTSubtreeBruteForce(root.left);
		int rightMaxBstHeight=largestBSTSubtreeBruteForce(root.right);
		return Math.max(height,Math.max(leftMaxBstHeight, rightMaxBstHeight));
	}

	public static boolean isBST(BinaryTreeNode<Integer> root) {

		return isBstHelper(root,Long.MIN_VALUE,Long.MAX_VALUE);
	}

	public static boolean isBstHelper(BinaryTreeNode<Integer> root,long minVal,long maxVal) {
		if(root==null)
			return true;
		if(root.data>=maxVal||root.data<=minVal)
			return false;
		return isBstHelper(root.left,minVal,root.data) && isBstHelper(root.right,root.data,maxVal);
	}

	public static int fetchMaximumDepthOfBinaryTree(BinaryTreeNode<Integer>root) {
		if(root==null)
			return 0;
		int maxDepthLeft=fetchMaximumDepthOfBinaryTree(root.left);
		int maxDepthRight=fetchMaximumDepthOfBinaryTree(root.right);
		return maxDepthLeft>maxDepthRight?maxDepthLeft+1:maxDepthRight+1;
	}

}