package binary_search_tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinarySearchTreeFromPreOrderTraversal {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	
	public TreeNode bstFromPreorder(int[] preorder) {

		if(preorder.length==0)
			return null;

		int min=Integer.MIN_VALUE;
		int max=Integer.MAX_VALUE;
		return solve(preorder,min,max);

	}

	public  int startIndex=0;

	private TreeNode solve(int[] preorder, int min, int max) {
		if(startIndex>=preorder.length)
			return null;
		if(preorder[startIndex]<min || preorder[startIndex]>max)
			return null;
		TreeNode root=new TreeNode(preorder[startIndex]);
		startIndex=startIndex+1;
		root.left=solve(preorder,min,root.val);
		root.right=solve(preorder,root.val,max);
		return root;
	}


	public TreeNode bstFromPreorderApproach2(int[] preorder) {

		if(preorder.length==0)
			return null;

		int inOrder[]=new int[preorder.length];
		for(int i=0;i<preorder.length;i++)
			inOrder[i]=preorder[i];

		Arrays.sort(inOrder);


		return buildTree(preorder,inOrder);

	}

	public static TreeNode buildTree(int[] preOrder, int[] inOrder) {
		Map<Integer,Integer>inOrderMap=new HashMap<>();
		for(int i=0;i<inOrder.length;i++)
			inOrderMap.put(inOrder[i], i);
		return buildBinaryTree(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1,inOrderMap);
	}

	private static TreeNode buildBinaryTree(int[] preOrder, int preOrderStart, int preOrderEnd, int[] inOrder, int inOrderStart, int inOrderEnd,
			Map<Integer, Integer> inOrderMap) {

		if(preOrderStart>preOrderEnd || inOrderStart>inOrderEnd)
			return null;
		TreeNode root=new TreeNode(preOrder[preOrderStart]);
		int inOrderRootIdx=inOrderMap.get(preOrder[preOrderStart]);
		int numsLeft=inOrderRootIdx-inOrderStart;
		root.left=buildBinaryTree(preOrder,preOrderStart+1,preOrderStart+numsLeft,inOrder,inOrderStart,inOrderRootIdx-1,inOrderMap);
		root.right=buildBinaryTree(preOrder,preOrderStart+1+numsLeft,preOrderEnd,inOrder,inOrderRootIdx+1,inOrderEnd,inOrderMap);
		return root;
	}

	public TreeNode bstFromPreorderApproach1(int[] preorder) {

		if(preorder.length==0)
			return null;

		return takeInput(preorder,null);

	}

	private TreeNode takeInput(int[] preorder, TreeNode root) {

		for(int i=0;i<preorder.length;i++)
			root=insertInToBst(root,preorder[i]);

		return root;
	}

	private TreeNode insertInToBst(TreeNode root, int data) {

		if(root==null) {
			root=new TreeNode(data);
			return root;
		}

		if(data<root.val) {
			root.left=insertInToBst(root.left,data);
		}
		if(data>root.val) {
			root.right=insertInToBst(root.right,data);
		}
		return root;
	}



}