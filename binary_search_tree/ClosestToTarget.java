package binary_search_tree;

import binary_trees.BinaryTreeNode;

public class ClosestToTarget {
	int ans;
	double mini;

	public  int closestToTarget(BinaryTreeNode<Integer>root,double target){
		ans=0;
		mini=Double.MAX_VALUE;
		if(root==null)
			return ans;
		closestToTargetHelper(root,target);
		return ans;
	}

	private  void closestToTargetHelper(BinaryTreeNode<Integer> root, double target) {

		if(root==null)
			return;
		double absValue=Math.abs(root.data-target);
		if(absValue<mini) {
			mini=absValue;
			ans=root.data;
		}

		if(target>root.data) {
			closestToTargetHelper(root.right,target);
		}else if(target<root.data) {

			closestToTargetHelper(root.left,target);
		}
	}

}