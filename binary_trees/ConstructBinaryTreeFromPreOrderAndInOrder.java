package binary_trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreOrderAndInOrder {
	
	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
		Map<Integer,Integer>inOrderMap=new HashMap<>();
		for(int i=0;i<inOrder.length;i++)
			inOrderMap.put(inOrder[i], i);
		return buildBinaryTree(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1,inOrderMap);
	}

	private static BinaryTreeNode<Integer> buildBinaryTree(int[] preOrder, int preOrderStart, int preOrderEnd, int[] inOrder, int inOrderStart, int inOrderEnd,
			Map<Integer, Integer> inOrderMap) {
		
		if(preOrderStart>preOrderEnd || inOrderStart>inOrderEnd)
			return null;
		BinaryTreeNode<Integer>root=new BinaryTreeNode<>(preOrder[preOrderStart]);
		int inOrderRootIdx=inOrderMap.get(preOrder[preOrderStart]);
		int numsLeft=inOrderRootIdx-inOrderStart;
		root.left=buildBinaryTree(preOrder,preOrderStart+1,preOrderStart+numsLeft,inOrder,inOrderStart,inOrderRootIdx-1,inOrderMap);
		root.right=buildBinaryTree(preOrder,preOrderStart+1+numsLeft,preOrderEnd,inOrder,inOrderRootIdx+1,inOrderEnd,inOrderMap);
		return root;
	}
	
}