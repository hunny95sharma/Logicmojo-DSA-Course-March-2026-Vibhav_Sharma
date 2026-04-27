package generic_trees;

public class NumberOfNodes {
	
	public static int countNumberOfNodeInTree(TreeNode<Integer>root) {
		if(root==null)
			return 0;
		int count=1;
		int childCount=root.children.size();
		for(int i=0;i<childCount;i++) {
			TreeNode<Integer>childNode=root.children.get(i);
			count=count+countNumberOfNodeInTree(childNode);
		}
		
		return count;
	}
}