import java.io.*;
import java.util.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CheckerBoard extends Board {
	
	public Board playingBoard;
   private Player redPlayer, blackPlayer, currentPlayer, nextPlayer;
   
   
	public CheckerBoard()
	{
      
      String redPlayerName = JOptionPane.showInputDialog(null, "Enter your name", 
               "Red Player", JOptionPane.PLAIN_MESSAGE);
      String blackPlayerName = JOptionPane.showInputDialog(null, "Enter your name",
                "Black Player", JOptionPane.PLAIN_MESSAGE);
		playingBoard = new Board();
      redPlayer = new Player(redPlayerName, new Piece(Piece.REDPIECE));
      blackPlayer = new Player(blackPlayerName, new Piece(Piece.BLACKPIECE));
		currentPlayer = redPlayer;
      nextPlayer = blackPlayer;
      this.setBoard();
				
	}
   
   public Player getRedPlayer()
   {
      return redPlayer;
   }
   
   public Player getBlackPlayer()
   {
      return blackPlayer;
   }      
   
    /** Gets the current Player
     * @return currentPlayer
     */
    public Player getCurrentPlayer()
    {
        return currentPlayer;
    }
    
    /** Gets the next Player
     * @return nextPlayer
     */
    public Player getNextPlayer()
    {   
        return nextPlayer;
    }
   
   /** sets the players after each turn
  * @param inPlayer - sets inPlayer to currentPlayer
  */
    public void setCurrentPlayer(Player inPlayer)
    {
        String nextP = "***";
        currentPlayer = inPlayer; //setting currentPlayer 
         
        Piece oppPiece = currentPlayer.getPiece().getOpposite();
        if(redPlayer.getPiece().equals(oppPiece))
        {
            nextPlayer = redPlayer;
            
        }    
        if(blackPlayer.getPiece().equals(oppPiece))
        {
            nextPlayer = blackPlayer;           
        }    
        
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
               Piece tempPiece = new Piece(Piece.BLACKPIECE);
   				super.setPiece(x, i+1, tempPiece);
            }   
            else
            {
               Piece tempPiece = new Piece(Piece.BLACKPIECE);
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
               Piece tempPiece = new Piece(Piece.REDPIECE);
   				super.setPiece(x, i+1, tempPiece);
            }   
            else
            {
               Piece tempPiece = new Piece(Piece.REDPIECE);
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
   
   public boolean moveLegal(Move move)
   {
      int r = move.getRow();
      int c = move.getColumn();
      
      return true;
   }  


}
