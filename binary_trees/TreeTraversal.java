package binary_trees;

public class TreeTraversal {
	
	public static void inorderTraversal(BinaryTreeNode<Integer>root) {
		if(root==null)
			return;
		inorderTraversal(root.left);
		System.out.println(root.data);
		inorderTraversal(root.right);
	}
	
	public static void preorderTraversal(BinaryTreeNode<Integer>root) {
		if(root==null)
			return;
		System.out.println(root.data);
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}
	
	public static void postorderTraversal(BinaryTreeNode<Integer>root) {
		if(root==null)
			return;
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.println(root.data);
	}

}