import static org.junit.Assert.*;

import org.junit.Test;

public class MiniQueenTest {

	@Test
	public void MiniQueenRightUp() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Queen("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 6, 6);
		assertEquals("Should be a pass", true, checkDirection);
	}
	
	@Test
	public void MiniQueenRightDown() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Queen("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 5, 2);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	@Test
	public void MiniQueenLeftUp() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Queen("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 3, 5);
		assertEquals("Should be a pass", true, checkDirection);
	}
	
	@Test
	public void MiniQueenLeftDown() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Queen("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 2, 2);
		assertEquals("Should be a pass", true, checkDirection);
	}
	
	@Test
	public void MiniQueenRight() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Queen("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 7, 4);
		assertEquals("Should be a fail", false, checkDirection);
	}
	@Test
	public void MiniQueenUp() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Queen("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 4, 7);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	//to check for obstructions
	@Test
	public void MiniQueenClear() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Queen("black", 4, 4);
		testGame.board[5][5] = new Bishop("white", 5, 5);
		testGame.board[6][6] = new Rook ("white", 6, 6);
		boolean checkDirection = testGame.allValidMoves(4, 4, 6, 6);
		assertEquals("Should be a pass", true, checkDirection);
	}

}
