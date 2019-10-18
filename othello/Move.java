package ca.utoronto.utm.assignment1.othello;
/**
 * This class represent move. Holds row and column of the move
 * in it's instance variables.
 * 
 *
 */
// TODO: Javadoc this class
public class Move {
	private int row, col;

	public Move(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
/**
 * String representation of the move
 */
	public String toString() {
		return "(" + this.row + "," + this.col + ")";
	}

}
