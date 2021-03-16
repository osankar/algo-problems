package sankar.ojili.java.algos.fbleet;

public class NumberOfIslands {
	public static void main(String[] args) {
		
	}
}

class NumberOfIslandsSolution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        if(grid == null || grid.length == 0) {
            return islands;
        }
        
        for(int i =0; i< grid.length; i++){
            for(int j=0; j< grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    islands += checkNeighbors(grid, i, j);
                }
            }
        }
        return islands;
    }
    
    int checkNeighbors(char[][] grid, int i, int j){
        if( i < 0|| i >= grid.length || j<0|| j>=grid[i].length || grid[i][j] == '0') {
            return 0;
        }
        grid[i][j] = '0';
        checkNeighbors(grid, i+1, j);
        checkNeighbors(grid, i-1, j);
        checkNeighbors(grid, i, j+1);
        checkNeighbors(grid, i, j-1);
        
        return 1;
    }
}