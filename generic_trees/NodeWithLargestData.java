package generic_trees;

public class NodeWithLargestData {
	
	public static int fetchNodeWithLargestData(TreeNode<Integer>root) {
		if(root==null)
			return Integer.MIN_VALUE;
		int largeValue=root.data;
		int childCount=root.children.size();
		for(int i=0;i<childCount;i++) {
			TreeNode<Integer>childNode=root.children.get(i);
			int temp=fetchNodeWithLargestData(childNode);
			if(temp>largeValue)
				largeValue=temp;
		}
		return largeValue;
	}
}