/*Queen Class*/

public class Queen extends chessPiece{

	//initializing Queen
	public Queen (String newColor, int x, int y){
		this.x = x;
		this.y = y;
		this.color = newColor;
		this.type = "queen";
		
	}
	
	//copy constructor
	public Queen(Queen copy){
		this.color = copy.color;
		this.x = copy.x;
		this.y = copy.y;
	}
	
	/* Function to determine the different ways in which the Queen can move. Can move in any 
	 * direction and how many ever spaces in one move, provided there is no obstruction.
	 * 
     * @param ChessBoard chess creating instance of board
     * @param int currX, int currY current position of chess piece
     * @param int newX, int newY new position of piece if it is a legal move
     *  
     */
	
	public boolean canMove(ChessBoard chess, int currX, int currY, int newX, int newY){
		boolean valid = false;
		
		//Checking the distance and if it is a valid position between current and new position.
		int distX = Math.abs(currX - newX);
		int distY = Math.abs(currY - newY);
		
		if (distX == distY){
			valid = true;
			return valid && chess.moveDiagonal(currX, currY, newX, newY);
		}
		
		if(distX == 0 && distY != 0){
			valid = true;
			return valid && chess.moveHorizontal(currX, currY, newX, newY);
		}
		
		if(distX != 0 && distY == 0){
			valid = true;
			return valid && chess.moveVertical(currX, currY, newX, newY);
		}
		
		return valid;
	}
	
}
