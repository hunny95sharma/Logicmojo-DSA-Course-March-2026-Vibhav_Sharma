package binary_search_tree;

import java.util.ArrayList;
import java.util.Collections;

import binary_trees.BinaryTreeNode;

public class GetPathFromRootToKthNode {

	public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
		ArrayList<Integer>res=new ArrayList<>();
		if(root==null)
			return res;
         
		if(getPathHelper(root,data,res))
		{
			Collections.reverse(res);
			return res;
		}
		return new ArrayList<>();
	}

	private static boolean getPathHelper(BinaryTreeNode<Integer> root, int data, ArrayList<Integer> res) {
	    if(root==null)
	    	return false;
	    res.add(root.data);
	    if(root.data==data)
	    	return true;
	    if(root.data>data) {
	    	if(getPathHelper(root.left,data,res))
	    	return true;
	    }else {
	    	if(getPathHelper(root.right,data,res))
		    	return true;
	    }
	    res.remove(res.size()-1);
		return false;
	}

	
}