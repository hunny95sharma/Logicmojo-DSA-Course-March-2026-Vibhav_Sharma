package stack_queue;

import java.util.Queue;

public class ReverseAQueue {


	public static void reverseQueue(Queue<Integer> input) {
		if(input.isEmpty())
			return;

		int element=input.poll();
		reverseQueue(input);

		input.offer(element);


	}

}