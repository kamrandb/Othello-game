package ca.utoronto.utm.assignment1.othello;

import java.util.ArrayList;
import java.util.Random;

/**
 * PlayerRandom makes a move by first determining all possible moves that this
 * player can make, putting them in an ArrayList, and then randomly choosing one
 * of them.
 * 
 *
 */
public class PlayerRandom {
	
	private Othello othello;
	private char player;
	private Random rand = new Random();

	
	public PlayerRandom(Othello Othello, char player) {
		this.othello = Othello;
		this.player = player;
	}
	
	/**
	 * Collects all possible moves for PlayerRandom in ArrayList and returns 
	 * randomly chosen one
	 * @return randomly chosen move
	 */
	private Move randomMove() {
		ArrayList<Move> moves = new ArrayList<Move>();
		for(int row = 0; row < this.othello.Board.getDimension(); row++) {
			for(int col = 0; col < this.othello.Board.getDimension(); col++) {
				if (othello.Board.canMove(row,col, this.player)){
					moves.add(new Move(row, col));
				}
			}
		}
		return moves.get(rand.nextInt(moves.size()));
	}
	
	
	
	
	
	
    /**
     * After collecting all possible moves returns a random one
     * @return Move which is intended to be made by computer
     */
	public Move getMove() {
		return this.randomMove();
	}
}
