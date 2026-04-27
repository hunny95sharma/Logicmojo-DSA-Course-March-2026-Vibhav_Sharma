package generic_trees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class NodesHavingSumOfChildrensAndNodeMax {

	public static class Result<T>{
		public TreeNode<T>res;
		public T sum;
		Result(T sum,TreeNode<T>res){
			this.sum=sum;
			this.res=res;
		}
	}
	
	public static Result<Integer> maxSumNodeBest(TreeNode<Integer> root){
		if(root==null) {
			return new Result<Integer>(0,null);
		}

		int maxSum=root.data;
		int childCount=root.children.size();
		for(int i=0;i<childCount;i++) {
			maxSum=maxSum+root.children.get(i).data;
		}
		Result<Integer> maxNode=new Result<>(maxSum,root);
		for(int i=0;i<childCount;i++) {
			TreeNode<Integer>childNode=root.children.get(i);
			Result<Integer> tempNode=maxSumNodeBest(childNode);
			if(tempNode.sum>maxNode.sum) {
				maxNode=tempNode;
			}
		}
		return maxNode;
	}

	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		if(root==null)
			return null;
		int maxSum=root.data;
		int childCount=root.children.size();
		for(int i=0;i<childCount;i++) {
			maxSum=maxSum+root.children.get(i).data;
		}
		TreeNode<Integer>maxNode=root;
		for(int i=0;i<childCount;i++) {
			TreeNode<Integer>childNode=root.children.get(i);
			TreeNode<Integer> tempNode=maxSumNode(childNode);
			int temp=tempNode.data;
			for(int j=0;j<tempNode.children.size();j++) {
				temp=temp+tempNode.children.get(j).data;
			}
			if(temp>maxSum) {
				maxSum=temp;
				maxNode=tempNode;
			}
		}
		return maxNode;
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
		TreeNode<Integer>root=takeInputLevelWise();
		printLevelWise(root);
		System.out.println(maxSumNode(root).data);
	}

}