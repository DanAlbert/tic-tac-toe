package edu.oregonstate.eecs.cs331.assn2;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * 
 */

/**
 * @author Dan Albert
 *
 */
public class MiniMaxTest {
	private TicTacToeBoard state;
	private MiniMax player;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		player = new MiniMax();
		
		state = new TicTacToeBoard();
		state.setTurn(TicTacToeBoard.PLAYER_O);
		
		state.setState(0, 0, TicTacToeBoard.PLAYER_X);
		state.setState(0, 1, TicTacToeBoard.PLAYER_X);
		state.setState(0, 2, TicTacToeBoard.PLAYER_O);
		
		state.setState(1, 0, TicTacToeBoard.PLAYER_NONE);
		state.setState(1, 1, TicTacToeBoard.PLAYER_O);
		state.setState(1, 2, TicTacToeBoard.PLAYER_NONE);
		
		state.setState(2, 0, TicTacToeBoard.PLAYER_X);
		state.setState(2, 1, TicTacToeBoard.PLAYER_O);
		state.setState(2, 2, TicTacToeBoard.PLAYER_X);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link edu.oregonstate.eecs.cs331.assn2.MiniMax#MiniMax()}.
	 */
	@Test
	public void testMiniMax() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link edu.oregonstate.eecs.cs331.assn2.MiniMax#getNextMove(edu.oregonstate.eecs.cs331.assn2.TicTacToeBoard)}.
	 * @throws Exception 
	 */
	@Test
	public void testGetNextMove() throws Exception {
		assertEquals(new Position(1, 0), player.getNextMove(state));
	}

	/**
	 * Test method for {@link edu.oregonstate.eecs.cs331.assn2.MiniMax#getPlayerType()}.
	 */
	@Test
	public void testGetPlayerType() {
		assertEquals(player.getPlayerType(), Player.MINIMAX_PLAYER);
	}

}
