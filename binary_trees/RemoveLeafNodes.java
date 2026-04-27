package binary_trees;

public class RemoveLeafNodes {

	
public static BinaryTreeNode<Integer> removeAllLeaves(BinaryTreeNode<Integer> root){
        
	    if(root==null||root.right==null&&root.left==null)
	    	return null;
	    root.right=removeAllLeaves(root.right);
	    root.left=removeAllLeaves(root.left);
        return root;
	}
	
}