package binary_search_tree;

import java.util.ArrayList;

import binary_trees.BinaryTreeNode;

public class InorderSuccessorAndPredecessor {
	
	
	
	
public static void printInorderPredecessorAndSucessorApproachOptimal(BinaryTreeNode<Integer>root,BinaryTreeNode<Integer>node) {
		
		if(root==null || node==null)
			return ;
		BinaryTreeNode<Integer>predecessor=null;
		BinaryTreeNode<Integer>successor=null;
		BinaryTreeNode<Integer>temp=root;
		while(temp!=null) {
			
			if(temp.data==node.data)
			break;
			else if(temp.data>node.data) {
				successor=temp;
				temp=temp.left;
			}
			else {
				predecessor=temp;
				temp=temp.right;
			}
			
		}
		BinaryTreeNode<Integer>leftTree=null;
		
		BinaryTreeNode<Integer>rightTree=null;
		if(temp!=null) {
			leftTree=temp.left;
			rightTree=temp.right;
		}
			
		while(leftTree!=null) {
			predecessor=leftTree;
			leftTree=leftTree.right;
		}
		
		while(rightTree!=null) {
			successor=rightTree;
			rightTree=rightTree.left;
		}
		System.out.println("predecessor"+predecessor.data);
		System.out.println("sucessor"+successor.data);
	}
	
	
	public static void printInorderPredecessorAndSucessorApproachBruteForce(BinaryTreeNode<Integer>root,BinaryTreeNode<Integer>node) {
		
		if(root==null || node==null)
			return ;
		
		ArrayList<Integer>inOrder=new ArrayList<>();
		inorder(root,inOrder);
		int i=0;
		for(;i<inOrder.size();i++) {
			if(inOrder.get(i).equals(node.data))
				break;
		}
		if((i-1)>=0)
		System.out.println("predecessor"+inOrder.get(i-1));
		if((i+1)<inOrder.size())
		System.out.println("sucessor"+inOrder.get(i+1));
	}

	private static void inorder(BinaryTreeNode<Integer> root, ArrayList<Integer> inOrder) {
		
		if(root==null)
			return;
		inorder(root.left,inOrder);
		inOrder.add(root.data);
		inorder(root.right,inOrder);
	}
	
	

}