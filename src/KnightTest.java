import static org.junit.Assert.*;

import org.junit.Test;

public class KnightTest {

	@Test
	public void KnightRightUp() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new King("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 5, 7);
		assertEquals("Should be a pass", true, checkDirection);
	}
	
	@Test
	public void KnightRightDown() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Knight("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 5, 2);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	@Test
	public void KnightLeftUp() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Knight("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 3, 7);
		assertEquals("Should be a pass", true, checkDirection);
	}
	
	@Test
	public void KnightLeftDown() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Knight("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 2, 1);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	@Test
	public void KnightRight() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Knight("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 5, 4);
		assertEquals("Should be a fail", false, checkDirection);
	}
	@Test
	public void KnightUp() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Knight("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 4, 5);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	//to check for obstructions
	@Test
	public void KnightNotClear() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Knight("black", 4, 4);
		testGame.board[5][5] = new Bishop("black", 5, 7);
		boolean checkDirection = testGame.allValidMoves(4, 4, 5, 7);
		assertEquals("Should be a fail", false, checkDirection);
	}


}
