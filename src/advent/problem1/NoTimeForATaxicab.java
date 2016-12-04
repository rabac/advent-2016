package advent.problem1;

import java.util.ArrayList;
import java.util.List;

import advent.problem1.Instruction.Direction;

public class NoTimeForATaxicab {

	public enum Navigation {
		NORTH, SOUTH, EAST, WEST;
	}

	public static void main(String[] args) {

		String inputString = "R4, R3, R5, L3, L5, R2, L2, R5, L2, R5, R5, R5, R1, R3, L2, L2, L1, R5, L3, R1, L2, R1, L3, L5, L1, R3, L4, R2, R4, L3, L1, R4, L4, R3, L5, L3, R188, R4, L1, R48, L5, R4, R71, R3, L2, R188, L3, R2, L3, R3, L5, L1, R1, L2, L4, L2, R5, L3, R3, R3, R4, L3, L4, R5, L4, L4, R3, R4, L4, R1, L3, L1, L1, R4, R1, L4, R1, L1, L3, R2, L2, R2, L1, R5, R3, R4, L5, R2, R5, L5, R1, R2, L1, L3, R3, R1, R3, L4, R4, L4, L1, R1, L2, L2, L4, R1, L3, R4, L2, R3, L1, L5, R4, R5, R2, R5, R1, R5, R1, R3, L3, L2, L2, L5, R2, L2, R5, R5, L2, R3, L5, R5, L2, R4, R2, L1, R3, L5, R3, R2, R5, L1, R3, L2, R2, R1";

		// parse the problem set into instructions.
		String[] input = inputString.split(",");
		List<Instruction> instruction;
		if (input != null) {
			instruction = new ArrayList<Instruction>(input.length);
			for (String singleInput : input) {
				singleInput = singleInput.trim();
				if (singleInput != null) {
					Instruction nextInstruction = new Instruction();
					nextInstruction.setMove(singleInput.substring(0, 1));

					String stepsString = singleInput.substring(1, singleInput.length());
					int steps = Integer.parseInt(stepsString);
					nextInstruction.setSteps(steps);

					instruction.add(nextInstruction);
				}
			}
		} else {
			// there can be more corner cases, but for now this should suffice.
			return;
		}

		final Position originPosition = new Position(0, 0);
		Position currentPosition = new Position(0, 0);
		Navigation currentNavigation = Navigation.NORTH;
		List<Position> snake = new ArrayList<Position>();
		snake.add(originPosition);

		// process the instructions.
		for (Instruction nextInstruction : instruction) {
			Position startPosition = new Position(currentPosition.getxPos(), currentPosition.getyPos());
			int steps = nextInstruction.getSteps();
			Navigation nextNavigation = getDirection(nextInstruction, currentNavigation);
			if (nextNavigation == Navigation.EAST) {
				currentPosition.incrementX(steps);
			} else if (nextNavigation == Navigation.WEST) {
				currentPosition.decrementX(steps);
			} else if (nextNavigation == Navigation.NORTH) {
				currentPosition.incrementY(steps);
			} else if (nextNavigation == Navigation.SOUTH) {
				currentPosition.decrementY(steps);
			}
			currentNavigation = nextNavigation;
			Position endPosition = new Position(currentPosition.getxPos(), currentPosition.getyPos());

			List<Position> currentMovePath = getPath(startPosition, endPosition, nextNavigation);
			Position collision = checkPathCollision(snake, currentMovePath);
			snake.addAll(currentMovePath);
			if (collision == null) {
				int blocks = Math.abs(endPosition.getxPos()) + Math.abs(endPosition.getyPos());
				System.out.println("status: " + endPosition.getxPos() + "," + endPosition.getyPos() + ":"
						+ nextNavigation.name() + ":" + blocks);
			} else {
				int blocks = Math.abs(collision.getxPos()) + Math.abs(collision.getyPos());
				System.out.println("status: " + collision.getxPos() + "," + collision.getyPos() + ":"
						+ nextNavigation.name() + ":" + blocks);
				// to solve second part of the problem, add the return here, so
				// on first collision, we terminate the program.
				// return;
			}
		}
	}

	private static List<Position> getPath(Position startPosition, Position endPosition, Navigation direction) {
		List<Position> path = new ArrayList<Position>();
		if (direction == Navigation.NORTH || direction == Navigation.SOUTH) {
			// x is constant. y is changing.
			int xPos = startPosition.getxPos();
			int startYPos = startPosition.getyPos();
			int endYPos = endPosition.getyPos();
			if (startYPos < endYPos) {
				for (int currentYPos = startYPos + 1; currentYPos <= endYPos; currentYPos++) {
					Position p = new Position(xPos, currentYPos);
					path.add(p);
				}
			} else {
				for (int currentYPos = startYPos - 1; currentYPos >= endYPos; currentYPos--) {
					Position p = new Position(xPos, currentYPos);
					path.add(p);
				}
			}
		} else if (direction == Navigation.EAST || direction == Navigation.WEST) {
			// y is constant. x is changing.
			int yPos = startPosition.getyPos();
			int startXPos = startPosition.getxPos();
			int endXPos = endPosition.getxPos();
			if (startXPos < endXPos) {
				for (int currentXPos = startXPos + 1; currentXPos <= endXPos; currentXPos++) {
					Position p = new Position(currentXPos, yPos);
					path.add(p);
				}
			} else {
				for (int currentXPos = startXPos - 1; currentXPos >= endXPos; currentXPos--) {
					Position p = new Position(currentXPos, yPos);
					path.add(p);
				}
			}
		}
		return path;
	}

	private static Position checkPathCollision(List<Position> snake, List<Position> currentMovePath) {
		System.out.println("snake: " + snake);
		Position collision = null;
		if (!snake.isEmpty()) {
			for (Position currentPosition : currentMovePath) {
				if (snake.contains(currentPosition)) {
					collision = currentPosition;
					break;
				}
			}
		}
		return collision;
	}

	private static Navigation getDirection(Instruction nextInstruction, Navigation map) {
		Direction nextDirection = nextInstruction.getMove();
		if (map == Navigation.NORTH && nextDirection == Direction.RIGHT) {
			return Navigation.EAST;
		} else if (map == Navigation.NORTH && nextDirection == Direction.LEFT) {
			return Navigation.WEST;
		} else if (map == Navigation.SOUTH && nextDirection == Direction.RIGHT) {
			return Navigation.WEST;
		} else if (map == Navigation.SOUTH && nextDirection == Direction.LEFT) {
			return Navigation.EAST;
		} else if (map == Navigation.WEST && nextDirection == Direction.RIGHT) {
			return Navigation.NORTH;
		} else if (map == Navigation.WEST && nextDirection == Direction.LEFT) {
			return Navigation.SOUTH;
		} else if (map == Navigation.EAST && nextDirection == Direction.RIGHT) {
			return Navigation.SOUTH;
		} else {
			// (map == Map.EAST && nextDirection == Direction.L)
			return Navigation.NORTH;
		}
	}
}

final class Instruction {
	public enum Direction {
		LEFT, RIGHT;
	}

	Direction move;
	int steps;

	public Direction getMove() {
		return move;
	}

	public void setMove(String move) {
		if (move.equals("L")) {
			this.move = Direction.LEFT;
		} else if (move.equals("R")) {
			this.move = Direction.RIGHT;
		}
	}

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
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
