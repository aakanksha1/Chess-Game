import static org.junit.Assert.*;

import org.junit.Test;

public class QueenTest {

	@Test
	public void QueenRightUp() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Queen("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 6, 6);
		assertEquals("Should be a pass", true, checkDirection);
	}
	
	@Test
	public void QueenRightDown() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Queen("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 5, 2);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	@Test
	public void QueenLeftUp() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Queen("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 3, 5);
		assertEquals("Should be a pass", true, checkDirection);
	}
	
	@Test
	public void QueenLeftDown() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Queen("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 2, 1);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	@Test
	public void QueenRight() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Queen("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 7, 4);
		assertEquals("Should be a pass", true, checkDirection);
	}
	@Test
	public void QueenUp() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Queen("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 4, 7);
		assertEquals("Should be a pass", true, checkDirection);
	}
	
	//to check for obstructions
	@Test
	public void QueenNotClear() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Queen("black", 4, 4);
		testGame.board[5][5] = new Bishop("black", 6, 6);
		boolean checkDirection = testGame.allValidMoves(4, 4, 7, 7);
		assertEquals("Should be a fail", false, checkDirection);
	}

}
