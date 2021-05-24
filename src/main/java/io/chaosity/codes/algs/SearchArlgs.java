package io.chaosity.codes.algs;

public class SearchArlgs {

	public static boolean binarySearch(int[] arr, int item) {
		return binarySearch(arr, item, 0, arr.length - 1);
	}

	private static boolean binarySearch(int[] arr, int item, int left, int right) {

		if (left > right)
			return false;

		var middle = (left + right) / 2;

		if (arr[middle] == item)
			return true;

		if (arr[middle] > item)
			return binarySearch(arr, item, left, middle - 1);
		else
			return binarySearch(arr, item, middle + 1, right);

	}

	private static boolean binarySearch_it(int[] arr, int item) {

		var left = 0;
		var right = arr.length - 1;

		while (left <= right) {

			var middle = (left + right) / 2;

			if (arr[middle] == item)
				return true;

			if (arr[middle] > item)
				right = middle - 1;
			else
				left = middle + 1;
		}

		return false;

	}

	private static boolean ternarySearch(int[] arr, int item, int left, int right) {

		if (left > right)
			return false;

		var blockSize = (left + right) / 3;
		var mid1 = left + blockSize;
		var mid2 = right - blockSize;

		if (arr[mid1] == item || arr[mid2] == item)
			return true;
		else if (item < arr[mid1])
			return ternarySearch(arr, item, left, mid1 - 1);
		else if (item > arr[mid1] && item < arr[mid2])
			return ternarySearch(arr, item, mid1 + 1, mid2 - 1);
		else
			return ternarySearch(arr, item, mid2 + 1, right);

	}

	private static boolean exponentialSearch(int[] arr, int target) {
		int bound = 1;
		while (bound < arr.length && arr[bound] < target)
			bound *= 2;

		return binarySearch(arr, target, bound / 2, Math.min(bound, arr.length));
	}

	private static boolean jumpSearch(int[] arr, int target) {

		int blockSize = (int) Math.sqrt(arr.length);

		int start = 0;
		int next = blockSize;

		while (target > arr[next - 1]) {
			if (start >= arr.length)
				break;
			start = next;
			next += blockSize;

			if (next > arr.length)
				next = arr.length;
		}

		for (var item : arr)
			if (item == target)
				return true;

		return false;
	}

}
