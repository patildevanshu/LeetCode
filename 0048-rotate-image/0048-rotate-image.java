class Solution {
    public void rotate(int[][] matrix) {
      int n = matrix.length;

        // // transpose of matrix
        // for(int i=0 ; i<n ; i++){
        //     for(int j=i ; j<n ; j++){
        //         // swap mat[i][j] with mat[j][i]
        //         int temp = matrix[i][j];
        //         matrix[i][j] = matrix[j][i];
        //         matrix[j][i] = temp;
        //     }
        // }

        // // reverse of each row of matrix
        //  for(int i=0 ; i<n ; i++){
        //     for(int j=0 ; j<n/2 ; j++){
        //         // swap mat[i][j] with mat[i][n-1-j]
        //         int temp = matrix[i][j];
        //         matrix[i][j] = matrix[i][n-1-j];
        //         matrix[i][n-1-j] = temp;
        //     }
        // }

        // 2nd approach

        int layers = n/2;

        for(int layer = 0; layer<layers ; layer++){
            int st = layer;
            int end = n-1-layer;

            for(int i=st ; i<end ; i++){
                // top in temp;
                int temp = matrix[st][i];

                // left in top
                matrix[st][i] = matrix[n-1-i][st];

                // buttom in left
                matrix[n-1-i][st] = matrix[end][n-1-i];

                // right in buttom
                matrix[end][n-1-i] = matrix[i][end];

                // top in right
                matrix[i][end] = temp;
            }
        }
    }
}