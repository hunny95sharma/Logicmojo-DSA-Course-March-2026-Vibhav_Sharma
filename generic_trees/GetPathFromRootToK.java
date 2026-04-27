package generic_trees;

import java.util.ArrayList;
import java.util.List;

public class GetPathFromRootToK {
	
	public static List<Integer> fetchPathFromRootToKthNode(TreeNode<Integer>root,int k){
		List<Integer>res=new ArrayList<>();
		if(root==null)
			return res;
		return  fetchPathFromRootToKthNodeHelper(root,k,res)?res:new ArrayList<>();
	}

	private static boolean fetchPathFromRootToKthNodeHelper(TreeNode<Integer> root, int k, List<Integer> res) {
		if(root==null)
			return false;
		res.add(root.data);
		if(root.data==k)
			return true;
		int childCount=root.children.size();
		for(int i=0;i<childCount;i++) {
			if(fetchPathFromRootToKthNodeHelper(root.children.get(i),k,res))
				return true;
		}
		res.remove(res.size()-1);
		return false;
	}

}