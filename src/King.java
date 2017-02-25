/*King Class*/

public class King extends chessPiece{
	
	//initializing King
	public King (String newColor, int x, int y){
		this.x = x;
		this.y = y;
		this.color = newColor;
		this.type = "king";
		
	}
	
	//constructor
	public King(King copy){
		this.color = copy.color;
		this.x = copy.x;
		this.y = copy.y;
	}
	
	/* Function to determine the different ways in which the King can move (can move in 
	 * any direction but only one space at a time).
	 * 
     * @param ChessBoard chess creating instance of board
     * @param int currX, int currY current position of chess piece
     * @param int newX, int newY new position of piece if the King can move in that specific
     * direction.
     *  
     */
	
	public boolean canMove(ChessBoard chess, int currX, int currY, int newX, int newY){
		boolean valid = false;
		
		//Checking the distance and if it is a valid position between current and new position.
		int distX = Math.abs(currX - newX);
		int distY = Math.abs(currY - newY);
		
		if (distX == 1 || distY == 1){
			valid = true;
		}
		
		return valid;
	}
}
