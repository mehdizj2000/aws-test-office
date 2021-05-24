package io.chaosity.codes.algs;

import java.util.Arrays;

public class ArrayQueue {

	private int[] arr;
	private int end;
	private int start;
	private int size;
	private int count;

	public ArrayQueue(int size) {
		this.size = size;
		arr = new int[this.size];
	}

	public void enqueue(int item) {

		if (isFull())
			throw new IllegalStateException();
		arr[end] = item;
		end = (end + 1) % size;
		count++;

	}

	public int dequeue() {
		if (isEmpty())
			throw new IllegalStateException();
		
		int item = arr[start];
		arr[start] = 0;
		start = (start + 1) % size;
		count--;
		
		return item;
	}

	public int peek() {
		if (isEmpty())
			throw new IllegalStateException();
		
		return arr[start];
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public boolean isFull() {
		return count > size;
	}

	@Override
	public String toString() {
		return Arrays.toString(arr);
	}
}
