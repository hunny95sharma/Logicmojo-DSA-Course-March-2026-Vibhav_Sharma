package binary_trees;

public class GivenArraySequenceIsPresentAsArootToLeafPath {


	public static boolean isPathExist(BinaryTreeNode<Integer>root,int path[]) {		
		if(root==null||path.length==0)
			return false;
		return isPathExist(root,path,0);
	}

	private static boolean isPathExist(BinaryTreeNode<Integer> root, int[] path, int index) {	
		if(root==null||index>=path.length)
			return false;
		if(!root.data.equals(path[index]))
			return false;
		if(root.left==null&&root.right==null&&index==path.length-1)
		{
				return true;
		}
		
		return isPathExist(root.left,path,index+1)||isPathExist(root.right,path,index+1);

	}
}