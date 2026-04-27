package binary_trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
	
	public int fetchMinimumDepthOfBinaryTree(BinaryTreeNode<Integer>root) {
		if(root ==null)
			return 0;
		int level=0;
		Queue<BinaryTreeNode<Integer>>queue=new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()) {
               int nodesCountAtLevel=queue.size();
               for(int i=0;i<nodesCountAtLevel;i++) {
            	   BinaryTreeNode<Integer>frontNode=queue.poll();
            	   if(frontNode.left==null&&frontNode.right==null)
            		   return level;
                      		if(frontNode.left!=null)
           		queue.add(frontNode.left);
           		if(frontNode.right!=null)
           		queue.add(frontNode.right);
               }
               level++;
		}
		return level;
	}

}
