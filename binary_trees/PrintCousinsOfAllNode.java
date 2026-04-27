package binary_trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class PrintCousinsOfAllNode {

	static void printCousins(BinaryTreeNode<Integer> root,BinaryTreeNode<Integer> node_to_find) {

		if(root==null)
		{
			System.out.println("no cousins");
			return;
		}

		if(root==node_to_find) {
			System.out.println("no cousins");
			return;
		}
		int level=0;
		Queue<BinaryTreeNode<Integer>>queue=new ArrayDeque<>();
		queue.add(root);
		boolean isFound=false;
		while(!queue.isEmpty() && !isFound) {
			int nodesCountAtLevel=queue.size();
			for(int i=0;i<nodesCountAtLevel;i++) {
				BinaryTreeNode<Integer>frontNode=queue.poll();
				if(frontNode.left==node_to_find || frontNode.right==node_to_find)
					isFound=true;
				else
				{
					if(frontNode.left!=null) {
						queue.add(frontNode.left);
					}
					if(frontNode.right!=null) {
						queue.add(frontNode.right);
					}
				}
			}
			level++;
		}
		if(isFound) {
			while(!queue.isEmpty()) {
				BinaryTreeNode<Integer>frontNode=queue.poll();
				System.out.println(frontNode.data);
			}
		}

	}

}