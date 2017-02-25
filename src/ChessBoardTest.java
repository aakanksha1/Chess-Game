import static org.junit.Assert.*;

import org.junit.Test;

public class ChessBoardTest {

	@Test
	public void NumberofPieces(){
		ChessBoard testGame = new ChessBoard();
		int number = testGame.whitePieces + testGame.blackPieces;
		assertEquals("making sure we have all the pieces", 16, number);
	}

	@Test
	public void SameColorPieces(){
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Pawn("black", 4, 4);
		testGame.board[4][5] = new Pawn ("black", 4, 5);
		boolean checkDirection = testGame.allValidMoves(4, 4, 4, 5);
		assertEquals("Testing same colored pieces", false, checkDirection);
	}
	
	@Test
	public void OutOfBounds(){
		ChessBoard testGame = new ChessBoard();
		testGame.board[4][4] = new Rook("black", 4, 4);
		boolean checkDirection = testGame.allValidMoves(4, 4, 40, 4);
		assertEquals("Testing out of bounds", false, checkDirection);
	}

}
