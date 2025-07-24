class Solution {
    public int getLeft(int[] nums){
        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
            min = Math.min(min, nums[i]);
        }
        return min;
    }

    public int getRight(int[] nums){
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public long getCost(int[] nums, int[] cost, int target){
        long rs = 0;
        for(int i = 0; i < nums.length; i++){
            rs += (long)Math.abs(nums[i] - target) * cost[i];
        }
        return rs;
    }

    public long minCost(int[] nums, int[] cost) {
        int left = getLeft(nums);
        int right = getRight(nums);
        long ans = Long.MAX_VALUE;

        while(left <= right){
            int mid = left + (right - left) / 2;

            long leftCost = getCost(nums, cost, mid);
            long rightCost = getCost(nums, cost, mid + 1);
            ans = Math.min(ans, Math.min(leftCost, rightCost));

            if(leftCost < rightCost){
                right = mid - 1; // Move left
            } else {
                left = mid + 1;  // Move right
            }
        }

        return ans;
    }
}
