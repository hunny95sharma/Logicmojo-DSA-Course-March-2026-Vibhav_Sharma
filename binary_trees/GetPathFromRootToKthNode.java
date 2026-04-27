package binary_trees;

import java.util.ArrayList;
import java.util.List;

public class GetPathFromRootToKthNode {

	public static List<Integer>getPathFromRootToKthNode(BinaryTreeNode<Integer>root,int k){
		List<Integer>res=new ArrayList<>();
		if(root==null)
			return res;
		return getPathFromRootToKthNode(root,res,k)?res:new ArrayList<>();
	}

	private static boolean getPathFromRootToKthNode(BinaryTreeNode<Integer> root, List<Integer> res, int k) {
		if(root==null)
			return false;
		res.add(root.data);
		if(root.data==k)
			return true;
		if(getPathFromRootToKthNode(root.left,res,k)||getPathFromRootToKthNode(root.right,res,k))
			return true;
		res.remove(res.size()-1);
		return false;
	}
	
	
}