package generic_trees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class TreeNodeUse {
	
	public static TreeNode<Integer> takeInput(Scanner sc){
		System.out.println("Enter next Node data");
		int data=sc.nextInt();
		TreeNode<Integer>root=new TreeNode<>(data);
		System.out.println("enter the number of children for "+data);
		int children=sc.nextInt();
		for(int i=0;i<children;i++) {
			TreeNode<Integer>child=takeInput(sc);
			root.children.add(child);
		}
		return root;
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
	
	public static void print(TreeNode<Integer>node) {
		if(node==null)
			return;
		System.out.print(node.data+":");
		int childCount=node.children.size();
		for(int i=0;i<childCount;i++) {
			System.out.print(node.children.get(i).data+",");
		}
		System.out.println();
		for(int i=0;i<childCount;i++) {
			print(node.children.get(i));
		}
	}
	
	public static void printLevelWise(TreeNode<Integer>root) {
		if(root==null)
			return;
		Queue<TreeNode<Integer>>queue=new ArrayDeque<>();
		int level=0;
		queue.add(root);
		while(!queue.isEmpty()) {
			int nodesCountAtLevel=queue.size();
			for(int i=0;i<nodesCountAtLevel;i++) {
				TreeNode<Integer> frontNode=queue.poll();
				System.out.print(frontNode.data+"--->");
				int childCount=frontNode.children.size();
				for(int j=0;j<childCount;j++) {
					TreeNode<Integer>childNode=frontNode.children.get(j);
					queue.add(childNode);
					System.out.print(childNode.data+", ");
				}
				System.out.println();
			}
			level++;
		}
	}

	public static void main(String[] args) {
		TreeNode<Integer>root=takeInputLevelWise();
		printLevelWise(root);
	}

}
