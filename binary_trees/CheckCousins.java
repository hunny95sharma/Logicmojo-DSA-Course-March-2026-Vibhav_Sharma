package binary_trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class CheckCousins {

	public static boolean isCousin1(BinaryTreeNode<Integer> root, int p, int q) {

		if(root ==null)
			return false;
		int level=0;
		Queue<BinaryTreeNode<Integer>>queue=new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int nodesCountAtLevel=queue.size();
			boolean isPnodePresent=false;
			boolean isQnodePresent=false;
			for(int i=0;i<nodesCountAtLevel;i++) {
				BinaryTreeNode<Integer>frontNode=queue.poll();

				if(frontNode.left !=null && frontNode.right!=null&&(frontNode.left.data.equals(p)||frontNode.right.data.equals(p))&&(frontNode.left.data.equals(q)||frontNode.right.data.equals(q)))
					return false;

				if(frontNode.left!=null) {
					if(frontNode.left.data.equals(p))
						isPnodePresent=true;
					if(frontNode.left.data.equals(q))
						isQnodePresent=true;
					queue.add(frontNode.left);
				}
				if(frontNode.right!=null) {
					if(frontNode.right.data.equals(p))
						isPnodePresent=true;
					if(frontNode.right.data.equals(q))
						isQnodePresent=true;
					queue.add(frontNode.right);
				}
				if(isPnodePresent&&isQnodePresent)
					return true;
			}
			level++;
		}
		return false;

	}

	public static boolean isCousin2(BinaryTreeNode<Integer> root, int p, int q) {

        if(root==null)
        	return false;
        if((depth(root,p,0)==depth(root,q,0))&& !sibling(root,p,q)) {
        	return true;
        }
		return false;

	}

	private static boolean sibling(BinaryTreeNode<Integer> frontNode, int p, int q) {
		if(frontNode ==null)
			return false;
		if(frontNode.left !=null && frontNode.right!=null&&(frontNode.left.data.equals(p)||frontNode.right.data.equals(p))&&(frontNode.left.data.equals(q)||frontNode.right.data.equals(q)))
			return true;
		boolean left=sibling(frontNode.left,p,q);
		boolean right=sibling(frontNode.right,p,q);
		return left || right;
	}

	private static int depth(BinaryTreeNode<Integer> root, int data,int level) {
		if(root==null)
			return -1;
		if(root.data.equals(data))
			return level;
		int left=depth(root.left,data,level+1);
		int right= depth(root.right,data,level+1);
		if(left==-1 && right==-1)
			return -1;
		else if(left ==-1)
			return right;
		else
			return left;
	}

}