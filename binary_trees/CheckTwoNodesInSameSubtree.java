package binary_trees;

public class CheckTwoNodesInSameSubtree {


	static boolean presentInSameSubTree(BinaryTreeNode<Integer> root, int node1, int node2) {

		if(root==null)
			return false;


		if(isNodeExist(root.left,node1)&&isNodeExist(root.left,node2))
			return true;
		else if(isNodeExist(root.right,node1)&&isNodeExist(root.right,node2))
			return true;
		else
			return false;

	}

	private static boolean isNodeExist(BinaryTreeNode<Integer> root, int node1) {

		if(root==null)
			return false;

		if(root.data==node1)
			return true;
		
		return isNodeExist(root.left,node1) ||isNodeExist(root.right,node1);
		
	}






}