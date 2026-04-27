package binary_trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
	
	public int fetchMaximumDepthOfBinaryTree(BinaryTreeNode<Integer>root) {
		if(root==null)
			return 0;
		int maxDepthLeft=fetchMaximumDepthOfBinaryTree(root.left);
		int maxDepthRight=fetchMaximumDepthOfBinaryTree(root.right);
		return maxDepthLeft>maxDepthRight?maxDepthLeft+1:maxDepthRight+1;
	}
	
	public int fetchMaximumDepthOfBinaryTreeLevelTraversal(BinaryTreeNode<Integer>root) {
		if(root ==null)
			return 0;
		int level=0;
		Queue<BinaryTreeNode<Integer>>queue=new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()) {
               int nodesCountAtLevel=queue.size();
               for(int i=0;i<nodesCountAtLevel;i++) {
            	   BinaryTreeNode<Integer>frontNode=queue.poll();
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