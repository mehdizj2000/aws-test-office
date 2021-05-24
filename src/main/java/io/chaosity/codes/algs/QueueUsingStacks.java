package io.chaosity.codes.algs;

import java.util.Stack;

public class QueueUsingStacks {

	private Stack<Integer> enqueue = new Stack<Integer>();
	private Stack<Integer> dequeue = new Stack<Integer>();

	public void enqueue(int item) {
		
		enqueue.push(item);
		
	}

	public int dequeue() {

		if (dequeue.isEmpty())
			while (!enqueue.isEmpty())
				dequeue.push(enqueue.pop());

		return dequeue.pop();
		
	}

}
