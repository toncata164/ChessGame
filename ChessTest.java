package edu.school.chess;

import java.util.Scanner;

public class ChessTest
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int x,y;
		try
		{
			Game game = new Game();
			printTable(game.getPieces());
			
			while(true){
				clearConsole();
				try{
			String cmnd = input.next();
			if(cmnd.equals("stop")) break;
			if(cmnd.equals("select")){ 
				x = input.nextInt();
				y = input.nextInt();
				game.select(x, y);
			}			
			if(cmnd.equals("move")){
				x = input.nextInt();
				y = input.nextInt();
				game.movePiece(x, y);			
			}
			printTable(game.getPieces());
			}catch(Exception e){
				clearConsole();
				e.printStackTrace();
			}
			}
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void printTable(ChessPiece[] a)
	{
		
		for(int i = 1; i<=8; i++)
		{
			for(int j = 1; j<=8; j++)
			{
				boolean noPiece = true;
				int kk = -1;
				for(int k = 0; k<a.length; k++)
				{
					if(a[k] != null && a[k].getX()==j 
							&& a[k].getY() == 8-i+1)
					{
						noPiece = false;
						kk = k;
						break;
					}
				}
				if(noPiece)
				{
					System.out.print("_ ");
				}
				else
				{
					System.out.print(a[kk]);
				}
			}
			System.out.println();
		}
		
	}
	
	public static void clearConsole(){
		for(int i = 0; i < 3; i++)
			System.out.println();
	}
	


}
