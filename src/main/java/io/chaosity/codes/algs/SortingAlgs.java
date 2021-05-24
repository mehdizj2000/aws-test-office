package io.chaosity.codes.algs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingAlgs {

	public static int[] bubbleSort(int[] arr) {

		boolean sorted = true;
		for (var i = 0; i < arr.length; i++) {
			for (var j = 1; j < arr.length - i; j++) {
				if (arr[j] < arr[j - 1]) {
					swap(arr, j, j - 1);
					sorted = false;
				}
			}
			if (sorted)
				break;
		}
		return arr;
	}

	public static int[] selectionSort(int[] arr) {

		for (var i = 0; i < arr.length; i++) {
			var minIndex = i;
			for (var j = i; j < arr.length; j++)
				if (arr[j] < arr[minIndex])
					minIndex = j;
			System.out.println(Arrays.toString(arr));
			swap(arr, minIndex, i);
		}

		return arr;
	}

	public static int[] insertionSort(int[] arr) {

		for (var i = 1; i < arr.length; i++) {
			var current = arr[i];
			var j = i - 1;
			while (j >= 0 && arr[j] > current) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = current;
		}
		return arr;
	}

	public static int[] quickSort(int[] arr) {

		quickSort(arr, 0, arr.length - 1);

		return arr;
	}

	public static int[] countSort(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (var item : arr)
			if (item > max)
				max = item;

		int[] temp = new int[max + 1];

		for (var item : arr)
			temp[item]++;

		int counter = 0;
		for (var i = 0; i < temp.length; i++) {
			var gh = temp[i];
			while (gh > 0) {
				arr[counter++] = i;
				gh--;
			}
		}
		return arr;
	}

	public static int[] bucketSort(int[] arr) {
		int bucketsSize = (int) Math.sqrt(arr.length);

		List<Integer>[] buckets = new List[bucketsSize];
		for (var item : arr) {
			if (buckets[item / bucketsSize] == null)
				buckets[item / bucketsSize] = new ArrayList<>();
			buckets[item / bucketsSize].add(item);
		}

		var counter = 0;
		for (var bucketItems : buckets) {
			Collections.sort(bucketItems);
			for (var item : bucketItems)
				arr[counter++] = item;

		}

		return arr;
	}

	private static int partition(int[] arr, int start, int end) {
		var pivot = arr[end];
		var boundry = start - 1;
		for (int i = 0; i < arr.length; i++)
			if (arr[i] <= pivot)
				swap(arr, i, ++boundry);
		System.out.println(Arrays.toString(arr));
		return boundry;
	}

	private static void quickSort(int[] arr, int start, int end) {
		if (start >= end)
			return;
		var boundry = partition(arr, start, end);
		quickSort(arr, start, boundry - 1);
		quickSort(arr, boundry + 1, end);
	}

	public static int[] mergeSort(int[] arr) {
		mergeSortRec(arr);
		return arr;
	}

	private static void mergeSortRec(int[] arr) {
		if (arr.length < 2)
			return;
		var middle = arr.length / 2;
		int[] left = new int[middle];
		for (int i = 0; i < middle; i++)
			left[i] = arr[i];
		int[] right = new int[arr.length - middle];
		for (int i = middle; i < arr.length; i++)
			right[i - middle] = arr[i];
		mergeSortRec(left);
		mergeSortRec(right);
		merge(left, right, arr);
	}

	private static void merge(int[] left, int[] right, int[] result) {
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] < right[j])
				result[k++] = left[i++];
			else
				result[k++] = right[j++];
		}
		while (i < left.length)
			result[k++] = left[i++];
		while (j < right.length)
			result[k++] = right[j++];
	}

	private static void swap(int[] arr, int i, int j) {
		var tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
