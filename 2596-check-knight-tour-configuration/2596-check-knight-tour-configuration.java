class Solution {
    private boolean isValid(int[][] grid , int row , int col, int expectedValue){
        if(row<0 || row>= grid.length ||
         col<0 || col>=grid[0].length ||
          grid[row][col] != expectedValue) {
            return false;
        }
        if(expectedValue == (grid.length * grid.length) -1) return true;

        boolean ans1 = isValid(grid , row-2 , col+1 , expectedValue +1);
        boolean ans2 = isValid(grid , row-1 , col+2 , expectedValue +1);
        boolean ans3 = isValid(grid , row+1 , col+2 , expectedValue +1);
        boolean ans4 = isValid(grid , row+2 , col+1 , expectedValue +1);
        boolean ans5 = isValid(grid , row+2 , col-1 , expectedValue +1);
        boolean ans6 = isValid(grid , row+1 , col-2 , expectedValue +1);
        boolean ans7 = isValid(grid , row-1 , col-2 , expectedValue +1);
        boolean ans8 = isValid(grid , row-2 , col-1 , expectedValue +1);
        return ans1 || ans2 || ans3 || ans4|| ans5 || ans6 || ans7 || ans8;

    }
    public boolean checkValidGrid(int[][] grid) {
        return isValid(grid , 0 , 0 , 0);
    }
}