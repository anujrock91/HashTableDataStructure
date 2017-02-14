package Snippet;
import java.util.*;
public class ValidSudoku {
	
	public boolean isValidSudoku(char [][] board){
		for(int row=0;row<board.length;row++){
			HashSet<Character> validateRow = new HashSet<>(); 
			HashSet<Character> validCol = new HashSet<>();
			for(int col=0;col<board[0].length;col++){
				char c = board[row][col];
				if(c == '.'){  }
				else if(validateRow.contains(c)){ return false; }
				else { validateRow.add(c); }
				c = board[col][row];
				if(c=='.'){}
				else if(validCol.contains(c)){ return false; }
				else {	validCol.add(c); } 
			}
			validateRow.clear();
			validCol.clear();
		}
		
		for(int box=0;box<9;box=box+3){
			HashSet<Character> validBox = new HashSet<>();
			for(int i=box;i<box+3;i++){
				for(int j=0;j<3;j++){
					char c= board[i][j];
					if(c=='.'){ continue; } 
					if(validBox.contains(c)){ return false; }
					validBox.add(c);
				}
			}
			
			validBox.clear();
			for(int i=box;i<box+3;i++){
				for(int j=3;j<6;j++){
					char c= board[i][j];
					if(c=='.'){ continue; } 
					if(validBox.contains(c)){ return false; }
					validBox.add(c);
				}
			}
			
			validBox.clear();
			for(int i=box;i<box+3;i++){
				for(int j=6;j<9;j++){
					char c= board[i][j];
					if(c=='.'){ continue; } 
					if(validBox.contains(c)){ return false; }
					validBox.add(c);
				}
			}
		}
		
		return true;
	}
	
	
	public static void main(String args[]){
		char mat[][] = new char[][]{
			{'.','.','5','.','.','.','.','.','6'},
			{'.','.','.','.','1','4','.','.','.'},
			{'.','.','.','.','.','.','.','.','.'},
			{'.','.','.','.','.','9','2','.','.'},
			{'5','.','.','.','.','2','.','.','.'},
			{'.','.','.','.','.','.','.','3','.'},
			{'.','.','.','5','4','.','.','.','.'},
			{'3','.','.','.','.','.','4','2','.'},
			{'.','.','.','2','7','.','6','.','.'}
		};
		
		for(char row[]: mat){
			for(char c: row){
				System.out.print(c);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println(new ValidSudoku().isValidSudoku(mat));
	}
	
}