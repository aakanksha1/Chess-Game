import static org.junit.Assert.*;

import org.junit.Test;

public class RookTest {

	@Test
	public void RookRightUp() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Rook("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 6, 6);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	@Test
	public void RookRightDown() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Rook("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 5, 2);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	@Test
	public void RookLeftUp() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Rook("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 3, 5);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	@Test
	public void RookLeftDown() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Rook("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 2, 1);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	@Test
	public void RookRight() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Rook("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 7, 4);
		assertEquals("Should be a pass", true, checkDirection);
	}
	@Test
	public void RookUp() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Rook("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 4, 6);
		assertEquals("Should be a pass", true, checkDirection);
	}
	
	//to check for obstructions
	@Test
	public void RookNotClear() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Rook("black", 4, 4);
		testGame.board[5][5] = new Rook("black", 4, 6);
		boolean checkDirection = testGame.allValidMoves(4, 4, 4, 7);
		assertEquals("Should be a fail", false, checkDirection);
	}

}
