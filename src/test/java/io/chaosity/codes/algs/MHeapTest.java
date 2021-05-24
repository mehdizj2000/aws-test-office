package io.chaosity.codes.algs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MHeapTest {

	@Test
	void test() {
		MHeap heap = new MHeap();
		
		heap.insert(30);
		heap.insert(25);
		heap.insert(20);
		
		System.out.println(heap);
		heap.insert(40);
		System.out.println(heap);
		
	}

}
