package binary_search_tree;


import java.util.Stack;

import binary_trees.BinaryTreeNode;

public class TwoSumBstOptimized {


	
	public boolean findTarget(BinaryTreeNode<Integer> root, int k) {
		if(root==null)
			return false;
		
		Stack<BinaryTreeNode<Integer>>stackAsc=new Stack<>();
		BinaryTreeNode<Integer>temp=root;
		while(temp!=null) {
			stackAsc.push(temp);
			temp=temp.left;
		}
		Stack<BinaryTreeNode<Integer>>stackDsc=new Stack<>();
		temp=root;
		while(temp!=null) {
			stackDsc.push(temp);
			temp=temp.right;
		}
		BinaryTreeNode<Integer>low=nextSmall(stackAsc);
		BinaryTreeNode<Integer>high=nextBig(stackDsc);
		while(low!=null&&high!=null&&low!=high&& low.data < high.data) {
			int sum=low.data+high.data;
			if(sum==k)
				return true;
			else if(sum>k) {
				high=nextBig(stackDsc);
			}else {
				low=nextSmall(stackAsc);
			}
		}
		return false;
		
	}
	
	public static BinaryTreeNode<Integer> nextSmall(Stack<BinaryTreeNode<Integer>>stackAsc) {
		if(stackAsc.isEmpty())
			return null;
		BinaryTreeNode<Integer>small=stackAsc.pop();
			BinaryTreeNode<Integer>temp=small.right;
			while(temp!=null) {
				stackAsc.push(temp);
				temp=temp.left;
			
		}
		return small;
	}
	
	public static BinaryTreeNode<Integer> nextBig(Stack<BinaryTreeNode<Integer>>stackDsc) {
		if(stackDsc.isEmpty())
			return null;
		BinaryTreeNode<Integer>big=stackDsc.pop();
			BinaryTreeNode<Integer>temp=big.left;
			while(temp!=null) {
				stackDsc.push(temp);
				temp=temp.right;
			
		}
		return big;
	}
	

}