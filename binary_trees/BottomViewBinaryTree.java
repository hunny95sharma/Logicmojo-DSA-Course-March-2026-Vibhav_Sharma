package binary_trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.TreeMap;


public class BottomViewBinaryTree {

	public static class Vertical<T>{
		BinaryTreeNode<T> node;
		T col;
		public Vertical(BinaryTreeNode<T>node,T col) {
			this.node=node;
			this.col=col;
		}
	}

	public static ArrayList<Integer>bottomView(BinaryTreeNode<Integer>root){
		ArrayList<Integer>result=new ArrayList<>();
		if(root==null)
			return result;
		TreeMap<Integer,Integer>res=new TreeMap<>();
		Queue<Vertical<Integer>>queue=new ArrayDeque<>();
		queue.add(new Vertical<Integer>(root,0));
		int level=0;
		while(!queue.isEmpty()) {
			int nodesCountAtLevel=queue.size();
			for(int i=0;i<nodesCountAtLevel;i++) {
				Vertical<Integer>frontNode=queue.poll();
				BinaryTreeNode<Integer>node=frontNode.node;
				int y=frontNode.col;
					res.put(y, node.data);
				if(node.left!=null) {
					queue.add(new Vertical<Integer>(node.left,y-1));
				}
				if(node.right!=null) {
					queue.add(new Vertical<Integer>(node.right,y+1));
				}
			}
			level++;
		}
		
		for(Integer temp:res.values()) {
			result.add(temp);
		}
		return result;
	}
	
}