package generic_trees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class TreeTraversals {
	
	public static void printPreOrder(TreeNode<Integer>root) {
		if(root==null)
			return;
		System.out.print(root.data+" ");
		int childCount=root.children.size();
		for(int i=0;i<childCount;i++) {
			TreeNode<Integer>childNode=root.children.get(i);
			printPreOrder(childNode);
		}
	}
	
	public static void printPostOrder(TreeNode<Integer>root) {
		if(root==null)
			return;
		int childCount=root.children.size();
		for(int i=0;i<childCount;i++) {
			TreeNode<Integer>childNode=root.children.get(i);
			printPostOrder(childNode);
		}
		System.out.print(root.data+" ");
	}

	public static TreeNode<Integer> takeInputLevelWise(){
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData=sc.nextInt();
		Queue<TreeNode<Integer>>queue=new ArrayDeque<>();
		TreeNode<Integer>root=new TreeNode<>(rootData);
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode<Integer>frontNode=queue.poll();
			System.out.println("enter the number of children for "+frontNode.data);
			int children=sc.nextInt();
			for(int i=0;i<children;i++) {
				System.out.println("Enter "+(i+1)+"th child data for "+frontNode.data);
				int childData=sc.nextInt();
				TreeNode<Integer>child=new TreeNode<>(childData); 
				queue.add(child);
				frontNode.children.add(child);
			}
		}
		sc.close();
		return root;
		
	}
	public static void printLevelWise(TreeNode<Integer>root) {
		if(root==null)
			return;
		
		Queue<TreeNode<Integer>>queue=new ArrayDeque<>();
		TreeNode<Integer>nullNode=new TreeNode<>(Integer.MIN_VALUE);
		queue.add(root);
		queue.add(nullNode);
		System.out.println(root.data);
		while(!queue.isEmpty()) {
			TreeNode<Integer> frontNode=queue.poll();
			if(frontNode==nullNode){
				System.out.println();
				if(!queue.isEmpty())
					queue.add(nullNode);
				continue;
			}
			int childCount=frontNode.children.size();
			for(int i=0;i<childCount;i++) {
				System.out.print(frontNode.children.get(i).data+" ");
				queue.add(frontNode.children.get(i));
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode<Integer>root=takeInputLevelWise();
		printLevelWise(root);
		printPostOrder(root);
	}

}