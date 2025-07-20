class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int count = 0;
        int row = grid.length;
        int col = grid[0].length;

        for(int r=0 ; r<row ; r++ ){
            for(int c=0; c<col ; c++){
                if(grid[r][c] == '1'){
                    dfs(grid , r ,c);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid , int r, int c){
        // invalid case or base case
        int row = grid.length;
        int col = grid[0].length;
        if(r<0 || r>=row || c<0 || c>=col || grid[r][c] != '1'){
            return;
        }

        // making island visited
        grid[r][c] = '0';

        // dfs calls
        dfs(grid , r+1 ,c);
        dfs(grid , r-1 ,c);
        dfs(grid , r ,c+1);
        dfs(grid , r ,c-1);
    }
}