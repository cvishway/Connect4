
public class BoardController {
	private String turn = this.whichPlayerToStart();//commnicates whose turn it is
	private BoardData board = new BoardData(); 

	
	//this determines who goes first randomly, by using build in Math random function
	private String whichPlayerToStart(){
		double whichPlayerToCommence = Math.random();
		if(whichPlayerToCommence <10){ 
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
		if (this.turn =="blue"){
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

