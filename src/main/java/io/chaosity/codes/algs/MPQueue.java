package io.chaosity.codes.algs;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class MPQueue {

	int[] arr = new int[10];
	int count;

	public void insert(int item) {

		int i;
		for (i = count - 1; i >= 0; i--) {
			if (arr[i] > item)
				arr[i + 1] = arr[i];
			else
				break;
		}

		arr[i + 1] = item;
		count++;

	}

	public static Queue<Integer> reverseKItems(Queue<Integer> queue, int k) {

		Stack<Integer> stack = new Stack<>();
		int counter = k;
		while (counter > 0) {
			stack.push(queue.remove());
			counter--;
		}

		while (!stack.isEmpty()) {
			queue.add(stack.pop());
		}

		int reminderSize = queue.size() - k;

		while (reminderSize > 0) {
			queue.add(queue.remove());
			reminderSize--;
		}

		return queue;
	}

	@Override
	public String toString() {
		return Arrays.toString(arr);
	}

}
