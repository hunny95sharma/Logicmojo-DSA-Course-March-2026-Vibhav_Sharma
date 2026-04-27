package binary_trees;

public class LCABinaryTree {

	
	static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {

		if(root==null)
			return -1;
		if(root.data==a || root.data==b)
			return root.data;
		int left=getLCA(root.left,a,b);
		int right=getLCA(root.right,a,b);
		if(right!=-1 && left !=-1)
			return root.data;
		if(left==-1)
			return right;
		if(right==-1)
			return left;
		return -1;
		
	}
	
}