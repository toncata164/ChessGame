package edu.school.chess;


public class Rook extends ChessPiece
{

	public Rook(int x, int y, ChessColor color) throws Exception
	{
		super(x, y, color);
	}
	
	
	public String toString()
	{
		if(getColor().equals(ChessColor.WHITE))
			return "WR";
		else
			return "BR";
	}

	@Override
	public void moveTo(int x, int y, ChessPiece[] table) 
			throws Exception 
	{		
		if(!isSelected())
		{
			throw new Exception("You need to select the figure first!");
		}
		else if(x != getX() && y != this.getY() || isSelected() == false)
		{
			
			throw new Exception("The Rook can't move there!");
		}
		else if(isOccupied(x, y, table)){
			ChessPiece piece = table[getPieceID(x, y, table)];
			if(isEnemy(piece))
			{
				table[getPieceID(x, y, table)] = null;
				setX(x);
				setY(y);
			}
			else
			{
				throw new Exception("The Rook can't move there because a piece is occuping the place");
			}
		}
		else
		{
			setX(x);
			setY(y);
		}		
	}

}
