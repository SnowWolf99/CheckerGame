import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Toolkit;
import java.util.List;



public class GUI extends JFrame
{
   protected String[] darkSquares, lightSquares;
	protected JLabel infoL, redCountL, blackCountL, statusLabel, turnL;
	protected CheckerBoard board;
   protected JTextField redC, blackC;
	protected JButton playB, saveB; 
	protected Canvas myCanvas;
   private JPanel controlPanel;
   protected Container myPane;
   protected boolean gate;
   private JMenuBar menuMB = new JMenuBar(); 
   private JMenu fileM;
   private JMenuItem exitI, newGameI;
   protected int startR, startC, endR, endC;
   protected Player currentPlayer, nextPlayer;
   private GUI display;
	
	public GUI(CheckerBoard inBoard) {
        setUIFont (new javax.swing.plaf.FontUIResource("Times New Roman",Font.BOLD,18));
        board = inBoard;
        gate = true;
        display = this;
        setJMenuBar(menuMB);
         setFileMenu();
        setGraphics();//Creating graphics needed to run game
    }
    private void setFileMenu()
   {
       fileM = new JMenu("File");
       menuMB.add(fileM);
       exitI = new JMenuItem("Exit");
       fileM.add(exitI);
       exitI.addActionListener(new QuitActionListener());
       
   }
	
	public void setGraphics()
	   {
         
           getArrays(); //creates arrays telling what squares are light or dark
                     
           
           setTitle("Checkers");
	        myPane = getContentPane();
	        myPane.setLayout(new GridLayout(1, 2));
	        
	        controlPanel = new JPanel();
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
           saveB = new JButton("Save Game");
           infoL = new JLabel("");
           
           turnL = new JLabel("");
           	        redCountL = new JLabel("Red Pieces Left: ");
           blackCountL = new JLabel("Black Pieces Left: ");
	        GameActionListener gameListener = new GameActionListener();
	        playB.addActionListener(gameListener);
           saveB.addActionListener(gameListener);
           
           statusLabel = new JLabel("",JLabel.CENTER); 
           myCanvas.addMouseListener(new MoveMouseListener());
	        
           playB.setEnabled(true);
	        controlPanel.setLayout(new GridLayout(8, 2));
           saveB.setEnabled(false);
	        controlPanel.add(playB);
	        controlPanel.add(statusLabel);
	        controlPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setSize(1000,700);
	        setVisible(true);
	        
	        drawBoard();
	        
	    }

	   //Draws the checker Board with no Pieces
		public void getArrays()
      {
         lightSquares = new String [32];
         darkSquares = new String [32];
         int size = board.getSize();
         int a = 0;
         int b = 0;
         
         for(int i = 0; i < size; i++)
         {  
            for(int j= 0; j<size; j++)
            {
               if(i%2 !=0)
               {
                  if(j%2 == 0)
                  {
                     darkSquares[b] = (i + ", " +j);
                     b++;
                  }
                  else
                  {
                     lightSquares[a] = (i + ", " +j);
                     a++;  
                  }
               }
               if(i%2 == 0)  
               {
                  if(j%2 == 0)
                  {
                     lightSquares[a] = (i + ", " +j);
                     a++;
                  }
                  else
                  {
                     darkSquares[b] = (i + ", " +j);
                     b++;
                  }
               }
               
            }
         } 
         for(String z: lightSquares)
            System.out.println(z);
         System.out.println("Light: END OF LOOP");
      
         for(String x: darkSquares)
            System.out.println(x);
         System.out.println("DARK: END OF LOOP");
      }  
      
      public void setUIFont (javax.swing.plaf.FontUIResource f)
      {
         java.util.Enumeration keys = UIManager.getDefaults().keys();
         while (keys.hasMoreElements())
         {
            Object key = keys.nextElement();
            Object value = UIManager.get (key);
            if (value != null && value instanceof javax.swing.plaf.FontUIResource)
               UIManager.put (key, f);
         }
      }  
      public String getSquare(int r, int c)
      {
         for(String a: lightSquares)
         {
            if(a.equals(r + ", " +c))
               return("Light Square");
         }
         return("Dark Square");         
      }
      
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
         
         int a = 0;
         for(int i = 0; i < size; i++)
         {  for(int j= 0; j<size; j++)
            {
               
               g.setColor(Color.white);
               g.drawRect(x,y,boxW, boxH);
               
               if(i%2 !=0)
               {
                  if(j%2 == 0)
                  {
                  
                     g.setColor(Color.darkGray);
                     g.fillRect(x,y,boxW, boxH);
                  }
                  else
                  {
                 
                     g.setColor(Color.white);
                     g.fillRect(x,y,boxW, boxH);
                     // lightSquares[a] = (i + ", " +j);
//                      a++;
                     
                  }
               }
               if(i%2 == 0)  
               {
                  if(j%2 == 0)
                  {
                  
                     g.setColor(Color.white);
                     g.fillRect(x,y,boxW, boxH);
                     // lightSquares[a] = (i + ", " +j);
//                      a++;
                  }
                  else
                  {
                    
                     g.setColor(Color.darkGray);
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
            
            g.drawLine(n,boxH, n,boxH*(size+1));
            n += boxW;
         }
                 
        // draw row numbers and horizontal board lines
         int d = boxH;
         for (int row = 0; row <= size; row++) {
            
            g.drawLine(boxW,d, boxW*(size+1),d);
            d += boxH;
         }
            
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
               drawPiece(board.getPiece(row,column), row, column, boxW, boxH);
            }
        }
        g.setFont(new Font("Times New Roman", 1, 20));
        turnL.setText(board.getCurrentPlayer().getName() + " you're up!");
        redCountL.setText("Red Pieces Left: " + board.countPieces(board.getRedPlayer()));
        blackCountL.setText("Black Pieces Left: " + board.countPieces(board.getBlackPlayer()));
         
		}
       /** Quit ActionListener */
      private class QuitActionListener implements ActionListener {
        // one method to get the data and perform the specified action
        /** handles all button action
          * @param event the event associated with the button pushed
          */
         public void actionPerformed(ActionEvent event) {
            System.exit(0);
         }
      }
      
   
	public class GameActionListener implements ActionListener {
		   
