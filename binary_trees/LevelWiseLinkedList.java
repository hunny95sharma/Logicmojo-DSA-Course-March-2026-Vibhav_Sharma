package binary_trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LevelWiseLinkedList {
	public static class LinkedListNode<T> 
	{ 
		T data; 
		LinkedListNode<T> next;
		public LinkedListNode(T data) 	
		{
			this.data = data; 
		} 
	}
	
	public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
		ArrayList<LinkedListNode<Integer>>res=new ArrayList<>();
		if(root ==null)
			return res;
		int level=0;
		Queue<BinaryTreeNode<Integer>>queue=new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()) {
               int nodesCountAtLevel=queue.size();
               LinkedListNode<Integer>head=null;
               LinkedListNode<Integer>tail=null;
               for(int i=0;i<nodesCountAtLevel;i++) {
            	   BinaryTreeNode<Integer>frontNode=queue.poll();
            	   LinkedListNode<Integer>curr=new LinkedListNode<>(frontNode.data);
            	   if(head==null) {
            		   head=curr;
            		   tail=curr;
            	   }else {
            		   tail.next=curr;
            		   tail=tail.next;
            	   }
           		if(frontNode.left!=null)
           		queue.add(frontNode.left);
           		if(frontNode.right!=null)
           		queue.add(frontNode.right);
               }
               level++;
               res.add(head);
		}
		return res;
	}

}