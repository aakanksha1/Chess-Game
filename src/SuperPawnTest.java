import static org.junit.Assert.*;

import org.junit.Test;

public class SuperPawnTest {

	@Test
	public void SuperPawnRightUp() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new SuperPawn("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 6, 7);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	@Test
	public void SuperPawnRightDown() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new SuperPawn("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 5, 2);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	@Test
	public void SuperPawnLeftUp() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new SuperPawn("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 3, 5);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	@Test
	public void SuperPawnLeftDown() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new SuperPawn("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 2, 1);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	@Test
	public void SuperPawnRight() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new SuperPawn("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 5, 4);
		assertEquals("Should be a fail", false, checkDirection);
	}
	@Test
	public void SuperPawnUp() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new SuperPawn("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 4, 5);
		assertEquals("Should be a pass", true, checkDirection);
	}
	
	@Test
	public void SuperPawnNotClear() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new SuperPawn("black", 4, 4);
		testGame.board[4][5] = new Pawn("black", 4, 5);
		boolean checkDirection = testGame.allValidMoves(4, 4, 4, 5);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	@Test
	public void SuperPawnKill() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new SuperPawn("black", 4, 4);
		testGame.board[6][6] = new Pawn("white", 6, 6);
		boolean checkDirection = testGame.allValidMoves(4, 4, 6, 6);
		assertEquals("Should be a pass", true, checkDirection);
	}
	
	//to check for obstructions
	public void SuperPawnClear() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Queen("black", 4, 4);
		testGame.board[5][5] = new Bishop("white", 5, 5);
		testGame.board[6][6] = new Rook ("white", 6, 6);
		boolean checkDirection = testGame.allValidMoves(4, 4, 6, 6);
		assertEquals("Should be a pass", true, checkDirection);
	}

}