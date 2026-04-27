package binary_trees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {
	
	public static BinaryTreeNode<Integer> takeInput(Scanner sc){
		System.out.println("Enter the node data");
		int rootData=sc.nextInt();
		if(rootData==-1)
			return null;
		BinaryTreeNode<Integer>root=new BinaryTreeNode<>(rootData);
		root.left=takeInput(sc);
		root.right=takeInput(sc);
		return root;
	}
	
	public static BinaryTreeNode<Integer> takeInputLevelWise(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the root data");
		int rootData=sc.nextInt();
		if(rootData==-1)
			return null;
		BinaryTreeNode<Integer>root=new BinaryTreeNode<>(rootData);
		Queue<BinaryTreeNode<Integer>>queue=new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode<Integer>frontNode=queue.poll();
			System.out.println("Enter the Left node data for"+frontNode.data);
			int leftChildData=sc.nextInt();
			if(leftChildData!=-1) {
				BinaryTreeNode<Integer>leftChildNode=new BinaryTreeNode<>(leftChildData);
				frontNode.left=leftChildNode;
				queue.add(leftChildNode);
			}
			System.out.println("Enter the Right node data for"+frontNode.data);
			int rightChildData=sc.nextInt();
			if(rightChildData!=-1) {
				BinaryTreeNode<Integer>rightChildNode=new BinaryTreeNode<>(rightChildData);
				frontNode.right=rightChildNode;
				queue.add(rightChildNode);
			}
		}
		sc.close();
		return root;
	}
	
	public static void print(BinaryTreeNode<Integer>root) {
		if(root==null)
			return;
		String toBePrinted=root.data+"-->";
		if(root.left!=null)
		toBePrinted=toBePrinted+"L:"+root.left.data+", ";	
		if(root.right!=null)
		toBePrinted=toBePrinted+"R:"+root.right.data;
		System.out.println(toBePrinted);
		print(root.left);
		print(root.right);
	}
	
	public static void printLevelWise(BinaryTreeNode<Integer>root) {
		if(root ==null)
			return;
		int level=0;
		Queue<BinaryTreeNode<Integer>>queue=new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()) {
               int nodesCountAtLevel=queue.size();
               for(int i=0;i<nodesCountAtLevel;i++) {
            	   BinaryTreeNode<Integer>frontNode=queue.poll();
            	   String toBePrinted=frontNode.data+"-->";
           		if(frontNode.left!=null)
           		toBePrinted=toBePrinted+"L:"+frontNode.left.data+", ";	
           		if(frontNode.right!=null)
           		toBePrinted=toBePrinted+"R:"+frontNode.right.data;
           		System.out.println(toBePrinted);
           		if(frontNode.left!=null)
           		queue.add(frontNode.left);
           		if(frontNode.right!=null)
           		queue.add(frontNode.right);
               }
               level++;
		}
		
	}
		

	public static void main(String[] args) {
		BinaryTreeNode<Integer>root=takeInputLevelWise();
		printLevelWise(root);
	}

}
