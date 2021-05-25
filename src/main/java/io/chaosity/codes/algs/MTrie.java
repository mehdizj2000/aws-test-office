package io.chaosity.codes.algs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MTrie {

	private class Node {
		private char value;
		private Map<Character, Node> children = new HashMap<>();
		private boolean isEndOfTheWord;

		public Node(char value) {
			super();
			this.value = value;
		}

		public Node[] getChildren() {
			return children.values().toArray(new Node[0]);
		}

		public Node getChild(char item) {
			return children.get(item);
		}

		public void addChild(char item) {
			children.put(item, new Node(item));
		}

		public boolean hasChild(char item) {
			return children.containsKey(item);
		}

		@Override
		public String toString() {
			return "" + this.value;
		}
	}

	private Node root = new Node(' ');

	public void insert(String word) {
		var current = root;

		for (var ch : word.toCharArray()) {
			if (!current.hasChild(ch))
				current.addChild(ch);
			current = current.getChild(ch);
		}
		current.isEndOfTheWord = true;

	}

	public List<String> findWords(String prefix) {
		List<String> words = new ArrayList<>();
		Node lastNode = findLastNodeOfPrefix(prefix);
		findWords(lastNode, prefix, words);
		return words;
	}

	private Node findLastNodeOfPrefix(String prefix) {
		var current = root;
		for (var ch : prefix.toCharArray()) {
			if (!current.hasChild(ch))
				return null;
			current = current.getChild(ch);
		}
		return current;
	}

	private void findWords(Node lastNode, String prefix, List<String> words) {
		if (lastNode == null)
			return;

		if (lastNode.isEndOfTheWord)
			words.add(prefix);

		for (var node : lastNode.getChildren())
			findWords(node, prefix + node.value, words);

	}
}
