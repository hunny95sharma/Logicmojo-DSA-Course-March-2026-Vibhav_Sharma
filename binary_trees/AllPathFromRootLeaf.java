package binary_trees;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromRootLeaf {

	public List<List<Integer>> pathSum(BinaryTreeNode<Integer> root, int targetSum) {
		List<List<Integer>>result=new ArrayList<>();
		if(root==null)
			return result;

		pathSumHelper(root, targetSum,0,new ArrayList<Integer>(),result);
		return result;
	}

	public void pathSumHelper(BinaryTreeNode<Integer> root, int targetSum,int currSum,List<Integer> temp, List<List<Integer>> result) {
		if(root==null)
			return;
		currSum=currSum+root.data;
		temp.add(root.data);
		if(root.left==null&&root.right==null&&targetSum==currSum) {
			result.add(new ArrayList<>(temp)); 
			temp.remove(temp.size()-1);
			return;
		}
		pathSumHelper(root.left,targetSum,currSum,temp,result);
		pathSumHelper(root.right,targetSum,currSum,temp,result);
		temp.remove(temp.size()-1);
	}

}