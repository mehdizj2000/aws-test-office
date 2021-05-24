package io.chaosity.codes.algs;

public class MLinkedList {

	private class Node {

		private int item;
		private Node next;

		public Node(int item) {
			super();
			this.item = item;
		}

	}

	private Node first;
	private Node last;
	private int size;

	public void addLast(int item) {
		var node = new Node(item);
		if (isEmpty()) {
			first = last = node;
		} else {
			last.next = node;
			last = node;
		}
		size++;
	}

	public void addFirst(int item) {
		var node = new Node(item);
		if (isEmpty()) {
			first = last = node;
		} else {
			node.next = first;
			first = node;
		}
		size++;
	}

	public int size() {
		return size;
	}

	public int indexOf(int item) {
		int count = 0;

		var current = first;
		while (current != null) {
			if (current.item == item)
				return count;
			current = current.next;
			count++;
		}
		return -1;
	}

	public boolean contains(int item) {
		return indexOf(item) != -1;
	}

	public void removeLast() {

		if (isEmpty())
			return;
		if (first == last) {
			first = last = null;
		} else {
			var current = findPrevious(last);
			last = current;
			last.next = null;
		}
		size--;
	}

	private Node findPrevious(Node node) {
		var current = first;
		while (current != null) {
			if (current.next == node)
				return current;
			current = current.next;
		}
		return null;
	}

	public void removeFirst() {

		if (isEmpty())
			return;
		if (first == last) {
			first = last = null;
		} else {
			var temp = first.next;
			first.next = null;
			first = temp;
		}
		size--;

	}

	public int[] toArray() {
		int[] arr = new int[size];
		var current = first;
		int count = 0;
		while (current != null) {

			arr[count++] = current.item;
			current = current.next;
		}

		return arr;
	}

	public void reverse() {
		var previous = first;
		var current = first.next;
		while (current != null) {
			var next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		last = first;
		first.next = previous;
		first = previous;
	}

	public int[] middleValues() {
		var p1 = first;
		var p2 = first;

		while (p1 != last && p1.next != last) {
			p1 = p1.next.next;
			p2 = p2.next;
		}

		if (p1 == last) {
			return new int[] { p2.item };
		} else {
			return new int[] { p2.item, p2.next.item };
		}

	}

	public int findKthFromTheEnd(int k) {
		var p1 = first;
		var p2 = first;

		for (int i = 0; i < k; i++) {
			p2 = p2.next;
		}

		var current = p2;
		while (current != null) {
			current = current.next;
			p1 = p1.next;
		}

		return p1.item;
	}

	private boolean isEmpty() {
		return first == null;
	}

}
