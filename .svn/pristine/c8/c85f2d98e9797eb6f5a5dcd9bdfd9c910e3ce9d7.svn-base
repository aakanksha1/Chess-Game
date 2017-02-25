//Superclass for all the pieces
public abstract class chessPiece {
	
	//Constructor variables
	String color;
	String type;
	int x, y;

	public chessPiece() {}
	
	//constructor
	public chessPiece(chessPiece copy){
		this.color = copy.color;
		this.x = copy.x;
		this.y = copy.y;
		this.type = copy.type;
	}
	
	//Setters and getters for x,y coordinates AND color
	public String getColor(){
		return this.color;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public String getType(){
		return this.type;
	}
	
	public void setColor(String val){
		this.color = val;
	}
	
	public void setX(int val){
		this.x = val;
	}
	
	public void setY(int val){
		this.y = val;
	}
	
	//This is a helper method for canMove
	public abstract boolean canMove(ChessBoard chess, int currX, int currY, int newX, int newY);
}


