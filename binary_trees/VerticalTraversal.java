package binary_trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalTraversal {


	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static class Vertical {
		TreeNode node;
		int row;
		int col;
		public Vertical(TreeNode node,int row,int col) {
			this.node=node;
			this.row=row;
			this.col=col;
		}
	}

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>>result=new ArrayList<>();
		if(root==null)
			return result;
		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
		Queue<Vertical>queue=new ArrayDeque<>();
		queue.add(new Vertical(root,0,0));
		while(!queue.isEmpty()) {
			int nodesCountAtLevel=queue.size();
			for(int i=0;i<nodesCountAtLevel;i++) {
				Vertical frontNode=queue.poll();
				TreeNode node=frontNode.node;
				int level=frontNode.row;
				int hd=frontNode.col;
				if(!map.containsKey(hd))
					map.put(hd, new TreeMap<Integer,PriorityQueue<Integer>>());
				if(!map.get(hd).containsKey(level))
					map.get(hd).put(level, new PriorityQueue<Integer>());
				map.get(hd).get(level).add(node.val);
				if(node.left!=null) {
					queue.add(new Vertical(node.left,level+1,hd-1));
				}
				if(node.right!=null) {
					queue.add(new Vertical(node.right,level+1,hd+1));
				}
				
			}
		}
		
		for(TreeMap<Integer,PriorityQueue<Integer>> res:map.values()) {
			List<Integer> column = new ArrayList<>();
			for(PriorityQueue<Integer>pq:res.values())
			{
				while (!pq.isEmpty()) {
                    column.add(pq.poll());
                }
				
			}
			result.add(column);
		}
		return result;
	}

}