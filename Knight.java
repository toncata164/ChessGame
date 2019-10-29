package edu.school.chess;

public class Knight extends ChessPiece
{
	public Knight(int x, int y, ChessColor color) 
			throws Exception
	{
		super(x, y, color);
	}

	@Override
	public void moveTo(int x, int y, ChessPiece[] table) 
			throws Exception
	{
		if(isSelected() == false)
		{
			throw new Exception("You need to select the figure first!");
		}
		else if ((x != getX() + 2 && y != this.getY() + 1) &&
				(x != getX() + 1 && y != this.getY() + 2) &&
				(x != getX() - 1 && y != this.getY() + 2) &&
				(x != getX() - 2 && y != this.getY() + 1) &&
				(x != getX() - 2 && y != this.getY() - 1) &&
				(x != getX() - 1 && y != this.getY() - 2) &&
				(x != getX() + 1 && y != this.getY() - 2) &&
				(x != getX() + 2 && y != this.getY() - 1))
		{
			throw new Exception("The knight can't move there!");
		}
		else
		{
			setX(x);
			setY(y);
		}
	}

	public String toString()
	{
		if (getColor().equals(ChessColor.WHITE))
			return "WK";
		else
			return "BK";
	}
}
