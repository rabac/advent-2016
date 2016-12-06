package advent.problem6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignalsAndNoise {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new FileReader(".\\src\\advent\\problem6\\input.txt"));

		final int columnCount = 8; 
		int rowCount = 0;
		while (in.hasNextLine()) {
			in.nextLine();
			rowCount++; 
		}
		
		char[][] allChars = new char[rowCount][columnCount];
		in.close(); 
		in = new Scanner(new FileReader(".\\src\\advent\\problem6\\input.txt"));
		
		for (int count = 0; count < rowCount; count++) {
			String encoded = in.nextLine();
			char[] encodedChars = encoded.toCharArray();
			allChars[count] = encodedChars;
		}
		in.close();
		
		String result = "";

		for (int count = 0; count < columnCount; count++) {
			char[] column = getColumn(count, rowCount, allChars);
			String mostFrequent = getMostFrequent(String.copyValueOf(column));
			result = result.concat(mostFrequent);
		}
		
		System.out.println(result);
	}

	
	private static String getMostFrequent(String encryptedName) {

		Map<String, Integer> sortedCharMap = new LinkedHashMap<String, Integer>();
		Map<String, Integer> occurences = new HashMap<>();
		String[] letters = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };

		for (String letter : letters) {
			Pattern pattern = Pattern.compile(letter);

			int count = 0;
			Matcher matcher = pattern.matcher(encryptedName);
			while (matcher.find()) {
				count++;
			}
			occurences.put(letter, count);
		}

		// get the most frequent. 
		// Collections.reverseOrder(Comparator.comparing())
		occurences.entrySet().stream().sorted(Comparator.comparing(e -> e.getValue()))
				.limit(1).forEachOrdered(e -> sortedCharMap.put(e.getKey(), e.getValue()));

		Set<String> keySet = sortedCharMap.keySet();
		String actual = "";
		for (String key : keySet) {
			actual = actual.concat(key);
		}

		return actual; 
	}

	private static char[] getColumn(int columnIndex, int rowCount, char[][] allChars) {

		char[] colArray = new char[rowCount];
		for(int row = 0; row < rowCount; row++)
		{
		    colArray[row] = allChars[row][columnIndex];
		}
		return colArray;
	}
}
