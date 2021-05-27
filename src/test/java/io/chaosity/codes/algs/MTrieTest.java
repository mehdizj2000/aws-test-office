package io.chaosity.codes.algs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	void abbreviation() {

		String a = "daBcd";
		String b = "ABC";
		if (a.length() < b.length()) {
			System.out.println("NO");
		}

		boolean[][] dp = new boolean[a.length() + 1][b.length() + 1];

		for (int i = 0; i <= a.length(); i++) {
			for (int j = 0; j <= b.length(); j++) {
				if (j > i) {
					dp[i][j] = false;
				} else if (i == 0 && j == 0) {
					dp[i][j] = true;
				} else if (j == 0) {
					dp[i][j] = !Character.isUpperCase(a.charAt(i - 1)) && dp[i - 1][j];
				} else if (Character.isUpperCase(a.charAt(i - 1))) {
					boolean tmp = a.charAt(i - 1) == b.charAt(j - 1) && dp[i - 1][j - 1];
					dp[i][j] = tmp;
				} else {
					boolean tmp = (Character.toUpperCase(a.charAt(i - 1)) == b.charAt(j - 1)) && dp[i - 1][j - 1];
					boolean tmp2 = (tmp || dp[i - 1][j]);
					dp[i][j] = tmp2;
				}
			}
		}

		String res = dp[a.length()][b.length()] ? "YES" : "NO";
		System.out.println(res);
	}

	@Test
	void abbreviation2() {

		String a = "daBcd";
		String b = "ABC";
		boolean[][] isValid = new boolean[a.length() + 1][b.length() + 1];
		isValid[0][0] = true;
		for (int i = 1; i <= a.length(); i++) {
			if (Character.isUpperCase(a.charAt(i - 1))) {
				isValid[i][0] = false;
			} else
				isValid[i][0] = true;
		}
		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					isValid[i][j] = isValid[i - 1][j - 1];
				} else if (Character.toUpperCase(a.charAt(i - 1)) == b.charAt(j - 1)) {
					isValid[i][j] = isValid[i - 1][j - 1] || isValid[i - 1][j];
				} else if (Character.isUpperCase(a.charAt(i - 1))) {
					isValid[i][j] = false;
				} else {
					isValid[i][j] = isValid[i - 1][j];
				}
			}
		}

		String res = isValid[a.length()][b.length()] ? "YES" : "NO";
		System.out.println(res);
	}

	@Test
	void countTriplet() {
//		List<Long> arr = Arrays.asList(1l, 4l, 16l, 64l);
		List<Long> arr = Arrays.asList(1l, 3l, 9l, 9l, 27l, 81l);
		int r = 3;
		Map<Long, Long> nextMap = new HashMap<>();
		for (long item : arr)
			nextMap.put(item, nextMap.getOrDefault(item, 0l) + 1);

		Map<Long, Long> prevMap = new HashMap<>();
		long sum = 0;
		for (long item : arr) {

			long prev_count = 0;
			long next_count = 0;

			nextMap.put(item, nextMap.getOrDefault(item, 0l) - 1);
			if (prevMap.containsKey(item / r) && item % r == 0) {
				prev_count = prevMap.get(item / r);
			}

			if (nextMap.containsKey(item * r)) {
				next_count = nextMap.get(item * r);
			}

			sum += prev_count * next_count;

			prevMap.put(item, prevMap.getOrDefault(item, 0l) + 1);

		}

		System.out.println(sum);

	}

	@Test
	void SherlockAndAnagram() {

		String s = "abba";

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				char[] arr = s.substring(i, j + 1).toCharArray();
				Arrays.sort(arr);
				String str = new String(arr);
				map.put(str, map.containsKey(str) ? map.get(str) + 1 : 1);
			}
		}

		int result = 0;
		for (String str : map.keySet()) {
			int occurances = map.get(str);
			result += occurances * (occurances - 1) / 2;
		}

		System.out.println(map);
		System.out.println(result);

	}

	@Test
	void bribeStuff() {
//		int[] arr = { 1, 2, 5, 3, 7, 8, 6, 4 };// list.toArray(new Integer[0]);
		int[] arr = { 1, 2, 3, 5, 7, 8, 6, 4 };
//		int[] init = { 1, 2, 3, 4, 5, 6, 7, 8 };

		int bribes = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] != i + 1) {
				if (i - 1 >= 0 && arr[i - 1] == i + 1) {
					bribes++;
					swap(arr, i, i - 1);
				} else if (i - 1 >= 0 && arr[i - 2] == i + 1) {
					bribes += 2;
					swap(arr, i - 2, i - 1);
					swap(arr, i - 1, i);
				} else {
					System.out.println("Too chaotic");
					return;
				}

			}
		}

		System.out.println(bribes);

	}

	@Test
	void minimumSwap() {
//		int[] arr = { 7, 1, 3, 2, 4, 5, 6 };
//		int[] arr = { 4, 3, 1, 2 };
		int[] arr = { 1, 3, 5, 2, 4, 7 };
		int swaps = 0;
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i; j < arr.length; j++)
				if (arr[j] < arr[minIndex])
					minIndex = j;
			if (i != minIndex) {
				swaps++;
				swap(arr, minIndex, i);
			}
