package io.chaosity.codes.algs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MAVLTreeTest {

	@Test
	void test() {
		MAVLTree mavlTree = new MAVLTree();
		
		mavlTree.insert(5);
		mavlTree.insert(2);
		mavlTree.insert(10);
		mavlTree.insert(15);
		mavlTree.insert(13);
		mavlTree.insert(8);
		mavlTree.insert(12);
		mavlTree.insert(18);
		mavlTree.insert(17);
		
//		mavlTree.traverseTreeByLevel();
		
//		System.out.println(mavlTree.max());
//		
		System.out.println(mavlTree.findAncestors(18));
		
//		mavlTree.traverse();
	}

}
