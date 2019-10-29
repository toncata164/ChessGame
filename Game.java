package edu.school.chess;

public class Game {
	private ChessPiece[] table = new ChessPiece[32];
	private int pieces = 32;
	
	public Game() 
			throws Exception
	{
		table[0] = new Rook(1, 1, ChessColor.WHITE);
		table[1] = new Rook(8, 8, ChessColor.BLACK);
		table[2] = new Queen(4, 1, ChessColor.WHITE);
		table[3] = new Queen(4, 8, ChessColor.BLACK);
	}
	
	public void select(int x, int y) 
			throws Exception
	{
		boolean flag = false;
		int save = 0;
		for(int i = 0; i < pieces; i++)
		{
			if(table[i] == null) 
				i++;
			else if(table[i].getX() == x && 
					table[i].getY() == y)
			{
				flag = true;
				save = i;
				break;
			}
		}
		for(int i = 0; i < pieces; i++)
		{
			if(table[i] == null)
				i++;
			else
			{ 
				table[i].setSelected(false);
			}
		}

		if(flag)
		{
			table[save].setSelected(true);
			System.out.printf("Piece %s is selected\n",table[save].toString());
		}
		else
		{
			throw new Exception("No figure to select in that position.\n");
		}
	}
	
	public void movePiece(int x, int y) 
			throws Exception
	{
		int piece = 0;
		for(int i = 0; i < pieces; i++)
		{
			if(table[i] == null)
				i++;
			else if(table[i].isSelected() == true)
			{
				piece = i;
				break;
			}
		}
		table[piece].moveTo(x, y, table);
		table[piece].setSelected(false);
	}
	
	public ChessPiece[] getPieces()
	{
		return table;
	}
	
	public int getPiecesNumber()
	{
		return pieces;
	}
}
