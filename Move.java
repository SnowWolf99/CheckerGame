public class Move
{

   private Player player;
   private int row, column;
   private Piece pieceType;
   
   public Move(Player inPlayer, int r, int c)
   {
      player = inPlayer;
      pieceType = player.getPiece();
      row = r;
      column = c;
   }
   
   public int getRow()
   {
      return row;
   }
   
   public int getColumn()
   {
      return column;
   }
   
   
}            