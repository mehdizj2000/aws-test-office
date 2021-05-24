package io.chaosity.codes.algs;

import java.util.ArrayDeque;
import java.util.Queue;

public class MStackOfTwoQueues {

	private Queue<Integer> queueAdd = new ArrayDeque<>();
	private Queue<Integer> queueRemove = new ArrayDeque<>();

	public void push(int item) {
		queueAdd.add(item);
	}

	public int pop() {

		if (queueRemove.isEmpty()) {
			while (!queueAdd.isEmpty())
				queueRemove.add(queueAdd.remove());
		}

		return queueRemove.remove();
	}
	
	public int peek() {

		if (queueRemove.isEmpty()) {
			while (!queueAdd.isEmpty())
				queueRemove.add(queueAdd.remove());
		}

		return queueRemove.peek();
	}

}
