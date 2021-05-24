package io.chaosity.codes.algs;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class SortingAlgsTest {

	@Test
	void test() {
//		{ 8, 5, 1, 2, 6, 9 }
		int[] arr = { 8, 5, 12, 1, 2, 6, 9 };//{};
//		int[] res = SortingAlgs.bubbleSort(arr);
		
//		int[] res = SortingAlgs.selectionSort(arr);
		
		int[] res = SortingAlgs.bucketSort(arr);

		System.out.println(Arrays.toString(res));
		
	}

}
