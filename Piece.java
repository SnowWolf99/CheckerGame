/**********Pieces*************
   Black: 1    Black King: 11
   Red: 2      Red King: 12
******************************/

public class Piece {

	public static final int BLACKPIECE = 1;
	public static final int REDPIECE = 2;
	public static final int BLANKPIECE = 0;
	public static final int RED_KINGPIECE = 12;
   public static final int BLACK_KINGPIECE = 11;
   private int pieceType; 
	
	public Piece(int pieceNum)
	{
		pieceType = pieceNum;
	}

	public int getType()
    {
        return pieceType;
    
    }    

    public boolean equals(Piece otherPiece)
    {
        if(otherPiece.getType()== pieceType)
            return true;
        else
            return false;
    }
    
    public Piece getOpposite()
    {
        Piece oppositePiece;
        if(pieceType == BLACKPIECE)
        {
           oppositePiece = new Piece(REDPIECE);
           
           return(oppositePiece);
        }
        else if(pieceType == REDPIECE)
        {
            oppositePiece = new Piece(BLACKPIECE);
            return(oppositePiece);
        }
        else if(pieceType == RED_KINGPIECE)
        {
            oppositePiece = new Piece(BLACK_KINGPIECE);
            return(oppositePiece);
         }
         else if(pieceType == BLACK_KINGPIECE)
         {
            oppositePiece = new Piece(RED_KINGPIECE);
            return(oppositePiece);
         }      

        else
        {
            oppositePiece = new Piece(BLANKPIECE);
            return(oppositePiece);    
        }
    }
    
    public boolean opposite(Piece otherPiece)
    {
        if(otherPiece.getOpposite().getType() == pieceType)
            return true; 
        else
            return false;    
    
    }
}
