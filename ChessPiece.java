package edu.school.chess;


public abstract class ChessPiece
{
	private int x;
	private int y;
	private ChessColor color;
	private boolean selected;
	
	public void setX(int value) throws Exception
	{
		if(value >= 1 && value <= 8)
			x = value;
		else
			throw new Exception("Invalid position!");
	}
	
	public int getX()
	{
		return x;
	}
	
	public void setY(int value) throws Exception
	{
		if(value >= 1 && value <= 8)
			y = value;
		else
			throw new Exception("Invalid position!");
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setColor(ChessColor value)
	{
		color = value;
	}
	
	public ChessColor getColor()
	{
		return color;
	}
	
	public void setSelected(boolean value){
		selected = value;
	}
	
	public boolean isSelected(){
		return selected;
	}
	
	public ChessPiece(int x, int y, ChessColor color) throws Exception
	{
		setX(x);
		setY(y);
		setColor(color);
	}
	
	public boolean isOccupied(int x, int y, ChessPiece[] table){
		for(int i = 0; i < table.length; i++){
			if(table[i] == null) return false;
			if(table[i].getX() == x && table[i].getY() == y)
				return true;
		}
		return false;
	}
	
	public boolean isEnemy(ChessPiece toCheck){
		if(toCheck.getColor() != this.getColor()) 
			return true;
		return false;
	}
	
	public int getPieceID(int x, int y, ChessPiece[] table){
		for(int i = 0; i < table.length; i++){
			if(table[i].getX() == x && table[i].getY() == y)
				return i;
		}
		return -1;
	}
	
	public abstract void moveTo(int x, int y,ChessPiece[] chesspiece) throws Exception;
	
	
}
