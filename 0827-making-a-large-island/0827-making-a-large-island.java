import java.util.*;

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[] size = new int[2 + n * n];  // Stores island sizes
        int numComp = 2;  // Start labeling islands from 2
        int maxSize = 0;  

        // Step 1: Label all islands and store their sizes
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < n; ++col) {
                if (grid[row][col] == 1) {
                    size[numComp] = dfs(grid, row, col, numComp);
                    maxSize = Math.max(maxSize, size[numComp]);  
                    ++numComp;
                }
            }
        }

        // Step 2: Check each `0` and compute possible max island size
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < n; ++col) {
                if (grid[row][col] != 0) continue;

                int mergedSize = 1;  // Start with size 1 (flipped cell)
                Set<Integer> seenIslands = new HashSet<>();

                // Check all four directions
                if (row > 0) seenIslands.add(grid[row - 1][col]);
                if (col > 0) seenIslands.add(grid[row][col - 1]);
                if (row + 1 < n) seenIslands.add(grid[row + 1][col]);
                if (col + 1 < n) seenIslands.add(grid[row][col + 1]);

                // Sum up sizes of distinct adjacent islands
                for (int island : seenIslands) {
                    mergedSize += size[island];
                }

                maxSize = Math.max(maxSize, mergedSize);
            }
        }

        return maxSize;
    }

    // DFS function to label islands and return size
    private int dfs(int[][] grid, int row, int col, int num) {
        int n = grid.length;
        if (row < 0 || row >= n || col < 0 || col >= n || grid[row][col] != 1) {
            return 0;
        }

        grid[row][col] = num;  // Label the island with a unique number
        int size = 1;

        // Explore all four directions
        size += dfs(grid, row - 1, col, num);
        size += dfs(grid, row + 1, col, num);
        size += dfs(grid, row, col - 1, num);
        size += dfs(grid, row, col + 1, num);

        return size;
    }
}