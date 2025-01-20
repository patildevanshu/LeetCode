import java.util.HashMap;

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        int n = mat.length;
        int m = mat[0].length;
        int max = Integer.MAX_VALUE;

        // Check rows
        for (int i = 0; i < n; i++) {
            int min = 0;
            for (int j = 0; j < m; j++) {
                min = Math.max(min, map.get(mat[i][j]));
            }
            max = Math.min(max, min);
        }

        // Check columns
        for (int j = 0; j < m; j++) {
            int min = 0;
            for (int i = 0; i < n; i++) {
                min = Math.max(min, map.get(mat[i][j]));
            }
            max = Math.min(max, min);
        }

        return max;
    }
}