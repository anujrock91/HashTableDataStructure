package Snippet;

public class IslandPerimeter {
	 
	public int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		for(int row=grid.length-1;row>=0;row--){
			for(int col = 0;col<grid[0].length;col++){
				if(grid[row][col] == 0){ continue; }
				perimeter += getSelfPerimeter(grid, row, col);
			}
		}
		return perimeter;
	}
	
	
	public int getSelfPerimeter(int [][] mat, int row, int col){
		int count = 4;
		if(col-1 >= 0){ if(mat[row][col-1]==1){ --count; } }
		if(col+1 < mat[0].length){ if(mat[row][col+1] ==1){ --count; }  }
		if(row+1 < mat.length){ if(mat[row+1][col] ==1){ --count; }  }
		if(row-1 >=0){ if(mat[row-1][col] ==1){ --count; }  }
		return count;
	}
	
	
	public static void main(String [] args){
		int [][] grid = new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		System.out.println(new IslandPerimeter().islandPerimeter(grid));
	}
	
}