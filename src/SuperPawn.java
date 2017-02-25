
public class SuperPawn extends chessPiece {
	//Initializing SuperPawn
	public SuperPawn (String newColor, int x, int y){
		this.x = x;
		this.y = y;
		this.color = newColor;
		this.type = "superpawn";
		
	}
	
	//Copy constructor for Bishop
	public SuperPawn(SuperPawn copy){
		this.color = copy.color;
		this.x = copy.x;
		this.y = copy.y;
	}

	/**
	* @param int currX, int currY current position of chess piece
    * @param int newX, int newY new position of piece if it is a legal move
    * @returns the different moves the black or white pawn can make when it is moving vertically up or down
    * @returns the different moves the black of white pawn can make when it checks to see if it can kill two
    * enemy pieces at one or not.
	*/
	public boolean canMove(ChessBoard chess, int currX, int currY, int newX, int newY){
		boolean valid = false;

		int distX = Math.abs(currX - newX);
		int distY = Math.abs(currY - newY);

		//moving vertically one space. (can only move forward one space even if it's
		//the first move.
		if(distX == 0 && distY == 1){
			valid = true;
			return valid && chess.moveVertical(currX, currY, newX, newY);
		}

		String color = chess.board[currX][currY].getColor();

		//Checking the if it needs to kill enemy piece diagonally. Specifically also checks
		//whether there are two pieces it can kill diagonally.
		if(distX == 1 && distY == 1 && chess.board[newX][newY] != null){
			if (color.equals("black") && (newY == currY-1))
				valid = true;
			if (color.equals("white") && (newY == currY+1))
				valid = true;
			return valid;
		}

		if(distX == 2 && distY == 2 && chess.board[newX][newY] != null){
			if (color.equals("black") && (newY == currY-2)){
				if(newX == currX-2){
					if(color != chess.board[currX-1][currY-1].getColor())
						chess.board[currX-1][currY-1] = null;
				}
				if(newX == currX+2){
					if(color != chess.board[currX+1][currY-1].getColor())
						chess.board[currX+1][currY-1] = null;
				}
				valid = true;
			}

			if (color.equals("white") && (newY == currY+2)){
				if(newX == currX-2){
					if(color != chess.board[currX-1][currY+1].getColor())
						chess.board[currX-1][currY+1] = null;
				}
				if(newX == currX+2){
					if(color != chess.board[currX+1][currY+1].getColor())
						chess.board[currX+1][currY+1] = null;
				}
				valid = true;
			}	
			return valid;
		}
		return valid;
	}
}