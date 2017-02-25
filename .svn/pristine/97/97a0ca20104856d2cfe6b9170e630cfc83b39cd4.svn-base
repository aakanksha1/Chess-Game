import static org.junit.Assert.*;

import org.junit.Test;

public class PawnTest {

	@Test
	public void PawnRightUp() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Pawn("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 6, 7);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	@Test
	public void PawnRightDown() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Pawn("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 5, 2);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	@Test
	public void PawnLeftUp() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Pawn("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 6, 6);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	@Test
	public void PawnLeftDown() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Pawn("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 2, 1);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	@Test
	public void PawnRight() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Pawn("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 3, 5);
		assertEquals("Should be a fail", false, checkDirection);
	}
	@Test
	public void PawnUp() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Pawn("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 4, 3);
		assertEquals("Should be a pass", true, checkDirection);
	}
	
	@Test
	public void PawnNotClear() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Pawn("black", 4, 4);
		testGame.board[4][5] = new Pawn("black", 4, 5);
		boolean checkDirection = testGame.allValidMoves(4, 4, 4, 5);
		assertEquals("Should be a fail", false, checkDirection);
	}
	
	@Test
	public void PawnKill() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Pawn("black", 4, 4);
		testGame.board[5][5] = new Pawn("white", 5, 5);
		boolean checkDirection = testGame.allValidMoves(4, 4, 5, 5);
		assertEquals("Should be a pass", true, checkDirection);
	}
	
	//to check for obstructions	
	@Test
	public void PawnTwoStep() {
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][6] = new Pawn("black", 4, 6);
		boolean checkDirection = testGame.allValidMoves(4, 6, 4, 4);
		assertEquals("Should be a pass", true, checkDirection);
	}

}
