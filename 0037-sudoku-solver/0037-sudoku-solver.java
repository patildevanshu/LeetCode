class Solution {
    private boolean isSafe(char[][] board, int row, int col, char digit) {
        // check row & col
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit || board[i][col] == digit) return false;
        }

        // check 3x3 box
        int sR = (row / 3) * 3;
        int sC = (col / 3) * 3;
        for (int i = sR; i < sR + 3; i++) {
            for (int j = sC; j < sC + 3; j++) {
                if (board[i][j] == digit) return false;
            }
        }

        return true;
    }

    private boolean sudokuSolver(char[][] board, int row, int col) {
        // ✅ base case: solved when row = 9
        if (row == 9) return true;

        int nextRow = row, nextCol = col + 1;
        if (col == 8) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (board[row][col] != '.') {
            return sudokuSolver(board, nextRow, nextCol);
        }

        for (char digit = '1'; digit <= '9'; digit++) {
            if (isSafe(board, row, col, digit)) {
                board[row][col] = digit;
                if (sudokuSolver(board, nextRow, nextCol)) return true;
                board[row][col] = '.'; // backtrack
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        sudokuSolver(board, 0, 0);
    }
}
