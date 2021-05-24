package io.chaosity.codes.algs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class MHashTable {

	public static int mostFrequent(int[] items) {
//		[1, 2, 2, 3, 3, 3, 4]

		Map<Integer, Integer> map = new HashMap<>();

		for (int item : items)
			map.put(item, map.containsKey(item) ? map.get(item) + 1 : 1);

		int key = -1;
		int max = 0;
		for (Map.Entry<Integer, Integer> entr : map.entrySet()) {
			if (entr.getValue() > max) {
				max = entr.getValue();
				key = entr.getKey();
			}
		}

		return key;
	}

	public static int countPairsWithDiff(int[] items, int k) {
		var count = 0;

		Set<Integer> ints = new HashSet<>();
		for (int item : items)
			ints.add(item);

		for (int item : items)
			if (ints.contains(item + k) || ints.contains(item - k))
				count++;

		return count;
	}

	public static int[] twoSum(int[] items, int target) {
		int[] sumIndex = new int[2];

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < items.length; i++) {
			var complement = target - items[i];
			if (map.containsKey(complement))
				return new int[] { i, map.get(complement) };
			map.put(complement, i);
		}

		return sumIndex;
	}

	private class Entry {
		private int key;
		private String value;

		public Entry(int key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

	}

	LinkedList<Entry>[] arr = new LinkedList[5];

	public void put(int key, String value) {
		int hash = this.toHash(key);
		if (arr[hash] == null)
			arr[hash] = new LinkedList<Entry>();

		for (Entry jfg : arr[hash]) {
			if (jfg.key == key)
				return;
		}

		arr[hash].addLast(new Entry(key, value));
	}

	public String get(int key) {
		int hash = this.toHash(key);

		if (arr[hash] == null)
			return null;

		LinkedList<Entry> entries = arr[hash];

		for (Entry ent : entries) {
			if (ent.key == key)
				return ent.value;
		}

		return null;
	}

	public String remove(int key) {
		int hash = this.toHash(key);

		if (arr[hash] == null)
			return null;

		LinkedList<Entry> entries = arr[hash];

		boolean found = false;
		var counter = 0;
		for (Entry ent : entries) {

			if (ent.key == key) {
				found = true;
				break;
			}
			counter++;
		}

		return found ? entries.remove(counter + 1).value : null;

	}

	private int toHash(int key) {
		return Math.abs(key) % arr.length;
	}

}
