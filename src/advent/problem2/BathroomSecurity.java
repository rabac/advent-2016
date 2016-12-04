package advent.problem2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import advent.problem2.Position;

public class BathroomSecurity {

	//
	private static String inputString = "RRLLRLLRULLRUUUDRDLDDLLLDDDDDUUURRRRUUDLRULURRRDRUDRUUDDRUDLLLRLDDDUDRDDRRLLLLRLRLULUURDRURRUULDRRDUDURRUURURDLURULLDUDRDLUUUUDDURRLLLUDLDLRDRRRDULLDLDULLDRLDLDURDLRRULLDDLDRLLLUDDLLRDURULLDDDDDUURURLRLRRDUURUULRLLLULLRLULLUUDRRLLDURLDDDDULUUDLUDDDULRLDURDDRUUDRRUUURLLLULURUDRULDRDUDUDRRDDULRURLLRRLRRLLDLULURDRDRULDRDRURUDLLRRDUUULDDDUURDLULDLRLLURRURLLUDURDDRUDRDLLLLDLRLDLDDRDRRDUUULLUULRRDLURLDULLDLDUUUULLLDRURLRULLULRLULUURLLRDDRULDULRLDRRURLURUDLRRRLUDLDUULULLURLDDUDDLLUDRUDRLDUDURRRRLRUUURLUDDUDURDUDDDLLRLRDDURDRUUDUDRULURLRLDRULDRRLRLDDDRDDDRLDUDRLULDLUDLRLRRRLRDULDDLRRDDLDDULDLLDU\nRULLUDDUDLULRRDLLDRUDLLLDURLLLURDURLRDRRDLRDRDLLURRULUULUDUDDLLRRULLURDRLDURDLDDUURLUURLDLDLRLDRLRUULDRLRLDRLRLUDULURDULLLDRUDULDURURRRUDURDUDLRDRRURULRRLRLRRRRRRDRUDLDRULDRUDLRDLRRUDULDLRLURRRLLDRULULRUDULRLULLRLULDRUDUULLRUULDULDUDDUUULLLDRDDRRDLURUUDRRLRRRDLRRLULLLLDLRUULDLLULURUURURDRURLLDUDRRURRURRUUDDRRDDRRRRUDULULRLUULRRDDRDDLLUDLDLULLRLDRLLUULDURLDRULDDUDRUUUURRLDDUDRUURUDLLDLDLURDLULDRLLLULLLUDLLDLD\nRDLDULURDLULRRDLRLLLULRUULURULLLDLLDDRLLURUUUURDRLURLLRLRLLLULRDLURDURULULDDUDDUDRLRLDLULLURRRUULUDRDURRRUDDDLUDLDLRLRRLLLRUULLLLURRDDDRRRUURULRLDRRRLRLUDDRRULDDDRUUDDRLLDULRLUDUDLDLDDDUDDLLDDRDRDUDULDRRUDRDRRDRLUURDLRDDDULLDRRRRRUDRLURDUURRDDRLUDLURRRLRDDDLRRLUULRLURDUUURRDLDDULLLRURRRUDRLUDLLDDDDDUDDRDULLUUDDURRLULLUDULUUDRLDRRRLLURLRRLLDLLLLUDRUUUDDULLRDLLDUDUDUURRUUUDRUURDRDLLDLDDULLDDRRULDLDDUUURLDLULLLRRLLRDDULLDLDLDDLDLDULURRDURURDRDRRDLR\nRDRLRRUUDRLDUDLLDLUDLUUDUDLRRUUDRDDDLDDLLLRRRUDULLRRRRRURRRLUDDDLRRRRUUULDURDRULLDLRURRUULUDRURRRRLRURLRDUUDUDUDRDDURRURUDLLLLLRURUULRUURLLURDRUURLUDDDRLDDURDLDUDRURDRLRRRRUURDDRRRRURDLUUDRLDRDUULURUDDULLURRDUDLUULLDURRURLUDUUDRDDDUUDDUUUULDLDUDDLUDUUDRURLLULRUUULLRRDDUDDLULDDUUUDLUDDLDDLLRUUDRULLRRDRLLDLLRRLULLRRDDRLRDUULLLUULLDLLUDUDDLRDULUDLDLUDDRRRRDUDLUULLULDLRRDLULRLRRRULRURRDRLULDDUDLDLDULLURLLRDLURRULURDLURLUDRDRRUUDRLLUDDRLRDDUURLRRDUDLDRURDUUUDRRLLRDLDLLDRRURLUDURUULDUDLDDDDRUULLDDRLRURRDURLURRLDDRRRRLRLRDRURUDDRDLDRURLULDDL\nRULRDLDDLRURDDDDDDRURLLLDDDUUULLRRDLDLURUURLUDLURRLUDUURDULDRUULDDURULDUULDDULLLUDLRULDRLDLRDDRRDLDDLLDRRUDDUDRDUULUDLLLDDLUUULDDUUULRRDULLURLULDLRLLLRLURLLRLRLDRDURRDUUDDURRULDDURRULRDRDUDLRRDRLDULULDRDURDURLLLDRDRLULRDUURRUUDURRDRLUDDRRLDLDLULRLLRRUUUDDULURRDRLLDLRRLDRLLLLRRDRRDDLDUULRLRRULURLDRLRDULUDRDLRUUDDDURUDLRLDRRUDURDDLLLUDLRLURDUDUDULRURRDLLURLLRRRUDLRRRLUDURDDDDRRDLDDLLDLRDRDDRLLLURDDRDRLRULDDRRLUURDURDLLDRRRDDURUDLDRRDRUUDDDLUDULRUUUUDRLDDD";

