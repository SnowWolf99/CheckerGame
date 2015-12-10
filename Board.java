import java.io.*;
import java.util.*;


public class Board {
	
	private Piece[][] gameBoard;
	private static final int BOARDSIZE = 8;
   private String[][] gameString;
	
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
		gameString = new String[BOARDSIZE][BOARDSIZE];
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
	
   public Piece getPiece(int row, int column)
   {
      return gameBoard[row][column];
   }   
	public void setPiece(int row, int column, Piece inPiece)
	{
		gameBoard[row][column] = inPiece;
	}
   
   public String toString()
   {
      String str = "";
      for(int i = 0; i < BOARDSIZE; i++)
		{
			for(int x = 0; x < BOARDSIZE; x++)
			{
            int z = gameBoard[i][x].getType();
				str = str + Integer.toString(z);
			}
         str = str + "\n";
		}
      return str;
   }

   public int getSize()
   {
      return BOARDSIZE;
   }   
}
