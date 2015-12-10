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
	        setDefaultCloseOperation(0);
	        setSize(1000, 460);
	        setVisible(true);
	        
	        drawBoard();
	        
	    }

	
		public void drawBoard()
		{
			
		}
	public class GameActionListener implements ActionListener {
		   
	    /** Gets event from game board and does appropriate action
	      */
	      public void actionPerformed(ActionEvent event) {
	         String command = event.getActionCommand();
	         Graphics myGraph = myCanvas.getGraphics();
	      }
	}
}


