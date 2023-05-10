package com.solvd.ta.lab3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

public class UniqueWords {

	public static void main(String[] args) throws IOException {
		File file = new File("src/resources/words.txt");
		File result = new File("src/resources/result.txt");
		String content = FileUtils.readFileToString(file, StandardCharsets.UTF_8.name());
		String[] words = StringUtils.split(content);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int unique = 0;

		// loop through array of words and add it to the map
		for (String word : words) {
			// removes 0-9 ."()%-
			word = RegExUtils.replacePattern(word, "[0-9.,\"()%-]", "");
			word = StringUtils.lowerCase(word);

			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			} else {
				map.put(word, 1);
			}
		}

		// loop through map to count unique words
		for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				unique++;
			}
		}
		System.out.println("Number of unique words: " + unique);
		FileUtils.writeStringToFile(result, String.valueOf(unique), StandardCharsets.UTF_8.name());
	}
}