//			if (sorted)
//				break;
		}
		System.out.println(swaps);
		System.out.println(Arrays.toString(arr));
	}

	@Test
	void minimumSwap2() {
//		int[] arr = { 7, 1, 3, 2, 4, 5, 6 };
		int[] arr = { 4, 3, 1, 2 };
//		int[] arr = { 1, 3, 5, 2, 4, 7 };
//		int swaps = sort(arr, 0, arr.length - 1);

		int swaps = 0;

		int i = 0;
		while (i < arr.length) {
			if (arr[i] != i + 1) {
				if (arr[i] - 1 < arr.length) {
					var temp = arr[arr[i] - 1];
					arr[arr[i] - 1] = arr[i];
					arr[i] = temp;
					swaps++;
					i--;
				}
			}
			i++;
		}
		System.out.println(swaps);
		System.out.println(Arrays.toString(arr));
	}

	@Test
	void maxArraySum() {
		int max = maxArraySumSol();

	}

	private int maxArraySumSol() {
		int[] arr = new int[10];
		int size = arr.length;
		if (size == 0 || size == 2)
			return 0;
		if (size == 1)
			return arr[1];

		int[] dp = new int[size];
		dp[0] = Math.max(Integer.MIN_VALUE, arr[0]);
		dp[1] = Math.max(dp[0], arr[1]);

		for (int i = 2; i < size; i++) {
			dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]);
		}

		return dp[size - 1];

	}

	@Test
	void arrayManipulation() {
		List<List<Integer>> list = new ArrayList<>();
		int n = 10;
		long[] arr = new long[n];
		for (List<Integer> operation : list) {
			Integer[] query = operation.toArray(new Integer[0]);
			int start = query[0] - 1;// a - 1;
			int end = query[1] - 1;// b - 1;
			long v = query[2];
			arr[start] += v;
			if (end + 1 < arr.length)
				arr[end + 1] -= v;
		}
		long sum = 0;
		long max = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum > max)
				max = sum;
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(max);
	}

	@Test
	void commonSubString() {
		String a = "hackerrankcommunity";
		String b = "cdecdecdecde";
		char[] aChars = a.toCharArray();
		char[] bChars = b.toCharArray();
		int i = 0;
		boolean[] ref = new boolean[26];
		for (int k = 0; k < aChars.length; k++)
			ref[aChars[k] - 'a'] = true;
		int j = 0;
		while (j < bChars.length) {
			if (ref[aChars[i] - 'a']) {
				System.out.println("YES");
				break;
			}
			j++;
		}
		System.out.println("NO");
	}

	private int sort(int[] arr, int start, int end) {
		if (start >= end)
			return 0;
		int swaps = 0;
		int boundry = start - 1;
		int pivot = arr[end];
		for (int i = start; i <= end; i++) {
			if (arr[i] <= pivot) {
				boundry++;
				if (boundry != i) {
					swaps++;
					swap(arr, i, boundry);
				}
			}
		}
		sort(arr, start, boundry - 1);
		sort(arr, boundry + 1, end);
		return swaps;
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
		var temp = arr[second];
		arr[second] = arr[first];
		arr[first] = temp;
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
