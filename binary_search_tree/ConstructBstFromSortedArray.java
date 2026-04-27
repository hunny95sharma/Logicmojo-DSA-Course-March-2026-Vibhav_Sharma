package binary_search_tree;

import binary_trees.BinaryTreeNode;

public class ConstructBstFromSortedArray {



	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
        
		return  SortedArrayToBSTHelper(arr,0,n-1 );
		
	}

	private static BinaryTreeNode<Integer> SortedArrayToBSTHelper(int[] arr, int start, int end) {
		if(end<start)
			return null;
		int mid=start+(end-start)/2;
		BinaryTreeNode<Integer>root=new BinaryTreeNode<>(arr[mid]);
		root.left=SortedArrayToBSTHelper(arr,start,mid-1);
		root.right=SortedArrayToBSTHelper(arr,mid+1,end);
		return root;
	}
}