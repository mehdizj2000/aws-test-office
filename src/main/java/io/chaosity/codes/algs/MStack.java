package io.chaosity.codes.algs;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MStack {

	private int[] arr;
	private int count;

	public MStack() {
		arr = new int[5];
	}

	public void push(int item) {

		if (count == arr.length)
			throw new StackOverflowError();
		arr[count++] = item;

	}

	public int pop() {
		if (isEmpty())
			throw new IllegalStateException();

		return arr[--count];
	}

	public int peek() {
		if (isEmpty())
			throw new IllegalStateException();

		return arr[count - 1];
	}

	public boolean isEmpty() {

		return count == 0;
	}

	public static boolean isStringBalanced(String str) {

		List<Character> open = Arrays.asList('(', '<', '{', '[');
		List<Character> close = Arrays.asList(')', '>', '}', ']');

		Stack<Character> characters = new Stack<>();
		char[] arr = str.toCharArray();
		for (char ch : arr) {
			if (open.contains(ch))
				characters.push(ch);
			if (close.contains(ch)) {
				if (characters.isEmpty())
					return false;
				char temp = characters.pop();

				if (open.indexOf(temp) != close.indexOf(ch))
					return false;

			}
		}

		return characters.isEmpty();
	}

}
