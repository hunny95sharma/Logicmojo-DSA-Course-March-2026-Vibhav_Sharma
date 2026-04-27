package binary_search_tree;

import binary_trees.BinaryTreeNode;

public class checkBst {

	
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
	
}