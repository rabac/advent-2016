package advent.problem3;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SquaresWithThreeSides {

	public static void main(String[] args) throws IOException {

		// mode 0 is horizontal triangle lengths. mode 1 is vertical lengths.
		int mode = 0;
		Scanner in = new Scanner(new FileReader(".\\src\\advent\\problem3\\input.txt"));

		int rowCount = 0;

		while (in.hasNextLine()) {
			rowCount++;
			in.nextLine();
		}

		final int groupSize = rowCount; 
		final int size = groupSize * 3;
		System.out.println(size);
		int[] lengths = new int[size];

		rowCount = 0;
		in.close();

		in = new Scanner(new FileReader(".\\src\\advent\\problem3\\input.txt"));

		while (in.hasNextLine()) {
			String nextLine = in.nextLine();
			String[] allLengths = nextLine.trim().split("\\s+");

			int side1 = Integer.parseInt(allLengths[0]);
			int side2 = Integer.parseInt(allLengths[1]);
			int side3 = Integer.parseInt(allLengths[2]);
			if (mode == 0) {
				lengths[rowCount] = side1;
				lengths[rowCount + 1] = side2;
				lengths[rowCount + 2] = side3;
				rowCount = rowCount + 3;
			} else if (mode == 1) {
				lengths[rowCount + groupSize*0] = side1;
				lengths[rowCount + groupSize*1] = side2;
				lengths[rowCount + groupSize*2] = side3;
				rowCount = rowCount + 1;
			}
		}

		int triangles = 0;
		for (int indexCount = 0; indexCount < size ; indexCount = indexCount + 3) {
			int side1 = lengths[indexCount];
			int side2 = lengths[indexCount + 1];
			int side3 = lengths[indexCount + 2];
			
			System.out.println(side1 + ":" + side2 + ":" + side3);
			if ((side1 + side2 > side3) && (side2 + side3 > side1) && (side3 + side1 > side2)) {
				triangles++;
			}
		}
		System.out.println(triangles);
		in.close();
	}
}
