package ca.utoronto.utm.assignment1.othello;

public class RandomVsRandomReport {
	
	/**
	 * In order to check the N0 and Na hypothesis
	 * series of RandomVsRandom games will be experimented.
	 */
	
	public void main(String[] args) {
		int p1wins = 0; int p2wins =0;
		for (int i = 0; i < 1000; i++) {
			OthelloControllerRandomVSRandom oc = new OthelloControllerRandomVSRandom();
			oc.play();
			if(oc.othello.getWinner()== OthelloBoard.P1) p1wins ++;
			else p2wins++;
		}
		float p1probability = (float) p1wins / 1000;
		float p2probability = (float) p2wins / 1000;
		
		if(p1probability == p2probability) System.out.println("Both players have the same probability of winning, therefore H0 is true");
		else System.out.println("Players don't have the same probability of winning therefore Ha is true ");
	}

}
