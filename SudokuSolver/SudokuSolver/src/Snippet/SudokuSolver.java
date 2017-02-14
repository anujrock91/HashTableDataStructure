package Snippet;
import java.util.*;

public class SudokuSolver {
	
	HashMap<Integer, HashSet<Character>> rowStore;
	HashMap<Integer, HashSet<Character>> colStore;
	HashMap<Integer, HashMap<Integer,HashSet<Character>>> boxStore;
	
	public void fillSudoku(char board[][]){
		rowStore = new HashMap<>();
		colStore = new HashMap<>();
		boxStore = new HashMap<>();
		
		for(int i=0;i<9;i++){
			rowStore.put(i, new HashSet<Character>());
			colStore.put(i, new HashSet<Character>());
		}
		
		for(int i=0;i<3;i++){
			boxStore.put(i, new HashMap<Integer,HashSet<Character>>());
		}
		for(Integer i: boxStore.keySet()){
			HashMap<Integer, HashSet<Character>> temp = boxStore.get(i);
			for(int eachBox =0;eachBox<3;eachBox++){
				temp.put(eachBox, new HashSet<Character>());
			}
		}
		
		for(int row=0;row<9;row++){
			for(int col=0;col<9;col++){
				char c = board[row][col];
				if(c == '.'){ continue; }
				rowStore.get(row).add(c);
				colStore.get(col).add(c);
				HashMap<Integer, HashSet<Character>> box = boxStore.get(row/3);
				box.get(col/3).add(c);
			}
		}
		return;
	}
	
	
	public void sudoku(char board[][]){
		fillSudoku(board);
		sudokuSolver(board);
	}
	
	
	public boolean sudokuSolver(char board[][]){
		int flag = 0;
		int insertRow = 0;
		int insertCol = 0;
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				char c = board[i][j];
				if(c == '.'){
					insertRow = i;
					insertCol = j;
					flag = 1;
					break;
				}
			}
			if(flag == 1){ break; }
		}
		
		if(flag == 0){ return true; }
		
		for(int i=1;i<10;i++){
			String num = ""+i;
			char c = num.charAt(0);
			if(rowStore.get(insertRow).contains(c) || colStore.get(insertCol).contains(c) || boxStore.get(insertRow/3).get(insertCol/3).contains(c)){
				continue;
			}
			else{
				board[insertRow][insertCol] = c;
				rowStore.get(insertRow).add(c);
				colStore.get(insertCol).add(c);
				boxStore.get(insertRow/3).get(insertCol/3).add(c);
				boolean dec = sudokuSolver(board);
				if(dec == false){ 
					rowStore.get(insertRow).remove(c);
					colStore.get(insertCol).remove(c);
					boxStore.get(insertRow/3).get(insertCol/3).remove(c);
					board[insertRow][insertCol] = '.';
					continue; 
				}
				else{ return true; }
			}
		}
		
		return false;
	}
	
	
	public static void main(String args[]){
		char mat[][] = new char[][]{
			{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}
		};
		
		new SudokuSolver().sudoku(mat);
		for(char [] row: mat){
			for(char c: row){
				System.out.print(c+ " | ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
}