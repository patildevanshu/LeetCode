class Solution {
    private boolean isSafe(char[][] board , int row , int col){
        // vertically up
        for(int i = row - 1 ; i >= 0 ; i--){
            if(board[i][col] == 'Q') return false;
        }

        // diagonal left up
        for(int i = row - 1 , j = col - 1 ; i >= 0 && j >= 0 ; i-- , j--){
            if(board[i][j] == 'Q') return false;
        }

        // diagonal right up
        for(int i = row - 1 , j = col + 1 ; i >= 0 && j < board.length ; i-- , j++){
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }

    private void nQueens(char[][] board , int row , List<List<String>> ans ){
        if(row == board.length){
            addToList(board , ans);
            return;
        }

        for(int col = 0 ; col < board.length ; col++){
           if(isSafe(board , row , col)){
               board[row][col] = 'Q';
               nQueens(board , row + 1 , ans);
               board[row][col] = '.';
           }
        }
    }

    private void addToList(char[][] board , List<List<String>> ans){
        List<String> temp = new ArrayList<>();
        for(int i = 0 ; i < board.length ; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < board.length ; j++){
                sb.append(board[i][j]);
            }
            temp.add(sb.toString());
        }
        ans.add(temp);
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(board[i] , '.');
        }

        List<List<String>> ans = new ArrayList<>();
        nQueens(board , 0 , ans);
        return ans;
    }
}
