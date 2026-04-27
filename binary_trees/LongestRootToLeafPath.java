package binary_trees;

import java.util.ArrayList;
import java.util.Collections;

public class LongestRootToLeafPath {



	public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root){

		ArrayList<Integer>result=new ArrayList<>();
		if(root==null)
			return result;
		helper(root,result,new ArrayList<Integer>());	
		Collections.reverse(result);
		return result;
	}

	private static void helper(BinaryTreeNode<Integer> root, ArrayList<Integer> result,
			ArrayList<Integer> temp) {

		if(root==null)
			return;
			temp.add(root.data);
		
		if(root.left==null && root.right==null) {
			if(temp.size()>result.size())
			{
				result.clear();
                result.addAll(temp); 
			}
		}
		
		helper(root.left,result,temp);
		helper(root.right,result,temp);
		temp.remove(temp.size()-1);
	}
}