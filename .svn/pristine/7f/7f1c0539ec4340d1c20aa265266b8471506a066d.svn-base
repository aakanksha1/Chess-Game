import static org.junit.Assert.*;

import org.junit.Test;

public class BishopTest {

	@Test
	public void BishopRightUp() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Bishop("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 6, 6);
		assertEquals("Should be a pass", true, checkDirection);
	}
	
	@Test
	public void BishopRightDown() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Bishop("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 5, 2);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	@Test
	public void BishopLeftUp() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Bishop("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 3, 5);
		assertEquals("Should be a pass", true, checkDirection);
	}
	
	@Test
	public void BishopLeftDown() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Bishop("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 2, 1);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	@Test
	public void BishopRight() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Bishop("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 5, 4);
		assertEquals("Should be a fail", false, checkDirection);
	}
	@Test
	public void BishopUp() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Bishop("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 4, 5);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	//to check for obstructions
	@Test
	public void BishopNotClear() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Bishop("black", 4, 4);
		testGame.board[5][5] = new Bishop("black", 5, 5);
		boolean checkDirection = testGame.allValidMoves(4, 4, 7, 7);
		assertEquals("Should be a fail", false, checkDirection);
	}

}
