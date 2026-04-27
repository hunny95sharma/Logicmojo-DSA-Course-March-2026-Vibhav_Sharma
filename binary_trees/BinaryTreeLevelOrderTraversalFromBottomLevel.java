package binary_trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalFromBottomLevel {

	public List<List<Integer>> levelOrderBottom(BinaryTreeNode<Integer> root) {

		List<List<Integer>>result=new ArrayList<>();
		
		if(root ==null)
			return result;
		int level=0;
		Queue<BinaryTreeNode<Integer>>queue=new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int nodesCountAtLevel=queue.size();
			List<Integer>temp=new ArrayList<>();
			for(int i=0;i<nodesCountAtLevel;i++) {
				BinaryTreeNode<Integer>frontNode=queue.poll();
				temp.add(frontNode.data);
				if(frontNode.left!=null)
					queue.add(frontNode.left);
				if(frontNode.right!=null)
					queue.add(frontNode.right);
			}
			result.add(temp);
			level++;
		}
		return result.reversed();

	}


}