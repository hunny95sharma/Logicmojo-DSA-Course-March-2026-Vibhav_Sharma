package generic_trees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class StructurallyIdentical {
	
	public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){
		if(root1==null && root2==null)
			return true;
		if(root1==null || root2==null)
			return false;
		if(!root1.data.equals(root2.data))
			return false;
		
		int childCount1=root1.children.size();
		int childCount2=root2.children.size();
		if(childCount1!=childCount2)
			return false;
		for(int i=0,j=0;i<childCount1&&j<childCount2;i++,j++) {
			TreeNode<Integer>childNode1=root1.children.get(i);
			TreeNode<Integer>childNode2=root2.children.get(j);
			if(!checkIdentical(childNode1,childNode2))
				return false;
		}
		return true;
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
		TreeNode<Integer>root1=takeInputLevelWise();
		TreeNode<Integer>root2=takeInputLevelWise();
		printLevelWise(root1);
		printLevelWise(root2);
		System.out.println(checkIdentical(root1,root2));
	}

}
