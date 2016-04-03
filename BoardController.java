
public class BoardController {
	
	
	
	
	private String turn = this.whichPlayerToStart();//commnicates whose turn it is
	private BoardData board = new BoardData(); 

	
	//method determines which player will commence the game
	//uses math.random to determine who goes first
	private String whichPlayerToStart(){
		double whichPlayerToCommence = Math.random();
		double randomLimit = Math.random();
		if(whichPlayerToCommence <= randomLimit){ 
		this.turn  = "blue";
		return this.turn;
		}
		else{
		this.turn  = "red";
		return this.turn;
		} 
	}
	
	public String getTurn()
	{
		return this.turn; 
	}
	
	// Method used to switch turns between players
	public void changeTurn(){
		if (this.turn =="blue")
		{
			this.turn = "red";
			
		}else{
			this.turn ="blue";
		}
	}
	
	//used to communicate the colour in the array to the board
	public String getColour(int row, int column)
	{
		
		return board.GetColor(row, column); 
		
	}
	
	
	//tells the model to reset its data
	 public void add(int column){
		if(turn == "blue"){
			board.AddBlue(column);
			
		}else{
			board.AddRed(column);
		}
		this.changeTurn();
	}
	
	
	 public void reset()
		{
	       	board.Reset();
			this.whichPlayerToStart(); 
		}
	 
	 
	//Determines the winner and returns it
	public String winner(){
		String winner ="";
		if(board.isWin() == "blue")
			{
			winner= "blue";
			}
		else if(board.isWin()=="red")
			{
			winner= "red";
			}
		return winner; 
	}

	
	

	
}

