public class Player
{
   private Piece pieceType;
   private String name;
   
   public Player(String inName, Piece inPiece)
   {
      name = inName;
      pieceType = inPiece;
   }   

   public Piece getPiece()
   {
      return pieceType;
   }
   
   public String getName()
   {
      return name;
   }   


}