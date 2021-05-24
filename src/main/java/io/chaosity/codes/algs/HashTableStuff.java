package io.chaosity.codes.algs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashTableStuff {

	public static char findFirstNoneRepeatedCharacter(String str) {

		Map<Character, Integer> map = new HashMap<>();

		for (char ch : str.toCharArray()) {
			var count = map.containsKey(ch) ? map.get(ch) : 0;
			map.put(ch, count + 1);
		}

		for (char ch : str.toCharArray())
			if (map.get(ch) == 1)
				return ch;

		return '\\';

	}

	public static char findFirstRepeatedCharacter(String str) {

		Set<Character> map = new HashSet<>();

		for (char ch : str.toCharArray()) {
			if (map.contains(ch))
				return ch;
			map.add(ch);
		}

		return '\\';

	}

}
