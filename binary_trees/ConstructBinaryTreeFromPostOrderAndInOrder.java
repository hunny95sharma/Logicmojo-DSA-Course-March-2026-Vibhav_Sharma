package binary_trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPostOrderAndInOrder {

	public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
		Map<Integer,Integer>inOrderMap=new HashMap<>();
		for(int i=0;i<inOrder.length;i++)
			inOrderMap.put(inOrder[i], i);
		return buildBinaryTree(postOrder,0,postOrder.length-1,inOrder,0,inOrder.length-1,inOrderMap);
	}
	
	private static BinaryTreeNode<Integer> buildBinaryTree(int[] postOrder, int postOrderStart, int postOrderEnd, int[] inOrder, int inOrderStart, int inOrderEnd,
			Map<Integer, Integer> inOrderMap) {
		
		if(postOrderStart>postOrderEnd || inOrderStart>inOrderEnd)
			return null;
		BinaryTreeNode<Integer>root=new BinaryTreeNode<>(postOrder[postOrderEnd]);
		int inOrderRootIdx=inOrderMap.get(postOrder[postOrderEnd]);
		int numsLeft=inOrderRootIdx-inOrderStart;
		root.left=buildBinaryTree(postOrder,postOrderStart,postOrderStart+numsLeft-1,inOrder,inOrderStart,inOrderRootIdx-1,inOrderMap);
		root.right=buildBinaryTree(postOrder,postOrderStart+numsLeft,postOrderEnd-1,inOrder,inOrderRootIdx+1,inOrderEnd,inOrderMap);
		return root;
	}
}
