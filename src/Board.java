import java.io.*;
import java.util.*;


public class Board {
	
	public Piece[][] gameBoard;
	private static final int BOARDSIZE = 8;
	
	public Board()
	{
		gameBoard = new Piece[BOARDSIZE][BOARDSIZE];
		for(int i = 0; i < BOARDSIZE; i++)
		{
			for(int x = 0; x < BOARDSIZE; x++)
			{
				gameBoard[i][x] = new Piece(0);
			}
		}
	}
	
	public String[][] gameString()
	{
		String[][] gameString = new String[BOARDSIZE][BOARDSIZE];
		for(int i = 0; i < BOARDSIZE; i++)
		{
			for(int x = 0; x < BOARDSIZE; x++)
			{
				int z = gameBoard[i][x].getType();
				gameString[i][x] = Integer.toString(z);
			}
		}
		return(gameString);
	}
	
	public void setPiece(int row, int column, Piece inPiece)
	{
		gameBoard[row][column] = inPiece;
	}

}
