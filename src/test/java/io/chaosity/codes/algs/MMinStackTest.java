package io.chaosity.codes.algs;

import org.junit.jupiter.api.Test;

class MMinStackTest {

	@Test
	void test() {
		MMinStack minStack = new MMinStack();
		minStack.push(5);
		minStack.push(2);
		minStack.push(10);
		minStack.push(1);
		
		System.out.println(minStack);
	}

}
