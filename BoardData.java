import java.util.*;
import java.io.*;

import javax.swing.JOptionPane;

public class BoardData {
private String [][] data;
private String turn; 


	public BoardData(){
		this.data = new String[6][7];
		for(int row=0;row<6;row++){
			for(int col=0;col<7;col++){
				data[row][col] = "n/a";
			}
		}
	}
	
	public void AddRed(int col){
		int row = 0;
		while(data[row][col] != "n/a"){
			row++;
		}
		data[row][col] = "red";
	} 
	
	public void AddBlue(int col){
		int row = 0;
		while(data[row][col] != "n/a"){
			row++;
		}
		data[row][col] = "blue";
	}
	
	//returns the colour at the specified location
	public String GetColor(int row, int col){
		return this.data[row][col];
	}
	
	//resets the game and the board
	public void Reset(){
		for(int row=0;row<6;row++){
			for(int col=0;col<7;col++){
				data[row][col] = "";
			}
		}
	}
	

	
	
	public String isWin(){
		//vertical check
		String winner = "";
		for (int col=0;col<7;col++){   
            for (int row=0;row<3;row++){ 
                    if (data[row][col].equals(data[row+1][col]) && data[row][col].equals(data[row+2][col]) && data[row][col].equals(data[row+3][col]) && data[row][col].equals("red"))winner="red";
                    if (data[row][col].equals(data[row+1][col]) && data[row][col].equals(data[row+2][col]) && data[row][col].equals(data[row+3][col]) && data[row][col].equals("blue"))winner="blue";
            }
		}
		//horizontal check
		for (int row=0;row<6;row++){
            for(int col=0;col<4;col++){
                    if (data[row][col].equals(data[row][col+1]) && data[row][col].equals(data[row][col+2]) && data[row][col].equals(data[row][col+3]) && data[row][col].equals("red"))winner="red";
                    if (data[row][col].equals(data[row][col+1]) && data[row][col].equals(data[row][col+2]) && data[row][col].equals(data[row][col+3]) && data[row][col].equals("blue"))winner="blue";
            }                                      
        }
		//diagonal check #1
		for (int row=0;row<3;row++){ 
            for(int col=0;col<4;col++){   
                    if (data[row][col].equals(data[row+1][col+1]) && data[row][col].equals(data[row+2][col+2]) && data[row][col].equals(data[row+3][col+3]) && data[row][col].equals("red"))winner="red";
                    if (data[row][col].equals(data[row+1][col+1]) && data[row][col].equals(data[row+2][col+2]) && data[row][col].equals(data[row+3][col+3]) && data[row][col].equals("blue"))winner="blue";          
            }
		}
   
		//diagonal check #2
		for (int row=3;row<6;row++){ 
            for(int col=0;col<4;col++){   
                    if (data[row][col].equals(data[row-1][col+1]) && data[row][col].equals(data[row-2][col+2]) && data[row][col].equals(data[row-3][col+3]) && data[row][col].equals("red"))winner="red";
                    if (data[row][col].equals(data[row-1][col+1]) && data[row][col].equals(data[row-2][col+2]) && data[row][col].equals(data[row-3][col+3]) && data[row][col].equals("blue"))winner="blue";
            }
		}
		return winner;
	}
	
	public String getTurn(){
		return this.turn; 
	}
}