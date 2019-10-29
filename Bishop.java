package edu.school.chess;

public class Bishop extends ChessPiece
  {

	public Bishop(int x, int y, ChessColor color) 
			throws Exception 
	{
		super(x, y, color);
	}

	@Override
	public void moveTo(int x, int y, ChessPiece[] table) 
			throws Exception 
	{
		if(x != getX() && y != getY() && x != y) 
		{
			throw new Exception("The Bishop can not move there!");
		}		
	}
	
	public String toString()
	{
		if(getColor().equals(ChessColor.WHITE))
		{
			return "WB";
		}
		else return "BB";
	}
}
