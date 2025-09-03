class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] ans = new int[n][m];

        // initailize with max value
        for(int i=0; i<n ; i++){
            Arrays.fill(ans[i] , Integer.MAX_VALUE -100);
        }

        // first pass form top-left to buttom-right
        for(int i=0; i<n ; i++){
            for(int j=0; j<m ; j++){
                if(grid[i][j] == 0){
                    ans[i][j] = 0;
                }else{
                    if(i>0){
                        ans[i][j] = Math.min(ans[i][j] , ans[i-1][j] + 1 );
                    }
                    if(j>0){
                        ans[i][j] = Math.min(ans[i][j] , ans[i][j-1] +1);
                    }
                }
            }
        }

        // Second pass , buttom right t0 topleft
        for(int i=n-1 ; i>=0 ; i--){
            for(int j=m-1 ; j>=0 ; j--){
                if(grid[i][j] != 0){
                    if(i<n-1){
                        ans[i][j] = Math.min(ans[i][j] , ans[i+1][j] + 1 );
                    }
                    if(j<m-1){
                        ans[i][j] = Math.min(ans[i][j] , ans[i][j+1] +1);
                    }
                }
            }
        }
        
        return ans;
    }
}