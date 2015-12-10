import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame
{
	protected JLabel infoL;
	protected CheckerBoard board;
	protected JButton playB; 
	protected Canvas myCanvas;
	
	public GUI(CheckerBoard inBoard) {
        board = inBoard;
        
        setGraphics();//Creating graphics needed to run game
    }
	
	public void setGraphics()
	   {
	        setTitle("Checkers");
	        Container myPane = getContentPane();
	        
	        myPane.setLayout(new GridLayout(1, 2));
	        
	        JPanel controlPanel = new JPanel();
	        JPanel drawPanel = new JPanel();
	        myPane.add(drawPanel);
	        myPane.add(controlPanel);
	        myCanvas = new Canvas();
	        drawPanel.setLayout(new FlowLayout(0));
	        myCanvas.setSize(460, 460);
	        drawPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
	        drawPanel.add(myCanvas);
	        drawPanel.setOpaque(true);
	        
	        playB = new JButton("Play a Game!");
	        
	        GameActionListener gameListener = new GameActionListener();
	        playB.addActionListener(gameListener);
	        playB.setEnabled(true);
	        controlPanel.setLayout(new GridLayout(8, 2));
	        controlPanel.add(playB);
	        
	        controlPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setSize(1000,700);
	        setVisible(true);
	        
	        drawBoard();
	        
	    }

	   //Draws the checker Board with no Pieces
		public void drawBoard()
		{
         Graphics g = myCanvas.getGraphics();
         int width = myCanvas.getWidth();
         int height = myCanvas.getHeight();
         int size = board.getSize();
         int boxH = height / (size + 1);
         int boxW = width / (size + 1);
         
         int y = boxH;
         int x = boxW;
         
         for(int i = 0; i < size; i++)
         {  for(int j= 0; j<size; j++)
            {
               g.setColor(Color.white);
               g.drawRect(x,y,boxW, boxH);
               
               if(i%2 !=0)
               {
                  if(j%2 == 0)
                  {
                     g.setColor(Color.lightGray);
                     g.fillRect(x,y,boxW, boxH);
                  }
                  else
                  {
                     g.setColor(Color.white);
                     g.fillRect(x,y,boxW, boxH);
                  }
               }
               if(i%2 == 0)  
               {
                  if(j%2 == 0)
                  {
                     g.setColor(Color.white);
                     g.fillRect(x,y,boxW, boxH);
                  }
                  else
                  {
                     g.setColor(Color.lightGray);
                     g.fillRect(x,y,boxW, boxH);
                  }
               }
       
               x += boxW;
            }
            x = boxW;
            y +=boxH;
         } 
           
         g.setColor(Color.black);  
         int n = boxW;
         for (int column = 0; column <=size; column++) {
            ;
            g.drawLine(n,boxH, n,boxH*(size+1));
            n += boxW;
         }
                 
        // draw row numbers and horizontal board lines
         int d = boxH;
         for (int row = 0; row <= size; row++) {
            
            g.drawLine(boxW,d, boxW*(size+1),d);
            d += boxH;
         }
         //g.drawLine(boxW, (boxH * 9),(boxW * 9),(boxH * 9)); 
            
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
               drawPiece(board.getPiece(row,column), row, column, boxW, boxH);
            }
        }
        g.setFont(new Font("Times New Roman", 1, 20));

			
		}
	public class GameActionListener implements ActionListener {
		   
	    /** Gets event from game board and does appropriate action
	      */
	      public void actionPerformed(ActionEvent event) {
	         String command = event.getActionCommand();
	         Graphics myGraph = myCanvas.getGraphics();
            if(command.equals("Play a Game!"))
            {
               drawBoard();
               playB.setEnabled(false);     
	         }
         }   
	}
   private void drawPiece(Piece piece, int row, int column, int boxW, int boxH) {
         Graphics g = myCanvas.getGraphics();
         switch (piece.getType()) {
            case Piece.BLACKPIECE: g.setColor(Color.black); 
               row++;
               column++;	
               g.fillOval(column*boxW+1,row*boxH+1,boxW-2,boxH-2);
               break;
            case Piece.REDPIECE: g.setColor(Color.red); 
               row++;
               column++;	
               g.fillOval(column*boxW+1,row*boxH+1,boxW-2,boxH-2);
               break;
            // case Piece.BLANKPIECE: g.setColor(Color.white); 
//                break;
         }
        //  row++;
//          column++;	
//       	
//          g.fillOval(column*boxW+1,row*boxH+1,boxW-2,boxH-2);
         
         
      }
   
   
}


