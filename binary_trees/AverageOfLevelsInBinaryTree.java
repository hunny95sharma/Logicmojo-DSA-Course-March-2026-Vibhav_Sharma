package binary_trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

	public List<Double> averageOfLevels(BinaryTreeNode<Integer> root) {

		List<Double>res=new ArrayList<>();
		
		
		if(root ==null)
			return res;
		int level=0;
		Queue<BinaryTreeNode<Integer>>queue=new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int nodesCountAtLevel=queue.size();
			double sum=0;
			for(int i=0;i<nodesCountAtLevel;i++) {
				BinaryTreeNode<Integer>frontNode=queue.poll();
				sum=sum+frontNode.data;
				if(frontNode.left!=null)
					queue.add(frontNode.left);
				if(frontNode.right!=null)
					queue.add(frontNode.right);
			}
			double average=(double) sum/nodesCountAtLevel;
			res.add(average);
			level++;
		}
		return res;
	}

}