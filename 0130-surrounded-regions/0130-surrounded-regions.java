class Solution {

    private void dfs(int r, int c, int row, int col, char[][] board) {
        if (r < 0 || r >= row || c < 0 || c >= col || board[r][c] != 'O') {
            return;
        }

        board[r][c] = 'V';

        dfs(r + 1, c, row, col, board); // Down
        dfs(r - 1, c, row, col, board); // Up
        dfs(r, c + 1, row, col, board); // Right
        dfs(r, c - 1, row, col, board); // Left
    }

    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        //  step 1 - border and conneted o are marked as v 
        for(int j = 0; j<col ; j++){
            if(board[0][j] == 'O'){
                dfs(0 , j , row , col , board);
            }
            if(board[row-1][j] == 'O'){
                dfs(row-1 , j , row , col , board);
            }
        }

        for(int i=0 ; i<row ; i++){
            if(board[i][0] == 'O'){
                dfs(i , 0 , row , col , board);
            }
            if(board[i][col-1] == 'O'){
                dfs(i , col-1, row , col , board);
            }
        }

        // step 2 - leftover o's flipped to x
        for(int i=0 ; i<row ; i++){
            for(int j=0; j<col ; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

        // step 3 - flip v back to o
        for(int i=0 ; i<row ; i++){
            for(int j=0; j<col ; j++){
                if(board[i][j] == 'V'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }

}