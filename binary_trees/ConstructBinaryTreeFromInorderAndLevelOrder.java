package binary_trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndLevelOrder {

	public static BinaryTreeNode<Integer> buildTree(int[] levelOrder, int[] inOrder) {
		Map<Integer,Integer>inOrderMap=new HashMap<>();
		for(int i=0;i<inOrder.length;i++)
			inOrderMap.put(inOrder[i], i);
		List<Integer> list = Arrays.stream(levelOrder)
                .boxed()
                .toList();
		return buildBinaryTree(list,0,inOrder.length-1,inOrderMap);
	}
	private static BinaryTreeNode<Integer> buildBinaryTree(List<Integer> levelOrder,int inOrderStart, int inOrderEnd,
			Map<Integer, Integer> inOrderMap) {

		if(levelOrder.isEmpty() || inOrderStart>inOrderEnd)
			return null;
		BinaryTreeNode<Integer>root=new BinaryTreeNode<>(levelOrder.get(0));
		int inOrderRootIdx=inOrderMap.get(levelOrder.get(0));
		List<Integer>leftLevelOrder=new ArrayList<>();
		List<Integer>rightLevelOrder=new ArrayList<>();
		for(int i=1;i<levelOrder.size();i++) {
			int val = levelOrder.get(i);
			int idx = inOrderMap.get(val);
			if(idx<inOrderRootIdx)
				leftLevelOrder.add(val);
			else
				rightLevelOrder.add(val);

		}
		root.left=buildBinaryTree(leftLevelOrder,inOrderStart,inOrderRootIdx-1,inOrderMap);
		root.right=buildBinaryTree(rightLevelOrder,inOrderRootIdx+1,inOrderEnd,inOrderMap);
		return root;
	}


}