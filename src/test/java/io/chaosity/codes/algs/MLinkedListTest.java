package io.chaosity.codes.algs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MLinkedListTest {

	@Test
	void test() {
		MLinkedList linkList = new MLinkedList();
		
		linkList.addLast(10);
		linkList.addLast(20);
		linkList.addLast(30);
		linkList.addLast(40);
		linkList.addLast(50);
		linkList.addLast(60);
		linkList.addLast(70);
		linkList.addLast(80);

		
//		linkList.reverse();
		
		System.out.println(linkList.findKthFromTheEnd(6));
		
		
	}

}
