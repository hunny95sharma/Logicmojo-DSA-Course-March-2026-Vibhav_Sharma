package binary_search_tree;

import java.util.ArrayList;

import binary_trees.BinaryTreeNode;

public class MinimumDifferenceBetweenAnyTwoNodes {


	int minDiff=Integer.MAX_VALUE;

	public int getMinimumDifference(BinaryTreeNode<Integer> root) {

		minDiff=Integer.MAX_VALUE;
		inorder(root,null);
		return minDiff;
	}


	private BinaryTreeNode<Integer> inorder(BinaryTreeNode<Integer> root,BinaryTreeNode<Integer>prev) {

		if(root==null)
			return prev;
		prev=inorder(root.left,prev);
		if(prev!=null)
			minDiff=Math.min(minDiff, Math.abs(prev.data-root.data));
		prev=root;
		prev=inorder(root.right,prev);
		return prev;
	}


	public int getMinimumDifferenceBruteForce(BinaryTreeNode<Integer> root) {

		if(root==null)
			return 0;

		ArrayList<Integer>inOrder=new ArrayList<>();
		inorderBruteForce(root,inOrder);
		int min=Integer.MAX_VALUE;
		int i=1;
		for(;i<inOrder.size();i++) {
			int absValue=Math.abs(inOrder.get(i)-inOrder.get(i-1));
			if(absValue<min)
				min=absValue;

		}
		return min;
	}





	private static void inorderBruteForce(BinaryTreeNode<Integer> root, ArrayList<Integer> inOrder) {

		if(root==null)
			return;
		inorder(root.left,inOrder);
		inOrder.add(root.data);
		inorder(root.right,inOrder);
	}


}