	    /** Gets event from game board and does appropriate action
	      */
	      public void actionPerformed(ActionEvent event) {
	         String command = event.getActionCommand();
	         Graphics myGraph = myCanvas.getGraphics();
            
            //Removes playButton and adds the needed components for the game
            if(command.equals("Play a Game!"))
            {
               drawBoard();
               Container parent = playB.getParent();
               parent.remove(playB);
               parent.revalidate();
               parent.add(turnL);
               parent.add(infoL);
               parent.add(redCountL);
               parent.add(blackCountL);
               parent.add(saveB);
               
               parent.repaint();
               
               saveB.setEnabled(true);
               
                    
	         }
         }   
	}
   private void drawPiece(Piece piece, int row, int column, int boxW, int boxH) {
         Graphics g = myCanvas.getGraphics();
         Graphics2D g2d = (Graphics2D) g;

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
            case Piece.RED_KINGPIECE:
               g.setColor(Color.red); 
               row++;
               column++;	
               g.fillOval(column*boxW+1,row*boxH+1,boxW-2,boxH-2);
               int startX = column*boxW +10;
               int startY = row*boxH+10;
              // build a polygon in the shape of an 18 pixel by 18 pixel crown
              Polygon crown = new Polygon();
              crown.addPoint(startX, startY);
              crown.addPoint(startX + 15, startY + 15);
              crown.addPoint(startX + 30, startY);
              crown.addPoint(startX + 30, startY + 30);
              crown.addPoint(startX, startY + 30);
      
              // and draw it
              g.setColor(Color.yellow);
              g.drawPolygon(crown);
              g.fillPolygon(crown);
              break;
            case Piece.BLACK_KINGPIECE:
               g.setColor(Color.black); 
               row++;
               column++;	
               g.fillOval(column*boxW+1,row*boxH+1,boxW-2,boxH-2);
               startX = column*boxW +10;
               startY = row*boxH+10;
               // build a polygon in the shape of an 18 pixel by 18 pixel crown
               crown = new Polygon();
               crown.addPoint(startX, startY);
               crown.addPoint(startX + 15, startY + 15);
               crown.addPoint(startX + 30, startY);
               crown.addPoint(startX + 30, startY + 30);
               crown.addPoint(startX, startY + 30);
       
              // and draw it
               g.setColor(Color.yellow);
               g.drawPolygon(crown);
               g.fillPolygon(crown);
               break;
      
               
         } 
      }
               
      
      /** move MouseListener */
      private class MoveMouseListener implements MouseListener {

         public void mouseClicked(MouseEvent e) 
         {
          //statusLabel.setText("Mouse Clicked: ("+e.getX()+", "+e.getY() +")");
            int x = e.getX();
            int y = e.getY();
            int width = myCanvas.getWidth();
            int height = myCanvas.getHeight();
            int size = board.getSize();
            int boxH = height / (size + 1);
            int boxW = width / (size + 1);
            
            int column = x / boxW - 1;
            int row = y / boxH - 1;
            statusLabel.setText("Box at: " + row + ", " + column);
            infoL.setText("");
            
            if(gate == true)
            {
               if(board.getPiece(row,column).equals(board.getCurrentPlayer().getPiece()))
               {
                  startR = row;
                  startC = column;
                  gate = false;
               }
               else
               {
                  infoL.setText("You can't move another player's piece!");
               }
            }   
            else
            {
               endR = row;
               endC = column;
               makeMove();
               gate = true;
            }      
            
         }
         public void mousePressed(MouseEvent e)
         {
         }
      
         public void mouseReleased(MouseEvent e) 
         {
         }
      
         public void mouseEntered(MouseEvent e) 
         {
         }
      
         public void mouseExited(MouseEvent e) 
         {
         }
      }
      
      //Physically moves the pieces on the board
      public void makeMove()
      {
         Piece movePiece = board.getPiece(startR, startC);
         Piece tempPiece = board.getPiece(endR, endC);
         Move move = new Move(board.getCurrentPlayer(), endR, endC);
         if(getSquare(endR, endC).equals("Light Square"))
            infoL.setText("You can't make a move there!");
         if(board.moveLegal(move) == true)
         {
            board.movePiece(movePiece, startR, startC, endR, endC);
            board.setCurrentPlayer(board.getNextPlayer());
            drawBoard();
         }
         else
         {
            infoL.setText("You can't make a move there!");
         }
               
      }

   
   
}


