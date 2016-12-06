package advent.problem5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class NiceGameOfChess {

	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {

		final String doorId = "wtnhxymk";
		char[] result = new char[] { '-', '-', '-', '-', '-', '-', '-', '-' };
		final int outputSize = 8;

		for (int count = 0;; count++) {

			String inputForDigest = doorId + Integer.valueOf(count);
			byte[] inputForDigestBytes = inputForDigest.getBytes("UTF-8");

			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] digest = md.digest(inputForDigestBytes);

			byte zero = 0;
			if (digest[0] == zero && digest[1] == zero) {
				String thirdHex = String.format("%02X", digest[2]);
				if (thirdHex.substring(0, 1).equals("0")) {

					String positionStr = thirdHex.substring(1, 2);
					int position;
					try {
						position = Integer.parseInt(positionStr);
					} catch(NumberFormatException e) {
						continue;
					}
					
					String fourthHex = String.format("%02X", digest[3]);
					char subResult = fourthHex.charAt(0);

					if (position < 8 && position >= 0 && result[position] == '-') {
						result[position] = subResult;
						String resultStr = String.valueOf(result); 
						System.out.println(count + ":" + position + ":" + resultStr);
						if (!resultStr.contains("-")) {
							break;
						}
					}
				}
			}
		}

		System.out.println(result);
	}
}
