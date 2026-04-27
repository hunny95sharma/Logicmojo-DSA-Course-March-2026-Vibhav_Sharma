package binary_trees;

public class MinimumDistanceBetweenTwoNodesInBinaryTree {


	
	public static int findMinimumDistanceBetweenTwoNodesInBinaryTree(BinaryTreeNode<Integer>root,int node1,int node2) {
		
		if(root==null)
			return -1;
		
		BinaryTreeNode<Integer>lca=getLCA(root,node1,node2);
		if(lca==null)
			return -1;
		int leftDistance=findDist(lca,node1,0);
		int rightDistance=findDist(lca,node2,0);
		if (leftDistance == -1 || rightDistance == -1)
		    return -1;

		return leftDistance+rightDistance;
	}



	private static int findDist(BinaryTreeNode<Integer> root, int node,int level) {
		
		if(root==null)
			return -1;
		
		if(root.data==node)
			return level;
		int left=findDist(root.left,node,level+1);
		if(left !=-1)
			return left;
		return findDist(root.right,node,level+1);	
	}



	static BinaryTreeNode<Integer> getLCA(BinaryTreeNode<Integer> root, int a, int b) {

		if(root==null)
			return null;
		if(root.data==a || root.data==b)
			return root;
		BinaryTreeNode<Integer> left=getLCA(root.left,a,b);
		BinaryTreeNode<Integer> right=getLCA(root.right,a,b);
		if(right!=null && left !=null)
			return root;
		if(left==null)
			return right;
		if(right==null)
			return left;
		return null;
		
	}
	

}