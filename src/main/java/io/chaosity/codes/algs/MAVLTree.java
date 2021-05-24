package io.chaosity.codes.algs;

import java.util.ArrayList;
import java.util.List;

public class MAVLTree {

	private class Node {
		private int value;
		private Node left;
		private Node right;
		private int height;

		public Node(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "" + value;
		}
	}

	private Node root;
	private int count;

	public void insert(int item) {
		root = insert(root, item);
	}

	public boolean find(int item) {
		return find(root, item);
	}

	public void traverse() {
		traverseDeepFirstPostOrdeer(root);
	}

	private void traverseDeepFirstPreOrdeer(Node node) {
		if (node == null)
			return;
		System.out.println(node.value);

		traverseDeepFirstPreOrdeer(node.left);
		traverseDeepFirstPreOrdeer(node.right);
	}

	private void traverseDeepFirstInOrdeer(Node node) {
		if (node == null)
			return;
		traverseDeepFirstInOrdeer(node.left);
		System.out.println(node.value);
		traverseDeepFirstInOrdeer(node.right);
	}

	private void traverseDeepFirstPostOrdeer(Node node) {
		if (node == null)
			return;
		traverseDeepFirstPostOrdeer(node.left);
		traverseDeepFirstPostOrdeer(node.right);
		System.out.println(node.value);
	}

	public int min() {
		return min(root);
	}

	private int min(Node node) {
		if (node != null && isLeaf(node))
			return node.value;
		return min(node.left);
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node == null)
			return Integer.MIN_VALUE;
		if (isLeaf(node))
			return node.value;
		var leftMax = max(node.left);
		var rightMax = max(node.right);
		return Math.max(Math.max(leftMax, rightMax), node.value);
	}

	public boolean areSibling(int item1, int item2) {
		return areSibling(root, item1, item2);
	}

	private boolean areSibling(Node node, int item1, int item2) {

		if (node == null)
			return false;

		if (node.left != null && node.right != null)
			if ((node.left.value == item1 && node.right.value == item2)
					|| (node.left.value == item2 && node.right.value == item1))
				return true;

		return areSibling(node.left, item1, item2) || areSibling(node.right, item1, item2);
	}

	private boolean find(Node node, int item) {
		if (node == null)
			return false;
		if (node.value == item)
			return true;
		return node.value > item ? find(node.left, item) : find(node.right, item);
	}

	public List<Integer> findAncestors(int item) {
		List<Integer> list = new ArrayList<>();
		findAncestors(root, item, list);
		return list;
	}

	private void findAncestors(Node node, int item, List<Integer> ancestors) {
		if (node == null)
			return;
		ancestors.add(node.value);
		if (node.value == item)
			return;

		if (node.value > item)
			findAncestors(node.left, item, ancestors);
		else
			findAncestors(node.right, item, ancestors);

	}

	public boolean isPerfect() {
		return Math.pow(height(root), 2) - 1 == count;
	}

	private Node insert(Node node, int value) {

		if (node == null) {
			count++;
			return new Node(value);
		}

		if (node.value > value)
			node.left = insert(node.left, value);
		else
			node.right = insert(node.right, value);
		setHeight(node);
		return balance(node);
	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null)
			return 0;
		if (isLeaf(node))
			return 1;
		return 1 + size(node.left) + size(node.right);
	}

	public int countLeaves() {
		return countLeaves(root);
	}

	private int countLeaves(Node node) {
		if (node == null)
			return 0;

		if (isLeaf(node))
			return 1;

		return size(node.left) + size(node.right);
	}

	private Node balance(Node node) {
		var balance = calcBalance(node);
		if (balance > 1) {
			if (calcBalance(node.left) == -1)
				node.left = rotateLeft(node.left);
			node = rotateRight(node);
		} else if (balance < -1) {
			if (calcBalance(node.right) == 1)
				node.right = rotateRight(node.right);
			node = rotateLeft(node);
		}
		return node;
	}

	private Node rotateRight(Node node) {
		var newRoot = node.left;
		node.left = newRoot.right;
		newRoot.right = node;

		setHeight(node);
		setHeight(newRoot);

		return newRoot;
	}

	private Node rotateLeft(Node node) {
		var newRoot = node.right;
		node.right = newRoot.left;
		newRoot.left = node;

		setHeight(node);
		setHeight(newRoot);

		return newRoot;
	}

	public boolean binarySearchTreeValidation() {
		return binarySearchTreeValidation(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean binarySearchTreeValidation(Node node, int min, int max) {

		if (root == null)
			return true;

		if (node.value < min || node.value > max)
			return false;

		return binarySearchTreeValidation(node.left, min, node.value - 1)
				&& binarySearchTreeValidation(node.right, node.value + 1, max);

	}

	public void traverseTreeByLevel() {
		findNodesAtKDistance(root, root.height - 1);
	}

	public void findNodesAtKDistance(int distance) {
		findNodesAtKDistance(root, distance);
	}

	private void findNodesAtKDistance(Node node, int distance) {

		if (node == null)
			return;

		if (distance == 0) {
			System.out.println(node.value);
			return;
		}

		findNodesAtKDistance(node.left, distance - 1);
		findNodesAtKDistance(node.right, distance - 1);
	}

	private int calcBalance(Node node) {
		return height(node.left) - height(node.right);
	}

	private void setHeight(Node node) {
		node.height = Math.max(height(node.left), height(node.right)) + 1;
	}

	private int height(Node node) {
		return node == null ? -1 : node.height;
	}

	private boolean isLeaf(Node node) {
		return node.left == null && node.right == null;
	}

	public boolean equals(MAVLTree otherTree) {
		return this.equals(this.root, otherTree.root);
	}

	private boolean equals(Node node, Node other) {
		if (node == null && other == null)
			return true;

		if (node != null && other != null)
			return node.value == other.value && equals(node.left, other.left) && equals(node.right, other.right);

		return false;
	}

}
