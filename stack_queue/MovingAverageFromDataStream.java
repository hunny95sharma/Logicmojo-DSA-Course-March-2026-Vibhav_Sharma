package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream {


	Queue<Integer>q;
	int maxSize;
	int runningSum;

	public MovingAverageFromDataStream(int maxSize) {
		this.maxSize=maxSize;
		runningSum=0;
		q=new LinkedList<>();
	}

	public double nextValue(int val) {

		if(q.size()==maxSize)
			runningSum=runningSum-q.poll();
		runningSum=runningSum+val;
		q.offer(val);
		double result=runningSum*1.0/Math.min(q.size(), maxSize);
		return result;
	}

}