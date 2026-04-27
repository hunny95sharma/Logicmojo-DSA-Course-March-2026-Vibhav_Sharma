package binary_trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class AllNodesDistanceKInBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}


	public List<Integer> distanceKApproach2(TreeNode root, TreeNode target, int k) {

		List<Integer>result=new ArrayList<>();

		if(root==null || k<0)
			return result;

		distanceKApproach2Helper(root,target,k,result);
		
		return result;

	}
	
	public int distanceKApproach2Helper(TreeNode root, TreeNode target, int k,List<Integer> result) {

		if(root==null)
			return -1;
		if(root==target) {
			subTreeNodes(root,k,result);
			return 0;
		}
  
		
		int dl=distanceKApproach2Helper(root.left,target,k,result);
		if(dl!=-1)
		{
			if(dl+1==k)
			{
				result.add(root.val);
			}else {
				subTreeNodes(root.right,k-dl-2,result);
			}
			return 1+dl;
		}
		int dr=distanceKApproach2Helper(root.right,target,k,result);
		if(dr!=-1)
		{
			if(dr+1==k)
			{
				result.add(root.val);
			}else {
				subTreeNodes(root.left,k-dr-2,result);
			}
			return 1+dr;
		}
		
		return -1;
		

	}

	private void subTreeNodes(TreeNode root, int k, List<Integer> result) {	
		if(root==null || k<0)
			return;
		if(k==0)
		{
			result.add(root.val);
			return;
		}
		subTreeNodes(root.left,k-1,result);
		subTreeNodes(root.right,k-1,result);
	}

	public List<Integer> distanceKApproach1(TreeNode root, TreeNode target, int k) {

		List<Integer>result=new ArrayList<>();

		if(root==null)
			return result;

		HashMap<TreeNode,TreeNode>map=new HashMap<>();
		inorder(root,map);
		Bfs(root,target,map,result,k);
		return result;
	}

	void inorder(TreeNode root,HashMap<TreeNode,TreeNode>map) {
		if(root==null)
			return;
		if(root.left!=null)
			map.putIfAbsent(root.left, root);
		inorder(root.left,map);
		if(root.right!=null)
			map.putIfAbsent(root.right, root);
		inorder(root.right,map);
	}

	private void Bfs(TreeNode root, TreeNode target, HashMap<TreeNode, TreeNode> parent, List<Integer> result,int k) {

		if(root==null)
			return;
		Queue<TreeNode>queue=new ArrayDeque<>();
		Set<TreeNode>visited=new HashSet<>();
		visited.add(target);
		queue.add(target);
		int level=0;
		while(!queue.isEmpty()) {
			int levelSize=queue.size();
			if(level==k)
				break;
			for(int i=1;i<=levelSize;i++) {
				TreeNode frontNode=queue.poll();
				if(frontNode.left!=null && !visited.contains(frontNode.left)) {
					queue.add(frontNode.left);
					visited.add(frontNode.left);
				}
				if(frontNode.right!=null && !visited.contains(frontNode.right)) {
					queue.add(frontNode.right);
					visited.add(frontNode.right);
				}
				if(parent.containsKey(frontNode)&&!visited.contains(parent.get(frontNode))){
					queue.add(parent.get(frontNode));
					visited.add(parent.get(frontNode));
				}
			}
			level++;
		}
		while(!queue.isEmpty()) {
			TreeNode frontNode=queue.poll();
			result.add(frontNode.val);
		}
	}
}