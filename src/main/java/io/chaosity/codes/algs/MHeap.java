package io.chaosity.codes.algs;

import java.util.Arrays;

public class MHeap {

	private int[] arr;
	int size;

	public MHeap() {
		arr = new int[25];
	}

	public void insert(int item) {
		arr[size++] = item;
		var idx = size - 1;
		bubbleUp(idx);
	}

	public void remove() {
		
		arr[0] = arr[--size];

		var idx = 0;
 
//		while(arr[idx] < )
		

	}

	private void bubbleUp(int idx) {
		// var pIdx = calcParentIndex(idx);

		while (idx > 0 && arr[idx] > arr[calcParentIndex(idx)]) {
			swap(idx, calcParentIndex(idx));
			idx = calcParentIndex(idx);
//			pIdx = calcParentIndex(idx);
		}
	}

	private int calcParentIndex(int idx) {
		return (idx - 1) / 2;
	}

	private void swap(int idx, int pIdx) {
		var temp = arr[pIdx];
		arr[pIdx] = arr[idx];
		arr[idx] = temp;
	}

	@Override
	public String toString() {
		return Arrays.toString(arr);
	}

}
