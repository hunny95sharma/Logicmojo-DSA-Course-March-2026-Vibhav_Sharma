package binary_trees;

public class SumOfNodesWithEvenValuedGrandparent {


	public int sumEvenGrandparent(BinaryTreeNode<Integer> root) {
		if(root==null)
			return 0;
		int sum=0;
		if(root.data%2==0) {
			if(root.left!=null) {
				if(root.left.left!=null)
					sum=sum+root.left.left.data;
				if(root.left.right!=null)
					sum=sum+root.left.right.data;
			}
			if(root.right!=null) {
				if(root.right.left!=null)
					sum=sum+root.right.left.data;
				if(root.right.right!=null)
					sum=sum+root.right.right.data;
			}
		}
		int left=sumEvenGrandparent(root.left);
		int right=sumEvenGrandparent(root.right);
		return sum+left+right;
	}

}