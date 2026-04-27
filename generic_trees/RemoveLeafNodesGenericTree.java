package generic_trees;

import java.util.ArrayList;
import java.util.List;

public class RemoveLeafNodesGenericTree {


	public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {
		if(root==null || root.children.size()==0)
			return null;
		int child=root.children.size();
		List<TreeNode<Integer>>updatedChildren=new ArrayList<>();
		for(int i=0;i<child;i++) {
			TreeNode<Integer>temp=removeLeafNodes(root.children.get(i));
			if(temp!=null)
				updatedChildren.add(temp);
		}
		root.children=updatedChildren;
		return root;
	}

}