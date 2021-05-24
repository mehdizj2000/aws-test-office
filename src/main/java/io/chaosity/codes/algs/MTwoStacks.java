package io.chaosity.codes.algs;

import java.util.Arrays;

public class MTwoStacks {

	private int[] arr;
	private int top1;
	private int top2;

	public MTwoStacks(int size) {
		arr = new int[size];
		top1 = 0;
		top2 = size - 1;
	}

	public void push1(int item) {
		if (isFull1())
			throw new StackOverflowError();
		arr[top1++] = item;
	}

	public void push2(int item) {
		if (isFull2())
			throw new StackOverflowError();
		arr[top2--] = item;
	}

	public int pop1() {
		if (isEmpty1())
			throw new IllegalStateException();
		return arr[--top1];
	}

	public int pop2() {
		if (isEmpty2())
			throw new IllegalStateException();
		return arr[++top2];
	}

	public int peek1() {
		if (isEmpty1())
			throw new IllegalStateException();
		return arr[top1 - 1];
	}

	public int peek2() {
		if (isEmpty2())
			throw new IllegalStateException();
		return arr[top2 + 1];
	}

	public boolean isEmpty1() {
		return top1 == 0;
	}

	public boolean isEmpty2() {
		return top1 == arr.length - 1;
	}

	public boolean isFull1() {
		return top1 == top2 + 1;
	}

	public boolean isFull2() {
		return top1 == top2 + 1;
	}

	@Override
	public String toString() {
		return Arrays.toString(arr);
	}

}
