import static org.junit.Assert.*;

import org.junit.Test;

public class KingTest {

	@Test
	public void KingRightUp() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new King("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 5, 5);
		assertEquals("Should be a pass", true, checkDirection);
	}
	
	@Test
	public void KingRightDown() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new King("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 5, 2);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	@Test
	public void KingLeftUp() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new King("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 3, 5);
		assertEquals("Should be a pass", true, checkDirection);
	}
	
	@Test
	public void KingLeftDown() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new King("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 2, 1);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	@Test
	public void KingRight() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new King("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 5, 4);
		assertEquals("Should be a pass", true, checkDirection);
	}
	@Test
	public void KingUp() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new King("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 4, 5);
		assertEquals("Should be a pass", true, checkDirection);
	}
	
	//to check for obstructions
	@Test
	public void KingNotClear() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new King("black", 4, 4);
		testGame.board[5][5] = new Bishop("black", 5, 5);
		boolean checkDirection = testGame.allValidMoves(4, 4, 7, 7);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	// Check
	@Test
	public void KingInCheck() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new King("black", 4, 4);
		testGame.board[2][2] = new Bishop("white", 2, 2);
		assertEquals("Should be a pass", true, testGame.checkB);
	}
	
	// CheckMate
	@Test
	public void KingCheckMate() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new King("black", 4, 4);
		testGame.board[7][4] = new Queen("white", 7, 4);
		testGame.board[7][3] = new Rook("white", 7, 3);
		testGame.board[7][5] = new Rook("white", 7, 5);
		boolean isCheckMate = testGame.isCheckMate(4, 4);
		assertEquals("Should be a pass", true, isCheckMate);
	}

}
