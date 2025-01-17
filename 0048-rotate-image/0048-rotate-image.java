class Solution {
    public void rotate(int[][] matrix) {
      int n = matrix.length;

        // transpose of matrix
        for(int i=0 ; i<n ; i++){
            for(int j=i ; j<n ; j++){
                // swap mat[i][j] with mat[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse of each row of matrix
         for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n/2 ; j++){
                // swap mat[i][j] with mat[i][n-1-j]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}