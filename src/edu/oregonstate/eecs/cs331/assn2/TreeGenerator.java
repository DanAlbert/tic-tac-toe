/**
 * 
 */
package edu.oregonstate.eecs.cs331.assn2;

import java.util.LinkedList;

/**
 * @author Dan Albert
 *
 */
public class TreeGenerator
{
	public TreeGenerator()
	{
	}
	
	public StateTree getTree(TicTacToeBoard state) throws Exception
	{
		return this.generate(state, new Position());
	}
	
	private StateTree generate(
			TicTacToeBoard state,
			Position move) throws Exception
	{
		LinkedList<StateTree> successors = new LinkedList<StateTree>();
		
		if (!state.isGameOver()) {
			for (int row = 0; row < TicTacToeBoard.SIZE; row++) {
				for (int col = 0; col < TicTacToeBoard.SIZE; col++) {
					int player = state.getPlayerIndexOfSquare(row, col);
					if (player == TicTacToeBoard.PLAYER_NONE) {
						TicTacToeBoard next = (TicTacToeBoard)state.clone();
						next.setState(row, col, state.getTurn());
						
						if (state.getTurn() == TicTacToeBoard.PLAYER_O) {
							next.setTurn(TicTacToeBoard.PLAYER_X);
						} else if (state.getTurn() == TicTacToeBoard.PLAYER_X) {
							next.setTurn(TicTacToeBoard.PLAYER_O);
						} else {
							throw new Exception("Invalid player turn");
						}
						
						Position position = new Position(row, col);
						successors.add(this.generate(next, position));
					}
				}
			}
		}
		
		return new StateTree(move, state, successors);
	}
}
