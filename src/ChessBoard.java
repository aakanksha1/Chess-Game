/*Chess class*/
import java.util.Vector;

public class ChessBoard{
	
	public chessPiece[][] board = new chessPiece[8][8];
	
	//Global variables
	public int whitePieces = 16;
	public int blackPieces = 16; 
	public int pawns = 8;
	public boolean blackTurn;
	public boolean customB = false;
	public boolean checkW = false;
	public boolean checkB = false;
	
	public ChessBoard(){
		
	}
	/**
	 * 
	 * @param customBoard toggles whether the player wants a custom board with the
	 * custom pieces or a regular board.
	 */
	public ChessBoard(boolean customBoard){
		
		customB = customBoard;
		
		//initializing black pieces 
		blackTurn = false;
		board[0][7] = new Rook("black", 0, 7);
		board[1][7] = new Knight("black", 1, 7);
		board[2][7] = new Bishop("black", 2, 7);
		board[3][7] = new Queen("black", 3, 7);
		board[4][7] = new King("black", 4, 7);
		board[5][7] = new Bishop("black", 5, 7);
		board[6][7] = new Knight("black", 6, 7);
		board[7][7] = new Rook("black", 7, 7);
		
		if(customBoard){
			board[0][6] = new SuperPawn("black", 0, 6);
			
			for(int i=1; i<pawns; i++) { 
	            board[i][6] = new Pawn("black",i,6);
			}
			board[0][5] = new Pawn("black", 0, 5);
        }
		else{
			for(int i=0; i<pawns; i++) { 
	            board[i][6] = new Pawn("black",i,6);
			}
		}
		
		//initializing white pieces
		board[0][0] = new Rook("white", 0, 0);
		board[1][0] = new Knight("white", 1, 0);
		board[2][0] = new Bishop("white", 2, 0);
		board[3][0] = new Queen("white", 3, 0);
		board[4][0] = new King("white", 4, 0);
		board[5][0] = new Bishop("white", 5, 0);
		board[6][0] = new Knight("white", 6, 0);
		board[7][0] = new Rook("white", 7, 0);
		
		//taking care of the piece placement for custom board.
		if(customBoard){
			board[0][1] = new SuperPawn("white", 0, 0);
			
			for(int i=1; i<pawns; i++) { 
	            board[i][1] = new Pawn("white",i,1);
	        }
			board[0][2] = new Pawn("white", 0, 2);
		}
		else{
			for(int i=0; i<pawns; i++) { 
	            board[i][1] = new Pawn("white",i,1);
	        }
		}
		
	}
	/**
	 * 
	 * @param int currX, int currY current position of chess piece
	 * @param int newX, int newY new position of piece if it is a legal move
	 * Checks to see whether queen has been killed so that we can spawn the mini-queen (custom board)
	 * also calls CheckMate
	 */
	public void moveNkill(int currX, int currY, int newX, int newY){
		
		if(board[currX][currY] == null)
			return;
		
		boolean isQueen = board[newX][newY].getType().equals("queen");
		boolean isKing = board[newX][newY].getType().equals("king");
		
		if(customB && isQueen) {
			String queenColor = board[newX][newY].getColor();
			
			if(queenColor.equals("black")){
				board[7][6] = null;
				board[7][6] = new MiniQueen("black", 7, 6);
			}
			else {
				board[7][1] = null;
				board[7][1] = new MiniQueen("white", 7, 1);
			}
		}
		
		if(isKing){
			if(board[newX][newY].getColor().equals("black")){
				checkB = true;
			}
			else {
				checkW = true;
			}
			
			boolean gameOver = isCheckMate(newX, newY);
		}
		
		blackTurn = !blackTurn;
		board[newX][newY] = board[currX][currY];
		board[newX][newY].setX(newX);
		board[newX][newY].setY(newY);
		board[currX][currY] = null;
	}
	
