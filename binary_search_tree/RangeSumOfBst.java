package binary_search_tree;

import binary_trees.BinaryTreeNode;

public class RangeSumOfBst {


	public int rangeSumBST(BinaryTreeNode<Integer> root, int low, int high) {

		if(root==null)
			return 0;

		return rangeSumBSTHelper(root,low,high,0);
	}

	private int rangeSumBSTHelper(BinaryTreeNode<Integer> root, int low, int high, int sum) {

		if(root==null)
			return sum;

		if(root.data>=low && root.data<=high) {
			sum=rangeSumBSTHelper(root.left,low,high,sum);
			sum=sum+root.data;
			sum=rangeSumBSTHelper(root.right,low,high,sum);
		}else if(root.data>low) {
			return rangeSumBSTHelper(root.left,low,high,sum);
		}else {
			return rangeSumBSTHelper(root.right,low,high,sum);
		} 

		return sum;
	}

}