package io.chaosity.codes.algs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.jupiter.api.Test;

class MQueueTests {

	@Test
	void test() {
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		
		System.out.println(queue);
		queue =  MQueueReverser.reverse(queue);
		
		System.out.println(queue);
	}
	
	@Test
	void kjhsdfkjdhf() {
		MStackOfTwoQueues mStackOfTwoQueues =  new MStackOfTwoQueues();
		mStackOfTwoQueues.push(10);
		mStackOfTwoQueues.push(20);
		mStackOfTwoQueues.push(30);
		mStackOfTwoQueues.push(40);
		
		System.out.println(mStackOfTwoQueues.pop());
		System.out.println(mStackOfTwoQueues.peek());
		System.out.println(mStackOfTwoQueues.pop());
	}
	
	@Test
	void jywsgdfjhgsdf() {
		
//		System.out.println(7%8);
//		System.out.println(8%8);
//		System.out.println(9%8);
		
//		ArrayQueue arrayQueue = new ArrayQueue(5);
//		arrayQueue.enqueue(10);
//		arrayQueue.enqueue(20);
//		arrayQueue.enqueue(30);
//		
//		System.out.println(arrayQueue);
//		
//		System.out.println(arrayQueue.dequeue());
//		System.out.println(arrayQueue.dequeue());
//		System.out.println(arrayQueue.dequeue());
		
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		queue.add(6);
		queue.add(7);
		System.out.println(queue);
		queue = MPQueue.reverseKItems(queue, 3);
		System.out.println(queue);
		
	}
	
	@Test
	void jsdghfjhwgfjhwg(){
		
		MPQueue mpQueue = new MPQueue();
		mpQueue.insert(1);
		mpQueue.insert(7);
		mpQueue.insert(3);
		mpQueue.insert(4);
		
		System.out.println(mpQueue);
		
	}

}
