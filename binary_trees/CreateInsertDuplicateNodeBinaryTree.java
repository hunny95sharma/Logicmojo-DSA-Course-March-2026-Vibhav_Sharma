package binary_trees;

public class CreateInsertDuplicateNodeBinaryTree {

	
	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		if(root==null)
			return;
		BinaryTreeNode<Integer>newNode=new BinaryTreeNode<>(root.data);
		BinaryTreeNode<Integer>temp=root.left;
		root.left=newNode;
		newNode.left=temp;
		insertDuplicateNode(temp);
		insertDuplicateNode(root.right);
	}
}