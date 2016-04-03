
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.util.*;
import java.text.*; 




public class Board extends BoardController
{
	public static String [] modes = {"Player vs Player", "Player vs Computer"};
	public static String mode;
	private static boolean vsComputer; 
	private static BoardController controller= new BoardController(); 
	private static GameAI AI = new GameAI();
	public static void main(String[] args){
		mode = (String)JOptionPane.showInputDialog(
				null,
				"Select Game Mode",
				"Game Mode",
				JOptionPane.PLAIN_MESSAGE,
				null, modes,
				"--------");
		if(mode == modes[1])
			{
				vsComputer = true;
			}
		else
			{
				vsComputer = false;
			}
		
		 
		BoardGUI theBoard = new BoardGUI();
		theBoard.setTitle("Connect Four");
		theBoard.setVisible(true);
		theBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theBoard.setSize(500, 500);
	}
	
	
	public static class BoardGUI  extends JFrame implements ActionListener
	/*The reason this class implements the ActionListener class
	 * is to allow the buttons that add tokens to the board to be clicked
	 * more than once*/
	{	
		//the integers are click counters
		private int Click1=0;
		private int Click2=0;
		private int Click3=0;
		private int Click4=0;
		private int Click5=0;
		private int Click6=0;
		private int Click7=0;
		//this object relays messages from the GUI to the Model class, hence name of controller 
		
		//add buttons
		private JButton Column1 = new JButton("Add");
		private JButton Column2 = new JButton("Add");
		private JButton Column3 = new JButton("Add");
		private JButton Column4 = new JButton("Add");
		private JButton Column5 = new JButton("Add");
		private JButton Column6 = new JButton("Add");
		private JButton Column7 = new JButton("Add");
		
		//menu items
		
		
		//labels
		private JLabel status = new JLabel("Turn:"+controller.getTurn());
	
		
		private JLabel [][]  cells = new JLabel [6][7];//array of labels to repersent the board
		
		// the reason behind this is to at a later point grab the original colour of each created JLabel 
		private Color defaultColour; 
		
		
	
		public BoardGUI(){
			
			//create and add buttons to a button panel so they appear in the GUI
			JPanel buttonsPanel = new JPanel(new GridLayout(1,1));
			buttonsPanel.add(Column1);
			buttonsPanel.add(Column2);
			buttonsPanel.add(Column3);
			buttonsPanel.add(Column4);
			buttonsPanel.add(Column5);
			buttonsPanel.add(Column6);
			buttonsPanel.add(Column7);
			

			
			JPanel boardPanel = new JPanel(new GridLayout(6,7));
			this.updateBoard();
			for(int i = 5; i >=0; i--)
			{
				
				/*This for loop initates the the board's starting point
				 * it creates each label in the array
				 * it adds them to boardPanel */
				for(int j = 6; j>=0; j--)
				{
					cells[i][j]= new JLabel("");
					cells[i][j].setBackground(Color.yellow);
					cells[i][j].setBorder(BorderFactory.createEtchedBorder());
					cells[i][j].setOpaque(true);
					boardPanel.add(cells[i][j]);
					
				}
			}
			defaultColour = cells[0][0].getBackground(); 
			
			Container container = getContentPane();
			container.add(boardPanel,BorderLayout.CENTER);
			container.add(buttonsPanel,BorderLayout.NORTH);
			container.add(status,BorderLayout.SOUTH);
			
			
			//Add the actionListeners 
			Column1.addActionListener(this);
			Column2.addActionListener(this);
			Column3.addActionListener(this);
			Column4.addActionListener(this);
			Column5.addActionListener(this);
			Column6.addActionListener(this);
			Column7.addActionListener(this);
				
		}

		//This disables all the button on the board
		public void disableAll(){
			Column1.setEnabled(false);
			Column2.setEnabled(false);
			Column3.setEnabled(false);
			Column4.setEnabled(false);
			Column5.setEnabled(false);
			Column6.setEnabled(false);
			Column7.setEnabled(false);
		}
		
		//enables all the buttons
		private void buttonEnable(){
			Column1.setEnabled(true);
			Column2.setEnabled(true);
			Column3.setEnabled(true);
			Column4.setEnabled(true);
			Column5.setEnabled(true);
			Column6.setEnabled(true);
			Column7.setEnabled(true);
		}
		
	/* Method updates the color on the cell
	 * 1. Retrieves which color from BoardController class
	 * 2. Uses the color to place the correct background
	 */
	private void updateBoard(){
			for(int i = 0; i<6;i++){
				for(int j = 0;j <7; j++){
					if(controller.getColour(i,j)=="red"){
						cells[i][j].setBackground(Color.red);
						if(j==1)Click1++;
						else if(j==2)Click2++;
						else if(j==3)Click3++;
						else if(j==4)Click4++;
						else if(j==5)Click5++;
						else if(j==6)Click6++;
						else if(j==7)Click7++;
						
					}else if(controller.getColour(i,j)=="blue"){
						cells[i][j].setBackground(Color.blue);
						if(j==1)Click1++;
						else if(j==2)Click2++;
						else if(j==3)Click3++;
						else if(j==4)Click4++;
						else if(j==5)Click5++;
						else if(j==6)Click6++;
						else if(j==7)Click7++;
					}
				}
			}
			
			
		}
		
	
		
		//This method checks to see if there is winner, if so, it displays who won, and disables the buttons
		public void winner(String winningColour){
			this.disableAll();
			JOptionPane.showMessageDialog(null, "The winner is "+winningColour); 
		}
		
		
		@Override
		
		
		/* 1.Checks to see which button was pressed.	
		 * 2.Tells controller to add a chip 
		 * 3.Finds out what color placed, relays to user
		 * 4.Ensures that not more than 6 chips in one column
		 */
		
		public void actionPerformed(ActionEvent e) {

			if(e.getSource()== Column1){
				controller.add(6);
				this.updateBoard();
				if(Click1==6)Column1.setEnabled(false);
			}
			else if(e.getSource()== Column2){
				controller.add(5);
				this.updateBoard();
				if(Click2==6)Column2.setEnabled(false);
			}
			else if(e.getSource()== Column3){
				controller.add(4);
		
				this.updateBoard();
				
				if(Click3==6)Column3.setEnabled(false);
			}
			else if(e.getSource()== Column4){
				controller.add(3);
		
				this.updateBoard();
				
				if(Click4==6)Column4.setEnabled(false);
			}
			else if(e.getSource()== Column5){
				controller.add(2);
				this.updateBoard();
				
				if(Click5==6)Column5.setEnabled(false);
			}
			else if(e.getSource()== Column6){
				controller.add(1);
				this.updateBoard();	
				if(Click6==6)Column6.setEnabled(false);
			}
			else {
				controller.add(0); 
				this.updateBoard();
				if(Click7==6)Column7.setEnabled(false);
			}
			 
			if(vsComputer){
				AI.setMove();
				controller.add(AI.getMove());
				this.updateBoard();
			}
			status.setText("Turn:"+controller.getTurn()); 
		
			//this goes and calls the controller to see if there is a winner, and then the board deals with it
			if(controller.winner() != ""){
				this.winner(controller.winner());
				status.setText("The winner is "+controller.winner()); 
			}

		}

		private class QuitListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.exit(0);
			
			}
		}
		
		
		
		//resets the board
		private class ResetListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				for(int i= 5; i >= 0; i--){
					for(int j = 6; j>=0; j--){
						cells[i][j].setText("");
						cells[i][j].setBackground(defaultColour); 
						cells[i][j].setBorder(BorderFactory.createEtchedBorder());
						cells[i][j].setOpaque(true);
						
					}
				}
				Click1 =0;
				Click2 =0;
				Click3 =0;
				Click4 =0;
				Click5 =0;
				Click6 =0;
				Click7 =0;
				Column1.setEnabled(true);
				Column2.setEnabled(true);
				Column3.setEnabled(true);
				Column4.setEnabled(true);
				Column5.setEnabled(true);
				Column6.setEnabled(true);
				Column7.setEnabled(true);
				status.setText("Turn:"+controller.getTurn());
			}
		}

		

		
	}
	
	
	
}

