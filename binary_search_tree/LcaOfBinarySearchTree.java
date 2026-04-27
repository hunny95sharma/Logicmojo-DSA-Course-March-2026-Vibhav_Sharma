package binary_search_tree;

import binary_trees.BinaryTreeNode;

public class LcaOfBinarySearchTree {


	public BinaryTreeNode<Integer> lowestCommonAncestor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q) {
		if(root==null)
			return null;
		if(p.data<q.data)
			return lowestCommonAncestorHelper(root,p,q);
		else
			return lowestCommonAncestorHelper(root,q,p);
	}

	public BinaryTreeNode<Integer> lowestCommonAncestorHelper(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q) {
		if(root==null)
			return null;
		if(root.data==p.data||root.data==q.data)
			return root;

		if(root.data>p.data && root.data<q.data)
			return root;
		if(root.data>p.data && root.data>q.data)
			return lowestCommonAncestorHelper(root.left,p,q);
		if(root.data<p.data && root.data<q.data)
			return lowestCommonAncestorHelper(root.right,p,q);
		return null;
	}
}