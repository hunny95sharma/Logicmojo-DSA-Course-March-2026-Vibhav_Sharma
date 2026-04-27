package binary_trees;

public class MirrorBinaryTree {

	public static BinaryTreeNode<Integer> fetchMirrorBinaryTree(BinaryTreeNode<Integer>root){
		if(root==null)
			return root;
		BinaryTreeNode<Integer>temp=root.right;
		root.right=fetchMirrorBinaryTree(root.left);
		root.left=fetchMirrorBinaryTree(temp);
		return root;
	}

}
