package binary_trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

public class PairSumBinaryTree {


	static void pairSum(BinaryTreeNode<Integer> root, int sum) {
		if(root==null)
			return;

		ArrayList<Integer>res=new ArrayList<>();
		pairSumHelper(root,res);
		Collections.sort(res);
		int i=0;
		int j=res.size()-1;
		while(i<j) {
			if((res.get(i)+res.get(j))==sum) {
				System.out.println(res.get(i)+" "+res.get(j));
				i++;
				j--;
			}
			else if((res.get(i)+res.get(j))>sum) {
				j--;
			}else {
				i++;
			}
		}
	}

	private static void  pairSumHelper(BinaryTreeNode<Integer> root,ArrayList<Integer>res) {
		if(root==null)
			return;
		res.add(root.data);
		pairSumHelper(root.left,res);
		pairSumHelper(root.right,res);
	}

	static void pairSumBruteForce(BinaryTreeNode<Integer>root,int sum) {
		if(root==null)
			return;

		BinaryTreeNode<Integer>temp1=root;
		BinaryTreeNode<Integer>temp2=root;
		pairSumHelperBruteForce(temp1,temp2,sum);
	}

	private static void pairSumHelperBruteForce(BinaryTreeNode<Integer> temp1, BinaryTreeNode<Integer> temp2,int sum) {
		if(temp1==null)
			return;
		int reminder=sum-temp1.data;
		printPairSumBruteForce(temp1,temp2,reminder);
		pairSumHelperBruteForce(temp1.left,temp2,sum);
		pairSumHelperBruteForce(temp1.right,temp2,sum);
	}

	private static void printPairSumBruteForce(BinaryTreeNode<Integer> search, BinaryTreeNode<Integer> root, int reminder) {
		
		if(root==null)
			return;
		
		if(search!=root && root.data.equals(reminder)) {
			System.out.println(search.data+" "+root.data);
			search.data=Integer.MIN_VALUE;
		}
		printPairSumBruteForce(search,root.left,reminder);
		printPairSumBruteForce(search,root.right,reminder);
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
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer>root=takeInputLevelWise();
		pairSumBruteForce(root,21);
	}


}