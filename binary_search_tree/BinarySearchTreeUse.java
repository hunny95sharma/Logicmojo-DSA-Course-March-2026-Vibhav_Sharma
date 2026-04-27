package binary_search_tree;

import binary_trees.BinaryTreeNode;

public class BinarySearchTreeUse {

	private BinaryTreeNode<Integer>root;


	public void insert(int data) {
		
		root=insertHelper(root,data);
	}

	private BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root, int data) {
		BinaryTreeNode<Integer>newNode=new BinaryTreeNode(data);
		if(root==null) {
			root=newNode;
			return root;
		}
		BinaryTreeNode<Integer>curr=root;
		while(true) {
			if(curr.data<=data) {
				if(curr.right!=null)curr=curr.right;
				else {
					curr.right=newNode;
					break;
				}

			}else {
				if(curr.left!=null)curr=curr.left;
				else {
					curr.left=newNode;	
					break;
				}
			}
		}
		return root;
	}

	public void remove(int data) {
		root=removeHelper(data,root);
	}

	private BinaryTreeNode<Integer> removeHelper(int data, BinaryTreeNode<Integer> root) {
		if(root==null)
			return null;
		if(root.data==data)
			return helper(root);
			BinaryTreeNode<Integer>temp=root;
			while(temp!=null) {
				if(temp.data>data) {
					if(temp.left!=null&&temp.left.data.equals(data)) {
						temp.left=helper(temp.left);
						break;
					}else
						temp=temp.left;
					
				}else {
					if(temp.right!=null&&temp.right.data.equals(data)) {
						temp.right=helper(temp.right);
						break;
					}else
						temp=temp.right;
				}
			}
			return root;
	}

	private BinaryTreeNode<Integer> helper(BinaryTreeNode<Integer> root) {
		if(root.left==null && root.right==null)
			return null;
		else if(root.left==null)
			return root.right;
		else if(root.right==null)
			return root.left;
		else {
			BinaryTreeNode<Integer>rootRight=root.right;
			BinaryTreeNode<Integer>lastRightChild=lastRight(root.left);
			lastRightChild.right=rootRight;
			return root.left;
		}
	}

	private BinaryTreeNode<Integer> lastRight(BinaryTreeNode<Integer> root) {
		if(root.right==null)
			return root;
		return lastRight(root.right);
	}
	
	public void print() { 
        printHelper(root);
    }

	private void printHelper(BinaryTreeNode<Integer>temp) {
		if(temp==null)
			return;
		System.out.print(temp.data+":");
		if(temp.left!=null)
			System.out.print("L:"+temp.left.data+",");
		if(temp.right!=null)
			System.out.print("R:"+temp.right.data);
		System.out.println();
		printHelper(temp.left);
		printHelper(temp.right);
		
	}

	public boolean search(int data) {
		return searchHelper(root,data);
	}

	private boolean searchHelper(BinaryTreeNode<Integer>root,int data) {

		if(root==null)
			return false;
		if(root.data.equals(data))
			return true;
		else if(root.data>data)
			return searchHelper(root.left,data);
		else
			return searchHelper(root.right,data);
	}
}