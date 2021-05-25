package io.chaosity.codes.algs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MTrieTest {

	@Test
	void findPattern() {
//		List<Character> codeList = List.of('a', 'a', 'b', '@', 'b');
//		List<Character> shoppingCart = List.of('a', 'b', 'a', 'b', 'o', 'b');
		char[] pat = { 'a', '@', 'b' };
		char[] txt = { 'a', 'b', 'b', 'a', 'o', 'b' };
		int M = pat.length;
		int N = txt.length;
		char ignoreChar = '@';
		/* A loop to slide pat one by one */
		for (int i = 0; i <= N - M; i++) {
			int j;
			/*
			 * For current index i, check for pattern match
			 */
			for (j = 0; j < M; j++) {
				if (pat[j] == ignoreChar)
					continue;
				if (txt[i + j] != pat[j])
					break;
			}
			if (j == M) // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
				System.out.println("Pattern found at index " + i);
		}
	}

	@Test
	void bribeStuff() {
//		List<Integer> list = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8);
//		List<Integer> list = Arrays.asList(4, 1, 2, 3);
//		List<Integer> list = Arrays.asList(2, 1, 5, 3, 4);
		List<Integer> list = Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4);
		Integer[] arr = list.toArray(new Integer[0]);
		int bribes = 0;
		for (int i = 0; i < arr.length; i++) {
			int diff = arr[i] - i - 1;
			if (diff > 2) {
				System.out.println("Too chaotic");
				return;
			}

			bribes += diff < 0 ? 0 : diff;
		}

		System.out.println(bribes);

	}

	@Test
	void leftRotation() {
		var rotation = 4;
		int[] arr = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(arr));

		while (rotation-- > 0) {
			var temp = arr[0];
			for (int i = 0; i < arr.length - 1; i++) {
				arr[i] = arr[i + 1];
			}
			arr[arr.length - 1] = temp;
		}
		List<Integer> list = new ArrayList<>();
		for (int item : arr) {
			list.add(item);
		}
		System.out.println(list);
	}

	private void swap(int[] arr, int first, int second) {
		var temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}

	@Test
	void test() {
		MTrie mTrie = new MTrie();
		mTrie.insert("carry");
		mTrie.insert("carve");
		mTrie.insert("carol");
		mTrie.insert("carrot");
		mTrie.insert("career");
		mTrie.insert("carton");
		mTrie.insert("carter");
		mTrie.insert("cart");
		mTrie.insert("carpet");

		mTrie.insert("cereel");
		mTrie.insert("certain");
		mTrie.insert("ceramic");
		mTrie.insert("certify");

		mTrie.insert("mention");
		mTrie.insert("mermaid");
		mTrie.insert("medicine");
		mTrie.insert("memorial");

		List<List<String>> listOfList = new ArrayList<>();

//		System.out.println(mTrie.findWords("cer"));

		String pi = "";
		for (char ch : "cert".toCharArray()) {
			pi += ch;
			if (pi.length() > 2)
				listOfList.add(mTrie.findWords(pi));
		}

		listOfList.forEach(System.out::println);

	}

}
