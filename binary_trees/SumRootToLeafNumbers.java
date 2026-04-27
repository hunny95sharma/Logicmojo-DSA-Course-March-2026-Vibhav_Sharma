package binary_trees;

public class SumRootToLeafNumbers {

	public int sumNumbers(BinaryTreeNode<Integer> root) {
		if(root==null)
			return 0;
		return sumNumbersHelper(root,0);
	}

	private int sumNumbersHelper(BinaryTreeNode<Integer> root, int val) {
		if(root==null)
			return 0;
		val=root.data+val*10;
		if(root.left==null && root.right==null)
			return val;
		int l=sumNumbersHelper(root.left,val);
		int r=sumNumbersHelper(root.right,val);
			return l+r;
	}
}