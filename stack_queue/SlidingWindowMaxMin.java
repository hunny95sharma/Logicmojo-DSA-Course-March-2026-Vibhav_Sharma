package stack_queue;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class SlidingWindowMaxMin {

	public int[] maxSlidingWindow(int[] nums, int k) {

		ArrayDeque<Integer>queue=new ArrayDeque<>();

		ArrayList<Integer>result=new ArrayList<>();

		for(int i=0;i<nums.length;i++) {


			while(!queue.isEmpty()&&queue.peekFirst()<=i-k)
				queue.pollFirst();

			while(!queue.isEmpty()&&nums[queue.peekLast()]<=nums[i])
				queue.pollLast();

			queue.offer(i);



			if(i>=k-1) {
				result.add(nums[queue.peekFirst()]);
			}


		}
		return result.stream().mapToInt(Integer::intValue).toArray();

	}

	public int[] minSlidingWindow(int[] nums, int k) {

		ArrayDeque<Integer>queue=new ArrayDeque<>();

		ArrayList<Integer>result=new ArrayList<>();

		for(int i=0;i<nums.length;i++) {


			while(!queue.isEmpty()&&queue.peekFirst()<=i-k)
				queue.pollFirst();

			while(!queue.isEmpty()&&nums[queue.peekLast()]>=nums[i])
				queue.pollLast();

			queue.offer(i);



			if(i>=k-1) {
				result.add(nums[queue.peekFirst()]);
			}


		}
		return result.stream().mapToInt(Integer::intValue).toArray();

	}

}