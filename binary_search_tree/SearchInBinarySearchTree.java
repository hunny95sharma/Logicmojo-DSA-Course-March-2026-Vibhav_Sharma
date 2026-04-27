package binary_search_tree;

import binary_trees.BinaryTreeNode;

public class SearchInBinarySearchTree {

	public static boolean searchInBSTRecursive(BinaryTreeNode<Integer> root, int k) {
		if(root==null)
			return false;
		if(root.data.equals(k))
			return true;
		else if(root.data>k) {
			return searchInBSTRecursive(root.left,k);
		}else {
			return searchInBSTRecursive(root.right,k);
		}
	}
	
	public static boolean searchInBSTIterative(BinaryTreeNode<Integer> root, int k) {
		if(root==null)
			return false;
		BinaryTreeNode<Integer>temp=root;
		while(temp!=null) {
			if(temp.data==k)
				return true;
			else if(temp.data>k) {
				temp=temp.left;
			}else {
				temp=temp.right;
			}
		}
		return false;
	}
}