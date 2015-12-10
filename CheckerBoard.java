import java.io.*;
import java.util.*;

public class CheckerBoard extends Board {
	
	public Board playingBoard;
	public CheckerBoard()
	{
		playingBoard = new Board();
      
		this.setBoard();
				
	}
   public void setBoard()
   {
      // super.setPiece(1,1, new Piece(1));

      //BlackPieces
		for(int x = 0; x < 3; x++)
		{
			for(int i = 0; i < 8; i +=2)
			{
            
				if(x == 0 || x == 2)
            {
               Piece tempPiece = new Piece(1);
   				super.setPiece(x, i+1, tempPiece);
            }   
            else
            {
               Piece tempPiece = new Piece(1);
				   super.setPiece(x, i, tempPiece);
            }   
			}
		}
		
		for(int x = 5; x <8; x++)
		{
			for(int i = 0; i < 8; i +=2)
			{
				if(x == 6)
            {
               Piece tempPiece = new Piece(2);
   				super.setPiece(x, i+1, tempPiece);
            }   
            else
            {
               Piece tempPiece = new Piece(2);
				   super.setPiece(x, i, tempPiece);
            }   
			}
		}
   }
   
   public void movePiece(Piece piece, int startR, int startC, int endR, int endC)
   {
      setPiece(startR, startC, new Piece(0)); 
      setPiece(endR, endC, piece);
      
   
   }  


}
