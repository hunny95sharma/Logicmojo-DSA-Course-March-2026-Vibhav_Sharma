package binary_trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class ZigZagTree {

	public List<List<Integer>> zigzagLevelOrder(BinaryTreeNode<Integer> root) {
	       List<List<Integer>>res=new ArrayList<>();
			if(root ==null)
				return res;
			int level=0;
			boolean isLeftToRight=true;
			Queue<BinaryTreeNode<Integer>>queue=new ArrayDeque<>();
			queue.add(root);
			while(!queue.isEmpty()) {
				int nodesCountAtLevel=queue.size();
				List<Integer>temp=new ArrayList<>(nodesCountAtLevel);
				for(int i=0;i<nodesCountAtLevel;i++) {
					BinaryTreeNode<Integer> frontNode=queue.poll();
					temp.add(frontNode.data);
					if(frontNode.left!=null)
						queue.add(frontNode.left);
					if(frontNode.right!=null)
						queue.add(frontNode.right);
				}
				if(isLeftToRight)
					res.add(temp);
				else {
					Collections.reverse(temp);
					res.add(temp);
				}
	            isLeftToRight=!isLeftToRight;
				level++;
			}
	        return res;
	    }
}