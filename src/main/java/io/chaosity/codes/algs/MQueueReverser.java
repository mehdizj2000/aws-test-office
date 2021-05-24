package io.chaosity.codes.algs;

import java.util.Queue;
import java.util.Stack;

public class MQueueReverser {
	
	public static Queue<Integer> reverse(Queue<Integer> queue ) {
		Stack<Integer> stack = new Stack<>();
		while(!queue.isEmpty()) 
			stack.push(queue.remove());
		
		while(!stack.isEmpty())
			queue.add(stack.pop());
		
		return queue;
		
	}
	

}
