package edu.school.chess;

public class Queen extends ChessPiece{

		
	public Queen(int x, int y, ChessColor color) 
			throws Exception 
	{
		super(x, y, color);		
	}

	public String toString()
	{
		if(getColor().equals(ChessColor.WHITE))
			return "WQ";
		else
			return "BQ";
	}
	
	public boolean isDiagonal(int x, int y){
		if(Math.abs(getX() - x )== Math.abs(getY() - y))
		{
			return true;
		}		
		return false;
	}


	@Override
	public void moveTo(int x, int y, ChessPiece[] table) 
			throws Exception 
	{
		if(isSelected() == false)
		{
			throw new Exception("You need to select the figure first!");
		}
		else if(x != getX() && y != this.getY() && !isDiagonal(x,y) || isSelected() == false)
		{			
			throw new Exception("The Queen can't move there!");
		}
		else if(isOccupied(x,y,table))
		{
			ChessPiece piece = table[getPieceID(x,y,table)];
			if(isEnemy(piece))
			{
				table[getPieceID(x,y,table)] = null;
				setX(x);
				setY(y);
			}
			else
			{
				throw new Exception("The Queen can't move there because a piece is occuping the place");
			}
		}
		else
		{
			setX(x);
			setY(y);
		}		
	}
}
