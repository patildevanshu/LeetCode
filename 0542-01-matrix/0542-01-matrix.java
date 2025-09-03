class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }
        
        Queue<int[]> q = new LinkedList<>();
        
        // Step 1: Initialize queue with all cells having 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    ans[i][j] = 0;
                    q.add(new int[]{i, j});
                }
            }
        }
        
        // Step 2: BFS
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0];
            int y = cell[1];
            
            for (int[] d : directions) {
                int nx = x + d[0];
                int ny = y + d[1];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m 
                    && ans[nx][ny] == Integer.MAX_VALUE) {
                    
                    ans[nx][ny] = ans[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        
        return ans;
    }
}