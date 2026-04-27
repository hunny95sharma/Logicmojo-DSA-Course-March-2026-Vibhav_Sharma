package binary_trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

	public static class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	};

	public Node connect(Node root) {
if(root ==null)
			return null;
		int level=0;
		Queue<Node>queue=new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int nodesCountAtLevel=queue.size();
			for(int i=0;i<nodesCountAtLevel;i++) {
				Node frontNode=queue.poll();
				if(i!=nodesCountAtLevel-1)
					frontNode.next=queue.peek();
				if(frontNode.left!=null)
					queue.add(frontNode.left);
				if(frontNode.right!=null)
					queue.add(frontNode.right);
			}
			level++;
		}
		return root;

	}

}