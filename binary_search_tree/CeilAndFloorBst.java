package binary_search_tree;

import binary_trees.BinaryTreeNode;

public class CeilAndFloorBst {

	public static int ceilBst(BinaryTreeNode<Integer>root,int key) {
		
		if(root==null)
			return -1;
		
		int ans=-1;
		
		BinaryTreeNode<Integer>temp=root;
		while(temp!=null) {
			if(temp.data==key)
				return key;
			else if(temp.data>key) {
				ans=temp.data;
				temp=temp.left;
			}else {
				temp=temp.right;
			}
		}
		
		return ans;
	}
	
public static int floorBst(BinaryTreeNode<Integer>root,int key) {
		
		if(root==null)
			return -1;
		
		int ans=-1;
		
		BinaryTreeNode<Integer>temp=root;
		while(temp!=null) {
			if(temp.data==key)
				return key;
			else if(temp.data>key) {
				temp=temp.left;
			}else {
				ans=temp.data;
				temp=temp.right;
			}
		}
		
		return ans;
	}
	
}