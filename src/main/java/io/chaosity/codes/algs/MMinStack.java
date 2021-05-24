package io.chaosity.codes.algs;

import java.util.Stack;

public class MMinStack {

	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();

	public void push(int item) {
		stack.push(item);
		if (minStack.isEmpty() || minStack.peek() > item)
			minStack.push(item);
	}

	public int pop() {
		var top = stack.pop();
		if (minStack.peek() == top)
			minStack.pop();
		return top;
	}

	public int min() {
		return minStack.peek();
	}

	@Override
	public String toString() {
		return stack.toString() + "  " + minStack.toString();
	}

}
