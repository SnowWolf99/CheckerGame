import java.io.*;
import java.util.*;

public class CheckerBoard extends Board {
	private Board playingBoard;
	
	public CheckerBoard()
	{
		playingBoard = new Board();
		
		//BlackPieces
		for(int x = 0; x < 2; x++)
		{
			for(int i = 0; i < 8; i =+2)
			{
				Piece tempPiece = new Piece(1);
				playingBoard.setPiece(x, i, tempPiece);
			}
		}
		
		for(int x = 6; x < 8; x++)
		{
			for(int i = 0; i < 8; i =+2)
			{
				Piece tempPiece = new Piece(2);
				playingBoard.setPiece(x, i, tempPiece);
			}
		}
		
	}

}
