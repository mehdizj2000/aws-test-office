package io.chaosity.codes.algs;

public class MQueueLinkedList {

	private class Node {
		private int item;
		private Node next;

		public Node(int item) {
			this.item = item;
		}
	}

	private Node first;
	private Node last;
	private int count;

	public void add(int item) {

		var node = new Node(item);

		if (first == null)
			first = last = node;
		else {
			last.next = node;
			last = node;
		}

		count++;
	}

	public int remove() {
		if (first == null)
			throw new IllegalStateException();

		int val;
		if (first == last) {
			val = first.item;
		} else {
			var second = first.next;
			val = first.item;
			first.next = null;
			first = second;

		}
//		
//		var current = first;
//		while(current != null) {
//			if(current.next == last)
//				break;
//			current = current.next;
//		}
//		
//		last = current;
//		last.next = null;
//		count--;
//		return last.item;

		return val;

	}

}
