package generic_trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class ReplaceNodeWithDepth {

	public static void fetchReplaceNodeWithDepth(TreeNode<Integer>root) {
		if(root==null)
			return;
		Queue<TreeNode<Integer>>queue=new ArrayDeque<>();
		int level=0;
		queue.add(root);
		while(!queue.isEmpty()) {
			int nodesCountAtLevel=queue.size();
			for(int i=0;i<nodesCountAtLevel;i++) {
				TreeNode<Integer> frontNode=queue.poll();
				frontNode.data=level;
				int childCount=frontNode.children.size();
				for(int j=0;j<childCount;j++) {
					TreeNode<Integer>childNode=frontNode.children.get(j);
					queue.add(childNode);
				}
			}
			level++;
		}
	}
}