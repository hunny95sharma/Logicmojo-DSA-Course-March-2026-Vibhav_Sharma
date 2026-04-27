package binary_search_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import binary_trees.BinaryTreeNode;

public class AscendingDescendingListFromBst {

	public static List<Integer> sortingAsc(BinaryTreeNode<Integer>root) {

		List<Integer>result=new ArrayList<>();
		if(root==null)
			return result;

		Stack<BinaryTreeNode<Integer>> stackAsc = new Stack<>();
		BinaryTreeNode<Integer>temp=root;
		while(temp!=null) {
			stackAsc.add(temp);
			temp=temp.left;
		}
		while(!stackAsc.isEmpty()) {
			temp=stackAsc.pop();  
			result.add(temp.data);
			temp=temp.right;
			while(temp!=null) {
				stackAsc.add(temp);
				temp=temp.left;
			}
		}
		return result;

	}
	
	public static List<Integer> sortingDsc(BinaryTreeNode<Integer>root) {

		List<Integer>result=new ArrayList<>();
		if(root==null)
			return result;

		Stack<BinaryTreeNode<Integer>> stackDsc = new Stack<>();
		BinaryTreeNode<Integer>temp=root;
		while(temp!=null) {
			stackDsc.add(temp);
			temp=temp.right;
		}
		while(!stackDsc.isEmpty()) {
			temp=stackDsc.pop();  
			result.add(temp.data);
			temp=temp.left;
			while(temp!=null) {
				stackDsc.add(temp);
				temp=temp.right;
			}
		}
		return result;

	}
	
}