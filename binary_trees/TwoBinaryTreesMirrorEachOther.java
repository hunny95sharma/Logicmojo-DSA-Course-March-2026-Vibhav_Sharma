package binary_trees;

public class TwoBinaryTreesMirrorEachOther {

	
	public static boolean isTwoBinaryTreesMirrorOfEachOther(BinaryTreeNode<Integer>root1,BinaryTreeNode<Integer>root2) {
		if(root1==null && root2==null)
			return true;
		if(root1==null||root2==null)
			return false;
		if(!root1.data.equals(root2.data))
			return false;
		boolean isLeftMirrorEachOther=isTwoBinaryTreesMirrorOfEachOther(root1.left,root2.right);
		boolean isRightMirrorEachOther=isTwoBinaryTreesMirrorOfEachOther(root1.right,root2.left);
		return isLeftMirrorEachOther&&isRightMirrorEachOther;
	}
	
}