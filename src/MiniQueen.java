
public class MiniQueen extends chessPiece{
	//Initializing SuperPawn
	public MiniQueen (String newColor, int x, int y){
		this.x = x;
		this.y = y;
		this.color = newColor;
		this.type = "miniqueen";
		
	}
	
	//Copy constructor for Bishop
	public MiniQueen(SuperPawn copy){
		this.color = copy.color;
		this.x = copy.x;
		this.y = copy.y;
	}

	
	/** Function to determine the different ways in which the miniQueen can move. Can move in any 
	 * direction but only two spaces at a time.
	 * 
     * @param ChessBoard chess creating instance of board
     * @param int currX, int currY current position of chess piece
     * @param int newX, int newY new position of piece if it is a legal move
     * @returns the moves the queen make, taking into consideration if there is an 
     * enemy obstruction.
     */
	
	public boolean canMove(ChessBoard chess, int currX, int currY, int newX, int newY){
		boolean valid = false;

		int distX = Math.abs(currX - newX);
		int distY = Math.abs(currY - newY);

		String color = chess.board[currX][currY].getColor();

		//Checking the if it needs to kill enemy piece diagonally
		if(distX == 1 || distY == 1 && chess.board[newX][newY] != null){
			valid = true;
			return valid;
		}
		
		if(distX == 2 || distY == 2 && chess.board[newX][newY] != null){
			if(newX == currX-2){
				if(newY == currY+2){
					if(color != chess.board[currX-1][currY+1].getColor())
						chess.board[currX-1][currY+1] = null;
				}
				if(newY == currY-2){
					if(color != chess.board[currX-1][currY-1].getColor())
						chess.board[currX-1][currY-1] = null;
				}
				if (newY == currY){
					if(color != chess.board[currX-1][currY].getColor())
						chess.board[currX-1][currY] = null;
				}
			}
			if(newX == currX+2){
				if(newY == currY+2){
					if(color != chess.board[currX+1][currY+1].getColor())
						chess.board[currX+1][currY+1] = null;
				}
				if(newY == currY-2){
					
					if(color != chess.board[currX+1][currY-1].getColor())
						chess.board[currX+1][currY-1] = null;
				}
				if (newY == currY){
					if(color != chess.board[currX+1][currY].getColor())
						chess.board[currX+1][currY] = null;
				}
			}
			
			if(newX == currX){
				if(newY == currY+2){
					if(color != chess.board[currX][currY+1].getColor())
						chess.board[currX][currY+1] = null;
				}
				if(newY == currY-2){
					
					if(color != chess.board[currX][currY-1].getColor())
						chess.board[currX][currY-1] = null;
				}
			}
			valid = true;	
			return valid;
		}
		return valid;
	}
}