	/**
	 * 
	 * @param int currX, int currY current position of chess piece
	 * @returns true for checkmate if possible moves is equal to the number of kill moves
	 * which means that the king has no possible square to move to
	 */
	public boolean isCheckMate(int currX, int currY){
		boolean isBlack = board[currX][currY].getColor().equals("black");
		Vector<chessPiece> possibleMoves = possCheckMoves(currX, currY);
		Vector<chessPiece> killMoves = new Vector();
		
		if(possibleMoves.isEmpty())
			return true;
		
		if(isBlack){
			Vector<chessPiece> whiteP = getLiveWhitePieces();
			
			for(int pMoves=0; pMoves<possibleMoves.size(); pMoves++){
					
				chessPiece tempKing = possibleMoves.get(pMoves);
				int tempKingX = tempKing.getX();
				int tempKingY = tempKing.getY();
				
				for(int wPiece=0; wPiece<whiteP.size(); wPiece++){
					
					chessPiece tempKill = whiteP.get(wPiece);
					int tempKillX = tempKill.getX();
					int tempKillY = tempKill.getY();
					
					for(int x=0; x<8; x++){
						for(int  y=0; y<8; y++){
							if(allValidMoves(tempKillX, tempKillY, tempKingX, tempKingY))
								killMoves.add(tempKill);
						}
					}
				}
			}
			
			if(possibleMoves.size() == killMoves.size()){
				return true;
			}
		}
		
		else {
			Vector<chessPiece> blackP = getLiveBlackPieces();

			for(int pMoves=0; pMoves<possibleMoves.size(); pMoves++){

				chessPiece tempKing = possibleMoves.get(pMoves);
				int tempKingX = tempKing.getX();
				int tempKingY = tempKing.getY();

				for(int bPiece=0; bPiece<blackP.size(); bPiece++){

					chessPiece tempKill = blackP.get(bPiece);
					int tempKillX = tempKill.getX();
					int tempKillY = tempKill.getY();

					for(int x=0; x<8; x++){
						for(int  y=0; y<8; y++){
							if(allValidMoves(tempKillX, tempKillY, tempKingX, tempKingY))
								killMoves.add(tempKill);
						}
					}
				}
			}

			if(possibleMoves.size() == killMoves.size()){
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 
	 * @param int currX, int currY current position of chess piece
	 * @returns a vector of the possible moves a king in check can make
	 */
	public Vector<chessPiece> possCheckMoves(int currX, int currY){
		Vector<chessPiece> pMoves = new Vector();
		
		if(currY-1 > 0 && board[currX][currY-1] != null){
			pMoves.add(board[currX][currY-1]);
		}
		
		if(currY+1 < 9 && board[currX][currY+1] != null){
			pMoves.add(board[currX][currY+1]);
		}
		
		if(currX-1 > 0 && board[currX-1][currY] != null){
			pMoves.add(board[currX-1][currY]);
		}
		
		if(currX+1 < 9 && board[currX+1][currY] != null){
			pMoves.add(board[currX+1][currY]);
		}
		
		if(currX+1 < 9 && currY+1 < 9 && board[currX+1][currY+1] != null){
			pMoves.add(board[currX+1][currY+1]);
		}
		
		if(currX-1 > 0 && currY-1 > 0 && board[currX-1][currY-1] != null){
			pMoves.add(board[currX-1][currY-1]);
		}
		
		if(currX-1 > 0 && currY+1 < 9 && board[currX-1][currY+1] != null){
			pMoves.add(board[currX-1][currY+1]);
		}
		
		return pMoves;
	}
	
	/**
	 * 
	 * @returns existing black pieces on the board
	 */
	public Vector<chessPiece> getLiveBlackPieces(){
		Vector<chessPiece> listB = new Vector();
		
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(board[i][j] != null && board[i][j].getColor().equals("black")){
					listB.add(board[i][j]);
				}
			}
		}
		return listB;
	}
	
	/**
	 * 
	 * @returns existing white pieces on the board
	 */
	public Vector<chessPiece> getLiveWhitePieces(){
		Vector<chessPiece> listW = new Vector();
		
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(board[i][j] != null && board[i][j].getColor().equals("white")){
					listW.add(board[i][j]);
				}
			}
		}
		return listW;
	}
	
	/** Function to determine all the valid moves a piece can make 
    *
    * @param int currX, int currY current position of chess piece
    * @param int newX, int newY new position of piece if it is a legal move
    *  
    */
	public boolean allValidMoves(int currX, int currY, int newX, int newY){
		
		chessPiece current = board[currX][currY];
		chessPiece newPiece = board[newX][newY];
		
		String currentColor = current.getColor();
		String newPieceColor = "";
		if(newPiece != null)
			newPieceColor = newPiece.getColor();
		
		if(newX < 0 || newY < 0 || newX > 7 || newY > 7)
			throw new ArrayIndexOutOfBoundsException();
		
		if(newPiece != null && currentColor.equals(newPieceColor))
			return false;
		return current.canMove(this, currX, currY, newX, newY);
	}
	
	/** Function to determine whether the piece can move diagonally 
    *
    * @param int currX, int currY current position of chess piece
    * @param int newX, int newY new position of piece if the piece was moved diagonally
    *  
    */
	
	public boolean moveDiagonal(int currX, int currY, int newX, int newY){
		boolean clear = false;
		if(newX > currX){
			clear = rightDiagonal(currX+1, currY, newX, newY);
		}
		
		if(newX < currX){
			clear = leftDiagonal(currX-1, currY, newX, newY);
		}
		
		return clear;
	}
	
	/** Helper method for moveDiagonal -- taking care of the directions in which the
	* piece can move. Takes care of right and up, and right and down
    *
    * @param int currX, int currY current position of chess piece
    * @param int newX, int newY new position of piece if it is a legal move
    *  
    */
	public boolean rightDiagonal(int currX, int currY, int newX, int newY){
		if(newY > currY){
			currY++;
			while(newX > currX && newY > currY){
				if(board[currX][currY] != null){
					return false;
				}
				currX++;
				currY++;
			}
			return true;
		}
		
		if(newY < currY){
			currY--;
			while(newX > currX && newY < currY) {
				if(board[currX][currY] != null) {
					return false;
				}
				currX++;
				currY--;
			}
			return true;
		}
		return false;
	}
	
	/** Helper method for moveDiagonal -- taking care of the directions in which the
	* piece can move. Takes care of left and up, and left and down
    *
    * @param int currX, int currY current position of chess piece
    * @param int newX, int newY new position of piece if it is a legal move
    *  
    */
	
	public boolean leftDiagonal(int currX, int currY, int newX, int newY){
		if(newY > currY){
			currY++;
			while(newX < currX && newY > currY){
				if(board[currX][currY] != null){
					return false;
				}
				currX--;
				currY++;
			}
			return true;
		}
		
		if(newY < currY){
			currY--;
			while(newX < currX && newY < currY) {
				if(board[currX][currY] != null) {
					return false;
				}
				currX--;
				currY--;
			}
			return true;
		}
		return false;
	}
	
	/** Helper method for moveDiagonal -- taking care of the directions in which the
	* piece can move. Takes care of moving horizontally
    *
    * @param int currX, int currY current position of chess piece
    * @param int newX, int newY new position of piece if it is a legal move
    *  
    */
	public boolean moveHorizontal(int currX, int currY, int newX, int newY){
		
		if(newX > currX){
			currX++;
			for(; currX < newX; currX++){
				if(board[currX][currY] != null)
					return false;
			}
		}
		
		if(newX < currX){
			currX--;
			for(; currX > newX; currX--){
				if(board[currX][currY] != null)
					return false;
			}
		}
		return true;
	}
	
	/** Helper method for moveDiagonal -- taking care of the directions in which the
	* piece can move. Takes care of moving vertically.
    *
    * @param int currX, int currY current position of chess piece
    * @param int newX, int newY new position of piece if it is a legal move
    *  
    */
	
	public boolean moveVertical(int currX, int currY, int newX, int newY){
		
		if(newY > currY){
			currY++;
			for(; currY < newY; currY++){
				if(board[currX][currY] != null)
					return false;
			}
		}
		
		if(newY < currY){
			currY--;
			for(; currY > newY; currY--){
				if(board[currX][currY] != null)
					return false;
			}
		}
		return true;
	}
	
	public chessPiece getPiece(int x, int y){
		return board[x][y];
	}
	
}