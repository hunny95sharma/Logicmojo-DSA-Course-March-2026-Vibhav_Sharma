package binary_trees;

public class ConvertGivenTreeToItsSumTree {

	int toSumTree(BinaryTreeNode<Integer> root) {
		
		if(root==null)
			return 0;
		
		int left=toSumTree(root.left);
		int right=toSumTree(root.right);
		int temp=root.data;
		root.data=left+right;
		return temp+left+right;
	}
	
	
}