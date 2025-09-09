class Solution {
    private Boolean[][] dp;

    private boolean hasSubset(int[] nums, int target, int idx) {
        if (target == 0) return true;
        if (idx >= nums.length || target < 0) return false;

        if (dp[idx][target] != null) return dp[idx][target];

        boolean take = hasSubset(nums, target - nums[idx], idx + 1);
        boolean skip = hasSubset(nums, target, idx + 1);

        return dp[idx][target] = take || skip;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false;

        dp = new Boolean[nums.length][sum / 2 + 1];
        return hasSubset(nums, sum / 2, 0);
    }
}
