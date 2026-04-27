package binary_trees;

public class SumOfNodes {
	
	public static int getSum(BinaryTreeNode<Integer> root) {
		if(root==null)
			return 0;
		int sum=root.data;
		sum=sum+getSum(root.left);
		sum=sum+getSum(root.right);
		return sum;
	}
}