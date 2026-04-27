package binary_trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeftViewAndRightView {

	public static List<Integer> printLeftView(BinaryTreeNode<Integer>root) {

		
	List<Integer>res=new ArrayList<>();
		
		
		if(root ==null)
			return res;
		int level=0;
		Queue<BinaryTreeNode<Integer>>queue=new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int nodesCountAtLevel=queue.size();
			for(int i=0;i<nodesCountAtLevel;i++) {
				BinaryTreeNode<Integer>frontNode=queue.poll();
				if(i==0)
					res.add(frontNode.data);
				if(frontNode.left!=null)
					queue.add(frontNode.left);
				if(frontNode.right!=null)
					queue.add(frontNode.right);
			}
			level++;
		}
		return res;
		
	}
	
	public static List<Integer> printRightView(BinaryTreeNode<Integer>root) {

		
		List<Integer>res=new ArrayList<>();
			
			
			if(root ==null)
				return res;
			int level=0;
			Queue<BinaryTreeNode<Integer>>queue=new ArrayDeque<>();
			queue.add(root);
			while(!queue.isEmpty()) {
				int nodesCountAtLevel=queue.size();
				for(int i=0;i<nodesCountAtLevel;i++) {
					BinaryTreeNode<Integer>frontNode=queue.poll();
					if(i==nodesCountAtLevel-1)
						res.add(frontNode.data);
					if(frontNode.left!=null)
						queue.add(frontNode.left);
					if(frontNode.right!=null)
						queue.add(frontNode.right);
				}
				level++;
			}
			return res;
			
		}

}