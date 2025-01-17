class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<Integer>();
        int stRow = 0;
        int endRow = matrix.length -1;
        int stCol = 0;
        int endCol = matrix[0].length -1;

        while(stRow <= endRow && stCol <= endCol){
            // top
            for(int j=stCol ; j<= endCol ; j++){
                list.add(matrix[stRow][j]);
            }
            stRow++;

            // rigth
            for(int i=stRow ; i<= endRow ; i++){
                list.add(matrix[i][endCol]);
            }
            endCol--;

            // bottom
            if(stRow<=endRow){
                for(int j=endCol ; j>= stCol ; j--){
                    list.add(matrix[endRow][j]);
                }
                endRow--;
            }

            // left
            if(stCol<=endCol){
                for(int i=endRow ; i>= stRow ; i--){
                    list.add(matrix[i][stCol]);
                }
                stCol++;
            }
        }
        return list;
    }
}