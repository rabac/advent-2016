package advent.problem4;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecurityThroughObscurity {

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(new FileReader(".\\src\\advent\\problem4\\input.txt"));

		int total = 0;
		while (in.hasNextLine()) {

			String encrypted = in.next();

			Pattern numberOnlyPattern = Pattern.compile("\\d+");

			Matcher matcher = numberOnlyPattern.matcher(encrypted);
			matcher.find();
			String sectorIdStr = matcher.group();
			int sectorId = Integer.valueOf(sectorIdStr);
			String[] letters = numberOnlyPattern.split(encrypted);
			String encryptedName = letters[0];
			String checksum = letters[1];

			checksum = checksum.substring(1, checksum.length() - 1);
			encryptedName = encryptedName.replaceAll("-", "");
			boolean decryptMatched = decrypt(encryptedName, sectorId);
			if (decryptMatched) {
				System.out.println("North Pole objects: " + sectorId);
				return;
			}
			boolean topFiveMatch = getMostFrequent(encryptedName, checksum);
			if (topFiveMatch) {
				total = total + sectorId;
			}
			// System.out.println(sectorId + ": " + encryptedName + " : "+
			// topFiveMatch);
		}
		System.out.println(total);
	}

	private static boolean decrypt(String encryptedName, int sectorId) {
		final String target = "northpoleobjectstorage";

		final String alphabet = "abcdefghijklmnopqrstuvwxyz";
		final char[] alphabetArray = alphabet.toCharArray();
		final int alphabetCount = alphabet.length();
		int reducedSectorId = sectorId % alphabetCount;

		char[] encrypted = encryptedName.toCharArray();
		char[] decrypted = new char[encrypted.length];
		int count = 0;
		for (char encryptedChar : encrypted) {
			int position = alphabet.indexOf(encryptedChar);
			position = (position + reducedSectorId) % alphabetCount;
			char decryptedChar = alphabetArray[position];
			decrypted[count] = decryptedChar;
			count++;
		}

		String decryptedStr = new String(decrypted);

		System.out.println(encryptedName + " : " + decryptedStr + " : " + reducedSectorId);

		return target.equals(decryptedStr); 
	}

	private static boolean getMostFrequent(String encryptedName, String checksum) {

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

		// get the most frequent 5. 
		occurences.entrySet().stream().sorted(Collections.reverseOrder(Comparator.comparing(e -> e.getValue())))
				.limit(5).forEachOrdered(e -> sortedCharMap.put(e.getKey(), e.getValue()));

		Set<String> keySet = sortedCharMap.keySet();
		String actual = "";
		for (String key : keySet) {
			actual = actual.concat(key);
		}

		return actual.equals(checksum); 
	}
}
