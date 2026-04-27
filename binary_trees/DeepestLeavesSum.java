package binary_trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class DeepestLeavesSum {


	public int deepestLeavesSumBfs1(BinaryTreeNode<Integer> root) {

		if(root==null)
			return 0;
		int heightOfTree=height(root);
		int level=1;
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
			if(level==heightOfTree)
				break;
		}
		int sum=0;
		while(!queue.isEmpty()) {
			BinaryTreeNode<Integer>frontNode=queue.poll();
			sum=sum+frontNode.data;
		}
		return sum;
	}

	public int height(BinaryTreeNode<Integer> root) {
		if(root==null)
			return 0;
		return 1+Math.max(height(root.left), height(root.right));
	}

	public int deepestLeavesSumBfs2(BinaryTreeNode<Integer> root) {

		if(root==null)
			return 0;
		int level=1;
		int sum=0;
		Queue<BinaryTreeNode<Integer>>queue=new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			sum=0;
			int nodesCountAtLevel=queue.size();
			for(int i=0;i<nodesCountAtLevel;i++) {
				BinaryTreeNode<Integer>frontNode=queue.poll();
				sum=sum+frontNode.data;
				if(frontNode.left!=null)
					queue.add(frontNode.left);
				if(frontNode.right!=null)
					queue.add(frontNode.right);
			}
			level++;
		}
		return sum;
	}

	public int deepestLeavesSumDfs1(BinaryTreeNode<Integer> root) {

		if(root==null)
			return 0;
		int heightOfTree=height(root);

		return deepestLeavesSumDfs1Helper(root,1,heightOfTree);
	}

	private int deepestLeavesSumDfs1Helper(BinaryTreeNode<Integer> root, int level, int heightOfTree) {

		if(root==null)
			return 0;

		if(level==heightOfTree)
			return root.data;

		int left=deepestLeavesSumDfs1Helper(root.left,level+1,heightOfTree);
		int right=deepestLeavesSumDfs1Helper(root.right,level+1,heightOfTree);
		return left+right;

	}

	int maxSum=0;
	int maxDepth=0;
	public int deepestLeavesSumDfs2(BinaryTreeNode<Integer> root) {
		maxSum=0;
		maxDepth=0;
		if(root==null)
			return 0;
		deepestLeavesSumDfs2Helper(root,1);
		return maxSum;
	}

	private void deepestLeavesSumDfs2Helper(BinaryTreeNode<Integer> root, int level) {
		if(root==null)
			return; 

		if(level>maxDepth) {
			maxDepth=level;
			maxSum=root.data;
		}else if(level==maxDepth) {
			maxSum=maxSum+root.data;
		}
		deepestLeavesSumDfs2Helper(root.left,level+1);
		deepestLeavesSumDfs2Helper(root.right,level+1);
	}
}