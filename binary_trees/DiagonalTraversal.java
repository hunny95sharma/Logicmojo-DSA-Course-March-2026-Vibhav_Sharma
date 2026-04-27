package binary_trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.TreeMap;

public class DiagonalTraversal {

	public static class Pair<T>{
		BinaryTreeNode<T>root;
		T level;
		Pair(BinaryTreeNode<T>root,T level){
			this.root=root;
			this.level=level;
		}
	}

	public static ArrayList<ArrayList<Integer>> printTreeDiagonalWise1(BinaryTreeNode<Integer>root) {
		ArrayList<ArrayList<Integer>>res=new ArrayList<>();
		if(root==null)
			return res;
		Queue<Pair<Integer>>queue=new ArrayDeque<>();
		TreeMap<Integer,ArrayList<Integer>>map=new TreeMap<>();
		queue.add(new Pair(root,1));
		while(!queue.isEmpty()) {
			Pair<Integer>frontNode=queue.poll();
			int lev=frontNode.level;
			BinaryTreeNode<Integer> node=frontNode.root;
			map.computeIfAbsent(lev, k -> new ArrayList<>()).add(node.data);
			if(node.left!=null)
				queue.add(new Pair(node.left,lev+1));
			if(node.right!=null)
				queue.add(new Pair(node.right,lev));
		}
		res.addAll(map.values());
		return res;
	}


	public static ArrayList<ArrayList<Integer>> printTreeDiagonalWise2(BinaryTreeNode<Integer>root) {
		ArrayList<ArrayList<Integer>>res=new ArrayList<>();
		if(root==null)
			return res;
		Queue<BinaryTreeNode<Integer>>queue=new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode<Integer>frontNode=queue.poll();
			ArrayList<Integer>temp=new ArrayList<>();
			while(frontNode!=null) {
				if(frontNode.left!=null)
					queue.add(frontNode.left);
				temp.add(frontNode.data);
				frontNode=frontNode.right;
			}
        res.add(temp);

		}
		return res;
	}

}