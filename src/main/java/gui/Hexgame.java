package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 

/**********************************
  This is the main class of a Java program to play a game based on hexagonal tiles.
  The mechanism of handling hexes is in the file hexmech.java.

  Written by: M.H.
  Date: December 2012

 ***********************************/

public class Hexgame
{
  public Hexgame() {
		initGame();
		createAndShowGUI();
	}



	//constants and global variables
	final static Color COLOURBACK =  Color.WHITE;
	final static Color COLOURCELL =  new Color(210,210,210,200); 
	final static Color COLOURGRID =  Color.BLACK;	 
	final static Color COLOURONE = new Color(255,255,255,255);
	final static Color COLOURONETXT = Color.BLUE;
	final static Color COLOURTWO = new Color(0,0,0,200);
	final static Color COLOURTWOTXT = new Color(255,100,255);
	final static int EMPTY = 0;
	final static int BSIZE = 10; //board size.
	final static int BSIZE2 = 8; //board size.
	final static int HEXSIZE = 60;	//hex size in pixels
	final static int BORDERS = 15;  
	final static int SCRSIZE = HEXSIZE * (BSIZE + 1) + BORDERS*3; //screen size (vertical dimension).
	private DrawingPanel drawPanel;
	
	String[] tab= {"0.0", "0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7",
		      "1.0", "1.1", "1.4", "1.5", "1.6", "1.7",
		      "2.0", "2.1", "2.7",
		      "3.7",
		      "4.7",
		      "5.7",
		      "6.0",
		      "7.7",
		      "8.0", "8.6", "8.7",
		      "9.0", "9.1", "9.2", "9.5", "9.6", "9.7"};

	int[][] board = new int[BSIZE][BSIZE];

	void initGame(){

		Hexmech.setXYasVertex(false); //RECOMMENDED: leave this as FALSE.

		Hexmech.setHeight(HEXSIZE); //Either setHeight or setSize must be run to initialize the hex
		Hexmech.setBorders(BORDERS);

		for (int i=0;i<BSIZE;i++) {
			for (int j=0;j<BSIZE;j++) {
				board[i][j]=EMPTY;
			}
		}

	}

	private void createAndShowGUI()
	{
		drawPanel = new DrawingPanel();
		drawPanel.setPreferredSize(new Dimension(580, 0));		
	}
	
	public DrawingPanel getDrawingPanel() {
		return drawPanel;
	}


	class DrawingPanel extends JPanel
	{		

		public DrawingPanel()
		{	
			setBackground(COLOURBACK);

			MyMouseListener ml = new MyMouseListener();            
			addMouseListener(ml);
		}

		public void paintComponent(Graphics g)
		{
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			super.paintComponent(g2);
			String ValidCoord;
			boolean draw;
			
			//draw grid
			for (int i=0;i<BSIZE;i++) {
				for (int j=0;j<BSIZE2;j++) {
					draw = true;
					ValidCoord = i +"."+j ;
					for(int k=0; k<tab.length;k++){
						if(ValidCoord.equals(tab[k])){
							draw = false;
						}
					}
					if(draw == true){
						Hexmech.drawHex(i,j,g2);
						Hexmech.fillHex(i,j,board[i][j],g2);
					}
				}
			}

		}

		class MyMouseListener extends MouseAdapter	{	//inner class inside DrawingPanel 
			public void mouseClicked(MouseEvent e) { 
				int x = e.getX(); 
				int y = e.getY(); 

				Point p = new Point( Hexmech.pxtoHex(e.getX(),e.getY()) );
				if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE){
					
					return;
				}


				//What do you want to do when a hexagon is clicked?
				board[p.x][p.y] = (int)'X';
				repaint();
			}		 
		} //end of MyMouseListener class 
	} // end of DrawingPanel class
}