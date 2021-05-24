package io.chaosity.codes.algs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MTwoStacksTest {

	@Test
	void test() {
		MTwoStacks mTwoStacks = new MTwoStacks(10);
		
		mTwoStacks.push1(10);
		mTwoStacks.push1(20);
		mTwoStacks.push1(30);
		mTwoStacks.push1(40);
		mTwoStacks.push2(15);
		mTwoStacks.push2(25);
//		mTwoStacks.push1(40);
//		mTwoStacks.push1(45);
//		mTwoStacks.push1(50);
		
		System.out.println(mTwoStacks.pop2());
		System.out.println(mTwoStacks.pop1());
		System.out.println(mTwoStacks.pop2());
		
		System.out.println(mTwoStacks);
	}

}
