class Solution {
    private static final int MOD = 1_000_000_007;
    private int[] dp;

    private int solve(int low, int high, int zero, int one, int len) {
        if (len > high) return 0; // Base case
        if (dp[len] != -1) return dp[len]; // Memoization

        int count = 0;
        if (len >= low && len <= high) {
            count = 1; // Count valid string
        }

        // Recursive calls for 'zero' and 'one'
        int addOne = solve(low, high, zero, one, len + one) % MOD;
        int addZero = solve(low, high, zero, one, len + zero) % MOD;

        return dp[len] = (count + addOne + addZero) % MOD;
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new int[100001];
        Arrays.fill(dp, -1); // Initialize memoization array
        return solve(low, high, zero, one, 0);
    }
}