/**
 * 
 */
package edu.oregonstate.eecs.cs331.assn2;

import java.io.PrintStream;
import java.util.List;

/**
 * @author Dan Albert
 *
 */
public class StateTree
{
	int MAX_PLAYER = TicTacToeBoard.PLAYER_X;
	int MIN_PLAYER = TicTacToeBoard.PLAYER_O;
	
	private final Position move;
	private final TicTacToeBoard state;
	private final List<StateTree> successors;
	
	public StateTree(
			Position move,
			TicTacToeBoard state,
			List<StateTree> successors)
	{
		this.move = move;
		this.state = state;
		this.successors = successors;
	}
	
	public StateTree(
			TicTacToeBoard state,
			List<StateTree> successors)
	{
		this.move = null;
		this.state = state;
		this.successors = successors;
	}
	
	public Position getMove()
	{
		return this.move;
	}
	
	public TicTacToeBoard getState()
	{
		return this.state;
	}
	
	public List<StateTree> getSuccessors()
	{
		return this.successors;
	}
	
	public StateTree getSuccessor(int index)
	{
		return this.successors.get(index);
	}
	
	public boolean isLeaf()
	{
		return this.successors.size() == 0;
	}
	
	public int getScore() throws Exception
	{
		if (this.isLeaf()) {
			return this.getLeafScore();
		} else {
			throw new Exception("unhandled");
		}
	}
	
	private int getLeafScore() throws Exception
	{		
		if (this.getState().isWin(MAX_PLAYER)) {
			return 1;
		} else if (this.getState().isWin(MIN_PLAYER)) {
			return -1;
		} else {
			return 0;
		}
	}
	
	public void dump(PrintStream out) throws Exception
	{
		this.getState().dump(out);
		for (StateTree successor : this.successors) {
			successor.dump(out);
		}
	}
}
