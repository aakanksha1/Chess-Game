/*Bishop Class*/

public class Bishop extends chessPiece{
	
	//Initializing Bishop
	public Bishop (String newColor, int x, int y){
		this.x = x;
		this.y = y;
		this.color = newColor;
		this.type = "bishop";
		
	}
	
	//Copy constructor for Bishop
	public Bishop(Bishop copy){
		this.color = copy.color;
		this.x = copy.x;
		this.y = copy.y;
		this.type = copy.type;
	}

	
    /* Function to determine the different ways in which the bishop can move (can only move
	* diagonally but how many ever spaces in one turn).
	* 
    * @param ChessBoard chess creating instance of board
    * @param int currX, int currY current position of chess piece
    * @param int newX, int newY new position of piece if it is a legal move to make diagonally
    *  
    */
	public boolean canMove(ChessBoard chess, int currX, int currY, int newX, int newY){
		boolean valid = false;
		
		//Checking the distance and if it is a valid position between current and new position.
		int distX = Math.abs(currX - newX);
		int distY = Math.abs(currY - newY);
		
		if (distX == distY){
			valid = true;
		}
		
		//moveDiagonal defined in ChessBoard.java
		return valid && chess.moveDiagonal(currX, currY, newX, newY);
	}
}