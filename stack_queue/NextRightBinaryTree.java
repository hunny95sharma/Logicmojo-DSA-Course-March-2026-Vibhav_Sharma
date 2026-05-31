package stack_queue;

import java.util.LinkedList;
import java.util.Queue;



public class NextRightBinaryTree {

	class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}


	public Node nextRight(Node head,int k) {

		if(head==null)
			return head;
		Node res=null;
		Queue<Node>q=new LinkedList<>();
		q.add(head);
		while(!q.isEmpty()) {
			int n=q.size();
			for(int i=0;i<n;i++) {
				Node temp=q.peek();
				q.remove();
				if(temp.data==k)
				{
					if(i!=n-1)
						return q.peek();
					else
						return null;
				}
				if(temp.left!=null)
					q.add(temp.left);

				if(temp.right!=null)
					q.add(temp.right);
			}
		}
		return null;
	}

}