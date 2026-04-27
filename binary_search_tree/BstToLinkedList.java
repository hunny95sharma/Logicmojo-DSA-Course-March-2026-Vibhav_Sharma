package binary_search_tree;

import java.util.ArrayList;
import java.util.List;

import binary_trees.BinaryTreeNode;

public class BstToLinkedList {


	public static class LinkedListNode<T> { T data; LinkedListNode<T> next;

	public LinkedListNode(T data) { this.data = data; } }


	public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {

		if(root==null)
			return null;
		List<Integer>res=new ArrayList<>();
		fetchInorder(root,res);

		LinkedListNode<Integer>head=null;
		LinkedListNode<Integer>tail=null;

		for(int i=0;i<res.size();i++) {
			LinkedListNode<Integer>newNode=new LinkedListNode<>(res.get(i));
			if(head==null) {
				head=newNode;
				tail=newNode;
			}else {
				tail.next=newNode;
				tail=tail.next;
			}
		}
		return head;		
	}


	private static void fetchInorder(BinaryTreeNode<Integer> root,List<Integer>res) {    
		if(root==null)
			return;
		fetchInorder(root.left,res);
		res.add(root.data);
		fetchInorder(root.right,res);
	}
	
	public static BinaryTreeNode<Integer> constructLinkedList2(BinaryTreeNode<Integer> root) {

		if(root==null)
			return null;
		List<Integer>res=new ArrayList<>();
		fetchInorder(root,res);

		BinaryTreeNode<Integer>newRoot=new BinaryTreeNode<>(res.get(0));
		BinaryTreeNode<Integer>curr=newRoot;
		for(int i=1;i<res.size();i++) {
			BinaryTreeNode<Integer> newNode=new BinaryTreeNode<>(res.get(1));
			curr.left=null;
			curr.right=newNode;
			curr=newNode;
		}
		curr.left=null;
		curr.right=null;
		return newRoot;		
	}	
	
}