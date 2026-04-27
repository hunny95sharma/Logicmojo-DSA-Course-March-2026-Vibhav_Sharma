package generic_trees;

public class SumOfAllNodes {
	
	public static int fetchSumOfAllNodes(TreeNode<Integer>root) {
		
		if(root==null)
			return 0;
		int sum=root.data;
		int childCount=root.children.size();
		for(int i=0;i<childCount;i++) {
			TreeNode<Integer>childNode=root.children.get(i);
			sum=sum+fetchSumOfAllNodes(childNode);
		}
		return sum;
	}

}