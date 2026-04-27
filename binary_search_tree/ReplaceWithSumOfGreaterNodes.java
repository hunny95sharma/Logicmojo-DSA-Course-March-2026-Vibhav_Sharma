package binary_search_tree;

import binary_trees.BinaryTreeNode;

public class ReplaceWithSumOfGreaterNodes {
	
	public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
		if(root==null)
			return;
		replaceWithLargerNodesSumHelper(root,0);
	}

	private static int replaceWithLargerNodesSumHelper(BinaryTreeNode<Integer> root,int sum) {
		if(root==null)
			return sum;
		sum=replaceWithLargerNodesSumHelper(root.right,sum);
	     sum=sum+root.data;
		root.data=sum;
		sum=replaceWithLargerNodesSumHelper(root.left,sum);
		return sum;
	}

}