package generic_trees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SecondLargestValue {
	
	public static class Result<T>{
		public TreeNode<T> max;
		public TreeNode<T> secondMax;
		Result(TreeNode<T> max,TreeNode<T> secondMax){
			this.max=max;
			this.secondMax=secondMax;
		}
	}
	
	public static void fetchSecondLargestHelper2(TreeNode<Integer> root,Result<Integer>res){
		if(root==null)
			return;
		if(res.max==null||root.data>res.max.data) {
			res.secondMax=res.max;
			res.max=root;
		}
		else  if(root.data<res.max.data) {
			if(res.secondMax==null||root.data>res.secondMax.data) 
			res.secondMax=root;
		}
		int childCount=root.children.size();
		for(int i=0;i<childCount;i++) {
			fetchSecondLargestHelper2(root.children.get(i),res);
		}
	}

	public static Result<Integer> fetchSecondLargestHelper1(TreeNode<Integer> root){
        if(root==null) {
     	   return new Result<Integer>(null,null);
        }
         TreeNode<Integer> maxNode=root; 
         TreeNode<Integer> secondMaxNode=null;
        int childCount=root.children.size();
        for(int i=0;i<childCount;i++) {
        	TreeNode<Integer> childNode=root.children.get(i);
        	Result<Integer>temp=fetchSecondLargestHelper1(childNode);
        	if(temp.max.data>maxNode.data) {
        		if(temp.secondMax==null || temp.secondMax.data<maxNode.data) {
        			secondMaxNode=maxNode;
        			maxNode=temp.max;	
            	}
        	else {
        		secondMaxNode=temp.secondMax;
    			maxNode=temp.max;	
        	}
        }
        	else if(temp.max.data.equals(maxNode.data) && temp.secondMax!=null) {
        		if(secondMaxNode==null ||temp.secondMax.data>secondMaxNode.data)
        			secondMaxNode=temp.secondMax;
        	}
        	else if(!temp.max.data.equals(maxNode.data)&&(secondMaxNode==null||temp.max.data>secondMaxNode.data)) {
        		secondMaxNode=temp.max;
        	}
        }	
        return new Result<Integer>(maxNode,secondMaxNode);
	}
	
	public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
           return fetchSecondLargestHelper1(root).secondMax;

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
		System.out.println(findSecondLargest(root).data);
	}


}