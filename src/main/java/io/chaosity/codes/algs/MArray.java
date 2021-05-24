package io.chaosity.codes.algs;

public class MArray {

	int[] arr;
	int count;

	public MArray(int size) {
		arr = new int[size];
	}

	public int size() {
		return arr.length;
	}

	public void insert(int item) {
		arr[count++] = item;
		if (count == arr.length) {
			resizeArr();
		}
	}

	public void removeAt(int idx) {
		if (idx < 0 || idx > count - 1)
			throw new IllegalArgumentException();
		for (int i = idx; i < count; i++)
			arr[i] = arr[i + 1];
		count--;
	}

	public int indexOf(int item) {
		for (int i = 0; i < count; i++)
			if (arr[i] == item)
				return i;
		return -1;
	}

	public int max() {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < count; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}

	public int min() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < count; i++) {
			if (arr[i] < min)
				min = arr[i];
		}
		return min;
	}

	public MArray intersect(int[] otherArr) {
		MArray intersect = new MArray(count);
		for (int i = 0; i < otherArr.length; i++)
			if (this.indexOf(otherArr[i]) > -1)
				intersect.insert(otherArr[i]);
		return intersect;
	}

	public void reverse() {
		int[] temp = new int[count];
		for (int i = 0; i < count; i++) {
			temp[i] = this.arr[count - 1 - i];
		}
		arr = temp;
	}

	public void insertAt(int item, int idx) {

		if (idx < 0 || idx > count - 1)
			throw new IllegalArgumentException();

		if (++count == arr.length) {
			resizeArr();
		}

		for (int i = count - 1; i >= idx; i--) {
			arr[i + 1] = arr[i];
		}
		arr[idx] = item;
	}

	private void resizeArr() {
		int[] temp = new int[this.arr.length * 2];
		for (int i = 0; i < count; i++)
			temp[i] = arr[i];
		this.arr = temp;
	}

	public void print() {
		for (int i = 0; i < count; i++) {
			System.out.println(arr[i]);
		}
	}

}
