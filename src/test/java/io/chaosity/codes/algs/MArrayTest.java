package io.chaosity.codes.algs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MArrayTest {

	@Test
	void testInsertArrayResize() {
		MArray marray = new MArray(3);
		marray.insert(10);
		marray.insert(20);
		marray.insert(30);
		marray.insert(40);
		marray.insert(50);

//		int[] otherArray = new int[] {25,20,15,30};

//		marray.intersect(otherArray).print();

//		marray.reverse();
		marray.insertAt(25, 2);
		marray.print();

	}

}
