package generic_trees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class NumberOfNodesGreaterThenX {

	public static int fetchNumberOfNodesGreaterThenX(TreeNode<Integer>root,int x) {
		if(root==null)
			return 0;
		int count=0;
		if(root.data>x)
			count=1;
		int childCount=root.children.size();
		for(int i=0;i<childCount;i++) {
			TreeNode<Integer>childNode=root.children.get(i);
			int temp=fetchNumberOfNodesGreaterThenX(childNode,x);
				count=count+temp;
		}
		return count;
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
		System.out.println("Node count greater than x "+fetchNumberOfNodesGreaterThenX(root,35));
	}

}