	// "ULL\nRRDDD\nLURDL\nUUUUD";
	private static Map<Position, Integer> values = new HashMap<>();

	private static Map<Position, List<Character>> allowedMoves = new HashMap<>();

	public static void main(String[] args) {
		// initializeValueSquareGrid();
		initializeValueDiamondGrid();
		initializeAllowedMoves();

		String[] input = inputString.split("\n");
		// System.out.println(input.length);
		final Position startPosition = new Position(0, 2);

		int x = startPosition.getxPos();
		int y = startPosition.getyPos();

		for (String nextInput : input) {
			// int position = processSquareGrid(nextInput, x, y);
			int position = processDiamondGrid(nextInput, x, y);
			System.out.print(position);
		}
	}

	private static int processDiamondGrid(String nextInput, int x, int y) {
		int length = nextInput.length();
		for (int index = 0; index < length; index++) {
			char nextChar = nextInput.charAt(index);
			List<Character> allowedCharacters = allowedMoves.get(new Position(x, y));
			if (allowedCharacters.contains(nextChar)) {
				if (nextChar == 'U') {
					y++;
				} else if (nextChar == 'D') {
					y--;
				} else if (nextChar == 'R') {
					x++;
				} else if (nextChar == 'L') {
					x--;
				}
			}
		}
		int value = values.get(new Position(x,y));
		System.out.println("final position: " + new Position(x,y));
		return value;
	}

	private static void initializeAllowedMoves() {

		// grid 5 by 5.
		final int xMax = 5;
		final int yMax = 5;

		for (int indexX = 0; indexX < xMax; indexX++) {
			for (int indexY = 0; indexY < yMax; indexY++) {

				Position position = new Position(indexX, indexY);
				List<Character> possibleMoves = new ArrayList<Character>();
				// try all 4 combinations.
				int temp = indexX - 1;
				if (temp >= 0 && values.get(new Position(temp, indexY)) != -1) {
					possibleMoves.add('L');
				}

				temp = indexX + 1;
				if (temp < 5 && values.get(new Position(temp, indexY)) != -1) {
					possibleMoves.add('R');
				}

				temp = indexY - 1;
				if (temp >= 0 && values.get(new Position(indexX, temp)) != -1) {
					possibleMoves.add('D');
				}

				temp = indexY + 1;
				if (temp < 5 && values.get(new Position(indexX, temp)) != -1) {
					possibleMoves.add('U');
				}

				allowedMoves.put(position, possibleMoves);
			}

		}

		System.out.println(allowedMoves.size());
	}

	// There should also be a computation of allowed moves for a square grid. 
	private static int processSquareGrid(String nextInput, int x, int y) {
		int length = nextInput.length();
		for (int index = 0; index < length; index++) {
			char nextChar = nextInput.charAt(index);
			if (nextChar == 'R') {
				int temp = x + 1;
				if (temp > 2) {
					continue;
				}
				x++;
			} else if (nextChar == 'L') {
				int temp = x - 1;
				if (temp < 0) {
					continue;
				}
				x--;
			} else if (nextChar == 'U') {
				int temp = y + 1;
				if (temp > 2) {
					continue;
				}
				y++;
			} else if (nextChar == 'D') {
				int temp = y - 1;
				if (temp < 0) {
					continue;
				}
				y--;
			}
		}
		Integer position = values.get(new Position(x, y));
		return position;
	}

	private static void initializeValueSquareGrid() {
		values.put(new Position(0, 0), 7);
		values.put(new Position(0, 1), 4);
		values.put(new Position(0, 2), 1);
		values.put(new Position(1, 0), 8);
		values.put(new Position(1, 1), 5);
		values.put(new Position(1, 2), 2);
		values.put(new Position(2, 0), 9);
		values.put(new Position(2, 1), 6);
		values.put(new Position(2, 2), 3);
	}

	private static void initializeValueDiamondGrid() {
		values.put(new Position(0, 0), -1);
		values.put(new Position(0, 1), -1);
		values.put(new Position(0, 2), 5);
		values.put(new Position(0, 3), -1);
		values.put(new Position(0, 4), -1);

		values.put(new Position(1, 0), -1);
		values.put(new Position(1, 1), 10);
		values.put(new Position(1, 2), 6);
		values.put(new Position(1, 3), 2);
		values.put(new Position(1, 4), -1);

		values.put(new Position(2, 0), 13);
		values.put(new Position(2, 1), 11);
		values.put(new Position(2, 2), 7);
		values.put(new Position(2, 3), 3);
		values.put(new Position(2, 4), 1);

		values.put(new Position(3, 0), -1);
		values.put(new Position(3, 1), 12);
		values.put(new Position(3, 2), 8);
		values.put(new Position(3, 3), 4);
		values.put(new Position(3, 4), -1);

		values.put(new Position(4, 0), -1);
		values.put(new Position(4, 1), -1);
		values.put(new Position(4, 2), 9);
		values.put(new Position(4, 3), -1);
		values.put(new Position(4, 4), -1);

	}
}

final class Position {
	int xPos;
	int yPos;

	@Override
	public String toString() {
		return "(" + xPos + "," + yPos + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + xPos;
		result = prime * result + yPos;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (xPos != other.xPos)
			return false;
		if (yPos != other.yPos)
			return false;
		return true;
	}

	public Position(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public void incrementX(int steps) {
		this.xPos = this.xPos + steps;
	}

	public void incrementY(int steps) {
		this.yPos = this.yPos + steps;
	}

	public void decrementX(int steps) {
		this.xPos = this.xPos - steps;
	}

	public void decrementY(int steps) {
		this.yPos = this.yPos - steps;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
}
