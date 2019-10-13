package ca.utoronto.utm.assignment1.othello;

/**
 * The goal here is to print out the probability that Random wins and Greedy
 * wins as a result of playing 10000 games against each other with P1=Random and
 * P2=Greedy. What is your conclusion, which is the better strategy? 
 * @author arnold
 * After executing 10 trials with each try consisting summation of results of 10000 games 
 * Random player has probability of winning .38, whereas Greedy player distinguished 
 * itself by probability of winning .62. Also different trial have been experimented 
 * by changing number of games to 10, 100, 100 and 100000. Overall figures were similar
 * roughly .4 versus.6
 * Therefore the conclusion if Greedy has better chances to win the game. 
 * @author Kamran
 *
 */
public class OthelloControllerRandomVSGreedy {
	protected Othello othello;
	PlayerRandom player1;
	PlayerGreedy player2;

	/**
	 * Constructs a new OthelloController with a new Othello game, where computer plays against 
	 * computer in such arrangement that P1 has random strategy and P2 greedy.
	 */
	public OthelloControllerRandomVSGreedy() {
		
		this.othello = new Othello();
		this.player1 = new PlayerRandom(this.othello, OthelloBoard.P1);
		this.player2 = new PlayerGreedy(this.othello, OthelloBoard.P2);
	}

	public void play() {
		
		while (!othello.isGameOver()) {
			this.report();

			Move move = null;
			char whosTurn = othello.getWhosTurn();

			if (whosTurn == OthelloBoard.P1)
				move = player1.getMove();
			if (whosTurn == OthelloBoard.P2)
				move = player2.getMove();

			this.reportMove(whosTurn, move);
			othello.move(move.getRow(), move.getCol());
		}
		this.reportFinal();
	}

	private void reportMove(char whosTurn, Move move) {
		System.out.println(whosTurn + " makes move " + move + "\n");
	}

	private void report() {
		
		String s = othello.getBoardString() + OthelloBoard.P1 + ":" 
				+ othello.getCount(OthelloBoard.P1) + " "
				+ OthelloBoard.P2 + ":" + othello.getCount(OthelloBoard.P2) + "  " 
				+ othello.getWhosTurn() + " moves next";
		System.out.println(s);
	}

	private void reportFinal() {
		
		String s = othello.getBoardString() + OthelloBoard.P1 + ":" 
				+ othello.getCount(OthelloBoard.P1) + " "
				+ OthelloBoard.P2 + ":" + othello.getCount(OthelloBoard.P2) 
				+ "  " + othello.getWinner() + " won\n";
		System.out.println(s);
	}
	

	/**
	 * Run main to execute the simulation and print out the two line results.
	 * Output looks like: 
	 * Probability P1 wins=.75 
	 * Probability P2 wins=.20
	 * @param args
	 */
	public static void main(String[] args) {
		int p1wins = 0, p2wins = 0, numGames = 10000;
		for(int game = 0; game < numGames; game ++) {
			OthelloControllerRandomVSGreedy oc = new OthelloControllerRandomVSGreedy();
			oc.play();
			if (oc.othello.getWinner() == OthelloBoard.P1) p1wins ++;
			else p2wins ++;
			
		}
		System.out.println("Probability P1 wins=" + (float) p1wins / numGames);
		System.out.println("Probability P2 wins=" + (float) p2wins / numGames);

	}
}
