package edu.oregonstate.eecs.cs331.assn2;

/**
 * This class represents the module for minimax.
 * @author Dan Albert
 *
 */
public class MiniMax implements Player
{
	TreeGenerator generator;
	int MAX_PLAYER = TicTacToeBoard.PLAYER_X;
	int MIN_PLAYER = TicTacToeBoard.PLAYER_O;
	
	/**
	 * Constructor
	 *
	 */
	public MiniMax()
	{
		this.generator = new TreeGenerator();
	}

	/**
	 * Returns the next move.
	 * @param state The current board state in the game
	 * @return The next move
	 */
	public Position getNextMove(TicTacToeBoard state) throws Exception 
	{
		StateTree tree = generator.getTree(state);
		return this.getMinimaxMove(tree).getPosition();
	}
	
	private Move getMinimaxMove(StateTree tree) throws Exception
	{
		TicTacToeBoard state = tree.getState();
		
		if (state.getTurn() == MIN_PLAYER) {
			return this.getMinMove(tree);
		} else if (state.getTurn() == MAX_PLAYER) {
			return this.getMaxMove(tree);
		} else {
			throw new Exception("Invalid player turn"); 
		}
	}
	
	private Move getMinMove(StateTree tree) throws Exception
	{
		if (tree.isLeaf()) {
			return new Move(
					tree.getMove(),
					tree.getScore());
		}
		
		Move minMove = null;
		for (StateTree successor : tree.getSuccessors()) {
			Move move = this.getMaxMove(successor);
			if (minMove == null || move.getScore() < minMove.getScore()) {
				minMove = new Move(successor.getMove(), move.getScore());
			}
		}
		
		return minMove;
	}
	
	private Move getMaxMove(StateTree tree) throws Exception
	{
		if (tree.isLeaf()) {
			return new Move(
					tree.getMove(),
					tree.getScore());
		}
		
		Move maxMove = null;
		for (StateTree successor : tree.getSuccessors()) {
			Move move = this.getMinMove(successor);
			if (maxMove == null || move.getScore() > maxMove.getScore()) {
				maxMove = new Move(successor.getMove(), move.getScore());
			}
		}
		
		return maxMove;
	}

	/**
	 * Returns the player type 
	 */
	public int getPlayerType()
	{
		return MINIMAX_PLAYER;
	}
	
	private class Move
	{
		private Position position;
		private int score;
		
		public Move(Position position, int score)
		{
			this.position = position;
			this.score = score;
		}
		
		public Position getPosition()
		{
			return this.position;
		}
		
		public int getScore()
		{
			return this.score;
		}
	}
}
