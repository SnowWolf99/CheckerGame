
public class Piece {
	
	private static final int BLACKPIECE = 1;
	private static final int REDPIECE = 2;
	private static final int BLANKPIECE = 0;
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
        if(pieceType == 1)
        {
           oppositePiece = new Piece(2);
           
           return(oppositePiece);
        }
        else if(pieceType == 2)
        {
            oppositePiece = new Piece(1);
            return(oppositePiece);
        }
        else
        {
            oppositePiece = new Piece(0);
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
