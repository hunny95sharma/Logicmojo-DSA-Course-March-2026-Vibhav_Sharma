package binary_search_tree;

import java.util.ArrayList;

public class TwoSumBst {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}


	public boolean findTarget(TreeNode root, int k) {

		if(root==null)
			return false;
		ArrayList<Integer>res=new ArrayList<>();
		convertToList(root,res);
		int i=0;
		int j=res.size()-1;
		while(i<j) {
			if((res.get(i)+res.get(j))==k) {
				
				return true;
			}
			else if((res.get(i)+res.get(j))>k) {
				j--;
			}else {
				i++;
			}
		}
		return false;
	}


	public static void convertToList(TreeNode root,ArrayList<Integer>res) {
		if(root==null)
			return;
		convertToList(root.left,res);
		res.add(root.val);
		convertToList(root.right,res);
	}
	
}